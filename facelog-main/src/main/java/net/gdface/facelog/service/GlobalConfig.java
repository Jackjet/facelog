package net.gdface.facelog.service;

import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.tree.DefaultExpressionEngine;
import org.apache.commons.configuration2.tree.DefaultExpressionEngineSymbols;

import com.facebook.swift.service.ThriftServerConfig;

import io.airlift.units.Duration;

/**
 * 配置参数管理
 * @author guyadong
 *
 */
public class GlobalConfig implements ServiceConstant{
	private static final String ROOT_XML = "root.xml";
	/** 配置参数对象 */
	private static final CombinedConfiguration CONFIG = init();
	private GlobalConfig() {
	}
	private static CombinedConfiguration init(){
		try{
			DefaultExpressionEngine engine = new DefaultExpressionEngine(DefaultExpressionEngineSymbols.DEFAULT_SYMBOLS);
			Configurations configs = new Configurations();
			CombinedConfiguration config = configs.combined(GlobalConfig.class.getClassLoader().getResource(ROOT_XML));
			config.setExpressionEngine(engine);
			return config;
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	/** 全局配置参数对象 */
	public static CombinedConfiguration getConfig() {
		return CONFIG;
	}
	/**
	 * 从配置文件中读取参数创建{@link ThriftServerConfig}实例
	 * @return
	 */
	static ThriftServerConfig makeThriftServerConfig(){
		ThriftServerConfig thriftServerConfig = new ThriftServerConfig();
		int intValue ;
		thriftServerConfig.setPort(CONFIG.getInt(SERVER_PORT,DEFAULT_PORT));
		
		if((intValue  = CONFIG.getInt(SERVER_CONNECTION_LIMIT,0)) >0){
			thriftServerConfig.setConnectionLimit(intValue);
			logger.info("{}:{}",SERVER_CONNECTION_LIMIT,intValue);
		}
		if((intValue = CONFIG.getInt(SERVER_IDLE_CONNECTION_TIMEMOUT,0))>0){
			Duration timeout = new Duration(intValue,TimeUnit.SECONDS);
			thriftServerConfig.setIdleConnectionTimeout(
					timeout);
			logger.info("{}:{}",SERVER_IDLE_CONNECTION_TIMEMOUT,timeout);

		}
		if((intValue = CONFIG.getInt(SERVER_WORKER_THREAD_COUNT,0))>0){
			thriftServerConfig.setWorkerThreads(intValue);
			logger.info("{}:{}",SERVER_WORKER_THREAD_COUNT,intValue);
		}
		return thriftServerConfig;		
	}
	/** log 输出{@code config}中的关键参数 */
	static final void showThriftServerConfig(ThriftServerConfig config){
		logger.info("Service Parameter: port: {}", config.getPort());
		logger.info("Service Parameter: connectionLimit: {}", config.getConnectionLimit());
		logger.info("Service Parameter: idleConnectionTimeout: {}", config.getIdleConnectionTimeout());
		logger.info("Service Parameter: workerThreads: {}", config.getWorkerThreads());
	}	
}