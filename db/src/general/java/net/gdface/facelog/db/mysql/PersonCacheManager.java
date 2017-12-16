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
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.PersonGroupBean;
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
    public static synchronized final PersonCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new PersonCacheManager(updateStrategy,maximumSize,duration,unit);
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
    protected PersonCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new PersonCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected FeatureCacheManager instanceOfFeatureManager(){
        return FeatureCacheManager.getInstance();
    }
    @Override
    protected LogCacheManager instanceOfLogManager(){
        return LogCacheManager.getInstance();
    }
    @Override
    protected ImageCacheManager instanceOfImageManager(){
        return ImageCacheManager.getInstance();
    }
    @Override
    protected PersonGroupCacheManager instanceOfPersonGroupManager(){
        return PersonGroupCacheManager.getInstance();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IPersonManager

    @Override 
    public PersonBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override IPersonManager

    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
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
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(PersonBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PersonBean> action){
        if(null == fieldList ){
            action = new CacheAction(action);
        }
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________
    // override PersonManager

    @Override 
    public PersonBean loadByIndexImageMd5Checked(String imageMd5) throws ObjectRetrievalException{
        if(null == imageMd5){
            throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBeanByImageMd5(imageMd5);
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
    // override PersonManager

    @Override 
    public PersonBean loadByIndexPapersNumChecked(String papersNum) throws ObjectRetrievalException{
        if(null == papersNum){
            throw new ObjectRetrievalException(new NullPointerException());
        }
        try{
            return cache.getBeanByPapersNum(papersNum);
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
    public PersonBean save(PersonBean bean){
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getId())).resetIsModified();
        }
        return bean;
    }

}
