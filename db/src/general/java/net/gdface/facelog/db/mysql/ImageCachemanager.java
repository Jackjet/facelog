// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import net.gdface.facelog.db.Constant;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.ITableCache;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IImageManager;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.mysql.Cache.FaceCache;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.mysql.Cache.PersonCache;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.mysql.Cache.DeviceCache;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.db.mysql.ImageManager;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.mysql.Cache.ImageCache;

/**
 * Handles database calls (save, load, count, etc...) for the fl_image table.<br>
 * @author guyadong
 */
public class ImageCachemanager extends ImageManager
{
    private ImageManager nativeManager = ImageManager.getInstance();
    private final ImageCache imageCache;
    private FaceCache faceCache;
    public void setFaceCache(FaceCache faceCache){
        this.faceCache = faceCache;
    }
    private PersonCache personCache;
    public void setPersonCache(PersonCache personCache){
        this.personCache = personCache;
    }
    private DeviceCache deviceCache;
    public void setDeviceCache(DeviceCache deviceCache){
        this.deviceCache = deviceCache;
    }
    public ImageCachemanager(long maximumSize, long duration, TimeUnit unit) {
        this.imageCache = new ImageCache(maximumSize,duration,unit);
    }
    public ImageCachemanager(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }

    public ImageCachemanager(long maximumSize) {
        this(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    public ImageCachemanager() {
        this(ITableCache.DEFAULT_CACHE_MAXIMUMSIZE,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IImageManager
    @Override 
    public ImageBean loadByPrimaryKey(String md5)
    {
        return imageCache.getBean(md5);
    }

    //1.2
    @Override
    public ImageBean loadByPrimaryKey(ImageBean bean)
    {        
        return null == bean ? null : imageCache.getBean(bean.getMd5());
    }


    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////

    //3.2 GET IMPORTED override IImageManager
    @Override 
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(ImageBean bean)
    {
        return (java.util.List<FaceBean>)faceCache.put(super.getFaceBeansByImageMd5AsList(bean));
    }

    //3.2 GET IMPORTED override IImageManager
    @Override 
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(ImageBean bean)
    {
        return (java.util.List<PersonBean>)personCache.put(super.getPersonBeansByImageMd5AsList(bean));
    }


    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override IImageManager
    @Override 
    public DeviceBean getReferencedByDeviceId(ImageBean bean)
    {
        if(null == bean)return null;
        bean.setReferencedByDeviceId(deviceCache.getBean(bean.getDeviceId())); 
        return bean.getReferencedByDeviceId();        
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
            imageCache.put(bean);
        }
        @Override
        public ImageBean getBean() {
            return null == action?null:action.getBean();
        }}
    //20-5
    @Override
    public int loadUsingTemplate(ImageBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<ImageBean> action)
    {
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


}
