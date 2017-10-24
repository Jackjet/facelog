// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.concurrent.Callable;

import net.gdface.facelog.db.Constant;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IFaceManager;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.exception.WrapDAOException;
import net.gdface.facelog.db.exception.ObjectRetrievalException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.face.FlFaceManager;
import net.gdface.facelog.dborm.face.FlFaceBean;

/**
 * Handles database calls (save, load, count, etc...) for the fl_face table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.<br>
 * Remarks: 人脸检测信息数据表,用于保存检测到的人脸的所有信息(特征数据除外)<br>
 * @author guyadong
 */
public class FaceManager extends TableManager.Adapter<FaceBean> implements IFaceManager
{
    private FlFaceManager nativeManager = FlFaceManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<FaceBean,FlFaceBean> beanConverter = dbConverter.getFaceBeanConverter();
    private static FaceManager singleton = new FaceManager();
    protected FaceManager(){}
    /**
    * @return table name
    */
    public String getTableName() {
        return this.nativeManager.getTableName();
    }

    /**
    * @return field names of table
    */
    public String getFields() {
        return this.nativeManager.getFields();
    }
    
    public String getFullFields() {
        return this.nativeManager.getFullFields();
    }
    
    /**
    * @return primarykeyNames
    */
    public String[] getPrimarykeyNames() {
        return this.nativeManager.getPrimarykeyNames();
    }
    
    /**
     * Get the {@link FaceManager} singleton.
     *
     * @return {@link FaceManager}
     */
    public static FaceManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<FaceBean> _beanType(){
        return FaceBean.class;
    }
    
    public IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> getDbConverter() {
        return dbConverter;
    }

    /**
     * set  {@link IDbConverter} as converter used by manager.<br>
     * throw {@link NullPointerException} if {@code dbConverter} is null
     * @param dbConverter
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public synchronized void setDbConverter(IDbConverter dbConverter) {
        if( null == dbConverter)
            throw new NullPointerException();
        this.dbConverter = dbConverter;
        this.beanConverter = this.dbConverter.getFaceBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IFaceManager
    @Override 
    public FaceBean loadByPrimaryKey(Integer id)
    {
        if(null == id){
            return null;
        }
        try{
            return loadByPrimaryKeyChecked(id);
        }catch(ObjectRetrievalException e){
            // not found
            return null;
        }
    }
    //1.1
    @Override
    public FaceBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
    {
        try{
            return this.beanConverter.fromRight(nativeManager.loadByPrimaryKeyChecked(id));
        }catch(net.gdface.facelog.dborm.exception.ObjectRetrievalException e){
            throw new ObjectRetrievalException();
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }
    //1.2
    @Override
    public FaceBean loadByPrimaryKey(FaceBean bean)
    {
        return bean==null?null:loadByPrimaryKey(bean.getId());
    }

    //1.2.2
    @Override
    public FaceBean loadByPrimaryKeyChecked(FaceBean bean) throws ObjectRetrievalException
    {
        if(null == bean)
            throw new NullPointerException();
        return loadByPrimaryKeyChecked(bean.getId());
    }
    
    //1.3
    @Override
    public FaceBean loadByPrimaryKey(Object ...keys){
        try{
            return loadByPrimaryKeyChecked(keys);
        }catch(ObjectRetrievalException e){
            // not found
            return null;
        }
    }
    
    //1.3.2
    @Override
    public FaceBean loadByPrimaryKeyChecked(Object ...keys) throws ObjectRetrievalException{
        if(null == keys)
            throw new NullPointerException();
        if(keys.length != 1)
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
          return loadByPrimaryKeyChecked((Integer)keys[0]);
    }

    //1.4 override IFaceManager
    @Override 
    public boolean existsPrimaryKey(Integer id)
    {
        try{
            return nativeManager.existsPrimaryKey(id );
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //1.6
    @Override
    public boolean existsByPrimaryKey(FaceBean bean)
    {
        return null == bean ? false : existsPrimaryKey(bean.getId());
    }
    //1.7
    @Override
    public FaceBean checkDuplicate(FaceBean bean){
        if(null != bean)
            checkDuplicate(bean.getId());            
        return bean;   
    }
    //1.4.1 override IFaceManager
    @Override 
    public Integer checkDuplicate(Integer id){
        try{
            return this.nativeManager.checkDuplicate(id);
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }
    //1.8 override IFaceManager
    @Override 
    public java.util.List<FaceBean> loadByPrimaryKey(int... keys){
        if(null == keys)return new java.util.ArrayList<FaceBean>();
        java.util.ArrayList<FaceBean> list = new java.util.ArrayList<FaceBean>(keys.length);
        for(int i = 0 ;i< keys.length;++i){
            list.add(loadByPrimaryKey(keys[i]));
        }
        return list;
    }
    //1.9 override IFaceManager
    @Override 
    public java.util.List<FaceBean> loadByPrimaryKey(java.util.Collection<Integer> keys){
        if(null == keys )return new java.util.ArrayList<FaceBean>();
        java.util.ArrayList<FaceBean> list = new java.util.ArrayList<FaceBean>(keys.size());
        if(keys instanceof java.util.List){
            for(Integer key: keys){
                list.add(loadByPrimaryKey(key));
            }
        }else{
            FaceBean bean;
            for(Integer key: keys){
                if(null != (bean = loadByPrimaryKey(key)))
                    list.add(bean);
            }
        }
        return list;
    }
    //2 override IFaceManager
    @Override 
    public int deleteByPrimaryKey(Integer id)
    {
        try
        {
            return nativeManager.deleteByPrimaryKey(id);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //2
    @Override
    public int delete(FaceBean bean){
        try
        {
            return nativeManager.delete(this.beanConverter.toRight(bean));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }   
    }
    //2.1
    @Override
    public int deleteByPrimaryKey(Object ...keys){
        if(null == keys)
            throw new NullPointerException();
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        return deleteByPrimaryKey((Integer)keys[0]);
    }
    //2.2 override IFaceManager
    @Override 
    public int deleteByPrimaryKey(int... keys){
        if(null == keys)return 0;
        int count = 0;
        for(int key:keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.3 override IFaceManager
    @Override 
    public int deleteByPrimaryKey(java.util.Collection<Integer> keys){
        if(null == keys)return 0;
        int count = 0;
        for(Integer key :keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.4 override IFaceManager
    @Override 
    public int delete(FaceBean... beans){
        if(null == beans)return 0;
        int count = 0;
        for(FaceBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
    //2.5 override IFaceManager
    @Override 
    public int delete(java.util.Collection<FaceBean> beans){
        if(null == beans)return 0;
        int count = 0;
        for(FaceBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
 
    //////////////////////////////////////
    // IMPORT KEY GENERIC METHOD
    //////////////////////////////////////
    
    private static final Class<?>[] importedBeanTypes = new Class<?>[]{LogBean.class};

    /**
     * @see #getImportedBeansAsList(FaceBean,int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] getImportedBeans(FaceBean bean, int ikIndex){
        return getImportedBeansAsList(bean, ikIndex).toArray((T[])java.lang.reflect.Array.newInstance(importedBeanTypes[ikIndex],0));
    }
    
    /**
     * Retrieves imported T objects by ikIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link FaceBean} object to use
     * @param ikIndex valid values: {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE}
     * @return the associated T beans or {@code null} if {@code bean} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> java.util.List<T> getImportedBeansAsList(FaceBean bean,int ikIndex){
        switch(ikIndex){
        case FL_FACE_IK_FL_LOG_COMPARE_FACE:
            return (java.util.List<T>)this.getLogBeansByCompareFaceAsList(bean);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the T objects as imported beans of bean object by ikIndex.<br>
     * @param <T>
     * 
     * <ul>
     *     <li> {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link FaceBean} object to use
     * @param importedBeans the FlLogBean array to associate to the {@link FaceBean}
     * @param ikIndex valid values: {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] setImportedBeans(FaceBean bean,T[] importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_FACE_IK_FL_LOG_COMPARE_FACE:
            return (T[])setLogBeansByCompareFace(bean,(LogBean[])importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the importedBeans associates to the bean by ikIndex<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link FaceBean} object to use
     * @param importedBeans the <T> object to associate to the {@link FaceBean}
     * @param ikIndex valid values: {@link Constant#FL_FACE_IK_FL_LOG_COMPARE_FACE}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>,C extends java.util.Collection<T>> C setImportedBeans(FaceBean bean,C importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_FACE_IK_FL_LOG_COMPARE_FACE:
            return (C)setLogBeansByCompareFace(bean,(java.util.Collection<LogBean>)importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED override IFaceManager
    @Override 
    public LogBean[] getLogBeansByCompareFace(FaceBean bean)
    {
        return this.getLogBeansByCompareFaceAsList(bean).toArray(new LogBean[0]);
    }
    //3.1.2 GET IMPORTED override IFaceManager
    @Override
    public LogBean[] getLogBeansByCompareFace(Integer faceId)
    {
        FaceBean bean = new FaceBean();
        bean.setId(faceId);
        return getLogBeansByCompareFace(bean);
    }
    //3.2 GET IMPORTED override IFaceManager
    @Override 
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(FaceBean bean)
    {
        try {
            return this.dbConverter.getLogBeanConverter().fromRight(nativeManager.getLogBeansByCompareFaceAsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //3.2.2 GET IMPORTED override IFaceManager
    @Override
    public java.util.List<LogBean> getLogBeansByCompareFaceAsList(Integer faceId)
    {
         FaceBean bean = new FaceBean();
        bean.setId(faceId);
        return getLogBeansByCompareFaceAsList(bean);
    }
    //3.2.3 DELETE IMPORTED override IFaceManager
    @Override
    public int deleteLogBeansByCompareFace(Integer faceId)
    {
        java.util.List<LogBean> list =getLogBeansByCompareFaceAsList(faceId);
        return LogManager.getInstance().delete(list);
    }
    //3.3 SET IMPORTED override IFaceManager
    @Override 
    public LogBean[] setLogBeansByCompareFace(FaceBean bean , LogBean[] importedBeans)
    {
        if(null != importedBeans){
            for( LogBean importBean : importedBeans ){
                LogManager.getInstance().setReferencedByCompareFace(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.4 SET IMPORTED override IFaceManager
    @Override 
    public <C extends java.util.Collection<LogBean>> C setLogBeansByCompareFace(FaceBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( LogBean importBean : importedBeans ){
                LogManager.getInstance().setReferencedByCompareFace(importBean , bean);
            }
        }
        return importedBeans;
    }



    //3.5 SYNC SAVE override IFaceManager
    @Override  
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , LogBean[] impLogByCompareFace )
    {
        if(null == bean) return null;
        if(null != refFeatureByFeatureMd5)
            this.setReferencedByFeatureMd5(bean,refFeatureByFeatureMd5);
        if(null != refImageByImageMd5)
            this.setReferencedByImageMd5(bean,refImageByImageMd5);
        bean = this.save( bean );
        this.setLogBeansByCompareFace(bean,impLogByCompareFace);
        LogManager.getInstance().save( impLogByCompareFace );
        return bean;
    } 

    //3.6 SYNC SAVE AS TRANSACTION override IFaceManager
    @Override 
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final LogBean[] impLogByCompareFace )
    {
        return this.runAsTransaction(new Callable<FaceBean>(){
            @Override
            public FaceBean call() throws Exception {
                return save(bean , refFeatureByFeatureMd5 , refImageByImageMd5 , impLogByCompareFace );
            }});
    }
    //3.7 SYNC SAVE override IFaceManager
    @Override 
    public FaceBean save(FaceBean bean
        , FeatureBean refFeatureByFeatureMd5 , ImageBean refImageByImageMd5 
        , java.util.Collection<LogBean> impLogByCompareFace )
    {
        if(null == bean) return null;
        this.setReferencedByFeatureMd5(bean,refFeatureByFeatureMd5);
        this.setReferencedByImageMd5(bean,refImageByImageMd5);
        bean = this.save( bean );
        this.setLogBeansByCompareFace(bean,impLogByCompareFace);
        LogManager.getInstance().save( impLogByCompareFace );
        return bean;
    }   

    //3.8 SYNC SAVE AS TRANSACTION override IFaceManager
    @Override 
    public FaceBean saveAsTransaction(final FaceBean bean
        ,final FeatureBean refFeatureByFeatureMd5 ,final ImageBean refImageByImageMd5 
        ,final  java.util.Collection<LogBean> impLogByCompareFace )
    {
        return this.runAsTransaction(new Callable<FaceBean>(){
            @Override
            public FaceBean call() throws Exception {
                return save(bean , refFeatureByFeatureMd5 , refImageByImageMd5 , impLogByCompareFace );
            }});
    }
     /**
     * Save the {@link FaceBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(FaceBean , FeatureBean , ImageBean , LogBean[] )}
     * @return the inserted or updated {@link FaceBean} bean
     */
    //3.9 SYNC SAVE 
    @Override
    public FaceBean save(FaceBean bean,Object ...args) 
    {
        if(null == args)
            return save(bean);
        if(args.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        if( args.length > 0 && null != args[0] && !(args[0] instanceof FeatureBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:FeatureBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof ImageBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:ImageBean");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof LogBean[])){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:LogBean[]");
        }
        return save(bean,(args.length < 1 || null == args[0])?null:(FeatureBean)args[0],(args.length < 2 || null == args[1])?null:(ImageBean)args[1],(args.length < 3 || null == args[2])?null:(LogBean[])args[2]);
    } 

    /**
     * Save the {@link FaceBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link FaceBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(FaceBean , FeatureBean , ImageBean , java.util.Collection )}
     * @return the inserted or updated {@link FaceBean} bean
     */
    //3.10 SYNC SAVE 
    @SuppressWarnings("unchecked")
    @Override
    public FaceBean saveCollection(FaceBean bean,Object ...inputs)
    {
        if(null == inputs)
            return save(bean);
        if(inputs.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        Object[] args = new Object[3];
        System.arraycopy(inputs,0,args,0,3);
        if( args.length > 0 && null != args[0] && !(args[0] instanceof FeatureBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:FeatureBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof ImageBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:ImageBean");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:java.util.Collection<LogBean>");
        }
        return save(bean,null == args[0]?null:(FeatureBean)args[0],null == args[1]?null:(ImageBean)args[1],null == args[2]?null:(java.util.Collection<LogBean>)args[2]);
    }

     //////////////////////////////////////
    // FOREIGN KEY GENERIC METHOD
    //////////////////////////////////////

    /**
     * Retrieves the bean object referenced by fkIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_FACE_FK_FEATURE_MD5} -> {@link FeatureBean}</li>
     *     <li> {@link Constant#FL_FACE_FK_IMAGE_MD5} -> {@link ImageBean}</li>
     * </ul>
     * @param bean the {@link FaceBean} object to use
     * @param fkIndex valid values: <br>
     *        {@link Constant#FL_FACE_FK_FEATURE_MD5},{@link Constant#FL_FACE_FK_IMAGE_MD5}
     * @return the associated <T> bean or {@code null} if {@code bean} or {@code beanToSet} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T getReferencedBean(FaceBean bean,int fkIndex){
        switch(fkIndex){
        case FL_FACE_FK_FEATURE_MD5:
            return  (T)this.getReferencedByFeatureMd5(bean);
        case FL_FACE_FK_IMAGE_MD5:
            return  (T)this.getReferencedByImageMd5(bean);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    /**
     * Associates the {@link FaceBean} object to the bean object by fkIndex field.<br>
     * 
     * @param <T> see also {@link #getReferencedBean(FaceBean,int)}
     * @param bean the {@link FaceBean} object to use
     * @param beanToSet the <T> object to associate to the {@link FaceBean}
     * @param fkIndex valid values: see also {@link #getReferencedBean(FaceBean,int)}
     * @return always beanToSet saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T setReferencedBean(FaceBean bean,T beanToSet,int fkIndex){
        switch(fkIndex){
        case FL_FACE_FK_FEATURE_MD5:
            return  (T)this.setReferencedByFeatureMd5(bean, (FeatureBean)beanToSet);
        case FL_FACE_FK_IMAGE_MD5:
            return  (T)this.setReferencedByImageMd5(bean, (ImageBean)beanToSet);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////


    //5.1 GET REFERENCED VALUE override IFaceManager
    @Override 
    public FeatureBean getReferencedByFeatureMd5(FaceBean bean)
    {
        try{
            return this.dbConverter.getFeatureBeanConverter().fromRight(this.nativeManager.getReferencedByFeatureMd5(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override IFaceManager
    @Override 
    public FeatureBean setReferencedByFeatureMd5(FaceBean bean, FeatureBean beanToSet)
    {
        try{
            FlFaceBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean> foreignConverter = this.dbConverter.getFeatureBeanConverter();
            net.gdface.facelog.dborm.face.FlFeatureBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByFeatureMd5(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //5.1 GET REFERENCED VALUE override IFaceManager
    @Override 
    public ImageBean getReferencedByImageMd5(FaceBean bean)
    {
        try{
            return this.dbConverter.getImageBeanConverter().fromRight(this.nativeManager.getReferencedByImageMd5(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override IFaceManager
    @Override 
    public ImageBean setReferencedByImageMd5(FaceBean bean, ImageBean beanToSet)
    {
        try{
            FlFaceBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<ImageBean,net.gdface.facelog.dborm.image.FlImageBean> foreignConverter = this.dbConverter.getImageBeanConverter();
            net.gdface.facelog.dborm.image.FlImageBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByImageMd5(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //////////////////////////////////////
    // SQL 'WHERE' METHOD
    //////////////////////////////////////

    //11
    @Override
    public int deleteByWhere(String where)
    {
        try{
            return this.nativeManager.deleteByWhere(where);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________

    //13
    @Override
    protected FaceBean insert(FaceBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.insert(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //14
    @Override
    protected FaceBean update(FaceBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.update(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //_____________________________________________________________________
    //
    // USING TEMPLATE
    //_____________________________________________________________________
    //18
    @Override
    public FaceBean loadUniqueUsingTemplate(FaceBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplate(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
     }
    //18-1
    @Override
    public FaceBean loadUniqueUsingTemplateChecked(FaceBean bean) throws ObjectRetrievalException
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplate(this.beanConverter.toRight(bean)));
        }
        catch(net.gdface.facelog.dborm.exception.ObjectRetrievalException e)
        {
            throw new ObjectRetrievalException();
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
     }
    //20-5
    @Override
    public int loadUsingTemplate(FaceBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<FaceBean> action)
    {
        try {
            return this.nativeManager.loadUsingTemplate(this.beanConverter.toRight(bean),fieldList,startRow,numRows,searchType,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //21
    @Override
    public int deleteUsingTemplate(FaceBean bean)
    {
        try{
            return this.nativeManager.deleteUsingTemplate(this.beanConverter.toRight(bean));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }


    //_____________________________________________________________________
    //
    // USING INDICES
    //_____________________________________________________________________

     // override IFaceManager
    @Override 
    public FaceBean[] loadByIndexFeatureMd5(String featureMd5)
    {
        return this.loadByIndexFeatureMd5AsList(featureMd5).toArray(new FaceBean[0]);
    }
    
    // override IFaceManager
    @Override 
    public java.util.List<FaceBean> loadByIndexFeatureMd5AsList(String featureMd5)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexFeatureMd5AsList(featureMd5));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override IFaceManager
    @Override 
    public int deleteByIndexFeatureMd5(String featureMd5)
    {
        try{
            return this.nativeManager.deleteByIndexFeatureMd5(featureMd5);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
     // override IFaceManager
    @Override 
    public FaceBean[] loadByIndexImageMd5(String imageMd5)
    {
        return this.loadByIndexImageMd5AsList(imageMd5).toArray(new FaceBean[0]);
    }
    
    // override IFaceManager
    @Override 
    public java.util.List<FaceBean> loadByIndexImageMd5AsList(String imageMd5)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexImageMd5AsList(imageMd5));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override IFaceManager
    @Override 
    public int deleteByIndexImageMd5(String imageMd5)
    {
        try{
            return this.nativeManager.deleteByIndexImageMd5(imageMd5);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    
    /**
     * Retrieves a list of FaceBean using the index specified by keyIndex.
     * @param keyIndex valid values: <br>
     *        {@link Constant#FL_FACE_INDEX_FEATURE_MD5},{@link Constant#FL_FACE_INDEX_IMAGE_MD5}
     * @param keys key values of index
     * @return a list of FaceBean
     */
    @Override
    public java.util.List<FaceBean> loadByIndexAsList(int keyIndex,Object ...keys)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexAsList(keyIndex,keys));
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }
    
    /**
     * Deletes rows using key.
     * @param keyIndex valid values: <br>
     *        {@link Constant#FL_FACE_INDEX_FEATURE_MD5},{@link Constant#FL_FACE_INDEX_IMAGE_MD5}
     * @param keys key values of index
     * @return the number of deleted objects
     */
    @Override
    public int deleteByIndex(int keyIndex,Object ...keys)
    {
        try{
            return this.nativeManager.deleteByIndex(keyIndex,keys);
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }

    //_____________________________________________________________________
    //
    // COUNT
    //_____________________________________________________________________
    //25
    @Override
    public int countWhere(String where)
    {
        try{
            return this.nativeManager.countWhere(where);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //20
    @Override
    public int countUsingTemplate(FaceBean bean, int searchType)
    {
        try{
            return this.nativeManager.countUsingTemplate(this.beanConverter.toRight(bean),searchType);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }


    //_____________________________________________________________________
    //
    // LISTENER
    //_____________________________________________________________________

    //35
    @Override
    public void registerListener(TableListener<FaceBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<FaceBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlFaceBean> toNative(final TableListener<FaceBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlFaceBean> (){

            @Override
            public void beforeInsert(FlFaceBean bean) throws DAOException {
                listener.beforeInsert(FaceManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlFaceBean bean) throws DAOException {
                listener.afterInsert(FaceManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlFaceBean bean) throws DAOException {
                listener.beforeUpdate(FaceManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlFaceBean bean) throws DAOException {
                listener.afterUpdate(FaceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlFaceBean bean) throws DAOException {
                listener.beforeDelete(FaceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlFaceBean bean) throws DAOException {
                listener.afterDelete(FaceManager.this.beanConverter.fromRight(bean));
            }};
    }

    //_____________________________________________________________________
    //
    // UTILS
    //_____________________________________________________________________

    //43
    @Override
    public boolean isPrimaryKey(String column){
        return this.nativeManager.isPrimaryKey(column);
    }
    
    @Override
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<FaceBean> action){
        try{
            return this.nativeManager.loadBySqlForAction(sql,argList,fieldList,startRow,numRows,this.toNative(action));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    @Override
    public <T>T runAsTransaction(Callable<T> fun) {
        try{
            return this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    private net.gdface.facelog.dborm.TableManager.Action<FlFaceBean> toNative(final Action<FaceBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlFaceBean>(){

            @Override
            public void call(FlFaceBean bean) {
                action.call(FaceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlFaceBean getBean() {
                return  FaceManager.this.beanConverter.toRight(action.getBean());
            }};
    }
    
    //45 override IFaceManager
    @Override 
    public java.util.List<Integer> toPrimaryKeyList(FaceBean... array){        
        if(null == array)return new java.util.ArrayList<Integer>();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>(array.length);
        for(FaceBean bean:array){
            list.add(null == bean ? null : bean.getId());
        }
        return list;
    }
    //46 override IFaceManager
    @Override 
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<FaceBean> collection){        
        if(null == collection)return new java.util.ArrayList<Integer>();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>(collection.size());
        for(FaceBean bean:collection){
            list.add(null == bean ? null : bean.getId());
        }
        return list;
    }
}
