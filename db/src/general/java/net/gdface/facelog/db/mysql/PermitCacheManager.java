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
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.PersonGroupBean;
import net.gdface.facelog.db.mysql.PermitManager;
import net.gdface.facelog.db.PermitBean;
import net.gdface.facelog.db.mysql.PermitCache;

/**
 * cache implementation for PermitManager<br>
 * @author guyadong
 */
public class PermitCacheManager extends PermitManager
{
    /** singleton of PermitCacheManager */
    private static PermitCacheManager instance;
    /** 
     * @return a instance of PermitCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final PermitCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of PermitCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of PermitCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see {@link PermitCacheManager#PermitCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final PermitCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new PermitCacheManager(updateStragey,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final PermitCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PermitCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PermitCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link PermitCache} */
    private final PermitCache cache;
    /** constructor<br>
     * @see {@link PermitCache#PermitCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected PermitCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new PermitCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected DeviceGroupCacheManager instanceOfDeviceGroupManager(){
        return DeviceGroupCacheManager.getInstance();
    }
    @Override
    protected PersonGroupCacheManager instanceOfPersonGroupManager(){
        return PersonGroupCacheManager.getInstance();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IPermitManager

    @Override 
    public PermitBean loadByPrimaryKeyChecked(Integer deviceGroupId,Integer personGroupId) throws ObjectRetrievalException
    {
        if(null == deviceGroupId || null == personGroupId){
           throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBean(deviceGroupId,personGroupId);
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
    //1.4 override IPermitManager

    @Override 
    public boolean existsPrimaryKey(Integer deviceGroupId,Integer personGroupId){
        return null != loadByPrimaryKey(deviceGroupId,personGroupId);
    }
    private class CacheAction implements Action<PermitBean>{
        final Action<PermitBean> action;
        CacheAction(Action<PermitBean>action){
            this.action = action;
        }
        @Override
        public void call(PermitBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public PermitBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(PermitBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PermitBean> action){
        if(null == fieldList ){
            action = new CacheAction(action);
        }
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }


    //_____________________________________________________________________
    //
    // SIMPLE JUNCTION TABLE
    //_____________________________________________________________________
    /** see also {@link PermitCache#getBeanByDeviceGroupId(Integer)} */
    public java.util.Set<PermitBean> getBeanByDeviceGroupId(Integer deviceGroupId) throws ExecutionException{
        return cache.getBeanByDeviceGroupId(deviceGroupId);
    }
    /** see also {@link PermitCache#getBeanByDeviceGroupIdUnchecked(Integer)} */
    public java.util.Set<PermitBean> getBeanByDeviceGroupIdUnchecked(Integer deviceGroupId){
        return cache.getBeanByDeviceGroupIdUnchecked(deviceGroupId);
    }
    /** see also {@link PermitCache#getBeanByPersonGroupId(Integer)} */
    public java.util.Set<PermitBean> getBeanByPersonGroupId(Integer personGroupId) throws ExecutionException{
        return cache.getBeanByPersonGroupId(personGroupId);
    }
    /** see also {@link PermitCache#getBeanByPersonGroupIdUnchecked(Integer)} */
    public java.util.Set<PermitBean> getBeanByPersonGroupIdUnchecked(Integer personGroupId){
        return cache.getBeanByPersonGroupIdUnchecked(personGroupId);
    }
}
