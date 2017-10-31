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
     * @see {@link LogCacheManager#LogCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final LogCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new LogCacheManager(updateStragey,maximumSize,duration,unit);
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
     * @see {@link LogCache#LogCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected LogCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new LogCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override ILogManager
    @Override 
    public LogBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override ILogManager
    @Override 
    public boolean existsPrimaryKey(Integer id)
    {
        if(null != cache.getBeanIfPresent(id))return true;
        return super.existsPrimaryKey(id);
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public DeviceBean getReferencedByDeviceId(LogBean bean){
        if(null == bean)return null;
        bean.setReferencedByDeviceId(DeviceCacheManager.getInstance().loadByPrimaryKey(bean.getDeviceId())); 
        return bean.getReferencedByDeviceId();
    }
    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public FaceBean getReferencedByCompareFace(LogBean bean){
        if(null == bean)return null;
        bean.setReferencedByCompareFace(FaceCacheManager.getInstance().loadByPrimaryKey(bean.getCompareFace())); 
        return bean.getReferencedByCompareFace();
    }
    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public FeatureBean getReferencedByVerifyFeature(LogBean bean){
        if(null == bean)return null;
        bean.setReferencedByVerifyFeature(FeatureCacheManager.getInstance().loadByPrimaryKey(bean.getVerifyFeature())); 
        return bean.getReferencedByVerifyFeature();
    }
    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public PersonBean getReferencedByPersonId(LogBean bean){
        if(null == bean)return null;
        bean.setReferencedByPersonId(PersonCacheManager.getInstance().loadByPrimaryKey(bean.getPersonId())); 
        return bean.getReferencedByPersonId();
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
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }


}
