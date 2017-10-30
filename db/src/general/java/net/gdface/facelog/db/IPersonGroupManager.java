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
 * Interface to handle database calls (save, load, count, etc...) for the fl_person_group table.<br>
 * Remarks: 用户组信息
 * @author guyadong
 */
public interface IPersonGroupManager extends TableManager<PersonGroupBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a {@link PersonGroupBean} from the fl_person_group using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique PersonGroupBean or {@code null} if not found
     */
    //1
    public PersonGroupBean loadByPrimaryKey(Integer id);

    /**
     * Loads a {@link PersonGroupBean} from the fl_person_group using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique PersonGroupBean
     * @throws ObjectRetrievalException if not found
     */
    //1.1
    public PersonGroupBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException;
    
    /**
     * Returns true if this fl_person_group contains row with primary key fields.
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
     * Loads {@link PersonGroupBean} from the fl_person_group using primary key fields.
     *
     * @param keys primary keys array
     * @return list of PersonGroupBean
     */
    //1.8
    public java.util.List<PersonGroupBean> loadByPrimaryKey(int... keys);
    /**
     * Loads {@link PersonGroupBean} from the fl_person_group using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of PersonGroupBean
     */
    //1.9
    public java.util.List<PersonGroupBean> loadByPrimaryKey(java.util.Collection<Integer> keys);
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
     * @param beans PersonGroupBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.4
    public int delete(PersonGroupBean... beans);
    /**
     * Delete beans.<br>
     *
     * @param beans PersonGroupBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.5
    public int delete(java.util.Collection<PersonGroupBean> beans);
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link JunctionPersonGroupBean} object from the fl_junction_person_group.group_id field.<BR>
     * FK_NAME : fl_junction_person_group_ibfk_2 
     * @param bean the {@link PersonGroupBean}
     * @return the associated {@link JunctionPersonGroupBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public JunctionPersonGroupBean[] getJunctionPersonGroupBeansByGroupId(PersonGroupBean bean);
    
    /**
     * Retrieves the {@link JunctionPersonGroupBean} object from the fl_junction_person_group.group_id field.<BR>
     * FK_NAME : fl_junction_person_group_ibfk_2 
     * @param id Integer - PK# 1
     * @return the associated {@link JunctionPersonGroupBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws DAOException
     */
    //3.1.2 GET IMPORTED
    public JunctionPersonGroupBean[] getJunctionPersonGroupBeansByGroupId(Integer persongroupId);
    
    /**
     * @see #getJunctionPersonGroupBeansByGroupIdAsList(PersonGroupBean,int,int)
     */
    //3.2 GET IMPORTED
    public java.util.List<JunctionPersonGroupBean> getJunctionPersonGroupBeansByGroupIdAsList(PersonGroupBean bean);

    /**
     * Retrieves the {@link JunctionPersonGroupBean} object from fl_junction_person_group.group_id field.<BR>
     * FK_NAME:fl_junction_person_group_ibfk_2
     * @param id Integer - PK# 1
     * @return the associated {@link JunctionPersonGroupBean} beans 
     * @throws DAOException
     */
    //3.2.2 GET IMPORTED
    public java.util.List<JunctionPersonGroupBean> getJunctionPersonGroupBeansByGroupIdAsList(Integer persongroupId);
    /**
     * delete the associated {@link JunctionPersonGroupBean} objects from fl_junction_person_group.group_id field.<BR>
     * FK_NAME:fl_junction_person_group_ibfk_2
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //3.2.3 DELETE IMPORTED
    public int deleteJunctionPersonGroupBeansByGroupId(Integer persongroupId);
    /**
     * Retrieves the {@link JunctionPersonGroupBean} object from fl_junction_person_group.group_id field.<BR>
     * FK_NAME:fl_junction_person_group_ibfk_2
     * @param bean the {@link PersonGroupBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link JunctionPersonGroupBean} beans or empty list if {@code bean} is {@code null}
     */
    //3.2.4 GET IMPORTED
    public java.util.List<JunctionPersonGroupBean> getJunctionPersonGroupBeansByGroupIdAsList(PersonGroupBean bean,int startRow,int numRows);    
    /**
     * set  the {@link JunctionPersonGroupBean} object array associate to PersonGroupBean by the fl_junction_person_group.group_id field.<BR>
     * FK_NAME : fl_junction_person_group_ibfk_2 
     * @param bean the referenced {@link PersonGroupBean}
     * @param importedBeans imported beans from fl_junction_person_group
     * @return importedBeans always
     * @see {@link JunctionPersonGroupManager#setReferencedByGroupId(JunctionPersonGroupBean, PersonGroupBean)
     */
    //3.3 SET IMPORTED
    public JunctionPersonGroupBean[] setJunctionPersonGroupBeansByGroupId(PersonGroupBean bean , JunctionPersonGroupBean[] importedBeans);

    /**
     * set  the {@link JunctionPersonGroupBean} object java.util.Collection associate to PersonGroupBean by the fl_junction_person_group.group_id field.<BR>
     * FK_NAME:fl_junction_person_group_ibfk_2
     * @param bean the referenced {@link PersonGroupBean} 
     * @param importedBeans imported beans from fl_junction_person_group 
     * @return importedBeans always
     * @see {@link JunctionPersonGroupManager#setReferencedByGroupId(JunctionPersonGroupBean, PersonGroupBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<JunctionPersonGroupBean>> C setJunctionPersonGroupBeansByGroupId(PersonGroupBean bean , C importedBeans);

    /**
     * Retrieves the {@link PersonGroupBean} object from the fl_person_group.parent field.<BR>
     * FK_NAME : fl_person_group_ibfk_1 
     * @param bean the {@link PersonGroupBean}
     * @return the associated {@link PersonGroupBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public PersonGroupBean[] getPersonGroupBeansByParent(PersonGroupBean bean);
    
    /**
     * Retrieves the {@link PersonGroupBean} object from the fl_person_group.parent field.<BR>
     * FK_NAME : fl_person_group_ibfk_1 
     * @param id Integer - PK# 1
     * @return the associated {@link PersonGroupBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws DAOException
     */
    //3.1.2 GET IMPORTED
    public PersonGroupBean[] getPersonGroupBeansByParent(Integer persongroupId);
    
    /**
     * @see #getPersonGroupBeansByParentAsList(PersonGroupBean,int,int)
     */
    //3.2 GET IMPORTED
    public java.util.List<PersonGroupBean> getPersonGroupBeansByParentAsList(PersonGroupBean bean);

    /**
     * Retrieves the {@link PersonGroupBean} object from fl_person_group.parent field.<BR>
     * FK_NAME:fl_person_group_ibfk_1
     * @param id Integer - PK# 1
     * @return the associated {@link PersonGroupBean} beans 
     * @throws DAOException
     */
    //3.2.2 GET IMPORTED
    public java.util.List<PersonGroupBean> getPersonGroupBeansByParentAsList(Integer persongroupId);
    /**
     * delete the associated {@link PersonGroupBean} objects from fl_person_group.parent field.<BR>
     * FK_NAME:fl_person_group_ibfk_1
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //3.2.3 DELETE IMPORTED
    public int deletePersonGroupBeansByParent(Integer persongroupId);
    /**
     * Retrieves the {@link PersonGroupBean} object from fl_person_group.parent field.<BR>
     * FK_NAME:fl_person_group_ibfk_1
     * @param bean the {@link PersonGroupBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link PersonGroupBean} beans or empty list if {@code bean} is {@code null}
     */
    //3.2.4 GET IMPORTED
    public java.util.List<PersonGroupBean> getPersonGroupBeansByParentAsList(PersonGroupBean bean,int startRow,int numRows);    
    /**
     * set  the {@link PersonGroupBean} object array associate to PersonGroupBean by the fl_person_group.parent field.<BR>
     * FK_NAME : fl_person_group_ibfk_1 
     * @param bean the referenced {@link PersonGroupBean}
     * @param importedBeans imported beans from fl_person_group
     * @return importedBeans always
     * @see {@link PersonGroupManager#setReferencedByParent(PersonGroupBean, PersonGroupBean)
     */
    //3.3 SET IMPORTED
    public PersonGroupBean[] setPersonGroupBeansByParent(PersonGroupBean bean , PersonGroupBean[] importedBeans);

    /**
     * set  the {@link PersonGroupBean} object java.util.Collection associate to PersonGroupBean by the fl_person_group.parent field.<BR>
     * FK_NAME:fl_person_group_ibfk_1
     * @param bean the referenced {@link PersonGroupBean} 
     * @param importedBeans imported beans from fl_person_group 
     * @return importedBeans always
     * @see {@link PersonGroupManager#setReferencedByParent(PersonGroupBean, PersonGroupBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<PersonGroupBean>> C setPersonGroupBeansByParent(PersonGroupBean bean , C importedBeans);

    /**
     * Save the PersonGroupBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonGroupBean} bean to be saved
     * @param refPersongroupByParent the {@link PersonGroupBean} bean referenced by {@link PersonGroupBean} 
     * @param impJunctionpersongroupByGroupId the {@link JunctionPersonGroupBean} bean refer to {@link PersonGroupBean} 
     * @param impPersongroupByParent the {@link PersonGroupBean} bean refer to {@link PersonGroupBean} 
     * @return the inserted or updated {@link PersonGroupBean} bean
     */
    //3.5 SYNC SAVE 
    public PersonGroupBean save(PersonGroupBean bean
        , PersonGroupBean refPersongroupByParent 
        , JunctionPersonGroupBean[] impJunctionpersongroupByGroupId , PersonGroupBean[] impPersongroupByParent );
    /**
     * Transaction version for sync save
     * @see {@link #save(PersonGroupBean , PersonGroupBean , JunctionPersonGroupBean[] , PersonGroupBean[] )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public PersonGroupBean saveAsTransaction(final PersonGroupBean bean
        ,final PersonGroupBean refPersongroupByParent 
        ,final JunctionPersonGroupBean[] impJunctionpersongroupByGroupId ,final PersonGroupBean[] impPersongroupByParent );
    /**
     * Save the PersonGroupBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonGroupBean} bean to be saved
     * @param refPersongroupByParent the {@link PersonGroupBean} bean referenced by {@link PersonGroupBean} 
     * @param impJunctionpersongroupByGroupId the {@link JunctionPersonGroupBean} bean refer to {@link PersonGroupBean} 
     * @param impPersongroupByParent the {@link PersonGroupBean} bean refer to {@link PersonGroupBean} 
     * @return the inserted or updated {@link PersonGroupBean} bean
     */
    //3.7 SYNC SAVE 
    public PersonGroupBean save(PersonGroupBean bean
        , PersonGroupBean refPersongroupByParent 
        , java.util.Collection<JunctionPersonGroupBean> impJunctionpersongroupByGroupId , java.util.Collection<PersonGroupBean> impPersongroupByParent );
    /**
     * Transaction version for sync save
     * @see {@link #save(PersonGroupBean , PersonGroupBean , java.util.Collection , java.util.Collection )}
     */
    //3.8 SYNC SAVE AS TRANSACTION
    public PersonGroupBean saveAsTransaction(final PersonGroupBean bean
        ,final PersonGroupBean refPersongroupByParent 
        ,final  java.util.Collection<JunctionPersonGroupBean> impJunctionpersongroupByGroupId ,final  java.util.Collection<PersonGroupBean> impPersongroupByParent );
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link PersonGroupBean} object referenced by {@link PersonGroupBean#getParent}() field.<br>
     * FK_NAME : fl_person_group_ibfk_1
     * @param bean the {@link PersonGroupBean}
     * @return the associated {@link PersonGroupBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public PersonGroupBean getReferencedByParent(PersonGroupBean bean);

    /**
     * Associates the {@link PersonGroupBean} object to the {@link PersonGroupBean} object by {@link PersonGroupBean#getParent}() field.
     *
     * @param bean the {@link PersonGroupBean} object to use
     * @param beanToSet the {@link PersonGroupBean} object to associate to the {@link PersonGroupBean}
     * @return always beanToSet saved
     * @throws WrapDAOException
     */
    //5.2 SET REFERENCED 
    public PersonGroupBean setReferencedByParent(PersonGroupBean bean, PersonGroupBean beanToSet);
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


     /**
     * Retrieves an array of PersonGroupBean using the parent index.
     *
     * @param parent the parent column's value filter.
     * @return an array of PersonGroupBean
     */
    public PersonGroupBean[] loadByIndexParent(Integer parent);
    
    /**
     * Retrieves a list of PersonGroupBean using the parent index.
     *
     * @param parent the parent column's value filter.
     * @return a list of PersonGroupBean
     */
    public java.util.List<PersonGroupBean> loadByIndexParentAsList(Integer parent);

    /**
     * Deletes rows using the parent index.
     *
     * @param parent the parent column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexParent(Integer parent);
    

    /**
     * return a primary key list from {@link PersonGroupBean} array
     * @param array
     */
    //45
    public java.util.List<Integer> toPrimaryKeyList(PersonGroupBean... array);
    /**
     * return a primary key list from {@link PersonGroupBean} collection
     * @param array
     */
    //46
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<PersonGroupBean> collection);

    //_____________________________________________________________________
    //
    // MANY TO MANY: LOAD OTHER BEAN VIA JUNCTION TABLE
    //_____________________________________________________________________
    /**
     * @see #loadViaJunctionPersonGroupAsList(PersonGroupBean,int,int)
     */
    //22 MANY TO MANY
    public java.util.List<PersonGroupBean> loadViaJunctionPersonGroupAsList(PersonBean bean);

    /**
     * Retrieves an list of PersonGroupBean using the junction table JunctionPersonGroup, given a PersonBean, 
     * specifying the start row and the number of rows.
     *
     * @param bean the PersonBean bean to be used
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return a list of PersonGroupBean
     */
    //23 MANY TO MANY
    public java.util.List<PersonGroupBean> loadViaJunctionPersonGroupAsList(PersonBean bean, int startRow, int numRows);
    /**
     * add junction between {@link PersonGroupBean} and {@link PersonBean} if junction not exists
     * @param bean
     * @param linked
     */
    //23.2 MANY TO MANY
    public void addJunction(PersonGroupBean bean,PersonBean linked);
    /**
     * remove junction between {@link PersonGroupBean} and {@link PersonBean}
     * @param bean
     * @param linked
     */
    //23.3 MANY TO MANY
    public int deleteJunction(PersonGroupBean bean,PersonBean linked);
    /** @see #addJunction(PersonGroupBean,PersonBean) */
    //23.4 MANY TO MANY
    public void addJunction(PersonGroupBean bean,PersonBean... linkedBeans);
    /** @see #addJunction(PersonGroupBean,PersonBean) */
    //23.5 MANY TO MANY
    public void addJunction(PersonGroupBean bean,java.util.Collection<PersonBean> linkedBeans);
    /** @see #deleteJunction(PersonGroupBean,PersonBean) */
    //23.6 MANY TO MANY
    public int deleteJunction(PersonGroupBean bean,PersonBean... linkedBeans);
    /** @see #deleteJunction(PersonGroupBean,PersonBean) */
    //23.7 MANY TO MANY
    public int deleteJunction(PersonGroupBean bean,java.util.Collection<PersonBean> linkedBeans);

    //_____________________________________________________________________
    //
    // SELF-REFERENCE
    //_____________________________________________________________________
    /**
     * return bean list ( include {@code bean}) by the self-reference field : {@code fl_person_group(parent) }<br>
     * first element is top bean
     * @param bean
     * @return  empty list if {@code bean} is {@code null}<br>
     *         null if self-reference field is cycle
     * @throws WrapDAOException
     */
    //47
    public java.util.List<PersonGroupBean> listOfParent(PersonGroupBean bean);
    /**
     * get level count on the self-reference field : {@code fl_person_group(parent) }
     * @param bean
     * @return  0 if {@code bean} is {@code null}<br>
     *         -1 if self-reference field is cycle
     * @throws WrapDAOException
     */
    //48
    public int levelOfParent(PersonGroupBean bean);
    /**
     * test whether the self-reference field is cycle : {@code fl_person_group(parent) }
     * @param bean
     * @throws WrapDAOException
     * @see #levelOfParent(PersonGroupBean)
     */
    //49
    public boolean isCycleOnParent(PersonGroupBean bean);
    /**
     * return top bean that with {@code null} self-reference field  : {@code fl_person_group(parent) }
     * @param bean
     * @return top bean
     * @throws NullPointerException if {@code bean} is {@code null}
     * @throws IllegalStateException if self-reference field is cycle
     * @throws WrapDAOException
     */
    // 50
    public PersonGroupBean topOfParent(PersonGroupBean bean);
}
