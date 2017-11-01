// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: table.loadcaching.java.vm
// ______________________________________________________
package net.gdface.facelog.db;

import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.UncheckedExecutionException;

import net.gdface.facelog.db.ITableCache.UpdateStrategy;
import net.gdface.facelog.db.exception.ObjectRetrievalException;

/**
 * 
 * 基于 {@link LoadingCache}实现表数据缓存,并可以通过{@link TableListener}实现缓存数据自动更新
 * @author guyadong
 *
 * @param <K1> 主键类型(Primary or Unique)
 * @param <B> 数据库记录对象类型(Java Bean)
 */
public abstract class JunctionTableLoadCaching<K1 ,K2,B extends BaseBean<B>> {
    private final LoadingCache<K1, Set<B>> cache1;
    protected final ConcurrentMap<K1, Set<B>> cacheMap1;
    protected final  TableListener.Adapter<B> tableListener;
    /** 当前更新策略 */
    private final UpdateStrategy updateStragey;
	private final LoadingCache<K2, Set<B>> cache2;
	private final ConcurrentMap<K2, Set<B>> cacheMap2;
    /** 返回bean中主键值 */
    protected abstract K1 returnK1(B bean);
    protected abstract K2 returnK2(B bean);
    /** 从数据库中加载主键(pk)指定的记录 */
    protected abstract Set<B> loadfromDatabaseByK1(K1 key)throws Exception;
    protected abstract Set<B> loadfromDatabaseByK2(K2 key)throws Exception;
    public JunctionTableLoadCaching(){
        this(ITableCache.DEFAULT_CACHE_MAXIMUMSIZE,
        		ITableCache.DEFAULT_DURATION,
        		ITableCache.DEFAULT_TIME_UNIT);
    }
    public JunctionTableLoadCaching(long maximumSize){
        this(maximumSize,
        		ITableCache.DEFAULT_DURATION,
        		ITableCache.DEFAULT_TIME_UNIT);
    }
    public JunctionTableLoadCaching(long maximumSize,long durationMinutes){
        this(maximumSize,durationMinutes,ITableCache.DEFAULT_TIME_UNIT);
    }
    public JunctionTableLoadCaching(long maximumSize,long duration, TimeUnit unit) {
        this(ITableCache.DEFAULT_STRATEGY,maximumSize,duration,unit);
    }
    /**
     * 构造函数
     * @param updateStragey 缓存更新策略
     * @param maximumSize 最大缓存容量,参见 {@link CacheBuilder#maximumSize(long)}
     * @param duration 失效时间,参见 {@link CacheBuilder#expireAfterWrite(long, TimeUnit)}
     * @param unit {@code duration}的时间单位
     */
    public JunctionTableLoadCaching(UpdateStrategy updateStragey,long maximumSize,long duration, TimeUnit unit) {        
        if(null == updateStragey ) updateStragey = ITableCache.DEFAULT_STRATEGY;
        if(0 >= maximumSize) maximumSize = ITableCache.DEFAULT_CACHE_MAXIMUMSIZE;
        if(0 >= duration) maximumSize = ITableCache.DEFAULT_DURATION;
        if(null == unit) unit = ITableCache.DEFAULT_TIME_UNIT;
        this.updateStragey = updateStragey;
        cache1 = CacheBuilder.newBuilder()
            .maximumSize(maximumSize)
            .expireAfterWrite(duration, unit)
            .build(
                new CacheLoader<K1,Set<B>>() {
                    @Override
                    public Set<B> load(K1 key) throws Exception {
                        return loadfromDatabaseByK1(key);
                    }});
        cacheMap1 = cache1.asMap();
        cache2 = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(duration, unit)
                .build(
                    new CacheLoader<K2,Set<B>>() {
                        @Override
                        public Set<B> load(K2 key) throws Exception {
                            return loadfromDatabaseByK2(key);
                        }});
            cacheMap2 = cache2.asMap();
        // 初始化侦听器,当表数据改变时自动更新缓存
        tableListener = new TableListener.Adapter<B>(){
            @Override
            public void afterUpdate(B bean) {
                update(bean);
            }
            
            @Override
            public void afterInsert(B bean) {
                update(bean);
            }
            
            @Override
            public void afterDelete(B bean) {
                // the remove method allow null key
                // see also com.google.common.cache.LocalCache.remove(Object key)
                cacheMap1.remove(returnK1(bean));
            }};
    }
    /**
     * @see {@link com.google.common.cache.LoadingCache#get(Object)}
     */
    public Set<B> getBean(K1 key)throws ExecutionException{
        return cache1.get(key);
    }
    public Set<B> getBeanIfPresent(K1 key){
        return null == key ? null : cache1.getIfPresent(key);
    }
    public Set<B> getBeanUnchecked(K1 key){
        try{
            return cache1.getUnchecked(key);
        }catch(UncheckedExecutionException e){
            if(e.getCause() instanceof ObjectRetrievalException){
                return null;
            }
            throw e;
        }        
    }
    public void remove(B bean){
        cacheMap1.remove(returnK1(bean));
    }
    /**
     * 根据当前更新策略({@link UpdateStrategy})将{@code bean}更新到缓存
     * @see ITableCache#update(net.gdface.facelog.db.BaseBean)
     */
    public void update(B bean){
        //updateStragey.update(cacheMap1, returnKey(bean), bean);
    }
}

