package gu.simplemq.redis;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;

import gu.simplemq.Constant;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * 延迟初始化的 JedisPool封装类（线程安全）,使用方法:<br>
 * 通过 {@link #getDefaultInstance()} 和getInstance(...)系列静态方法获取{@link JedisPoolLazy}实例<br>
 * 通过{@link #apply()} 和 {@link #free()}方法实现{@link Jedis}对象的申请和释放
 * @author guyadong
 *
 */
public class JedisPoolLazy implements Constant{
	private static final Set<JedisPoolLazy> POOL_SET = Collections.synchronizedSet(new LinkedHashSet<JedisPoolLazy>());
	static {
		// 程序退出时自动销毁连接池对象
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				for(Iterator<JedisPoolLazy> itor = POOL_SET.iterator();itor.hasNext();){
					JedisPoolLazy p = itor.next();
					itor.remove();
					if(null != p.pool){
						p.pool.destroy();
						logger.info("discard jedis pool: {}",p);
					}
				}
			}});
	}
	/** {@link JedisPoolLazy} 初始化参数名 */
	public static enum PropName{
		/** 线程配置参数对象 */
		jedisPoolConfig,host,port,password,database,timeout,uri
	}
	
	public static final JedisPoolConfig DEFAULT_CONFIG = new JedisPoolConfig() {
		{
			setMaxTotal(Runtime.getRuntime().availableProcessors());
		}
	};
	/** redis缺省连接参数 */
	public static final Map<PropName, Object> DEFAULT_PARAMETERS = Collections.unmodifiableMap(new HashMap<PropName, Object>() {
		private static final long serialVersionUID = 1L;
		{
			put(PropName.jedisPoolConfig, DEFAULT_CONFIG);
			put(PropName.host, Protocol.DEFAULT_HOST);
			put(PropName.port, Protocol.DEFAULT_PORT);
			put(PropName.password, null);
			put(PropName.database, Protocol.DEFAULT_DATABASE);
			put(PropName.timeout, Protocol.DEFAULT_TIMEOUT);
		}
	});

	/** 默认实例 */
	private static JedisPoolLazy defaultInstance;
	
	/**
	 * 返回默认实例,如果 {@link #defaultInstance}为null则创建默认实例
	 * @return
	 * @see #createDefaultInstance(Map)
	 */
	public static JedisPoolLazy getDefaultInstance() {
		return null == defaultInstance
				? createDefaultInstance(null) 
				: defaultInstance;
	}

	/**
	 * 根据指定的连接参数创建默认实例,只能被调用一次(线程安全)
	 * @param props
	 * @return
	 */
	public static synchronized final JedisPoolLazy createDefaultInstance(Map<PropName,Object> props){
		if(null == defaultInstance){
			defaultInstance = createInstance(props);
		}else{
			logger.warn("default instance was initialized already before this invocation");
		}
		return defaultInstance;
	}
	
	static JedisPoolLazy createInstance(Map<PropName,Object> props) {
		return new JedisPoolLazy(props);
	}
	/** 根据{@code props}提供的参数及缺省参数{@link DEFAULT_PARAMETERS}创建一组完整的初始化参数 */
	public static HashMap<PropName,Object> initParameters(Map<PropName,Object> props){
		// 初始化时复制一份缺省参数
		HashMap<PropName,Object> params = Maps.newHashMap(DEFAULT_PARAMETERS);
		if(null != props){			
			// 过滤掉所有为null的参数，避免将缺省参数覆盖为null
			Map<PropName, Object> filtered = Maps.filterValues(props, Predicates.notNull());
			// 缺省参数与输入参数合并
			params.putAll(filtered);
		}
		return params;
	}
	
	public static synchronized JedisPoolLazy getInstance(Map<PropName,Object> props, boolean fullMatch) {
		// 初始化时复制一份缺省参数
		HashMap<PropName,Object> params = initParameters(props);
		// 查找在连接池对象集合中查找对应的匹配的对象,找不到就创建新实例
		URI canonicalURI = JedisUtils.getCanonicalURI(params);
		if(fullMatch){
			// 全匹配
			for (JedisPoolLazy pool : POOL_SET) {
				if (pool.getCanonicalURI().equals(canonicalURI)
						&& params.get(PropName.jedisPoolConfig).equals(pool.parameters.get(PropName.jedisPoolConfig))
						&& params.get(PropName.timeout).equals(pool.parameters.get(PropName.timeout))) {
					return pool;
				}
			}
		}else{
			// 只匹配 host port 相同就算找到
			HostAndPort hp1 = new HostAndPort(canonicalURI.getHost(),canonicalURI.getPort());
			for (JedisPoolLazy pool : POOL_SET) {
				URI uri2 = pool.getCanonicalURI();
				HostAndPort hp2 = new HostAndPort(uri2.getHost(),uri2.getPort());
				if(hp1.equals(hp2)){
					return pool;
				}
			}
		}
		return createInstance(params);
	}
	
	private static JedisPoolLazy getInstance( JedisPoolConfig jedisPoolConfig, String host, int port, final String password,
			int database, int timeout, URI uri){
		HashMap<PropName,Object> param = new HashMap<PropName,Object>(DEFAULT_PARAMETERS);
		if(null != jedisPoolConfig){
			param.put(PropName.jedisPoolConfig, jedisPoolConfig);
		}
		if(null != host && !host.isEmpty()){
			param.put(PropName.host, host);
		}
		if(0 < port){
			param.put(PropName.port, port);
		}
		param.put(PropName.password, password);
		if(0 <= database){
			param.put(PropName.database, database);
		}
		if( 0 < timeout ){
			param.put(PropName.timeout, timeout);
		}
		param.put(PropName.uri, uri);
		return getInstance(param, true);
	}
	
	public static JedisPoolLazy getInstance(JedisPoolConfig jedisPoolConfig, URI uri, int timeout) {
		if(null == uri){
			throw new NullPointerException(" the 'uri' must not be null");
		}
		return getInstance(jedisPoolConfig,null,0,null,-1,timeout,uri);
	}
	
	public static JedisPoolLazy getInstance(URI uri) {
		return getInstance(DEFAULT_CONFIG,uri,Protocol.DEFAULT_TIMEOUT);
	}

	public static JedisPoolLazy getInstance( JedisPoolConfig jedisPoolConfig, String host, int port, final String password,
			int database, int timeout){
		return getInstance(jedisPoolConfig,host,port,password,database,timeout, null);
	}
	
	public static JedisPoolLazy getInstance(String host, int port, final String password, int database) {
		return getInstance(DEFAULT_CONFIG,host,port,password,database,Protocol.DEFAULT_TIMEOUT);
	}

	public static JedisPoolLazy getInstance(String host, int port) {
		return getInstance(host,port,null,Protocol.DEFAULT_DATABASE);
	}
	
	public static  JedisPoolLazy getInstance(String host) {
		 return getInstance(host,Protocol.DEFAULT_PORT);
	}

	private final Map<PropName,Object> parameters;
	
	public Map<PropName, Object> getParameters() {
		return new HashMap<PropName,Object>(parameters);
	}

	private volatile JedisPool pool;

	protected JedisPoolLazy (Map<PropName,Object> props) {
		POOL_SET.add(this);
		this.parameters=initParameters(props);
	}
	
	private JedisPool createPool(){
		JedisPool pool;
		int timeout = (Integer)parameters.get(PropName.timeout);
		URI uri = this.getCanonicalURI();
		logger.info("jedis pool initialized(连接池初始化)  {} timeout : {} ms",uri,timeout);
		pool = new JedisPool(
				 (JedisPoolConfig) parameters.get(PropName.jedisPoolConfig),
				uri, 
				timeout);
		return pool;
	}
	
	private Jedis getJedis(){
		// double-checked locking
		if(null == pool){
			synchronized (this){
				if(null == pool){
					pool = createPool();
				}
			}
		}
        return pool.getResource();
    }
    
    private void releaseJedis(Jedis jedis) {
        if (jedis != null){
            jedis.close();
        }
    }
    /** apply/free 嵌套计数 */
	private final ThreadLocal<AtomicInteger> tlNestCount  = new ThreadLocal<AtomicInteger>(){
		@Override
		protected AtomicInteger initialValue() {
			return new AtomicInteger(0);
		}
	};
	
	private final ThreadLocal<Jedis> tlJedis = new ThreadLocal<Jedis>(); 
	
	/** 申请当前线程使用的{@link Jedis }对象,不可跨线程使用 */
	public Jedis apply(){
		Jedis jedis = tlJedis.get();
		if(null == jedis){
			jedis = getJedis();
			this.tlJedis.set(jedis);
		}
		tlNestCount.get().incrementAndGet();
		return jedis;
	}
	/** 释放当前线程使用的{@link Jedis }资源 */
	public void free(){
		Jedis jedis =tlJedis.get();
		if(null == jedis){
			throw new IllegalStateException("apply/free mismatch");
		}
		if(0 == tlNestCount.get().decrementAndGet()){
			releaseJedis(jedis);
			tlJedis.remove();
			tlNestCount.remove();
		}
	}
	
	/**
	 * @return
	 * @see {@link JedisUtils#getCanonicalURI(Map)}
	 */
	public URI getCanonicalURI(){
		return JedisUtils.getCanonicalURI(parameters);
	}
	
	@Override
	public String toString() {
		return getCanonicalURI().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pool == null) ? 0 : pool.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof JedisPoolLazy)) {
			return false;
		}
		JedisPoolLazy other = (JedisPoolLazy) obj;
		if (pool == null) {
			if (other.pool != null) {
				return false;
			}
		} else if (!pool.equals(other.pool)) {
			return false;
		}
		return true;
	}
}
