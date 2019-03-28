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
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.mysql.ImageManager;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.mysql.ImageCache;

/**
 * cache implementation for ImageManager<br>
 * @author guyadong
 */
public class ImageCacheManager extends ImageManager
{
    /** singleton of ImageCacheManager */
    private static ImageCacheManager instance;
    /** 
     * @return a instance of ImageCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final ImageCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of ImageCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of ImageCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see ImageCacheManager#ImageCacheManager(UpdateStrategy ,long , long , TimeUnit )
     */
    public static synchronized final ImageCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new ImageCacheManager(updateStrategy,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final ImageCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final ImageCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final ImageCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link ImageCache} */
    private final ImageCache cache;
    /** constructor<br>
     * @see ImageCache#ImageCache(UpdateStrategy ,long , long , TimeUnit )
     */
    protected ImageCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new ImageCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected FaceManager instanceOfFaceManager(){
        if(FaceCacheManager.getInstance() == null){
            FaceManager.getInstance();
        }
        return FaceCacheManager.getInstance();
    }
    @Override
    protected PersonManager instanceOfPersonManager(){
        if(PersonCacheManager.getInstance() == null){
            PersonManager.getInstance();
        }
        return PersonCacheManager.getInstance();
    }
    @Override
    protected DeviceManager instanceOfDeviceManager(){
        if(DeviceCacheManager.getInstance() == null){
            DeviceManager.getInstance();
        }
        return DeviceCacheManager.getInstance();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IImageManager

    @Override 
    public ImageBean loadByPrimaryKeyChecked(String md5) throws ObjectRetrievalException
    {
        if(null == md5){
           throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBean(md5);
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
    //1.4 override IImageManager

    @Override 
    public boolean existsPrimaryKey(String md5){
        return null != loadByPrimaryKey(md5);
    }
    private class CacheAction implements Action<ImageBean>{
        final Action<ImageBean> action;
        CacheAction(Action<ImageBean>action){
            this.action = action;
        }
        @Override
        public void call(ImageBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public ImageBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(ImageBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<ImageBean> action){
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
    public ImageBean save(ImageBean bean){
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getMd5())).resetIsModified();
        }
        return bean;
    }

}
