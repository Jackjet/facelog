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
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.mysql.FaceManager;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.mysql.FaceCache;

/**
 * cache implementation for FaceManager<br>
 * @author guyadong
 */
public class FaceCacheManager extends FaceManager
{
    /** singleton of FaceCacheManager */
    private static FaceCacheManager instance;
    /** 
     * @return a instance of FaceCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final FaceCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of FaceCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of FaceCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see FaceCacheManager#FaceCacheManager(UpdateStrategy ,long , long , TimeUnit )
     */
    public static synchronized final FaceCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new FaceCacheManager(updateStrategy,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final FaceCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final FaceCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final FaceCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link FaceCache} */
    private final FaceCache cache;
    /** constructor<br>
     * @see FaceCache#FaceCache(UpdateStrategy ,long , long , TimeUnit )
     */
    protected FaceCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new FaceCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected LogManager instanceOfLogManager(){
        try{
            return LogCacheManager.getInstance();
        } catch(IllegalStateException e){
            return LogManager.getInstance();
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
    protected ImageManager instanceOfImageManager(){
        try{
            return ImageCacheManager.getInstance();
        } catch(IllegalStateException e){
            return ImageManager.getInstance();
        }
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IFaceManager

    @Override 
    public FaceBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override IFaceManager

    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
    }
    private class CacheAction implements Action<FaceBean>{
        final Action<FaceBean> action;
        CacheAction(Action<FaceBean>action){
            this.action = action;
        }
        @Override
        public void call(FaceBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public FaceBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(FaceBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<FaceBean> action){
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
    public FaceBean save(FaceBean bean){
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getId())).resetIsModified();
        }
        return bean;
    }

}
