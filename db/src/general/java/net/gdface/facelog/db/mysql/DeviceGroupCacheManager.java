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
import net.gdface.facelog.db.PermitBean;
import net.gdface.facelog.db.PersonGroupBean;
import net.gdface.facelog.db.mysql.DeviceGroupManager;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.mysql.DeviceGroupCache;

/**
 * cache implementation for DeviceGroupManager<br>
 * @author guyadong
 */
public class DeviceGroupCacheManager extends DeviceGroupManager
{
    /** singleton of DeviceGroupCacheManager */
    private static DeviceGroupCacheManager instance;
    /** 
     * @return a instance of DeviceGroupCacheManager
     * @throws IllegalStateException while {@link #instance} is null
     */
    public static final DeviceGroupCacheManager getInstance(){
        if(null == instance){
            throw new IllegalStateException("uninitialized instance of DeviceGroupCacheManager");
        }
        return instance;
    }
    /**
     * create a instance of DeviceGroupCacheManager and assign to {@link #instance} if {@code instance} is not initialized.<br>
     * otherwise return {@code instance}.
     * @see {@link DeviceGroupCacheManager#DeviceGroupCacheManager(UpdateStrategy ,long , long , TimeUnit )}
     */
    public static synchronized final DeviceGroupCacheManager makeInstance(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit){
        if(null == instance){
            instance = new DeviceGroupCacheManager(updateStragey,maximumSize,duration,unit);
        }
        return instance;
    }
    /** @see #makeInstance(UpdateStrategy,long, long, TimeUnit) */
    public static final DeviceGroupCacheManager makeInstance(long maximumSize, long duration, TimeUnit unit){
        return makeInstance(ITableCache.DEFAULT_STRATEGY,maximumSize, duration, unit);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final DeviceGroupCacheManager makeInstance(long maximumSize, long durationMinutes){
        return makeInstance(maximumSize, durationMinutes, ITableCache.DEFAULT_TIME_UNIT);
    }
    /** @see #makeInstance(long, long, TimeUnit) */
    public static final DeviceGroupCacheManager makeInstance(long maximumSize){
        return makeInstance(maximumSize,ITableCache.DEFAULT_DURATION,ITableCache.DEFAULT_TIME_UNIT);
    }
    /** instance of {@link DeviceGroupCache} */
    private final DeviceGroupCache cache;
    /** constructor<br>
     * @see {@link DeviceGroupCache#DeviceGroupCache(UpdateStrategy ,long , long , TimeUnit )}
     */
    protected DeviceGroupCacheManager(UpdateStrategy updateStragey,long maximumSize, long duration, TimeUnit unit) {
        cache = new DeviceGroupCache(updateStragey,maximumSize,duration,unit);
        cache.registerListener();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1.1 override IDeviceGroupManager
    @Override 
    public DeviceGroupBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    //1.4 override IDeviceGroupManager
    @Override 
    public boolean existsPrimaryKey(Integer id){
        return null != loadByPrimaryKey(id);
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////

    //5.1 GET REFERENCED VALUE override IDeviceGroupManager
    @Override 
    public DeviceGroupBean getReferencedByParent(DeviceGroupBean bean){
        if(null == bean)return null;
        bean.setReferencedByParent(loadByPrimaryKey(bean.getParent())); 
        return bean.getReferencedByParent();
    }
    private class CacheAction implements Action<DeviceGroupBean>{
        final Action<DeviceGroupBean> action;
        CacheAction(Action<DeviceGroupBean>action){
            this.action = action;
        }
        @Override
        public void call(DeviceGroupBean bean) {
            if(null != action){
                action.call(bean);
            }
            cache.update(bean);
        }
        @Override
        public DeviceGroupBean getBean() {
            return null == action?null:action.getBean();
        }
    }
    //20-5
    @Override
    public int loadUsingTemplate(DeviceGroupBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<DeviceGroupBean> action){
        if(null == fieldList )
            action = new CacheAction(action);
        return super.loadUsingTemplate(bean,fieldList,startRow,numRows,searchType,action);
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________
    //12
    /**
     * check cycle for the self-reference field before save
     */
    @Override
    public DeviceGroupBean save(DeviceGroupBean bean){
        checkCycleOfParent(bean);
        return super.save(bean);
    }

    //_____________________________________________________________________
    //
    // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
    //_____________________________________________________________________
    //23 MANY TO MANY
    // override DeviceGroupManager
    @Override 
    public java.util.List<DeviceGroupBean> loadViaPermitAsList(PersonGroupBean bean, int startRow, int numRows)
    {
        java.util.List<PermitBean> junctions = 
            com.google.common.collect.Lists.newArrayList(PermitCacheManager.getInstance().getBeanByPersonGroupIdUnchecked(bean.getId()));
        startRow = Math.min(Math.max(0, startRow - 1), junctions.size() - 1);
        numRows = numRows < 0 ? junctions.size():Math.min(junctions.size(), numRows);
        numRows = Math.min(junctions.size() - startRow , numRows) ;
        junctions = com.google.common.collect.Ordering
                    .natural()
                    .onResultOf(new com.google.common.base.Function<PermitBean,Integer>(){
                        @Override
                        public Integer apply(PermitBean input) {
                            return input.getDeviceGroupId();
                        }})
                    .sortedCopy(junctions)
                    .subList(startRow, startRow + numRows);
        java.util.ArrayList<DeviceGroupBean> lbeans = new java.util.ArrayList<DeviceGroupBean>(junctions.size());
        for(PermitBean jbean:junctions){
            try{
                lbeans.add(loadByPrimaryKeyChecked(jbean.getDeviceGroupId()));
            }catch(ObjectRetrievalException  e){}
        }
        return lbeans;
    }
}
