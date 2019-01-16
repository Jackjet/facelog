// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.interface.java.vm
// ______________________________________________________
package net.gdface.facelog.db;
import net.gdface.facelog.db.exception.ObjectRetrievalException;
import net.gdface.facelog.db.exception.RuntimeDaoException;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_face table.<br>
 * Remarks: 人脸检测信息数据表,用于保存检测到的人脸的所有信息(特征数据除外)
 * @author guyadong
 */
public interface IFaceManager extends TableManager<FaceBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1
    /**
     * Loads a {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique FaceBean or {@code null} if not found
     * @throws RuntimeDaoException
     */
    public FaceBean loadByPrimaryKey(Integer id)throws RuntimeDaoException;

    //1.1
    /**
     * Loads a {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique FaceBean
     * @throws ObjectRetrievalException if not found
     * @throws RuntimeDaoException
     */
    public FaceBean loadByPrimaryKeyChecked(Integer id) throws RuntimeDaoException,ObjectRetrievalException;
    
    //1.4
    /**
     * Returns true if this fl_face contains row with primary key fields.
     * @param id Integer - PK# 1
     * @return
     * @throws RuntimeDaoException
     */
    public boolean existsPrimaryKey(Integer id)throws RuntimeDaoException;
    //1.4.1
    /**
     * Check duplicated row by primary keys,if row exists throw exception
     * @param id Integer
     * @return 
     * @throws RuntimeDaoException
     * @throws ObjectRetrievalException
     */
    public Integer checkDuplicate(Integer id)throws RuntimeDaoException,ObjectRetrievalException;
    //1.8
    /**
     * Loads {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param keys primary keys array
     * @return list of FaceBean
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> loadByPrimaryKey(int... keys)throws RuntimeDaoException;
    //1.9
    /**
     * Loads {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of FaceBean
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> loadByPrimaryKey(java.util.Collection<Integer> keys)throws RuntimeDaoException;
    //2
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(Integer id)throws RuntimeDaoException;
    //2.2
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys array
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(int... keys)throws RuntimeDaoException;
    //2.3
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys collection
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(java.util.Collection<Integer> keys)throws RuntimeDaoException;
    //2.4
    /**
     * Delete beans.<br>
     *
     * @param beans FaceBean collection wille be deleted
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int delete(FaceBean... beans)throws RuntimeDaoException;
    //2.5
    /**
     * Delete beans.<br>
     *
     * @param beans FaceBean collection wille be deleted
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int delete(java.util.Collection<FaceBean> beans)throws RuntimeDaoException;
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param bean the {@link FaceBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public LogBean[] getLogBeansByCompareFace(FaceBean bean)throws RuntimeDaoException;
    
    //3.1.2 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param idOfFace Integer - PK# 1
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public LogBean[] getLogBeansByCompareFace(Integer idOfFace)throws RuntimeDaoException;
    
    //3.2 GET IMPORTED
    /**
     * see also #getLogBeansByCompareFaceAsList(FaceBean,int,int)
     * @param bean
     * @return
     * @throws RuntimeDaoException
     */
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(FaceBean bean)throws RuntimeDaoException;

    //3.2.2 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param idOfFace Integer - PK# 1
     * @return the associated {@link LogBean} beans 
     * @throws RuntimeDaoException
     */
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(Integer idOfFace)throws RuntimeDaoException;
    //3.2.3 DELETE IMPORTED
    /**
     * delete the associated {@link LogBean} objects from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param idOfFace Integer - PK# 1
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteLogBeansByCompareFace(Integer idOfFace)throws RuntimeDaoException;
    //3.2.4 GET IMPORTED
    /**
     * Retrieves the {@link LogBean} object from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param bean the {@link FaceBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link LogBean} beans or empty list if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(FaceBean bean,int startRow,int numRows)throws RuntimeDaoException;    
    //3.3 SET IMPORTED
    /**
     * set  the {@link LogBean} object array associate to FaceBean by the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param bean the referenced {@link FaceBean}
     * @param importedBeans imported beans from fl_log
     * @return importedBeans always
     * @see ILogManager#setReferencedByCompareFace(LogBean, FaceBean)
     * @throws RuntimeDaoException
     */
    public LogBean[] setLogBeansByCompareFace(FaceBean bean , LogBean[] importedBeans)throws RuntimeDaoException;

    //3.4 SET IMPORTED
    /**
     * set  the {@link LogBean} object java.util.Collection associate to FaceBean by the fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param bean the referenced {@link FaceBean} 
     * @param importedBeans imported beans from fl_log 
     * @return importedBeans always
     * @see ILogManager#setReferencedByCompareFace(LogBean, FaceBean)
     * @throws RuntimeDaoException
     */
    public <C extends java.util.Collection<LogBean>> C setLogBeansByCompareFace(FaceBean bean , C importedBeans)throws RuntimeDaoException;

    //3.5 SYNC SAVE 
    /**
     * Save the FaceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     * @throws RuntimeDaoException
     */
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , LogBean[] impLogByCompareFace )throws RuntimeDaoException;
    //3.6 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(FaceBean , FeatureBean , ImageBean , LogBean[] )}
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     * @throws RuntimeDaoException
     */
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final LogBean[] impLogByCompareFace )throws RuntimeDaoException;
    //3.7 SYNC SAVE 
    /**
     * Save the FaceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     * @throws RuntimeDaoException
     */
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , java.util.Collection<LogBean> impLogByCompareFace )throws RuntimeDaoException;
    //3.8 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(FaceBean , FeatureBean , ImageBean , java.util.Collection )}
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     * @throws RuntimeDaoException
     */
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final  java.util.Collection<LogBean> impLogByCompareFace )throws RuntimeDaoException;
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    //5.1 GET REFERENCED VALUE
    /**
     * Retrieves the {@link FeatureBean} object referenced by {@link FaceBean#getFeatureMd5}() field.<br>
     * FK_NAME : fl_face_ibfk_2
     * @param bean the {@link FaceBean}
     * @return the associated {@link FeatureBean} bean or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public FeatureBean getReferencedByFeatureMd5(FaceBean bean)throws RuntimeDaoException;

    //5.2 SET REFERENCED 
    /**
     * Associates the {@link FaceBean} object to the {@link FeatureBean} object by {@link FaceBean#getFeatureMd5}() field.
     *
     * @param bean the {@link FaceBean} object to use
     * @param beanToSet the {@link FeatureBean} object to associate to the {@link FaceBean}
     * @return always beanToSet saved
     * @throws RuntimeDaoException
     */
    public FeatureBean setReferencedByFeatureMd5(FaceBean bean, FeatureBean beanToSet)throws RuntimeDaoException;
    //5.1 GET REFERENCED VALUE
    /**
     * Retrieves the {@link ImageBean} object referenced by {@link FaceBean#getImageMd5}() field.<br>
     * FK_NAME : fl_face_ibfk_1
     * @param bean the {@link FaceBean}
     * @return the associated {@link ImageBean} bean or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public ImageBean getReferencedByImageMd5(FaceBean bean)throws RuntimeDaoException;

    //5.2 SET REFERENCED 
    /**
     * Associates the {@link FaceBean} object to the {@link ImageBean} object by {@link FaceBean#getImageMd5}() field.
     *
     * @param bean the {@link FaceBean} object to use
     * @param beanToSet the {@link ImageBean} object to associate to the {@link FaceBean}
     * @return always beanToSet saved
     * @throws RuntimeDaoException
     */
    public ImageBean setReferencedByImageMd5(FaceBean bean, ImageBean beanToSet)throws RuntimeDaoException;
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


     /**
     * Retrieves an array of FaceBean using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return an array of FaceBean
     * @throws RuntimeDaoException
     */
    public FaceBean[] loadByIndexFeatureMd5(String featureMd5)throws RuntimeDaoException;
    
    /**
     * Retrieves a list of FaceBean using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return a list of FaceBean
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> loadByIndexFeatureMd5AsList(String featureMd5)throws RuntimeDaoException;

    /**
     * Deletes rows using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return the number of deleted objects
     * @throws RuntimeDaoException
     */
    public int deleteByIndexFeatureMd5(String featureMd5)throws RuntimeDaoException;
    

     /**
     * Retrieves an array of FaceBean using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return an array of FaceBean
     * @throws RuntimeDaoException
     */
    public FaceBean[] loadByIndexImageMd5(String imageMd5)throws RuntimeDaoException;
    
    /**
     * Retrieves a list of FaceBean using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return a list of FaceBean
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> loadByIndexImageMd5AsList(String imageMd5)throws RuntimeDaoException;

    /**
     * Deletes rows using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return the number of deleted objects
     * @throws RuntimeDaoException
     */
    public int deleteByIndexImageMd5(String imageMd5)throws RuntimeDaoException;
    

    //45
    /**
     * return a primary key list from {@link FaceBean} array
     * @param beans
     * @return
     */
    public java.util.List<Integer> toPrimaryKeyList(FaceBean... beans);
    //46
    /**
     * return a primary key list from {@link FaceBean} collection
     * @param beans
     * @return
     */
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<FaceBean> beans);

}