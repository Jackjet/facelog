// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: $db.driver
// ______________________________________________________

package net.gdface.facelog.db;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.base.Preconditions;
/**
 * 
 * 基于 {@link LoadingCache}实现表数据缓存,并可以通过{@link TableListener}实现缓存数组的更新
 * @author guyadong
 *
 * @param <K> 主键类型(Primary or Unique)
 * @param <B> 数据库记录对象类型(Java Bean)
 */
public abstract class TableLoadCaching<K ,B extends BaseBean<B>> implements ITableCache<K, B> {
    private final LoadingCache<K, B> cache;
    protected final ConcurrentMap<K, B> cacheMap;
    protected final  TableListener.Adapter<B> tableListener;
    private final UpdateStrategy updateStragey;

    /** 返回bean中主键值 */
    protected abstract K returnKey(B bean)
    /** 从数据库中加载主键(pk)指定的记录 */;
    protected abstract B loadfromDatabase(K key)throws Exception;

    public TableLoadCaching(){
        this(DEFAULT_CACHE_MAXIMUMSIZE,
                DEFAULT_DURATION,
                DEFAULT_TIME_UNIT);
    }
    public TableLoadCaching(long maximumSize){
        this(maximumSize,
                DEFAULT_DURATION,
                DEFAULT_TIME_UNIT);
    }
    public TableLoadCaching(long maximumSize,long durationMinutes){
        this(maximumSize,durationMinutes,DEFAULT_TIME_UNIT);
    }
    public TableLoadCaching(long maximumSize,long duration, TimeUnit unit) {
        this(DEFAULT_STRATEGY,maximumSize,duration,unit);
    }
    /**
     * 构造函数
     * @param updateStragey 缓存更新策略
     * @param maximumSize 最大缓存容量,参见 {@link CacheBuilder#maximumSize(long)}
     * @param duration 失效时间,参见 {@link CacheBuilder#expireAfterWrite(long, TimeUnit)}
     * @param unit {@code duration}的时间单位
     */
    public TableLoadCaching(UpdateStrategy updateStragey,long maximumSize,long duration, TimeUnit unit) {
        this.updateStragey = Preconditions.checkNotNull(updateStragey);
        cache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterWrite(duration, unit)
                .build(
                        new CacheLoader<K,B>() {
                            @Override
                            public B load(K key) throws Exception {
                                return loadfromDatabase(key);
                            }});
        cacheMap = cache.asMap();
        tableListener = new TableListener.Adapter<B>(){
            @Override
            public void afterUpdate(B bean) {
                cacheMap.putIfAbsent(returnKey(bean), bean);
            }

            @Override
            public void afterDelete(B bean) {
                cacheMap.remove(returnKey(bean));
            }};
    }
    @Override
    public B getBean(K key) {
        try {
            return cache.get(key);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void update(B bean){
        K key;
        if(null == bean || null == (key = returnKey(bean)))return;
        switch(updateStragey){
        case always:
            cacheMap.put(key,bean);break;
        case ifAbsent:
            cacheMap.putIfAbsent(key,bean);break;
        case replace:
            cacheMap.replace(key,bean);break;
        }        
    }
    @Override
    public Collection<B> update(Collection<B> beans){
        if(null != beans){
            for(B bean : beans){
                update(bean);
            }
        }
        return beans;
    }
}
