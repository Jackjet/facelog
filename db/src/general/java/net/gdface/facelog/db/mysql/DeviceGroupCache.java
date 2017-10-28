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

import net.gdface.facelog.db.TableLoadCaching;
import net.gdface.facelog.db.DeviceGroupBean;

/**
 * cache manager for DeviceGroupBean base {@link com.google.common.cache.LoadingCache}<br>
 * primary key (fl_device_group.id) is key
 * @author guyadong
 *
 */
public class DeviceGroupCache extends TableLoadCaching<Integer, DeviceGroupBean> {
    private final DeviceGroupManager manager = DeviceGroupManager.getInstance();
    
    /** constructor<br>
     * @see {@link TableLoadCaching#TableLoadCaching(UpdateStrategy ,long , long , TimeUnit )}
     */
    public DeviceGroupCache(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        super(updateStragey,maximumSize, duration, unit);
        manager.bindForeignKeyListenerForDeleteRule();
    }
    public DeviceGroupCache(long maximumSize, long duration, TimeUnit unit) {
        this(DEFAULT_STRATEGY,maximumSize,duration,unit);
    }
    public DeviceGroupCache(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, DEFAULT_TIME_UNIT);
    }

    public DeviceGroupCache(long maximumSize) {
        this(maximumSize,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    public DeviceGroupCache() {
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
    public Integer returnKey(DeviceGroupBean bean) {
        return null == bean ? null : bean.getId();
    }
    @Override
    protected DeviceGroupBean loadfromDatabase(Integer key)throws Exception {
        return manager.loadByPrimaryKeyChecked(key);
    }
    public DeviceGroupBean getBeanById(Integer id) throws ExecutionException{
        return getBean(id);
    }
    public DeviceGroupBean getBeanByIdUnchecked(Integer id){
        return getBeanUnchecked(id);
    }
}