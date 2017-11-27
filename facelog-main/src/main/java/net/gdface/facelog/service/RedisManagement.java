package net.gdface.facelog.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.facebook.swift.codec.ThriftStruct;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import gu.simplemq.redis.JedisPoolLazy;
import gu.simplemq.redis.JedisPoolLazy.PropName;
import gu.simplemq.redis.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;

/**
 * 
 * redis管理模块
 * @author guyadong
 *
 */
class RedisManagement implements ServiceConstant{	
	@ThriftStruct
	public enum RedisParam {
		/** redis服务器地址 */RedisUri,
		/** 设备命令通道名 */CmdChannel
	}
	private static final String CMD_PREFIX = "cmd_";
	private static final String ACK_PREFIX = "ack_";
	private static String redisURI;
	/** 本地redis服务器启动标志 */
	private static boolean localServerStarted = false;
	/**  设备命令通道名 */
	private final String cmdChannel;
	/** redis数据库配置参数 */
	private static Map<PropName, Object> parameters;
	private final Map<RedisParam,String> redisParam = Maps.newHashMap();
	static{
		parameters = GlobalConfig.makeRedisParameters();
		JedisPoolLazy.createDefaultInstance(parameters);
		redisURI = JedisPoolLazy.getDefaultInstance().getCanonicalURI().toString();
		/** 程序结束时关闭 redis 服务器 */
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				shutdownLocalServer();
			}
		});
	}
	protected RedisManagement() {
		init();
		cmdChannel = createCmdChannel();
		redisParam.put(RedisParam.CmdChannel, cmdChannel);
		redisParam.put(RedisParam.RedisUri, redisURI);
		GlobalConfig.logRedisParameters(JedisPoolLazy.getDefaultInstance().getParameters());
	}
	/** 创建随机命令通道 */
	private String createCmdChannel(){
		// 初始化redis 全局常量 KEY_CMD_CHANNEL
		String timestamp = String.format("%06x", System.nanoTime());
		String commendChannel = CMD_PREFIX + timestamp.substring(timestamp.length()-6, timestamp.length());
		return JedisUtils.setnx(KEY_CMD_CHANNEL,commendChannel);
	}
	/** redis 连接初始化,并测试连接,如果连接异常,则尝试启动本地redis服务器或等待redis server启动 */
	private void init(){
		JedisPoolLazy poolLazy = JedisPoolLazy.getDefaultInstance();
		boolean waitIfAbsent = CONFIG.getBoolean(REDIS_WAITIFABSENT,false);
		boolean selfBind = NetworkUtil.selfBind(poolLazy.getCanonicalURI().getHost());
		int tryCountLimit = CONFIG.getInt(REDIS_TRYCOUNT);
		long tryInterval = CONFIG.getLong(REDIS_TRYINTERVAL);
		do{
			try{
				// 测试服务器连接和访问
				Jedis jedis = poolLazy.apply();
				try{
					jedis.keys("*");
				}finally{
					poolLazy.free();
				}
				return;
			}catch(JedisConnectionException e){
				if(selfBind){
					// 如果 redis服务器指定为本地启动则尝试启动服务器
					if( CONFIG.containsKey(REDIS_HOME) && !localServerStarted){
						logger.info("try start redis server");
						startLocalServer(parameters);
						localServerStarted = true;	
					}else {
						throw new RuntimeException(String.format("cann't connect redis server(无法连接redis服务器) %s",redisURI),e);
					}
				} else if(waitIfAbsent && tryCountLimit-- > 0){
					logger.info("waiting for redis server...{}",tryCountLimit);
				} else {
					throw new RuntimeException(String.format("cann't connect redis server(无法连接redis服务器) %s",redisURI),e);
				}				
			}catch(JedisDataException e){
				throw new RuntimeException(String.format("access error(服务器访问异常),%s", e.getMessage()),e);
			}
			try {
				Thread.sleep(tryInterval);
			} catch (InterruptedException e) {
				break;
			}
		}while(tryCountLimit >0);
		throw new RuntimeException(String.format("cann't connect redis server(无法连接redis服务器) %s",redisURI));

	}
	private static final String REDIS_SERVER_EXE = "redis-server";
	private static final String suffixOfExe(){
		return System.getProperty("os.name").startsWith("Windows")?".exe":"";
	}
	private static final String shell(){
		return System.getProperty("os.name").startsWith("Windows")?"cmd /c":"sh";
	}
	/** 启动本地 redis 服务器 */
	private static final  void startLocalServer(Map<PropName, Object> parameters){
		String home = CONFIG.getString(REDIS_HOME,"");
		if(!home.isEmpty()){
			// redis-server 可执行程序路径
			String exe = new StringBuffer()
					.append(home)
					.append(File.separator)
					.append(REDIS_SERVER_EXE)
					.append(suffixOfExe()).toString();
			if(new File(exe).canExecute()){
				ArrayList<String> args = Lists.newArrayList(shell(),exe);
				// 命令行指定端口
				if(parameters.containsKey(PropName.port)){
					args.add("--port " + parameters.get(PropName.port));
				}
				// 命令行指定password
				if(parameters.containsKey(PropName.password)){
					args.add("--requirepass " + parameters.get(PropName.password));
				}
				try {
					String cmd = Joiner.on(' ').join(args);
					logger.info("start redis server(启动redis服务器): {}",cmd);
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}else{
				throw new IllegalArgumentException(String.format("INVALID FILE(无效文件名) %s",exe));
			}
		}else{
			throw new IllegalArgumentException(String.format("NOT DEFINE(参数没有定义) %s",REDIS_HOME));
		}
	}
	/** 中止本地 redis 服务器*/
	private static void  shutdownLocalServer(){
		if(localServerStarted){
			logger.info("shutdown redis server(关闭redis服务器)");
			HashMap<PropName, Object> param = JedisPoolLazy.initParameters(parameters);
			Jedis jedis = new Jedis(JedisUtils.getCanonicalURI(param));
			try{
				// shutdown前清除全局变量避免持久化
				jedis.del(KEY_CMD_SN);
				jedis.del(KEY_ACK_SN);
				jedis.shutdown();
			}finally{
				jedis.close();
			}
		}
	}
	/** 返回redis访问参数 */
	protected Map<RedisParam,String> getRedisParameters(){
		return Maps.newHashMap(this.redisParam);
	}
	/** 申请一个唯一的命令序列号 */
	protected long applyCmdSn(){
		return JedisUtils.incr(KEY_CMD_SN);
	}
	/** 申请一个唯一的命令响应通道 */
	protected String applyAckChannel(){
		return new StringBuffer(ACK_PREFIX)
				.append(JedisUtils.incr(KEY_ACK_SN))
				.toString();
	}
}
