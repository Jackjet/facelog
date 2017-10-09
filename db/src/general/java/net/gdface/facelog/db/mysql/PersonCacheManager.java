// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.concurrent.TimeUnit;

import net.gdface.facelog.db.ITableCache;
import net.gdface.facelog.db.ITableCache.UpdateStrategy;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.mysql.ImageCacheManager;
import net.gdface.facelog.db.mysql.PersonManager;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.mysql.PersonCache;

/**
 * cache implementation for PersonManager<br>
 * @author guyadong
 */
public class PersonCacheManager extends PersonManager
{
    /** singleton of PersonCacheManager */
    private static PersonCacheManager instance;
    /** 
     * @return a instance of PersonCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final PersonCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of PersonCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of PersonCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see {@link PersonCacheManager#PersonCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final PersonCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new PersonCacheManager(updateStragey,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final PersonCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PersonCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PersonCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link PersonCache} */
    private final PersonCache cache;
    /** constructor<br>
     * @see {@link PersonCache#PersonCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected PersonCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new PersonCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IPersonManager
    @Override 
    public PersonBean loadByPrimaryKey(Integer id){
        return cache.getBean(id);
    }

    //1.2
    @Override
    public PersonBean loadByPrimaryKey(PersonBean bean){        
        return null == bean ? null : loadByPrimaryKey(bean.getId());
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override IPersonManager
    @Override 
    public ImageBean getReferencedByImageMd5(PersonBean bean){
        if(null == bean)return null;
        bean.setReferencedByImageMd5(ImageCacheManager.getInstance().loadByPrimaryKey(bean.getImageMd5())); 
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
            cache.update(bean);
        }
        @Override
        public PersonBean getBean() {
            return null == action?null:action.getBean();
        }}
    //20-5
    @Override
    public int loadUsingTemplate(PersonBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PersonBean> action){
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________
    // override IPersonManager
    @Override 
    public PersonBean loadByIndexImageMd5(String imageMd5){
        return cache.getBeanByImageMd5(imageMd5);
    }
    // override IPersonManager
    @Override 
    public PersonBean loadByIndexPapersNum(String papersNum){
        return cache.getBeanByPapersNum(papersNum);
    }
}
