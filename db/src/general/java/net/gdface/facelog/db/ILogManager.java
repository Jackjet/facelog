// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_log table.<br>
 * Remarks: 人脸验证日志,记录所有通过验证的人员
 * @author guyadong
 */
public interface ILogManager extends TableManager<LogBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a {@link LogBean} from the fl_log using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique LogBean or {@code null} if not found
     */
    //1
    public LogBean loadByPrimaryKey(Integer id);

    
    /**
     * Returns true if this fl_log contains row with primary key fields.
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
     * Loads {@link LogBean} from the fl_log using primary key fields.
     *
     * @param keys primary keys array
     * @return list of LogBean
     */
    //1.8
    public java.util.List<LogBean> loadByPrimaryKey(int... keys);
    /**
     * Loads {@link LogBean} from the fl_log using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of LogBean
     */
    //1.9
    public java.util.List<LogBean> loadByPrimaryKey(java.util.Collection<Integer> keys);
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
     * @param beans LogBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.4
    public int delete(LogBean... beans);
    /**
     * Delete beans.<br>
     *
     * @param beans LogBean collection wille be deleted
     * @return the number of deleted rows
     */
    //2.5
    public int delete(java.util.Collection<LogBean> beans);
 
    /**
     * Save the LogBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link LogBean} bean to be saved
     * @param refDeviceByDeviceId the {@link DeviceBean} bean referenced by {@link LogBean} 
     * @param refFaceByCompareFace the {@link FaceBean} bean referenced by {@link LogBean} 
     * @param refFeatureByVerifyFeature the {@link FeatureBean} bean referenced by {@link LogBean} 
     * @param refPersonByPersonId the {@link PersonBean} bean referenced by {@link LogBean} 
         * @return the inserted or updated {@link LogBean} bean
     */
    //3.5 SYNC SAVE 
    public LogBean save(LogBean bean
        , DeviceBean refDeviceByDeviceId , FaceBean refFaceByCompareFace , FeatureBean refFeatureByVerifyFeature , PersonBean refPersonByPersonId 
        );
    /**
     * Transaction version for sync save
     * @see {@link #save(LogBean , DeviceBean , FaceBean , FeatureBean , PersonBean )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public LogBean saveAsTransaction(final LogBean bean
        ,final DeviceBean refDeviceByDeviceId ,final FaceBean refFaceByCompareFace ,final FeatureBean refFeatureByVerifyFeature ,final PersonBean refPersonByPersonId 
        );
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link DeviceBean} object referenced by {@link LogBean#getDeviceId}() field.<br>
     * FK_NAME : fl_log_ibfk_2
     * @param bean the {@link LogBean}
     * @return the associated {@link DeviceBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public DeviceBean getReferencedByDeviceId(LogBean bean);

    /**
     * Associates the {@link LogBean} object to the {@link DeviceBean} object by {@link LogBean#getDeviceId}() field.
     *
     * @param bean the {@link LogBean} object to use
     * @param beanToSet the {@link DeviceBean} object to associate to the {@link LogBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public DeviceBean setReferencedByDeviceId(LogBean bean, DeviceBean beanToSet);
    /**
     * Retrieves the {@link FaceBean} object referenced by {@link LogBean#getCompareFace}() field.<br>
     * FK_NAME : fl_log_ibfk_4
     * @param bean the {@link LogBean}
     * @return the associated {@link FaceBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public FaceBean getReferencedByCompareFace(LogBean bean);

    /**
     * Associates the {@link LogBean} object to the {@link FaceBean} object by {@link LogBean#getCompareFace}() field.
     *
     * @param bean the {@link LogBean} object to use
     * @param beanToSet the {@link FaceBean} object to associate to the {@link LogBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public FaceBean setReferencedByCompareFace(LogBean bean, FaceBean beanToSet);
    /**
     * Retrieves the {@link FeatureBean} object referenced by {@link LogBean#getVerifyFeature}() field.<br>
     * FK_NAME : fl_log_ibfk_3
     * @param bean the {@link LogBean}
     * @return the associated {@link FeatureBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public FeatureBean getReferencedByVerifyFeature(LogBean bean);

    /**
     * Associates the {@link LogBean} object to the {@link FeatureBean} object by {@link LogBean#getVerifyFeature}() field.
     *
     * @param bean the {@link LogBean} object to use
     * @param beanToSet the {@link FeatureBean} object to associate to the {@link LogBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public FeatureBean setReferencedByVerifyFeature(LogBean bean, FeatureBean beanToSet);
    /**
     * Retrieves the {@link PersonBean} object referenced by {@link LogBean#getPersonId}() field.<br>
     * FK_NAME : fl_log_ibfk_1
     * @param bean the {@link LogBean}
     * @return the associated {@link PersonBean} bean or {@code null} if {@code bean} is {@code null}
     */
    //5.1 GET REFERENCED VALUE
    public PersonBean getReferencedByPersonId(LogBean bean);

    /**
     * Associates the {@link LogBean} object to the {@link PersonBean} object by {@link LogBean#getPersonId}() field.
     *
     * @param bean the {@link LogBean} object to use
     * @param beanToSet the {@link PersonBean} object to associate to the {@link LogBean}
     * @return always beanToSet saved
     * @throws Exception
     */
    //5.2 SET REFERENCED 
    public PersonBean setReferencedByPersonId(LogBean bean, PersonBean beanToSet);
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


     /**
     * Retrieves an array of LogBean using the compare_face index.
     *
     * @param compareFace the compare_face column's value filter.
     * @return an array of LogBean
     */
    public LogBean[] loadByIndexCompareFace(Integer compareFace);
    
    /**
     * Retrieves a list of LogBean using the compare_face index.
     *
     * @param compareFace the compare_face column's value filter.
     * @return a list of LogBean
     */
    public java.util.List<LogBean> loadByIndexCompareFaceAsList(Integer compareFace);

    /**
     * Deletes rows using the compare_face index.
     *
     * @param compareFace the compare_face column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexCompareFace(Integer compareFace);
    

     /**
     * Retrieves an array of LogBean using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return an array of LogBean
     */
    public LogBean[] loadByIndexDeviceId(Integer deviceId);
    
    /**
     * Retrieves a list of LogBean using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return a list of LogBean
     */
    public java.util.List<LogBean> loadByIndexDeviceIdAsList(Integer deviceId);

    /**
     * Deletes rows using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexDeviceId(Integer deviceId);
    

     /**
     * Retrieves an array of LogBean using the person_id index.
     *
     * @param personId the person_id column's value filter.
     * @return an array of LogBean
     */
    public LogBean[] loadByIndexPersonId(Integer personId);
    
    /**
     * Retrieves a list of LogBean using the person_id index.
     *
     * @param personId the person_id column's value filter.
     * @return a list of LogBean
     */
    public java.util.List<LogBean> loadByIndexPersonIdAsList(Integer personId);

    /**
     * Deletes rows using the person_id index.
     *
     * @param personId the person_id column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexPersonId(Integer personId);
    

     /**
     * Retrieves an array of LogBean using the verify_feature index.
     *
     * @param verifyFeature the verify_feature column's value filter.
     * @return an array of LogBean
     */
    public LogBean[] loadByIndexVerifyFeature(String verifyFeature);
    
    /**
     * Retrieves a list of LogBean using the verify_feature index.
     *
     * @param verifyFeature the verify_feature column's value filter.
     * @return a list of LogBean
     */
    public java.util.List<LogBean> loadByIndexVerifyFeatureAsList(String verifyFeature);

    /**
     * Deletes rows using the verify_feature index.
     *
     * @param verifyFeature the verify_feature column's value filter.
     * @return the number of deleted objects
     */
    public int deleteByIndexVerifyFeature(String verifyFeature);
    

    /**
     * return a primary key list from {@link LogBean} array
     * @param array
     */
    //45
    public java.util.List<Integer> toPrimaryKeyList(LogBean... array);
    /**
     * return a primary key list from {@link LogBean} collection
     * @param array
     */
    //46
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<LogBean> collection);
}
