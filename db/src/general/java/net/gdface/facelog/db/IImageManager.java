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
 * Interface to handle database calls (save, load, count, etc...) for the fl_image table.<br>
 * Remarks: 图像信息存储表,用于存储系统中所有用到的图像数据,表中只包含图像基本信息,图像二进制源数据存在在fl_store中(md5对应)
 * @author guyadong
 */
public interface IImageManager extends TableManager<ImageBean>
{  
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1
    /**
     * Loads a {@link ImageBean} from the fl_image using primary key fields.
     *
     * @param md5 String - PK# 1
     * @return a unique ImageBean or {@code null} if not found
     * @throws RuntimeDaoException
     */
    public ImageBean loadByPrimaryKey(String md5)throws RuntimeDaoException;

    //1.1
    /**
     * Loads a {@link ImageBean} from the fl_image using primary key fields.
     *
     * @param md5 String - PK# 1
     * @return a unique ImageBean
     * @throws ObjectRetrievalException if not found
     * @throws RuntimeDaoException
     */
    public ImageBean loadByPrimaryKeyChecked(String md5) throws RuntimeDaoException,ObjectRetrievalException;
    
    //1.4
    /**
     * Returns true if this fl_image contains row with primary key fields.
     * @param md5 String - PK# 1
     * @return
     * @throws RuntimeDaoException
     */
    public boolean existsPrimaryKey(String md5)throws RuntimeDaoException;
    //1.4.1
    /**
     * Check duplicated row by primary keys,if row exists throw exception
     * @param md5 String
     * @return 
     * @throws RuntimeDaoException
     * @throws ObjectRetrievalException
     */
    public String checkDuplicate(String md5)throws RuntimeDaoException,ObjectRetrievalException;
    //1.8
    /**
     * Loads {@link ImageBean} from the fl_image using primary key fields.
     *
     * @param keys primary keys array
     * @return list of ImageBean
     * @throws RuntimeDaoException
     */
    public java.util.List<ImageBean> loadByPrimaryKey(String... keys)throws RuntimeDaoException;
    //1.9
    /**
     * Loads {@link ImageBean} from the fl_image using primary key fields.
     *
     * @param keys primary keys collection
     * @return list of ImageBean
     * @throws RuntimeDaoException
     */
    public java.util.List<ImageBean> loadByPrimaryKey(java.util.Collection<String> keys)throws RuntimeDaoException;
    //2
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param md5 String - PK# 1
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(String md5)throws RuntimeDaoException;
    //2.2
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys array
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(String... keys)throws RuntimeDaoException;
    //2.3
    /**
     * Delete rows according to primary key.<br>
     *
     * @param keys primary keys collection
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteByPrimaryKey(java.util.Collection<String> keys)throws RuntimeDaoException;
    //2.4
    /**
     * Delete beans.<br>
     *
     * @param beans ImageBean collection wille be deleted
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int delete(ImageBean... beans)throws RuntimeDaoException;
    //2.5
    /**
     * Delete beans.<br>
     *
     * @param beans ImageBean collection wille be deleted
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int delete(java.util.Collection<ImageBean> beans)throws RuntimeDaoException;
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED
    /**
     * Retrieves the {@link FaceBean} object from the fl_face.image_md5 field.<BR>
     * FK_NAME : fl_face_ibfk_1 
     * @param bean the {@link ImageBean}
     * @return the associated {@link FaceBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public FaceBean[] getFaceBeansByImageMd5(ImageBean bean)throws RuntimeDaoException;
    
    //3.1.2 GET IMPORTED
    /**
     * Retrieves the {@link FaceBean} object from the fl_face.image_md5 field.<BR>
     * FK_NAME : fl_face_ibfk_1 
     * @param md5OfImage String - PK# 1
     * @return the associated {@link FaceBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public FaceBean[] getFaceBeansByImageMd5(String md5OfImage)throws RuntimeDaoException;
    
    //3.2 GET IMPORTED
    /**
     * see also #getFaceBeansByImageMd5AsList(ImageBean,int,int)
     * @param bean
     * @return
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(ImageBean bean)throws RuntimeDaoException;

    //3.2.2 GET IMPORTED
    /**
     * Retrieves the {@link FaceBean} object from fl_face.image_md5 field.<BR>
     * FK_NAME:fl_face_ibfk_1
     * @param md5OfImage String - PK# 1
     * @return the associated {@link FaceBean} beans 
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(String md5OfImage)throws RuntimeDaoException;
    //3.2.3 DELETE IMPORTED
    /**
     * delete the associated {@link FaceBean} objects from fl_face.image_md5 field.<BR>
     * FK_NAME:fl_face_ibfk_1
     * @param md5OfImage String - PK# 1
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deleteFaceBeansByImageMd5(String md5OfImage)throws RuntimeDaoException;
    //3.2.4 GET IMPORTED
    /**
     * Retrieves the {@link FaceBean} object from fl_face.image_md5 field.<BR>
     * FK_NAME:fl_face_ibfk_1
     * @param bean the {@link ImageBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link FaceBean} beans or empty list if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(ImageBean bean,int startRow,int numRows)throws RuntimeDaoException;    
    //3.3 SET IMPORTED
    /**
     * set  the {@link FaceBean} object array associate to ImageBean by the fl_face.image_md5 field.<BR>
     * FK_NAME : fl_face_ibfk_1 
     * @param bean the referenced {@link ImageBean}
     * @param importedBeans imported beans from fl_face
     * @return importedBeans always
     * @see IFaceManager#setReferencedByImageMd5(FaceBean, ImageBean)
     * @throws RuntimeDaoException
     */
    public FaceBean[] setFaceBeansByImageMd5(ImageBean bean , FaceBean[] importedBeans)throws RuntimeDaoException;

    //3.4 SET IMPORTED
    /**
     * set  the {@link FaceBean} object java.util.Collection associate to ImageBean by the fl_face.image_md5 field.<BR>
     * FK_NAME:fl_face_ibfk_1
     * @param bean the referenced {@link ImageBean} 
     * @param importedBeans imported beans from fl_face 
     * @return importedBeans always
     * @see IFaceManager#setReferencedByImageMd5(FaceBean, ImageBean)
     * @throws RuntimeDaoException
     */
    public <C extends java.util.Collection<FaceBean>> C setFaceBeansByImageMd5(ImageBean bean , C importedBeans)throws RuntimeDaoException;

    //3.1 GET IMPORTED
    /**
     * Retrieves the {@link PersonBean} object from the fl_person.image_md5 field.<BR>
     * FK_NAME : fl_person_ibfk_2 
     * @param bean the {@link ImageBean}
     * @return the associated {@link PersonBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public PersonBean[] getPersonBeansByImageMd5(ImageBean bean)throws RuntimeDaoException;
    
    //3.1.2 GET IMPORTED
    /**
     * Retrieves the {@link PersonBean} object from the fl_person.image_md5 field.<BR>
     * FK_NAME : fl_person_ibfk_2 
     * @param md5OfImage String - PK# 1
     * @return the associated {@link PersonBean} beans or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public PersonBean[] getPersonBeansByImageMd5(String md5OfImage)throws RuntimeDaoException;
    
    //3.2 GET IMPORTED
    /**
     * see also #getPersonBeansByImageMd5AsList(ImageBean,int,int)
     * @param bean
     * @return
     * @throws RuntimeDaoException
     */
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(ImageBean bean)throws RuntimeDaoException;

    //3.2.2 GET IMPORTED
    /**
     * Retrieves the {@link PersonBean} object from fl_person.image_md5 field.<BR>
     * FK_NAME:fl_person_ibfk_2
     * @param md5OfImage String - PK# 1
     * @return the associated {@link PersonBean} beans 
     * @throws RuntimeDaoException
     */
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(String md5OfImage)throws RuntimeDaoException;
    //3.2.3 DELETE IMPORTED
    /**
     * delete the associated {@link PersonBean} objects from fl_person.image_md5 field.<BR>
     * FK_NAME:fl_person_ibfk_2
     * @param md5OfImage String - PK# 1
     * @return the number of deleted rows
     * @throws RuntimeDaoException
     */
    public int deletePersonBeansByImageMd5(String md5OfImage)throws RuntimeDaoException;
    //3.2.4 GET IMPORTED
    /**
     * Retrieves the {@link PersonBean} object from fl_person.image_md5 field.<BR>
     * FK_NAME:fl_person_ibfk_2
     * @param bean the {@link ImageBean}
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return the associated {@link PersonBean} beans or empty list if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(ImageBean bean,int startRow,int numRows)throws RuntimeDaoException;    
    //3.3 SET IMPORTED
    /**
     * set  the {@link PersonBean} object array associate to ImageBean by the fl_person.image_md5 field.<BR>
     * FK_NAME : fl_person_ibfk_2 
     * @param bean the referenced {@link ImageBean}
     * @param importedBeans imported beans from fl_person
     * @return importedBeans always
     * @see IPersonManager#setReferencedByImageMd5(PersonBean, ImageBean)
     * @throws RuntimeDaoException
     */
    public PersonBean[] setPersonBeansByImageMd5(ImageBean bean , PersonBean[] importedBeans)throws RuntimeDaoException;

    //3.4 SET IMPORTED
    /**
     * set  the {@link PersonBean} object java.util.Collection associate to ImageBean by the fl_person.image_md5 field.<BR>
     * FK_NAME:fl_person_ibfk_2
     * @param bean the referenced {@link ImageBean} 
     * @param importedBeans imported beans from fl_person 
     * @return importedBeans always
     * @see IPersonManager#setReferencedByImageMd5(PersonBean, ImageBean)
     * @throws RuntimeDaoException
     */
    public <C extends java.util.Collection<PersonBean>> C setPersonBeansByImageMd5(ImageBean bean , C importedBeans)throws RuntimeDaoException;

    //3.5 SYNC SAVE 
    /**
     * Save the ImageBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link ImageBean} bean to be saved
     * @param refDeviceByDeviceId the {@link DeviceBean} bean referenced by {@link ImageBean} 
     * @param impFaceByImageMd5 the {@link FaceBean} bean refer to {@link ImageBean} 
     * @param impPersonByImageMd5 the {@link PersonBean} bean refer to {@link ImageBean} 
     * @return the inserted or updated {@link ImageBean} bean
     * @throws RuntimeDaoException
     */
    public ImageBean save(ImageBean bean
        , DeviceBean refDeviceByDeviceId 
        , FaceBean[] impFaceByImageMd5 , PersonBean[] impPersonByImageMd5 )throws RuntimeDaoException;
    //3.6 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(ImageBean , DeviceBean , FaceBean[] , PersonBean[] )}
     * @param bean the {@link ImageBean} bean to be saved
     * @param refDeviceByDeviceId the {@link DeviceBean} bean referenced by {@link ImageBean} 
     * @param impFaceByImageMd5 the {@link FaceBean} bean refer to {@link ImageBean} 
     * @param impPersonByImageMd5 the {@link PersonBean} bean refer to {@link ImageBean} 
     * @return the inserted or updated {@link ImageBean} bean
     * @throws RuntimeDaoException
     */
    public ImageBean saveAsTransaction(final ImageBean bean
        ,final DeviceBean refDeviceByDeviceId 
        ,final FaceBean[] impFaceByImageMd5 ,final PersonBean[] impPersonByImageMd5 )throws RuntimeDaoException;
    //3.7 SYNC SAVE 
    /**
     * Save the ImageBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link ImageBean} bean to be saved
     * @param refDeviceByDeviceId the {@link DeviceBean} bean referenced by {@link ImageBean} 
     * @param impFaceByImageMd5 the {@link FaceBean} bean refer to {@link ImageBean} 
     * @param impPersonByImageMd5 the {@link PersonBean} bean refer to {@link ImageBean} 
     * @return the inserted or updated {@link ImageBean} bean
     * @throws RuntimeDaoException
     */
    public ImageBean save(ImageBean bean
        , DeviceBean refDeviceByDeviceId 
        , java.util.Collection<FaceBean> impFaceByImageMd5 , java.util.Collection<PersonBean> impPersonByImageMd5 )throws RuntimeDaoException;
    //3.8 SYNC SAVE AS TRANSACTION
    /**
     * Transaction version for sync save<br>
     * see also {@link #save(ImageBean , DeviceBean , java.util.Collection , java.util.Collection )}
     * @param bean the {@link ImageBean} bean to be saved
     * @param refDeviceByDeviceId the {@link DeviceBean} bean referenced by {@link ImageBean} 
     * @param impFaceByImageMd5 the {@link FaceBean} bean refer to {@link ImageBean} 
     * @param impPersonByImageMd5 the {@link PersonBean} bean refer to {@link ImageBean} 
     * @return the inserted or updated {@link ImageBean} bean
     * @throws RuntimeDaoException
     */
    public ImageBean saveAsTransaction(final ImageBean bean
        ,final DeviceBean refDeviceByDeviceId 
        ,final  java.util.Collection<FaceBean> impFaceByImageMd5 ,final  java.util.Collection<PersonBean> impPersonByImageMd5 )throws RuntimeDaoException;
      //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////
    //5.1 GET REFERENCED VALUE
    /**
     * Retrieves the {@link DeviceBean} object referenced by {@link ImageBean#getDeviceId}() field.<br>
     * FK_NAME : fl_image_ibfk_1
     * @param bean the {@link ImageBean}
     * @return the associated {@link DeviceBean} bean or {@code null} if {@code bean} is {@code null}
     * @throws RuntimeDaoException
     */
    public DeviceBean getReferencedByDeviceId(ImageBean bean)throws RuntimeDaoException;

    //5.2 SET REFERENCED 
    /**
     * Associates the {@link ImageBean} object to the {@link DeviceBean} object by {@link ImageBean#getDeviceId}() field.
     *
     * @param bean the {@link ImageBean} object to use
     * @param beanToSet the {@link DeviceBean} object to associate to the {@link ImageBean}
     * @return always beanToSet saved
     * @throws RuntimeDaoException
     */
    public DeviceBean setReferencedByDeviceId(ImageBean bean, DeviceBean beanToSet)throws RuntimeDaoException;
    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________


     /**
     * Retrieves an array of ImageBean using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return an array of ImageBean
     * @throws RuntimeDaoException
     */
    public ImageBean[] loadByIndexDeviceId(Integer deviceId)throws RuntimeDaoException;
    
    /**
     * Retrieves a list of ImageBean using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return a list of ImageBean
     * @throws RuntimeDaoException
     */
    public java.util.List<ImageBean> loadByIndexDeviceIdAsList(Integer deviceId)throws RuntimeDaoException;

    /**
     * Deletes rows using the device_id index.
     *
     * @param deviceId the device_id column's value filter.
     * @return the number of deleted objects
     * @throws RuntimeDaoException
     */
    public int deleteByIndexDeviceId(Integer deviceId)throws RuntimeDaoException;
    

    //45
    /**
     * return a primary key list from {@link ImageBean} array
     * @param beans
     * @return
     */
    public java.util.List<String> toPrimaryKeyList(ImageBean... beans);
    //46
    /**
     * return a primary key list from {@link ImageBean} collection
     * @param beans
     * @return
     */
    public java.util.List<String> toPrimaryKeyList(java.util.Collection<ImageBean> beans);

}
