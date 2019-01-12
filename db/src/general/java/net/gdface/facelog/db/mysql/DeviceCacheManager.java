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

import com.google.common.util.concurrent.UncheckedExecutionException;

import net.gdface.facelog.db.ITableCache;
import net.gdface.facelog.db.ITableCache.UpdateStrategy;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.RuntimeDaoException;
import net.gdface.facelog.db.ImageBean;
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
     * @see DeviceCacheManager#DeviceCacheManager(UpdateStrategy ,long , long , TimeUnit )
     */
    public static synchronized final DeviceCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new DeviceCacheManager(updateStrategy,maximumSize,duration,unit);
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
     * @see DeviceCache#DeviceCache(UpdateStrategy ,long , long , TimeUnit )
     */
    protected DeviceCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new DeviceCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected ImageCacheManager instanceOfImageManager(){
        return ImageCacheManager.getInstance();
    }
    @Override
    protected LogCacheManager instanceOfLogManager(){
        return LogCacheManager.getInstance();
    }
    @Override
    protected DeviceGroupCacheManager instanceOfDeviceGroupManager(){
        return DeviceGroupCacheManager.getInstance();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IDeviceManager

    @Override 
    public DeviceBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
    {
        if(null == id){
           throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBean(id);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }catch(UncheckedExecutionException ue){
            try{
                throw ue.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ue);
            }
        }
    }
    //1.4 override IDeviceManager

    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
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
        if(null == fieldList ){
            action = new CacheAction(action);
        }
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________
    // override DeviceManager

    @Override 
    public DeviceBean loadByIndexMacChecked(String mac) throws ObjectRetrievalException{
        if(null == mac){
            throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBeanByMac(mac);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }catch(UncheckedExecutionException ue){
            try{
                throw ue.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ue);
            }
        }
    }
    // override DeviceManager

    @Override 
    public DeviceBean loadByIndexSerialNoChecked(String serialNo) throws ObjectRetrievalException{
        if(null == serialNo){
            throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBeanBySerialNo(serialNo);
        }catch(ExecutionException ee){
            try{
                throw ee.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ee);
            }
        }catch(UncheckedExecutionException ue){
            try{
                throw ue.getCause();
            }catch(ObjectRetrievalException oe){
                throw oe;
            } catch (RuntimeDaoException we) {
                throw we;
            } catch (RuntimeException re) {
                throw re;
            }catch (Throwable e) {
                throw new RuntimeException(ue);
            }
        }
    }
    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________
    //12

    @Override
    public DeviceBean save(DeviceBean bean){
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getId())).resetIsModified();
        }
        return bean;
    }

}
