// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import net.gdface.facelog.db.TableLoadCaching;
import net.gdface.facelog.db.StoreBean;

/**
 * cache manager for StoreBean base {@link com.google.common.cache.LoadingCache}<br>
 * primary key (fl_store.md5) is key
 * @author guyadong
 *
 */
public class StoreCache extends TableLoadCaching<String, StoreBean> {
    private final StoreManager manager = StoreManager.getInstance();
    public StoreCache(long maximumSize, long duration, TimeUnit unit) {
        super(maximumSize, duration, unit);
    }

    public StoreCache(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, DEFAULT_TIME_UNIT);
    }

    public StoreCache(long maximumSize) {
        this(maximumSize,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    public StoreCache() {
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
    protected String returnKey(StoreBean bean) {
        return bean.getMd5();
    }
    @Override
    protected StoreBean loadfromDatabase(String key) {
        return manager.loadByPrimaryKey(key);
    }
    @Override
    public void put(StoreBean bean){
        super.put(bean);
    }
    @Override
    public Collection<StoreBean> put(Collection<StoreBean> beans){
        super.put(beans);
        return beans;
    }
    @Override
    public void putIfAbsent(StoreBean bean){
        super.putIfAbsent(bean);
    }
    @Override
    public Collection<StoreBean> putIfAbsent(Collection<StoreBean> beans){
        super.putIfAbsent(beans);
        return beans;
    }
    @Override
    public void replace(StoreBean bean){
        super.replace(bean);
    }
    @Override
    public Collection<StoreBean> replace(Collection<StoreBean> beans){
        super.replace(beans);
        return beans;
    }
    
    public StoreBean getBeanByMd5(String md5){
        return super.getBean(md5);
    }
}