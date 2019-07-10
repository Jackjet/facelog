// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: cache.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import net.gdface.facelog.db.BaseTableLoadCaching;
import net.gdface.facelog.db.LogBean;

/**
 * cache manager for LogBean base {@link com.google.common.cache.LoadingCache}<br>
 * primary key (fl_log.id) is key
 * @author guyadong
 *
 */
public class LogCache extends BaseTableLoadCaching<Integer, LogBean> {
    private final LogManager manager = LogManager.getInstance();
    
    /** constructor<br>
     * @see BaseTableLoadCaching#BaseTableLoadCaching(UpdateStrategy ,long , long , TimeUnit )
     */
    public LogCache(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        super(updateStrategy,maximumSize, duration, unit);
        manager.bindForeignKeyListenerForDeleteRule();
    }
    /**
     * add bean to all other cacher
     * @param bean
     * @param exclude
     */
    private void addToOtherCache(LogBean bean,BaseTableLoadCaching<?,?> exclude){
        if(exclude != this){
            this.getCacheMap().putIfAbsent(bean.getId(),bean);
        }
    }    
    public LogCache(long maximumSize, long duration, TimeUnit unit) {
        this(DEFAULT_STRATEGY,maximumSize,duration,unit);
    }
    public LogCache(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, DEFAULT_TIME_UNIT);
    }

    public LogCache(long maximumSize) {
        this(maximumSize,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    public LogCache() {
        this(DEFAULT_CACHE_MAXIMUMSIZE,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    
    @Override
    public void registerListener() {        
        
        manager.registerListener(tableListener);
    }
    @Override
    public void unregisterListener() {
        manager.unregisterListener(tableListener);
        
    }
    @Override
    protected Integer returnKey(LogBean bean) {
        return null == bean ? null : bean.getId();
    }
    @Override
    protected LogBean loadfromDatabase(Integer key)throws Exception {
        LogBean bean = manager.loadByPrimaryKeyChecked(key);
        addToOtherCache(bean,this);
        return bean;
    }
    public LogBean getBeanById(Integer id) throws ExecutionException{
        return getBean(id);
    }
    public LogBean getBeanByIdUnchecked(Integer id){
        return getBeanUnchecked(id);
    }
}