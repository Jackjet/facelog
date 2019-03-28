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
import net.gdface.facelog.db.PermitBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.mysql.PersonGroupManager;
import net.gdface.facelog.db.PersonGroupBean;
import net.gdface.facelog.db.mysql.PersonGroupCache;

/**
 * cache implementation for PersonGroupManager<br>
 * @author guyadong
 */
public class PersonGroupCacheManager extends PersonGroupManager
{
    /** singleton of PersonGroupCacheManager */
    private static PersonGroupCacheManager instance;
    /** 
     * @return a instance of PersonGroupCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final PersonGroupCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of PersonGroupCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of PersonGroupCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see PersonGroupCacheManager#PersonGroupCacheManager(UpdateStrategy ,long , long , TimeUnit )
     */
    public static synchronized final PersonGroupCacheManager makeInstance(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new PersonGroupCacheManager(updateStrategy,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final PersonGroupCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PersonGroupCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final PersonGroupCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link PersonGroupCache} */
    private final PersonGroupCache cache;
    /** constructor<br>
     * @see PersonGroupCache#PersonGroupCache(UpdateStrategy ,long , long , TimeUnit )
     */
    protected PersonGroupCacheManager(UpdateStrategy updateStrategy,long maximumSize, long duration, TimeUnit unit) {
        cache = new PersonGroupCache(updateStrategy,maximumSize,duration,unit);
        cache.registerListener();
    }
    
    @Override
    protected PermitManager instanceOfPermitManager(){
        if(PermitCacheManager.getInstance() == null){
            PermitManager.getInstance();
        }
        return PermitCacheManager.getInstance();
    }
    @Override
    protected PersonManager instanceOfPersonManager(){
        if(PersonCacheManager.getInstance() == null){
            PersonManager.getInstance();
        }
        return PersonCacheManager.getInstance();
    }
    @Override
    protected DeviceGroupManager instanceOfDeviceGroupManager(){
        if(DeviceGroupCacheManager.getInstance() == null){
            DeviceGroupManager.getInstance();
        }
        return DeviceGroupCacheManager.getInstance();
    }
    @Override
    protected PersonGroupCacheManager instanceOfPersonGroupManager(){
        return this;
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IPersonGroupManager

    @Override 
    public PersonGroupBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override IPersonGroupManager

    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
    }
    private class CacheAction implements Action<PersonGroupBean>{
        final Action<PersonGroupBean> action;
        CacheAction(Action<PersonGroupBean>action){
            this.action = action;
        }
        @Override
        public void call(PersonGroupBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public PersonGroupBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5

    @Override
    public int loadUsingTemplate(PersonGroupBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PersonGroupBean> action){
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
    public PersonGroupBean save(PersonGroupBean bean){
        // check cycle for the self-reference field before save
        checkCycleOfParent(bean);
        boolean modified = null == bean ? false : bean.isModified();
        super.save(bean);
        if( modified && UpdateStrategy.refresh == cache.getUpdateStrategy() ){
            bean.copy(cache.getBeanUnchecked(bean.getId())).resetIsModified();
        }
        return bean;
    }

    //_____________________________________________________________________
    //
    // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
    //_____________________________________________________________________
    //23 MANY TO MANY
    // override PersonGroupManager

    @Override 
    public java.util.List<PersonGroupBean> loadViaPermitAsList(DeviceGroupBean bean, int startRow, int numRows)
    {
        PermitManager m = instanceOfPermitManager();
        java.util.List<PermitBean> junctions;
        if(m instanceof PermitCacheManager){
            junctions = 
                    com.google.common.collect.Lists.newArrayList(((PermitCacheManager)m).getBeanByDeviceGroupIdUnchecked(bean.getId()));
        }else{
            PermitBean template = PermitBean.builder().personGroupId(bean.getId()).build();
            junctions = 
                    m.loadUsingTemplateAsList(template);
        }
        startRow = Math.min(Math.max(0, startRow - 1), junctions.size() - 1);
        numRows = numRows < 0 ? junctions.size():Math.min(junctions.size(), numRows);
        numRows = Math.min(junctions.size() - startRow , numRows) ;
        junctions = com.google.common.collect.Ordering
                    .natural()
                    .onResultOf(new com.google.common.base.Function<PermitBean,Integer>(){
                        @Override
                        public Integer apply(PermitBean input) {
                            return input.getPersonGroupId();
                        }})
                    .sortedCopy(junctions)
                    .subList(startRow, startRow + numRows);
        java.util.ArrayList<PersonGroupBean> lbeans = new java.util.ArrayList<PersonGroupBean>(junctions.size());
        for(PermitBean jbean:junctions){
            try{
                lbeans.add(loadByPrimaryKeyChecked(jbean.getPersonGroupId()));
            }catch(ObjectRetrievalException  e){}
        }
        return lbeans;
    }
}
