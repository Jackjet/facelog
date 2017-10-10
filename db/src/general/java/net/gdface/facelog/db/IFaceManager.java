// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.interface.java.vm
// ______________________________________________________

package net.gdface.facelog.db;

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

    /**
     * Loads a {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique FaceBean or {@code null} if not found
     */
    //1
    public FaceBean loadByPrimaryKey(Integer id);

    
    /**
     * Returns true if this fl_face contains row with primary key fields.
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
     * Loads {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param keys primary keys array
     * @return list of FaceBean
     */
    //1.8
    public java.util.List<FaceBean> loadByPrimaryKey(int... keys);
    /**
     * Loads {@link FaceBean} from the fl_face using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of FaceBean
     */
    //1.9
    public java.util.List<FaceBean> loadByPrimaryKey(java.util.Collection<Integer> keys);
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
     * @param beans FaceBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.4
    public int delete(FaceBean... beans);
    /**
     * Delete beans.<br>
     *
     * @param beans FaceBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.5
    public int delete(java.util.Collection<FaceBean> beans);
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link LogBean} object from the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param bean the {@link FaceBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public LogBean[] getLogBeansByCompareFace(FaceBean bean);
    
    /**
     * Retrieves the {@link LogBean} object from the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param id Integer - PK# 1
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws DAOException
     */
    //3.1.2 GET IMPORTED
    public LogBean[] getLogBeansByCompareFace(Integer faceId);
    
    /**
     * Retrieves the {@link LogBean} object from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param bean the {@link FaceBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.2 GET IMPORTED
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(FaceBean bean);

    /**
     * Retrieves the {@link LogBean} object from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param id Integer - PK# 1
     * @return the associated {@link LogBean} beans 
     * @throws DAOException
     */
    //3.2.2 GET IMPORTED
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(Integer faceId);
    /**
     * delete the associated {@link LogBean} objects from fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //3.2.3 DELETE IMPORTED
    public int deleteLogBeansByCompareFace(Integer faceId);
    
    /**
     * set  the {@link LogBean} object array associate to FaceBean by the fl_log.compare_face field.<BR>
     * FK_NAME : fl_log_ibfk_4 
     * @param bean the referenced {@link FaceBean}
     * @param importedBeans imported beans from fl_log
     * @return importedBeans always
     * @see {@link LogManager#setReferencedByCompareFace(LogBean, FaceBean)
     */
    //3.3 SET IMPORTED
    public LogBean[] setLogBeansByCompareFace(FaceBean bean , LogBean[] importedBeans);

    /**
     * set  the {@link LogBean} object java.util.Collection associate to FaceBean by the fl_log.compare_face field.<BR>
     * FK_NAME:fl_log_ibfk_4
     * @param bean the referenced {@link FaceBean} 
     * @param importedBeans imported beans from fl_log 
     * @return importedBeans always
     * @see {@link LogManager#setReferencedByCompareFace(LogBean, FaceBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<LogBean>> C setLogBeansByCompareFace(FaceBean bean , C importedBeans);

    /**
     * Save the FaceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     */
    //3.5 SYNC SAVE 
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , LogBean[] impLogByCompareFace );
    /**
     * Transaction version for sync save
     * @see {@link #save(FaceBean , FeatureBean , ImageBean , LogBean[] )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final LogBean[] impLogByCompareFace );
    /**
     * Save the FaceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
     * @param impLogByCompareFace the {@link LogBean} bean refer to {@link FaceBean} 
     * @return the inserted or updated {@link FaceBean} bean
     */
    //3.7 SYNC SAVE 
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , java.util.Collection<LogBean> impLogByCompareFace );
    /**
     * Transaction version for sync save
     * @see {@link #save(FaceBean , FeatureBean , ImageBean , java.util.Collection )}
     */
    //3.8 SYNC SAVE AS TRANSACTION
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final  java.util.Collection<LogBean> impLogByCompareFace );
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link FeatureBean} object referenced by {@link FaceBean#getFeatureMd5}() field.<br>
     * FK_NAME : fl_face_ibfk_2
     * @param bean the {@link FaceBean}
     * @return the associated {@link FeatureBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public FeatureBean getReferencedByFeatureMd5(FaceBean bean);

    /**
     * Associates the {@link FaceBean} object to the {@link FeatureBean} object by {@link FaceBean#getFeatureMd5}() field.
     *
     * @param bean the {@link FaceBean} object to use
     * @param beanToSet the {@link FeatureBean} object to associate to the {@link FaceBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public FeatureBean setReferencedByFeatureMd5(FaceBean bean, FeatureBean beanToSet);
    /**
     * Retrieves the {@link ImageBean} object referenced by {@link FaceBean#getImageMd5}() field.<br>
     * FK_NAME : fl_face_ibfk_1
     * @param bean the {@link FaceBean}
     * @return the associated {@link ImageBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public ImageBean getReferencedByImageMd5(FaceBean bean);

    /**
     * Associates the {@link FaceBean} object to the {@link ImageBean} object by {@link FaceBean#getImageMd5}() field.
     *
     * @param bean the {@link FaceBean} object to use
     * @param beanToSet the {@link ImageBean} object to associate to the {@link FaceBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public ImageBean setReferencedByImageMd5(FaceBean bean, ImageBean beanToSet);
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


     /**
     * Retrieves an array of FaceBean using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return an array of FaceBean
     */
    public FaceBean[] loadByIndexFeatureMd5(String featureMd5);
    
    /**
     * Retrieves a list of FaceBean using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return a list of FaceBean
     */
    public java.util.List<FaceBean> loadByIndexFeatureMd5AsList(String featureMd5);

    /**
     * Deletes rows using the feature_md5 index.
     *
     * @param featureMd5 the feature_md5 column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexFeatureMd5(String featureMd5);
    

     /**
     * Retrieves an array of FaceBean using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return an array of FaceBean
     */
    public FaceBean[] loadByIndexImageMd5(String imageMd5);
    
    /**
     * Retrieves a list of FaceBean using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return a list of FaceBean
     */
    public java.util.List<FaceBean> loadByIndexImageMd5AsList(String imageMd5);

    /**
     * Deletes rows using the image_md5 index.
     *
     * @param imageMd5 the image_md5 column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexImageMd5(String imageMd5);
    

    /**
     * return a primary key list from {@link FaceBean} array
     * @param array
     */
    //45
    public java.util.List<Integer> toPrimaryKeyList(FaceBean... array);
    /**
     * return a primary key list from {@link FaceBean} collection
     * @param array
     */
    //46
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<FaceBean> collection);
}
