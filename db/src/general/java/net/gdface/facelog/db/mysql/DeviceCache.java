// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: cache.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import net.gdface.facelog.db.TableLoadCaching;
import net.gdface.facelog.db.DeviceBean;

/**
 * cache manager for DeviceBean base {@link com.google.common.cache.LoadingCache}<br>
 * primary key (fl_device.id) is key
 * @author guyadong
 *
 */
public class DeviceCache extends TableLoadCaching<Integer, DeviceBean> {
    private final DeviceManager manager = DeviceManager.getInstance();
    private final TableLoadCaching<String, DeviceBean> macCacher;
    private final TableLoadCaching<String, DeviceBean> serialNoCacher;
    /** constructor<br>
     * @see {@link TableLoadCaching#TableLoadCaching(UpdateStrategy ,long , long , TimeUnit )}
     */
    public DeviceCache(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        super(updateStragey,maximumSize, duration, unit);

        macCacher = new TableLoadCaching<String, DeviceBean>(updateStragey, maximumSize, duration, unit){
            @Override
            public void registerListener() {
                manager.registerListener(tableListener);
            }
            @Override
            public void unregisterListener() {
                manager.unregisterListener(tableListener);
            }
            @Override
            protected String returnKey(DeviceBean bean) {
                return bean.getMac();
            }
            @Override
            protected DeviceBean loadfromDatabase(String key) throws Exception {
                return manager.loadByIndexMacChecked(key);
            }};

        serialNoCacher = new TableLoadCaching<String, DeviceBean>(updateStragey, maximumSize, duration, unit){
            @Override
            public void registerListener() {
                manager.registerListener(tableListener);
            }
            @Override
            public void unregisterListener() {
                manager.unregisterListener(tableListener);
            }
            @Override
            protected String returnKey(DeviceBean bean) {
                return bean.getSerialNo();
            }
            @Override
            protected DeviceBean loadfromDatabase(String key) throws Exception {
                return manager.loadByIndexSerialNoChecked(key);
            }};
    }
    public DeviceCache(long maximumSize, long duration, TimeUnit unit) {
        this(DEFAULT_STRATEGY,maximumSize,duration,unit);
    }
    public DeviceCache(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, DEFAULT_TIME_UNIT);
    }

    public DeviceCache(long maximumSize) {
        this(maximumSize,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    public DeviceCache() {
        this(DEFAULT_CACHE_MAXIMUMSIZE,DEFAULT_DURATION,DEFAULT_TIME_UNIT);
    }
    
    @Override
    public void registerListener() {
        manager.registerListener(tableListener);
        macCacher.registerListener();
        serialNoCacher.registerListener();
    }
    @Override
    public void unregisterListener() {
        manager.unregisterListener(tableListener);
        macCacher.unregisterListener();
        serialNoCacher.unregisterListener();
    }
    @Override
    protected Integer returnKey(DeviceBean bean) {
        return bean.getId();
    }
    @Override
    protected DeviceBean loadfromDatabase(Integer key)throws Exception {
        return manager.loadByPrimaryKeyChecked(key);
    }
    @Override
    public void update(DeviceBean bean){
        super.update(bean);
        macCacher.update(bean);
        serialNoCacher.update(bean);
    }
    @Override
    public Collection<DeviceBean> update(Collection<DeviceBean> beans){
        super.update(beans);
        macCacher.update(beans);
        serialNoCacher.update(beans);
        return beans;
    }
    
    public DeviceBean getBeanById(Integer id) throws ExecutionException{
        return getBean(id);
    }
    public DeviceBean getBeanByIdUnchecked(Integer id){
        return getBeanUnchecked(id);
    }
    public DeviceBean getBeanByMac(String mac)  throws ExecutionException{
        return macCacher.getBean(mac);
    }
    public DeviceBean getBeanByMacUnchecked(String mac){
        return macCacher.getBeanUnchecked(mac);
    }
    public DeviceBean getBeanBySerialNo(String serialNo)  throws ExecutionException{
        return serialNoCacher.getBean(serialNo);
    }
    public DeviceBean getBeanBySerialNoUnchecked(String serialNo){
        return serialNoCacher.getBeanUnchecked(serialNo);
    }
}