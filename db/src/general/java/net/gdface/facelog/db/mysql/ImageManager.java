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
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IImageManager;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.image.FlImageManager;
import net.gdface.facelog.dborm.image.FlImageBean;

/**
 * Handles database calls (save, load, count, etc...) for the fl_image table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.<br>
 * Remarks: 图像信息存储表,用于存储系统中所有用到的图像数据,表中只包含图像基本信息,图像二进制源数据存在在fl_store中(md5对应)<br>
 * @author guyadong
 */
public class ImageManager extends TableManager.Adapter<ImageBean> implements IImageManager
{
    private FlImageManager nativeManager = FlImageManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<ImageBean,FlImageBean> beanConverter = dbConverter.getImageBeanConverter();
    private static ImageManager singleton = new ImageManager();
    protected ImageManager(){}
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
     * Get the {@link ImageManager} singleton.
     *
     * @return {@link ImageManager}
     */
    public static ImageManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<ImageBean> _beanType(){
        return ImageBean.class;
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
        this.beanConverter = this.dbConverter.getImageBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IImageManager
    @Override 
    public ImageBean loadByPrimaryKey(String md5)
    {
        try{
            return this.beanConverter.fromRight(nativeManager.loadByPrimaryKey(md5));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //1.2
    @Override
    public ImageBean loadByPrimaryKey(ImageBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByPrimaryKey(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //1.3
    @Override
    public ImageBean loadByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof String))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:String");
        return loadByPrimaryKey((String)keys[0]);
    }
    
    //1.4 override IImageManager
    @Override 
    public boolean existsPrimaryKey(String md5)
    {
        try{
            return nativeManager.existsPrimaryKey(md5 );
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //1.6
    @Override
    public boolean existsByPrimaryKey(ImageBean bean)
    {
        return null == bean ? false : existsPrimaryKey(bean.getMd5());
    }
    //1.7
    @Override
    public ImageBean checkDuplicate(ImageBean bean){
        if(null != bean)
            checkDuplicate(bean.getMd5());            
        return bean;   
    }
    //1.4.1 override IImageManager
    @Override 
    public String checkDuplicate(String md5){
        try{
            return this.nativeManager.checkDuplicate(md5);
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }
    //1.8 override IImageManager
    @Override 
    public java.util.List<ImageBean> loadByPrimaryKey(String... keys){
        if(null == keys)return new java.util.ArrayList<ImageBean>();
        java.util.ArrayList<ImageBean> list = new java.util.ArrayList<ImageBean>(keys.length);
        for(int i = 0 ;i< keys.length;++i){
            list.add(loadByPrimaryKey(keys[i]));
        }
        return list;
    }
    //1.9 override IImageManager
    @Override 
    public java.util.List<ImageBean> loadByPrimaryKey(java.util.Collection<String> keys){
        if(null == keys )return new java.util.ArrayList<ImageBean>();
        java.util.ArrayList<ImageBean> list = new java.util.ArrayList<ImageBean>(keys.size());
        if(keys instanceof java.util.List){
            for(String key: keys){
                list.add(loadByPrimaryKey(key));
            }
        }else{
            ImageBean bean;
            for(String key: keys){
                if(null != (bean = loadByPrimaryKey(key)))
                    list.add(bean);
            }
        }
        return list;
    }
    //2 override IImageManager
    @Override 
    public int deleteByPrimaryKey(String md5)
    {
        try
        {
            return nativeManager.deleteByPrimaryKey(md5);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //2
    @Override
    public int delete(ImageBean bean){
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
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof String))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:String");
        return deleteByPrimaryKey((String)keys[0]);
    }
    //2.2 override IImageManager
    @Override 
    public int deleteByPrimaryKey(String... keys){
        if(null == keys)return 0;
        int count = 0;
        for(String key:keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.3 override IImageManager
    @Override 
    public int deleteByPrimaryKey(java.util.Collection<String> keys){
        if(null == keys)return 0;
        int count = 0;
        for(String key :keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.4 override IImageManager
    @Override 
    public int delete(ImageBean... beans){
        if(null == beans)return 0;
        int count = 0;
        for(ImageBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
    //2.5 override IImageManager
    @Override 
    public int delete(java.util.Collection<ImageBean> beans){
        if(null == beans)return 0;
        int count = 0;
        for(ImageBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
 
    //////////////////////////////////////
    // IMPORT KEY GENERIC METHOD
    //////////////////////////////////////
    
    private static final Class<?>[] importedBeanTypes = new Class<?>[]{FaceBean.class,PersonBean.class};

    /**
     * @see #getImportedBeansAsList(ImageBean,int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] getImportedBeans(ImageBean bean, int ikIndex){
        return getImportedBeansAsList(bean, ikIndex).toArray((T[])java.lang.reflect.Array.newInstance(importedBeanTypes[ikIndex],0));
    }
    
    /**
     * Retrieves imported T objects by ikIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5} -> {@link FaceBean}</li>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5} -> {@link PersonBean}</li>
     * </ul>
     * @param bean the {@link ImageBean} object to use
     * @param ikIndex valid values: {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5},{@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5}
     * @return the associated T beans or {@code null} if {@code bean} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> java.util.List<T> getImportedBeansAsList(ImageBean bean,int ikIndex){
        switch(ikIndex){
        case FL_IMAGE_IK_FL_FACE_IMAGE_MD5:
            return (java.util.List<T>)this.getFaceBeansByImageMd5AsList(bean);
        case FL_IMAGE_IK_FL_PERSON_IMAGE_MD5:
            return (java.util.List<T>)this.getPersonBeansByImageMd5AsList(bean);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the T objects as imported beans of bean object by ikIndex.<br>
     * @param <T>
     * 
     * <ul>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5} -> {@link FaceBean}</li>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5} -> {@link PersonBean}</li>
     * </ul>
     * @param bean the {@link ImageBean} object to use
     * @param importedBeans the FlPersonBean array to associate to the {@link ImageBean}
     * @param ikIndex valid values: {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5},{@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] setImportedBeans(ImageBean bean,T[] importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_IMAGE_IK_FL_FACE_IMAGE_MD5:
            return (T[])setFaceBeansByImageMd5(bean,(FaceBean[])importedBeans);
        case FL_IMAGE_IK_FL_PERSON_IMAGE_MD5:
            return (T[])setPersonBeansByImageMd5(bean,(PersonBean[])importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the importedBeans associates to the bean by ikIndex<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5} -> {@link FaceBean}</li>
     *     <li> {@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5} -> {@link PersonBean}</li>
     * </ul>
     * @param bean the {@link ImageBean} object to use
     * @param importedBeans the <T> object to associate to the {@link ImageBean}
     * @param ikIndex valid values: {@link Constant#FL_IMAGE_IK_FL_FACE_IMAGE_MD5},{@link Constant#FL_IMAGE_IK_FL_PERSON_IMAGE_MD5}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>,C extends java.util.Collection<T>> C setImportedBeans(ImageBean bean,C importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_IMAGE_IK_FL_FACE_IMAGE_MD5:
            return (C)setFaceBeansByImageMd5(bean,(java.util.Collection<FaceBean>)importedBeans);
        case FL_IMAGE_IK_FL_PERSON_IMAGE_MD5:
            return (C)setPersonBeansByImageMd5(bean,(java.util.Collection<PersonBean>)importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED override IImageManager
    @Override 
    public FaceBean[] getFaceBeansByImageMd5(ImageBean bean)
    {
        return this.getFaceBeansByImageMd5AsList(bean).toArray(new FaceBean[0]);
    }
    //3.1.2 GET IMPORTED override IImageManager
    @Override
    public FaceBean[] getFaceBeansByImageMd5(String imageMd5)
    {
        ImageBean bean = new ImageBean();
        bean.setMd5(imageMd5);
        return getFaceBeansByImageMd5(bean);
    }
    //3.2 GET IMPORTED override IImageManager
    @Override 
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(ImageBean bean)
    {
        try {
            return this.dbConverter.getFaceBeanConverter().fromRight(nativeManager.getFaceBeansByImageMd5AsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //3.2.2 GET IMPORTED override IImageManager
    @Override
    public java.util.List<FaceBean> getFaceBeansByImageMd5AsList(String imageMd5)
    {
         ImageBean bean = new ImageBean();
        bean.setMd5(imageMd5);
        return getFaceBeansByImageMd5AsList(bean);
    }
    //3.2.3 DELETE IMPORTED override IImageManager
    @Override
    public int deleteFaceBeansByImageMd5(String imageMd5)
    {
        java.util.List<FaceBean> list =getFaceBeansByImageMd5AsList(imageMd5);
        return FaceManager.getInstance().delete(list);
    }
    //3.3 SET IMPORTED override IImageManager
    @Override 
    public FaceBean[] setFaceBeansByImageMd5(ImageBean bean , FaceBean[] importedBeans)
    {
        if(null != importedBeans){
            for( FaceBean importBean : importedBeans ){
                FaceManager.getInstance().setReferencedByImageMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.4 SET IMPORTED override IImageManager
    @Override 
    public <C extends java.util.Collection<FaceBean>> C setFaceBeansByImageMd5(ImageBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( FaceBean importBean : importedBeans ){
                FaceManager.getInstance().setReferencedByImageMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.1 GET IMPORTED override IImageManager
    @Override 
    public PersonBean[] getPersonBeansByImageMd5(ImageBean bean)
    {
        return this.getPersonBeansByImageMd5AsList(bean).toArray(new PersonBean[0]);
    }
    //3.1.2 GET IMPORTED override IImageManager
    @Override
    public PersonBean[] getPersonBeansByImageMd5(String imageMd5)
    {
        ImageBean bean = new ImageBean();
        bean.setMd5(imageMd5);
        return getPersonBeansByImageMd5(bean);
    }
    //3.2 GET IMPORTED override IImageManager
    @Override 
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(ImageBean bean)
    {
        try {
            return this.dbConverter.getPersonBeanConverter().fromRight(nativeManager.getPersonBeansByImageMd5AsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //3.2.2 GET IMPORTED override IImageManager
    @Override
    public java.util.List<PersonBean> getPersonBeansByImageMd5AsList(String imageMd5)
    {
         ImageBean bean = new ImageBean();
        bean.setMd5(imageMd5);
        return getPersonBeansByImageMd5AsList(bean);
    }
    //3.2.3 DELETE IMPORTED override IImageManager
    @Override
    public int deletePersonBeansByImageMd5(String imageMd5)
    {
        java.util.List<PersonBean> list =getPersonBeansByImageMd5AsList(imageMd5);
        return PersonManager.getInstance().delete(list);
    }
    //3.3 SET IMPORTED override IImageManager
    @Override 
    public PersonBean[] setPersonBeansByImageMd5(ImageBean bean , PersonBean[] importedBeans)
    {
        if(null != importedBeans){
            for( PersonBean importBean : importedBeans ){
                PersonManager.getInstance().setReferencedByImageMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.4 SET IMPORTED override IImageManager
    @Override 
    public <C extends java.util.Collection<PersonBean>> C setPersonBeansByImageMd5(ImageBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( PersonBean importBean : importedBeans ){
                PersonManager.getInstance().setReferencedByImageMd5(importBean , bean);
            }
        }
        return importedBeans;
    }



    //3.5 SYNC SAVE override IImageManager
    @Override  
    public ImageBean save(ImageBean bean
        , DeviceBean refDeviceByDeviceId 
        , FaceBean[] impFaceByImageMd5 , PersonBean[] impPersonByImageMd5 )
    {
        if(null == bean) return null;
        if(null != refDeviceByDeviceId)
            this.setReferencedByDeviceId(bean,refDeviceByDeviceId);
        bean = this.save( bean );
        this.setFaceBeansByImageMd5(bean,impFaceByImageMd5);
        FaceManager.getInstance().save( impFaceByImageMd5 );
        this.setPersonBeansByImageMd5(bean,impPersonByImageMd5);
        PersonManager.getInstance().save( impPersonByImageMd5 );
        return bean;
    } 

    //3.6 SYNC SAVE AS TRANSACTION override IImageManager
    @Override 
    public ImageBean saveAsTransaction(final ImageBean bean
        ,final DeviceBean refDeviceByDeviceId 
        ,final FaceBean[] impFaceByImageMd5 ,final PersonBean[] impPersonByImageMd5 )
    {
        return this.runAsTransaction(new Callable<ImageBean>(){
            @Override
            public ImageBean call() throws Exception {
                return save(bean , refDeviceByDeviceId , impFaceByImageMd5 , impPersonByImageMd5 );
            }});
    }
    //3.7 SYNC SAVE override IImageManager
    @Override 
    public ImageBean save(ImageBean bean
        , DeviceBean refDeviceByDeviceId 
        , java.util.Collection<FaceBean> impFaceByImageMd5 , java.util.Collection<PersonBean> impPersonByImageMd5 )
    {
        if(null == bean) return null;
        this.setReferencedByDeviceId(bean,refDeviceByDeviceId);
        bean = this.save( bean );
        this.setFaceBeansByImageMd5(bean,impFaceByImageMd5);
        FaceManager.getInstance().save( impFaceByImageMd5 );
        this.setPersonBeansByImageMd5(bean,impPersonByImageMd5);
        PersonManager.getInstance().save( impPersonByImageMd5 );
        return bean;
    }   

    //3.8 SYNC SAVE AS TRANSACTION override IImageManager
    @Override 
    public ImageBean saveAsTransaction(final ImageBean bean
        ,final DeviceBean refDeviceByDeviceId 
        ,final  java.util.Collection<FaceBean> impFaceByImageMd5 ,final  java.util.Collection<PersonBean> impPersonByImageMd5 )
    {
        return this.runAsTransaction(new Callable<ImageBean>(){
            @Override
            public ImageBean call() throws Exception {
                return save(bean , refDeviceByDeviceId , impFaceByImageMd5 , impPersonByImageMd5 );
            }});
    }
     /**
     * Save the {@link ImageBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link ImageBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(ImageBean , DeviceBean , FaceBean[] , PersonBean[] )}
     * @return the inserted or updated {@link ImageBean} bean
     */
    //3.9 SYNC SAVE 
    @Override
    public ImageBean save(ImageBean bean,Object ...args) 
    {
        if(args.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        if( args.length > 0 && null != args[0] && !(args[0] instanceof DeviceBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof FaceBean[])){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:FaceBean[]");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof PersonBean[])){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:PersonBean[]");
        }
        return save(bean,(args.length < 1 || null == args[0])?null:(DeviceBean)args[0],(args.length < 2 || null == args[1])?null:(FaceBean[])args[1],(args.length < 3 || null == args[2])?null:(PersonBean[])args[2]);
    } 

    /**
     * Save the {@link ImageBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link ImageBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(ImageBean , DeviceBean , java.util.Collection , java.util.Collection )}
     * @return the inserted or updated {@link ImageBean} bean
     */
    //3.10 SYNC SAVE 
    @SuppressWarnings("unchecked")
    @Override
    public ImageBean saveCollection(ImageBean bean,Object ...inputs)
    {
        if(inputs.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        Object[] args = new Object[3];
        System.arraycopy(inputs,0,args,0,3);
        if( args.length > 0 && null != args[0] && !(args[0] instanceof DeviceBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:java.util.Collection<FaceBean>");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:java.util.Collection<PersonBean>");
        }
        return save(bean,null == args[0]?null:(DeviceBean)args[0],null == args[1]?null:(java.util.Collection<FaceBean>)args[1],null == args[2]?null:(java.util.Collection<PersonBean>)args[2]);
    }

     //////////////////////////////////////
    // FOREIGN KEY GENERIC METHOD
    //////////////////////////////////////

    /**
     * Retrieves the bean object referenced by fkIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_IMAGE_FK_DEVICE_ID} -> {@link DeviceBean}</li>
     * </ul>
     * @param bean the {@link ImageBean} object to use
     * @param fkIndex valid values: <br>
     *        {@link Constant#FL_IMAGE_FK_DEVICE_ID}
     * @return the associated <T> bean or {@code null} if {@code bean} or {@code beanToSet} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T getReferencedBean(ImageBean bean,int fkIndex){
        switch(fkIndex){
        case FL_IMAGE_FK_DEVICE_ID:
            return  (T)this.getReferencedByDeviceId(bean);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    /**
     * Associates the {@link ImageBean} object to the bean object by fkIndex field.<br>
     * 
     * @param <T> see also {@link #getReferencedBean(ImageBean,int)}
     * @param bean the {@link ImageBean} object to use
     * @param beanToSet the <T> object to associate to the {@link ImageBean}
     * @param fkIndex valid values: see also {@link #getReferencedBean(ImageBean,int)}
     * @return always beanToSet saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T setReferencedBean(ImageBean bean,T beanToSet,int fkIndex){
        switch(fkIndex){
        case FL_IMAGE_FK_DEVICE_ID:
            return  (T)this.setReferencedByDeviceId(bean, (DeviceBean)beanToSet);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////


    //5.1 GET REFERENCED VALUE override IImageManager
    @Override 
    public DeviceBean getReferencedByDeviceId(ImageBean bean)
    {
        try{
            return this.dbConverter.getDeviceBeanConverter().fromRight(this.nativeManager.getReferencedByDeviceId(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override IImageManager
    @Override 
    public DeviceBean setReferencedByDeviceId(ImageBean bean, DeviceBean beanToSet)
    {
        try{
            FlImageBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<DeviceBean,net.gdface.facelog.dborm.device.FlDeviceBean> foreignConverter = this.dbConverter.getDeviceBeanConverter();
            net.gdface.facelog.dborm.device.FlDeviceBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByDeviceId(nativeBean,foreignNativeBean);
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
    protected ImageBean insert(ImageBean bean)
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
    protected ImageBean update(ImageBean bean)
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
    public ImageBean loadUniqueUsingTemplate(ImageBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplate(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
     }

    //20-5
    @Override
    public int loadUsingTemplate(ImageBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<ImageBean> action)
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
    public int deleteUsingTemplate(ImageBean bean)
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

     // override IImageManager
    @Override 
    public ImageBean[] loadByIndexDeviceId(Integer deviceId)
    {
        return this.loadByIndexDeviceIdAsList(deviceId).toArray(new ImageBean[0]);
    }
    
    // override IImageManager
    @Override 
    public java.util.List<ImageBean> loadByIndexDeviceIdAsList(Integer deviceId)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexDeviceIdAsList(deviceId));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override IImageManager
    @Override 
    public int deleteByIndexDeviceId(Integer deviceId)
    {
        try{
            return this.nativeManager.deleteByIndexDeviceId(deviceId);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    
    /**
     * Retrieves a list of ImageBean using the index specified by keyIndex.
     * @param keyIndex valid values: <br>
     *        {@link Constant#FL_IMAGE_INDEX_DEVICE_ID}
     * @param keys key values of index
     * @return a list of ImageBean
     */
    @Override
    public java.util.List<ImageBean> loadByIndexAsList(int keyIndex,Object ...keys)
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
     *        {@link Constant#FL_IMAGE_INDEX_DEVICE_ID}
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
    public int countUsingTemplate(ImageBean bean, int searchType)
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
    public void registerListener(TableListener<ImageBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<ImageBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlImageBean> toNative(final TableListener<ImageBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlImageBean> (){

            @Override
            public void beforeInsert(FlImageBean bean) throws DAOException {
                listener.beforeInsert(ImageManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlImageBean bean) throws DAOException {
                listener.afterInsert(ImageManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlImageBean bean) throws DAOException {
                listener.beforeUpdate(ImageManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlImageBean bean) throws DAOException {
                listener.afterUpdate(ImageManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlImageBean bean) throws DAOException {
                listener.beforeDelete(ImageManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlImageBean bean) throws DAOException {
                listener.afterDelete(ImageManager.this.beanConverter.fromRight(bean));
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<ImageBean> action){
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
    
    private net.gdface.facelog.dborm.TableManager.Action<FlImageBean> toNative(final Action<ImageBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlImageBean>(){

            @Override
            public void call(FlImageBean bean) {
                action.call(ImageManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlImageBean getBean() {
                return  ImageManager.this.beanConverter.toRight(action.getBean());
            }};
    }
    
    //45 override IImageManager
    @Override 
    public java.util.List<String> toPrimaryKeyList(ImageBean... array){        
        if(null == array)return new java.util.ArrayList<String>();
        java.util.ArrayList<String> list = new java.util.ArrayList<String>(array.length);
        for(ImageBean bean:array){
            list.add(null == bean ? null : bean.getMd5());
        }
        return list;
    }
    //46 override IImageManager
    @Override 
    public java.util.List<String> toPrimaryKeyList(java.util.Collection<ImageBean> collection){        
        if(null == collection)return new java.util.ArrayList<String>();
        java.util.ArrayList<String> list = new java.util.ArrayList<String>(collection.size());
        for(ImageBean bean:collection){
            list.add(null == bean ? null : bean.getMd5());
        }
        return list;
    }
}
