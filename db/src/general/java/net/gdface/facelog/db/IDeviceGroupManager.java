// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.interface.java.vm
// ______________________________________________________
package net.gdface.facelog.db;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.WrapDAOException;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_device_group table.<br>
 * Remarks: 设备组信息
 * @author guyadong
 */
public interface IDeviceGroupManager extends TableManager<DeviceGroupBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a {@link DeviceGroupBean} from the fl_device_group using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique DeviceGroupBean or {@code null} if not found
     */
    //1
    public DeviceGroupBean loadByPrimaryKey(Integer id);

    /**
     * Loads a {@link DeviceGroupBean} from the fl_device_group using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique DeviceGroupBean
     * @throws ObjectRetrievalException if not found
     */
    //1.1
    public DeviceGroupBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException;
    
    /**
     * Returns true if this fl_device_group contains row with primary key fields.
     * @param id Integer - PK# 1
     * @see #loadByPrimaryKey($keys)
     */
    //1.4
    public boolean existsPrimaryKey(Integer id);
    /**
     * Check duplicated row by primary keys,if row exists throw exception
     * @param id Integer
     */
    //1.4.1
    public Integer checkDuplicate(Integer id);
    /**
     * Loads {@link DeviceGroupBean} from the fl_device_group using primary key fields.
     *
     * @param keys primary keys array
     * @return list of DeviceGroupBean
     */
    //1.8
    public java.util.List<DeviceGroupBean> loadByPrimaryKey(int... keys);
    /**
     * Loads {@link DeviceGroupBean} from the fl_device_group using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of DeviceGroupBean
     */
    //1.9
    public java.util.List<DeviceGroupBean> loadByPrimaryKey(java.util.Collection<Integer> keys);
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //2
    public int deleteByPrimaryKey(Integer id);
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys array
     * @return the number of deleted rows
     */
    //2.2
    public int deleteByPrimaryKey(int... keys);
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys collection
     * @return the number of deleted rows
     */
    //2.3
    public int deleteByPrimaryKey(java.util.Collection<Integer> keys);
    /**
     * Delete beans.<br>
     *
     * @param beans DeviceGroupBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.4
    public int delete(DeviceGroupBean... beans);
    /**
     * Delete beans.<br>
     *
     * @param beans DeviceGroupBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.5
    public int delete(java.util.Collection<DeviceGroupBean> beans);
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link JunctionDeviceGroupBean} object from the fl_junction_device_group.group_id field.<BR>
     * FK_NAME : fl_junction_device_group_ibfk_2 
     * @param bean the {@link DeviceGroupBean}
     * @return the associated {@link JunctionDeviceGroupBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public JunctionDeviceGroupBean[] getJunctionDeviceGroupBeansByGroupId(DeviceGroupBean bean);
    
    /**
     * Retrieves the {@link JunctionDeviceGroupBean} object from the fl_junction_device_group.group_id field.<BR>
     * FK_NAME : fl_junction_device_group_ibfk_2 
     * @param id Integer - PK# 1
     * @return the associated {@link JunctionDeviceGroupBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws DAOException
     */
    //3.1.2 GET IMPORTED
    public JunctionDeviceGroupBean[] getJunctionDeviceGroupBeansByGroupId(Integer devicegroupId);
    
    /**
     * @see #getJunctionDeviceGroupBeansByGroupIdAsList(DeviceGroupBean,int,int)
     */
    //3.2 GET IMPORTED
    public java.util.List<JunctionDeviceGroupBean> getJunctionDeviceGroupBeansByGroupIdAsList(DeviceGroupBean bean);

    /**
     * Retrieves the {@link JunctionDeviceGroupBean} object from fl_junction_device_group.group_id field.<BR>
     * FK_NAME:fl_junction_device_group_ibfk_2
     * @param id Integer - PK# 1
     * @return the associated {@link JunctionDeviceGroupBean} beans 
     * @throws DAOException
     */
    //3.2.2 GET IMPORTED
    public java.util.List<JunctionDeviceGroupBean> getJunctionDeviceGroupBeansByGroupIdAsList(Integer devicegroupId);
    /**
     * delete the associated {@link JunctionDeviceGroupBean} objects from fl_junction_device_group.group_id field.<BR>
     * FK_NAME:fl_junction_device_group_ibfk_2
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //3.2.3 DELETE IMPORTED
    public int deleteJunctionDeviceGroupBeansByGroupId(Integer devicegroupId);
    /**
     * Retrieves the {@link JunctionDeviceGroupBean} object from fl_junction_device_group.group_id field.<BR>
     * FK_NAME:fl_junction_device_group_ibfk_2
     * @param bean the {@link DeviceGroupBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link JunctionDeviceGroupBean} beans or empty list if {@code bean} is {@code null}
     */
    //3.2.4 GET IMPORTED
    public java.util.List<JunctionDeviceGroupBean> getJunctionDeviceGroupBeansByGroupIdAsList(DeviceGroupBean bean,int startRow,int numRows);    
    /**
     * set  the {@link JunctionDeviceGroupBean} object array associate to DeviceGroupBean by the fl_junction_device_group.group_id field.<BR>
     * FK_NAME : fl_junction_device_group_ibfk_2 
     * @param bean the referenced {@link DeviceGroupBean}
     * @param importedBeans imported beans from fl_junction_device_group
     * @return importedBeans always
     * @see {@link JunctionDeviceGroupManager#setReferencedByGroupId(JunctionDeviceGroupBean, DeviceGroupBean)
     */
    //3.3 SET IMPORTED
    public JunctionDeviceGroupBean[] setJunctionDeviceGroupBeansByGroupId(DeviceGroupBean bean , JunctionDeviceGroupBean[] importedBeans);

    /**
     * set  the {@link JunctionDeviceGroupBean} object java.util.Collection associate to DeviceGroupBean by the fl_junction_device_group.group_id field.<BR>
     * FK_NAME:fl_junction_device_group_ibfk_2
     * @param bean the referenced {@link DeviceGroupBean} 
     * @param importedBeans imported beans from fl_junction_device_group 
     * @return importedBeans always
     * @see {@link JunctionDeviceGroupManager#setReferencedByGroupId(JunctionDeviceGroupBean, DeviceGroupBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<JunctionDeviceGroupBean>> C setJunctionDeviceGroupBeansByGroupId(DeviceGroupBean bean , C importedBeans);

    /**
     * Save the DeviceGroupBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link DeviceGroupBean} bean to be saved
         * @param impJunctiondevicegroupByGroupId the {@link JunctionDeviceGroupBean} bean refer to {@link DeviceGroupBean} 
     * @return the inserted or updated {@link DeviceGroupBean} bean
     */
    //3.5 SYNC SAVE 
    public DeviceGroupBean save(DeviceGroupBean bean
        
        , JunctionDeviceGroupBean[] impJunctiondevicegroupByGroupId );
    /**
     * Transaction version for sync save
     * @see {@link #save(DeviceGroupBean , JunctionDeviceGroupBean[] )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public DeviceGroupBean saveAsTransaction(final DeviceGroupBean bean
        
        ,final JunctionDeviceGroupBean[] impJunctiondevicegroupByGroupId );
    /**
     * Save the DeviceGroupBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link DeviceGroupBean} bean to be saved
         * @param impJunctiondevicegroupByGroupId the {@link JunctionDeviceGroupBean} bean refer to {@link DeviceGroupBean} 
     * @return the inserted or updated {@link DeviceGroupBean} bean
     */
    //3.7 SYNC SAVE 
    public DeviceGroupBean save(DeviceGroupBean bean
        
        , java.util.Collection<JunctionDeviceGroupBean> impJunctiondevicegroupByGroupId );
    /**
     * Transaction version for sync save
     * @see {@link #save(DeviceGroupBean , java.util.Collection )}
     */
    //3.8 SYNC SAVE AS TRANSACTION
    public DeviceGroupBean saveAsTransaction(final DeviceGroupBean bean
        
        ,final  java.util.Collection<JunctionDeviceGroupBean> impJunctiondevicegroupByGroupId );
  
    /**
     * return a primary key list from {@link DeviceGroupBean} array
     * @param array
     */
    //45
    public java.util.List<Integer> toPrimaryKeyList(DeviceGroupBean... array);
    /**
     * return a primary key list from {@link DeviceGroupBean} collection
     * @param array
     */
    //46
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<DeviceGroupBean> collection);

    //_____________________________________________________________________
    //
    // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
    //_____________________________________________________________________
    /**
     * @see #loadViaJunctionDeviceGroupAsList(DeviceGroupBean,int,int)
     */
    //22 MANY TO MANY
    public java.util.List<DeviceGroupBean> loadViaJunctionDeviceGroupAsList(DeviceBean bean);

    /**
     * Retrieves an list of DeviceGroupBean using the junction table JunctionDeviceGroup, given a DeviceBean, 
     * specifying the start row and the number of rows.
     *
     * @param bean the DeviceBean bean to be used
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return a list of DeviceGroupBean
     */
    //23 MANY TO MANY
    public java.util.List<DeviceGroupBean> loadViaJunctionDeviceGroupAsList(DeviceBean bean, int startRow, int numRows);
    /**
     * add junction between {@link DeviceGroupBean} and {@link DeviceBean} if junction not exists
     * @param bean
     * @param linked
     */
    //23.2 MANY TO MANY
    public void addJunction(DeviceGroupBean bean,DeviceBean linked);
    /**
     * remove junction between {@link DeviceGroupBean} and {@link DeviceBean}
     * @param bean
     * @param linked
     */
    //23.3 MANY TO MANY
    public int deleteJunction(DeviceGroupBean bean,DeviceBean linked);
    /** @see #addJunction(DeviceGroupBean,DeviceBean) */
    //23.4 MANY TO MANY
    public void addJunction(DeviceGroupBean bean,DeviceBean... linkedBeans);
    /** @see #addJunction(DeviceGroupBean,DeviceBean) */
    //23.5 MANY TO MANY
    public void addJunction(DeviceGroupBean bean,java.util.Collection<DeviceBean> linkedBeans);
    /** @see #deleteJunction(DeviceGroupBean,DeviceBean) */
    //23.6 MANY TO MANY
    public int deleteJunction(DeviceGroupBean bean,DeviceBean... linkedBeans);
    /** @see #deleteJunction(DeviceGroupBean,DeviceBean) */
    //23.7 MANY TO MANY
    public int deleteJunction(DeviceGroupBean bean,java.util.Collection<DeviceBean> linkedBeans);
}
