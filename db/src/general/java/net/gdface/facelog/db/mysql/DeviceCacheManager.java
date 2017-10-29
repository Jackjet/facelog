// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: cache.manager.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import net.gdface.facelog.db.ITableCache;
import net.gdface.facelog.db.ITableCache.UpdateStrategy;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.WrapDAOException;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.JunctionDeviceGroupBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.mysql.DeviceManager;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.mysql.DeviceCache;

/**
 * cache implementation for DeviceManager<br>
 * @author guyadong
 */
public class DeviceCacheManager extends DeviceManager
{
    /** singleton of DeviceCacheManager */
    private static DeviceCacheManager instance;
    /** 
     * @return a instance of DeviceCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final DeviceCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of DeviceCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of DeviceCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see {@link DeviceCacheManager#DeviceCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final DeviceCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new DeviceCacheManager(updateStragey,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final DeviceCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final DeviceCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final DeviceCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link DeviceCache} */
    private final DeviceCache cache;
    /** constructor<br>
     * @see {@link DeviceCache#DeviceCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected DeviceCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new DeviceCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IDeviceManager
    @Override 
    public DeviceBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
    {
        try{
            return cache.getBean(id);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (WrapDAOException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }
    }
    //1.4 override IDeviceManager
    @Override 
    public boolean existsPrimaryKey(Integer id)
    {
        if(null != cache.getBeanIfPresent(id))return true;
        return super.existsPrimaryKey(id);
    }
    
    private class CacheAction implements Action<DeviceBean>{
        final Action<DeviceBean> action;
        CacheAction(Action<DeviceBean>action){
            this.action = action;
        }
        @Override
        public void call(DeviceBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public DeviceBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5
    @Override
    public int loadUsingTemplate(DeviceBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<DeviceBean> action){
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________
    // override DeviceManager
    @Override 
    public DeviceBean loadByIndexMacChecked(String mac) throws ObjectRetrievalException{
        try{
            return cache.getBeanByMac(mac);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (WrapDAOException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }
    }
    // override DeviceManager
    @Override 
    public DeviceBean loadByIndexSerialNoChecked(String serialNo) throws ObjectRetrievalException{
        try{
            return cache.getBeanBySerialNo(serialNo);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (WrapDAOException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }
    }

    //_____________________________________________________________________
    //
    // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
    //_____________________________________________________________________
    //23 MANY TO MANY
    // override DeviceManager
    @Override 
    public java.util.List<DeviceBean> loadViaJunctionDeviceGroupAsList(DeviceGroupBean bean, int startRow, int numRows)
    {
        java.util.List<JunctionDeviceGroupBean> junctions = 
            DeviceGroupManager.getInstance().getJunctionDeviceGroupBeansByGroupIdAsList(bean,startRow,numRows);
        java.util.ArrayList<DeviceBean> lbeans = new java.util.ArrayList<DeviceBean>(junctions.size());
        for(JunctionDeviceGroupBean jbean:junctions){
        	try{
        		lbeans.add(loadByPrimaryKeyChecked(jbean.getDeviceId()));
        	}catch(ObjectRetrievalException  e){}
        }
        return lbeans;
    }
}
