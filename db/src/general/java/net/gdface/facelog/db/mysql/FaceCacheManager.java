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
     * @see {@link FaceCacheManager#FaceCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final FaceCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new FaceCacheManager(updateStragey,maximumSize,duration,unit);
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
     * @see {@link FaceCache#FaceCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected FaceCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new FaceCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IFaceManager
    @Override 
    public FaceBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override IFaceManager
    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override IFaceManager
    @Override 
    public FeatureBean getReferencedByFeatureMd5(FaceBean bean){
        if(null == bean)return null;
        bean.setReferencedByFeatureMd5(FeatureCacheManager.getInstance().loadByPrimaryKey(bean.getFeatureMd5())); 
        return bean.getReferencedByFeatureMd5();
    }
    //5.1 GET REFERENCED VALUE override IFaceManager
    @Override 
    public ImageBean getReferencedByImageMd5(FaceBean bean){
        if(null == bean)return null;
        bean.setReferencedByImageMd5(ImageCacheManager.getInstance().loadByPrimaryKey(bean.getImageMd5())); 
        return bean.getReferencedByImageMd5();
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
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }


}
