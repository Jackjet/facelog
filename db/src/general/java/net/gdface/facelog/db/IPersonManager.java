// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.interface.java.vm
// ______________________________________________________
package net.gdface.facelog.db;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.WrapDAO1Exception;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_person table.<br>
 * Remarks: 人员基本描述信息
 * @author guyadong
 */
public interface IPersonManager extends TableManager<PersonBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1
    /**
     * Loads a {@link PersonBean} from the fl_person using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique PersonBean or {@code null} if not found
     */
    public PersonBean loadByPrimaryKey(Integer id);

    //1.1
    /**
     * Loads a {@link PersonBean} from the fl_person using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique PersonBean
     * @throws ObjectRetrievalException if not found
     */
    public PersonBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException;
    
    //1.4
    /**
     * Returns true if this fl_person contains row with primary key fields.
     * @param id Integer - PK# 1
     * @see #loadByPrimaryKey($keys)
     * @return
     */
    public boolean existsPrimaryKey(Integer id);
    //1.4.1
    /**
     * Check duplicated row by primary keys,if row exists throw exception
     * @param id Integer
     * @return 
     * @throws ObjectRetrievalException
     */
    public Integer checkDuplicate(Integer id)throws ObjectRetrievalException;
    //1.8
    /**
     * Loads {@link PersonBean} from the fl_person using primary key fields.
     *
     * @param keys primary keys array
     * @return list of PersonBean
     */
    public java.util.List<PersonBean> loadByPrimaryKey(int... keys);
    //1.9
    /**
     * Loads {@link PersonBean} from the fl_person using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of PersonBean
     */
    public java.util.List<PersonBean> loadByPrimaryKey(java.util.Collection<Integer> keys);
    //2
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(Integer id);
    //2.2
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys array
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(int... keys);
    //2.3
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys collection
     * @return the number of deleted rows
     */
    public int deleteByPrimaryKey(java.util.Collection<Integer> keys);
    //2.4
    /**
     * Delete beans.<br>
     *
     * @param beans PersonBean collection wille be deleted
     * @return the number of deleted rows
     */
    public int delete(PersonBean... beans);
    //2.5
    /**
     * Delete beans.<br>
     *
     * @param beans PersonBean collection wille be deleted
     * @return the number of deleted rows
     */
    public int delete(java.util.Collection<PersonBean> beans);
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED
    /**
     * Retrieves the {@link FeatureBean} object from the fl_feature.person_id field.<BR>
     * FK_NAME : fl_feature_ibfk_1 
     * @param bean the {@link PersonBean}
     * @return the associated {@link FeatureBean} beans or {@code null} if {@code bean} is {@code null}
     */
    public FeatureBean[] getFeatureBeansByPersonId(PersonBean bean);
    
    //3.1.2 GET IMPORTED
    /**
     * Retrieves the {@link FeatureBean} object from the fl_feature.person_id field.<BR>
     * FK_NAME : fl_feature_ibfk_1 
     * @param idOfPerson Integer - PK# 1
     * @return the associated {@link FeatureBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws Dao3Exception
     */
    public FeatureBean[] getFeatureBeansByPersonId(Integer idOfPerson);
    
    //3.2 GET IMPORTED
    /**
     * see also #getFeatureBeansByPersonIdAsList(PersonBean,int,int)
     * @param bean
     * @return
     */
    public java.util.List<FeatureBean> getFeatureBeansByPersonIdAsList(PersonBean bean);

    //3.2.2 GET IMPORTED
    /**
     * Retrieves the {@link FeatureBean} object from fl_feature.person_id field.<BR>
     * FK_NAME:fl_feature_ibfk_1
     * @param idOfPerson Integer - PK# 1
     * @return the associated {@link FeatureBean} beans 
     * @throws Dao3Exception
     */
    public java.util.List<FeatureBean> getFeatureBeansByPersonIdAsList(Integer idOfPerson);
    //3.2.3 DELETE IMPORTED
    /**
     * delete the associated {@link FeatureBean} objects from fl_feature.person_id field.<BR>
     * FK_NAME:fl_feature_ibfk_1
     * @param idOfPerson Integer - PK# 1
     * @return the number of deleted rows
     */
    public int deleteFeatureBeansByPersonId(Integer idOfPerson);
    //3.2.4 GET IMPORTED
    /**
     * Retrieves the {@link FeatureBean} object from fl_feature.person_id field.<BR>
     * FK_NAME:fl_feature_ibfk_1
     * @param bean the {@link PersonBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link FeatureBean} beans or empty list if {@code bean} is {@code null}
     */
    public java.util.List<FeatureBean> getFeatureBeansByPersonIdAsList(PersonBean bean,int startRow,int numRows);    
    //3.3 SET IMPORTED
    /**
     * set  the {@link FeatureBean} object array associate to PersonBean by the fl_feature.person_id field.<BR>
     * FK_NAME : fl_feature_ibfk_1 
     * @param bean the referenced {@link PersonBean}
     * @param importedBeans imported beans from fl_feature
     * @return importedBeans always
     * @see {@link FeatureManager#setReferencedByPersonId(FeatureBean, PersonBean)
     */
    public FeatureBean[] setFeatureBeansByPersonId(PersonBean bean , FeatureBean[] importedBeans);

    //3.4 SET IMPORTED
    /**
     * set  the {@link FeatureBean} object java.util.Collection associate to PersonBean by the fl_feature.person_id field.<BR>
     * FK_NAME:fl_feature_ibfk_1
     * @param bean the referenced {@link PersonBean} 
     * @param importedBeans imported beans from fl_feature 
     * @return importedBeans always
     * @see {@link FeatureManager#setReferencedByPersonId(FeatureBean, PersonBean)
     */
    public <C extends java.util.Collection<FeatureBean>> C setFeatureBeansByPersonId(PersonBean bean , C importedBeans);

    //3.1 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from the fl_log.person_id field.<BR>
     * FK_NAME : fl_log_ibfk_1 
     * @param bean the {@link PersonBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     */
    public LogBean[] getLogBeansByPersonId(PersonBean bean);
    
    //3.1.2 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from the fl_log.person_id field.<BR>
     * FK_NAME : fl_log_ibfk_1 
     * @param idOfPerson Integer - PK# 1
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws Dao3Exception
     */
    public LogBean[] getLogBeansByPersonId(Integer idOfPerson);
    
    //3.2 GET IMPORTED
    /**
     * see also #getLogBeansByPersonIdAsList(PersonBean,int,int)
     * @param bean
     * @return
     */
    public java.util.List<LogBean> getLogBeansByPersonIdAsList(PersonBean bean);

    //3.2.2 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from fl_log.person_id field.<BR>
     * FK_NAME:fl_log_ibfk_1
     * @param idOfPerson Integer - PK# 1
     * @return the associated {@link LogBean} beans 
     * @throws Dao3Exception
     */
    public java.util.List<LogBean> getLogBeansByPersonIdAsList(Integer idOfPerson);
    //3.2.3 DELETE IMPORTED
    /**
     * delete the associated {@link LogBean} objects from fl_log.person_id field.<BR>
     * FK_NAME:fl_log_ibfk_1
     * @param idOfPerson Integer - PK# 1
     * @return the number of deleted rows
     */
    public int deleteLogBeansByPersonId(Integer idOfPerson);
    //3.2.4 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from fl_log.person_id field.<BR>
     * FK_NAME:fl_log_ibfk_1
     * @param bean the {@link PersonBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link LogBean} beans or empty list if {@code bean} is {@code null}
     */
    public java.util.List<LogBean> getLogBeansByPersonIdAsList(PersonBean bean,int startRow,int numRows);    
    //3.3 SET IMPORTED
    /**
     * set  the {@link LogBean} object array associate to PersonBean by the fl_log.person_id field.<BR>
     * FK_NAME : fl_log_ibfk_1 
     * @param bean the referenced {@link PersonBean}
     * @param importedBeans imported beans from fl_log
     * @return importedBeans always
     * @see {@link LogManager#setReferencedByPersonId(LogBean, PersonBean)
     */
    public LogBean[] setLogBeansByPersonId(PersonBean bean , LogBean[] importedBeans);

    //3.4 SET IMPORTED
    /**
     * set  the {@link LogBean} object java.util.Collection associate to PersonBean by the fl_log.person_id field.<BR>
     * FK_NAME:fl_log_ibfk_1
     * @param bean the referenced {@link PersonBean} 
     * @param importedBeans imported beans from fl_log 
     * @return importedBeans always
     * @see {@link LogManager#setReferencedByPersonId(LogBean, PersonBean)
     */
    public <C extends java.util.Collection<LogBean>> C setLogBeansByPersonId(PersonBean bean , C importedBeans);

    //3.5 SYNC SAVE 
    /**
     * Save the PersonBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonBean} bean to be saved
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link PersonBean} 
     * @param refPersongroupByGroupId the {@link PersonGroupBean} bean referenced by {@link PersonBean} 
     * @param impFeatureByPersonId the {@link FeatureBean} bean refer to {@link PersonBean} 
     * @param impLogByPersonId the {@link LogBean} bean refer to {@link PersonBean} 
     * @return the inserted or updated {@link PersonBean} bean
     */
    public PersonBean save(PersonBean bean
        , ImageBean refImageByImageMd5 , PersonGroupBean refPersongroupByGroupId 
        , FeatureBean[] impFeatureByPersonId , LogBean[] impLogByPersonId );
    //3.6 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(PersonBean , ImageBean , PersonGroupBean , FeatureBean[] , LogBean[] )}
     * @param bean the {@link PersonBean} bean to be saved
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link PersonBean} 
     * @param refPersongroupByGroupId the {@link PersonGroupBean} bean referenced by {@link PersonBean} 
     * @param impFeatureByPersonId the {@link FeatureBean} bean refer to {@link PersonBean} 
     * @param impLogByPersonId the {@link LogBean} bean refer to {@link PersonBean} 
     * @return the inserted or updated {@link PersonBean} bean
     */
    public PersonBean saveAsTransaction(final PersonBean bean
        ,final ImageBean refImageByImageMd5 ,final PersonGroupBean refPersongroupByGroupId 
        ,final FeatureBean[] impFeatureByPersonId ,final LogBean[] impLogByPersonId );
    //3.7 SYNC SAVE 
    /**
     * Save the PersonBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonBean} bean to be saved
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link PersonBean} 
     * @param refPersongroupByGroupId the {@link PersonGroupBean} bean referenced by {@link PersonBean} 
     * @param impFeatureByPersonId the {@link FeatureBean} bean refer to {@link PersonBean} 
     * @param impLogByPersonId the {@link LogBean} bean refer to {@link PersonBean} 
     * @return the inserted or updated {@link PersonBean} bean
     */
    public PersonBean save(PersonBean bean
        , ImageBean refImageByImageMd5 , PersonGroupBean refPersongroupByGroupId 
        , java.util.Collection<FeatureBean> impFeatureByPersonId , java.util.Collection<LogBean> impLogByPersonId );
    //3.8 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(PersonBean , ImageBean , PersonGroupBean , java.util.Collection , java.util.Collection )}
     * @param bean the {@link PersonBean} bean to be saved
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link PersonBean} 
     * @param refPersongroupByGroupId the {@link PersonGroupBean} bean referenced by {@link PersonBean} 
     * @param impFeatureByPersonId the {@link FeatureBean} bean refer to {@link PersonBean} 
     * @param impLogByPersonId the {@link LogBean} bean refer to {@link PersonBean} 
     * @return the inserted or updated {@link PersonBean} bean
     */
    public PersonBean saveAsTransaction(final PersonBean bean
        ,final ImageBean refImageByImageMd5 ,final PersonGroupBean refPersongroupByGroupId 
        ,final  java.util.Collection<FeatureBean> impFeatureByPersonId ,final  java.util.Collection<LogBean> impLogByPersonId );
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    //5.1 GET REFERENCED VALUE
    /**
     * Retrieves the {@link ImageBean} object referenced by {@link PersonBean#getImageMd5}() field.<br>
     * FK_NAME : fl_person_ibfk_2
     * @param bean the {@link PersonBean}
     * @return the associated {@link ImageBean} bean or {@code null} if {@code bean} is {@code null}
     */
    public ImageBean getReferencedByImageMd5(PersonBean bean);

    //5.2 SET REFERENCED 
    /**
     * Associates the {@link PersonBean} object to the {@link ImageBean} object by {@link PersonBean#getImageMd5}() field.
     *
     * @param bean the {@link PersonBean} object to use
     * @param beanToSet the {@link ImageBean} object to associate to the {@link PersonBean}
     * @return always beanToSet saved
     * @throws WrapDAO1Exception
     */
    public ImageBean setReferencedByImageMd5(PersonBean bean, ImageBean beanToSet);
    //5.1 GET REFERENCED VALUE
    /**
     * Retrieves the {@link PersonGroupBean} object referenced by {@link PersonBean#getGroupId}() field.<br>
     * FK_NAME : fl_person_ibfk_1
     * @param bean the {@link PersonBean}
     * @return the associated {@link PersonGroupBean} bean or {@code null} if {@code bean} is {@code null}
     */
    public PersonGroupBean getReferencedByGroupId(PersonBean bean);

    //5.2 SET REFERENCED 
    /**
     * Associates the {@link PersonBean} object to the {@link PersonGroupBean} object by {@link PersonBean#getGroupId}() field.
     *
     * @param bean the {@link PersonBean} object to use
     * @param beanToSet the {@link PersonGroupBean} object to associate to the {@link PersonBean}
     * @return always beanToSet saved
     * @throws WrapDAO1Exception
     */
    public PersonGroupBean setReferencedByGroupId(PersonBean bean, PersonGroupBean beanToSet);
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


    /**
     * Retrieves an unique PersonBean using the image_md5 index.
     * 
     * @param imageMd5 the image_md5 column's value filter
     * @return an PersonBean,otherwise null if not found or exists null in input arguments
     * @throws WrapDAO1Exception
     */
    public PersonBean loadByIndexImageMd5(String imageMd5);
    /**
     * Retrieves an unique PersonBean using the image_md5 index.
     * 
     * @param imageMd5 the image_md5 column's value filter. must not be null
     * @return an PersonBean
     * @throws NullPointerException exists null in input arguments
     * @throws ObjectRetrievalException if not found
     * @throws WrapDAO1Exception
     */
    public PersonBean loadByIndexImageMd5Checked(String imageMd5)throws ObjectRetrievalException;
    /**
     * Retrieves an unique PersonBean for each image_md5 index.
     *
     * @param indexs index array
     * @return an list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexImageMd5(String... indexs);
    /**
     * Retrieves an unique PersonBean for each image_md5 index.
     *
     * @param indexs index collection
     * @return an list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexImageMd5(java.util.Collection<String> indexs);
    /**
     * Deletes rows for each image_md5 index.
     *
     * @param indexs index array
     * @return the number of deleted rows
     */
    public int deleteByIndexImageMd5(String... indexs);
    /**
     * Deletes rows for each image_md5 index.
     *
     * @param indexs index collection
     * @return the number of deleted rows
     */
    public int deleteByIndexImageMd5(java.util.Collection<String> indexs);

    /**
     * Deletes rows using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexImageMd5(String imageMd5);
    

    /**
     * Retrieves an unique PersonBean using the papers_num index.
     * 
     * @param papersNum the papers_num column's value filter
     * @return an PersonBean,otherwise null if not found or exists null in input arguments
     * @throws WrapDAO1Exception
     */
    public PersonBean loadByIndexPapersNum(String papersNum);
    /**
     * Retrieves an unique PersonBean using the papers_num index.
     * 
     * @param papersNum the papers_num column's value filter. must not be null
     * @return an PersonBean
     * @throws NullPointerException exists null in input arguments
     * @throws ObjectRetrievalException if not found
     * @throws WrapDAO1Exception
     */
    public PersonBean loadByIndexPapersNumChecked(String papersNum)throws ObjectRetrievalException;
    /**
     * Retrieves an unique PersonBean for each papers_num index.
     *
     * @param indexs index array
     * @return an list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexPapersNum(String... indexs);
    /**
     * Retrieves an unique PersonBean for each papers_num index.
     *
     * @param indexs index collection
     * @return an list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexPapersNum(java.util.Collection<String> indexs);
    /**
     * Deletes rows for each papers_num index.
     *
     * @param indexs index array
     * @return the number of deleted rows
     */
    public int deleteByIndexPapersNum(String... indexs);
    /**
     * Deletes rows for each papers_num index.
     *
     * @param indexs index collection
     * @return the number of deleted rows
     */
    public int deleteByIndexPapersNum(java.util.Collection<String> indexs);

    /**
     * Deletes rows using the papers_num index.
     *
     * @param papersNum the papers_num column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexPapersNum(String papersNum);
    

     /**
     * Retrieves an array of PersonBean using the expiry_date index.
     *
     * @param expiryDate the expiry_date column's value filter.
     * @return an array of PersonBean
     */
    public PersonBean[] loadByIndexExpiryDate(java.util.Date expiryDate);
    
    /**
     * Retrieves a list of PersonBean using the expiry_date index.
     *
     * @param expiryDate the expiry_date column's value filter.
     * @return a list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexExpiryDateAsList(java.util.Date expiryDate);

    /**
     * Deletes rows using the expiry_date index.
     *
     * @param expiryDate the expiry_date column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexExpiryDate(java.util.Date expiryDate);
    

     /**
     * Retrieves an array of PersonBean using the group_id index.
     *
     * @param groupId the group_id column's value filter.
     * @return an array of PersonBean
     */
    public PersonBean[] loadByIndexGroupId(Integer groupId);
    
    /**
     * Retrieves a list of PersonBean using the group_id index.
     *
     * @param groupId the group_id column's value filter.
     * @return a list of PersonBean
     */
    public java.util.List<PersonBean> loadByIndexGroupIdAsList(Integer groupId);

    /**
     * Deletes rows using the group_id index.
     *
     * @param groupId the group_id column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexGroupId(Integer groupId);
    

    //45
    /**
     * return a primary key list from {@link PersonBean} array
     * @param beans
     * @return
     */
    public java.util.List<Integer> toPrimaryKeyList(PersonBean... beans);
    //46
    /**
     * return a primary key list from {@link PersonBean} collection
     * @param beans
     * @return
     */
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<PersonBean> beans);

}
