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
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.ITableCache;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IPersonManager;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.mysql.Cache.FeatureCache;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.mysql.Cache.LogCache;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.mysql.Cache.ImageCache;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.db.mysql.PersonManager;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.mysql.Cache.PersonCache;

/**
 * Handles database calls (save, load, count, etc...) for the fl_person table.<br>
 * @author guyadong
 */
public class PersonCachemanager extends PersonManager
{
    private PersonManager nativeManager = PersonManager.getInstance();
    private final PersonCache personCache;
    private FeatureCache featureCache;
    public void setFeatureCache(FeatureCache featureCache){
        this.featureCache = featureCache;
    }
    private LogCache logCache;
    public void setLogCache(LogCache logCache){
        this.logCache = logCache;
    }
    private ImageCache imageCache;
    public void setImageCache(ImageCache imageCache){
        this.imageCache = imageCache;
    }
    public PersonCachemanager(long maximumSize, long duration, TimeUnit unit) {
        this.personCache = new PersonCache(maximumSize,duration,unit);
    }
    public PersonCachemanager(long maximumSize, long durationMinutes) {
        this(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }

    public PersonCachemanager(long maximumSize) {
        this(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    public PersonCachemanager() {
        this(ITableCache.DEFAULT_CACHE_MAXIMUMSIZE,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IPersonManager
    @Override 
    public PersonBean loadByPrimaryKey(Integer id)
    {
        return personCache.getBean(id);
    }

    //1.2
    @Override
    public PersonBean loadByPrimaryKey(PersonBean bean)
    {        
        return null == bean ? null : personCache.getBean(bean.getId());
    }


    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////

    //3.2 GET IMPORTED override IPersonManager
    @Override 
    public java.util.List<FeatureBean> getFeatureBeansByPersonIdAsList(PersonBean bean)
    {
        return (java.util.List<FeatureBean>)featureCache.put(super.getFeatureBeansByPersonIdAsList(bean));
    }

    //3.2 GET IMPORTED override IPersonManager
    @Override 
    public java.util.List<LogBean> getLogBeansByPersonIdAsList(PersonBean bean)
    {
        return (java.util.List<LogBean>)logCache.put(super.getLogBeansByPersonIdAsList(bean));
    }


    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override IPersonManager
    @Override 
    public ImageBean getReferencedByImageMd5(PersonBean bean)
    {
        if(null == bean)return null;
        bean.setReferencedByImageMd5(imageCache.getBean(bean.getImageMd5())); 
        return bean.getReferencedByImageMd5();        
    }
    private class CacheAction implements Action<PersonBean>{
        final Action<PersonBean> action;
        CacheAction(Action<PersonBean>action){
            this.action = action;            
        }
        @Override
        public void call(PersonBean bean) {
            if(null != action){
                action.call(bean);
            }
            personCache.put(bean);
        }
        @Override
        public PersonBean getBean() {
            return null == action?null:action.getBean();
        }}
    //20-5
    @Override
    public int loadUsingTemplate(PersonBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PersonBean> action)
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
