// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db;

/**
 * Interface to handle database calls (save, load, count, etc...) for the fl_face table.<br>
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
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //2
    public int deleteByPrimaryKey(Integer id);

 
    /**
     * Save the FaceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param refFeatureByFeatureMd5 the {@link FeatureBean} bean referenced by {@link FaceBean} 
     * @param refImageByImageMd5 the {@link ImageBean} bean referenced by {@link FaceBean} 
         * @return the inserted or updated {@link FaceBean} bean
     */
    //3.5 SYNC SAVE 
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        );
    /**
     * Transaction version for sync save
     * @see {@link #save(FaceBean , FeatureBean , ImageBean )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        );
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
    
}