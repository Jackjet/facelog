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
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.mysql.LogManager;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.mysql.LogCache;

/**
 * cache implementation for LogManager<br>
 * @author guyadong
 */
public class LogCacheManager extends LogManager
{
    /** singleton of LogCacheManager */
    private static LogCacheManager instance;
    /** 
     * @return a instance of LogCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final LogCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of LogCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of LogCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see LogCacheManager#LogCacheManager(UpdateStrategy ,long , long , TimeUnit )
     */
    public static synchronized final LogCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new LogCacheManager(updateStrategy,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final LogCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final LogCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final LogCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link LogCache} */
    private final LogCache cache;
    /** constructor<br>
     * @see LogCache#LogCache(UpdateStrategy ,long , long , TimeUnit )
     */
    protected LogCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new LogCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected DeviceManager instanceOfDeviceManager(){
        try{
            return DeviceCacheManager.getInstance();
        } catch(IllegalStateException e){
            return DeviceManager.getInstance();
        }
    }
    @Override
    protected FaceManager instanceOfFaceManager(){
        try{
            return FaceCacheManager.getInstance();
        } catch(IllegalStateException e){
            return FaceManager.getInstance();
        }
    }
    @Override
    protected FeatureManager instanceOfFeatureManager(){
        try{
            return FeatureCacheManager.getInstance();
        } catch(IllegalStateException e){
            return FeatureManager.getInstance();
        }
    }
    @Override
    protected PersonManager instanceOfPersonManager(){
        try{
            return PersonCacheManager.getInstance();
        } catch(IllegalStateException e){
            return PersonManager.getInstance();
        }
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override ILogManager

    @Override 
    public LogBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override ILogManager

    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
    }
    private class CacheAction implements Action<LogBean>{
        final Action<LogBean> action;
        CacheAction(Action<LogBean>action){
            this.action = action;
        }
        @Override
        public void call(LogBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public LogBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(LogBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<LogBean> action){
        if(null == fieldList ){
            action = new CacheAction(action);
        }
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________
    //12

    @Override
    public LogBean save(LogBean bean){
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getId())).resetIsModified();
        }
        return bean;
    }

}
