// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.concurrent.Callable;

import net.gdface.facelog.db.Constant;
import net.gdface.facelog.db.StoreBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.image.FlStoreManager;
import net.gdface.facelog.dborm.image.FlStoreBean;

/**
 * Handles database calls (save, load, count, etc...) for the fl_store table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.
 * @author guyadong
 */
public class StoreManager extends TableManager.Adapter<StoreBean>
{
    private FlStoreManager nativeManager = FlStoreManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.face.FlFaceLightBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<StoreBean,FlStoreBean> beanConverter = dbConverter.getStoreBeanConverter();
    private static StoreManager singleton = new StoreManager();

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
     * Get the {@link StoreManager} singleton.
     *
     * @return {@link StoreManager}
     */
    public static StoreManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<StoreBean> _beanType(){
        return StoreBean.class;
    }
    
    public IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.face.FlFaceLightBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.log.FlLogLightBean> getDbConverter() {
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
        this.beanConverter = this.dbConverter.getStoreBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a {@link StoreBean} from the fl_store using primary key fields.
     *
     * @param md5 String - PK# 1
     * @return a unique StoreBean or {@code null} if not found
     */
    //1
    public StoreBean loadByPrimaryKey(String md5)
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
    public StoreBean loadByPrimaryKey(StoreBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByPrimaryKey(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    /**
     * Loads a {@link StoreBean} from the fl_store using primary key fields.
     * @param keys primary keys value:<br> 
     * @return a unique {@link StoreBean} or {@code null} if not found
     * @see {@link #loadByPrimaryKey(String md5)}
     */
    //1.3
    @Override
    public StoreBean loadByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof String))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:String");
        return loadByPrimaryKey((String)keys[0]);
    }
    
    /**
     * Returns true if this fl_store contains row with primary key fields.
     * @param md5 String - PK# 1
     * @see #loadByPrimaryKey(String md5)
     */
    //1.4
    public boolean existsPrimaryKey(String md5)
    {
        return null!=loadByPrimaryKey(md5 );
    }
    
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param md5 String - PK# 1
     * @return the number of deleted rows
     */
    //2
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

    /**
     * Delete row according to its primary keys.
     *
     * @param keys primary keys value:<br> 
     * @return the number of deleted rows
     * @see {@link #deleteByPrimaryKey(String md5)}
     */   
    //2.1
    @Override
    public int deleteByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof String))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:String");
        return deleteByPrimaryKey((String)keys[0]);
    }

 
    //////////////////////////////////////
    // IMPORT KEY GENERIC METHOD
    //////////////////////////////////////
    
    private static final Class<?>[] importedBeanTypes = new Class<?>[]{ImageBean.class,ImageBean.class};

    /**
     * @see #getImportedBeansAsList(StoreBean,int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] getImportedBeans(StoreBean bean, int ikIndex){
        return getImportedBeansAsList(bean, ikIndex).toArray((T[])java.lang.reflect.Array.newInstance(importedBeanTypes[ikIndex],0));
    }
    
    /**
     * Retrieves imported T objects by ikIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_MD5} -> {@link ImageBean}</li>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5} -> {@link ImageBean}</li>
     * </ul>
     * @param bean the {@link StoreBean} object to use
     * @param ikIndex valid values: {@link Constant#FL_STORE_IK_FL_IMAGE_MD5},{@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5}
     * @return the associated T beans or {@code null} if {@code bean} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> java.util.List<T> getImportedBeansAsList(StoreBean bean,int ikIndex){
        switch(ikIndex){
        case FL_STORE_IK_FL_IMAGE_MD5:
            return (java.util.List<T>)this.getFlImageBeansByMd5AsList(bean);
        case FL_STORE_IK_FL_IMAGE_THUMB_MD5:
            return (java.util.List<T>)this.getFlImageBeansByThumbMd5AsList(bean);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the T objects as imported beans of bean object by ikIndex.<br>
     * @param <T>
     * 
     * <ul>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_MD5} -> {@link ImageBean}</li>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5} -> {@link ImageBean}</li>
     * </ul>
     * @param bean the {@link StoreBean} object to use
     * @param importedBeans the FlImageBean array to associate to the {@link StoreBean}
     * @param ikIndex valid values: {@link Constant#FL_STORE_IK_FL_IMAGE_MD5},{@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] setImportedBeans(StoreBean bean,T[] importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_STORE_IK_FL_IMAGE_MD5:
            return (T[])setFlImageBeansByMd5(bean,(ImageBean[])importedBeans);
        case FL_STORE_IK_FL_IMAGE_THUMB_MD5:
            return (T[])setFlImageBeansByThumbMd5(bean,(ImageBean[])importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the importedBeans associates to the bean by ikIndex<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_MD5} -> {@link ImageBean}</li>
     *     <li> {@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5} -> {@link ImageBean}</li>
     * </ul>
     * @param bean the {@link StoreBean} object to use
     * @param importedBeans the <T> object to associate to the {@link StoreBean}
     * @param ikIndex valid values: {@link Constant#FL_STORE_IK_FL_IMAGE_MD5},{@link Constant#FL_STORE_IK_FL_IMAGE_THUMB_MD5}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>,C extends java.util.Collection<T>> C setImportedBeans(StoreBean bean,C importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_STORE_IK_FL_IMAGE_MD5:
            return (C)setFlImageBeansByMd5(bean,(java.util.Collection<ImageBean>)importedBeans);
        case FL_STORE_IK_FL_IMAGE_THUMB_MD5:
            return (C)setFlImageBeansByThumbMd5(bean,(java.util.Collection<ImageBean>)importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link ImageBean} object from the fl_image.md5 field.<BR>
     * FK_NAME : fl_image_ibfk_1 
     * @param bean the {@link StoreBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public ImageBean[] getFlImageBeansByMd5(StoreBean bean)
    {
        return this.getFlImageBeansByMd5AsList(bean).toArray(new ImageBean[0]);
    }

    /**
     * Retrieves the {@link ImageBean} object from fl_image.md5 field.<BR>
     * FK_NAME:fl_image_ibfk_1
     * @param bean the {@link StoreBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.2 GET IMPORTED
    public java.util.List<ImageBean> getFlImageBeansByMd5AsList(StoreBean bean)
    {
        try {
            return this.dbConverter.getImageBeanConverter().fromRight(nativeManager.getFlImageBeansByMd5AsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link ImageBean} object array associate to StoreBean by the fl_image.md5 field.<BR>
     * FK_NAME : fl_image_ibfk_1 
     * @param bean the referenced {@link StoreBean}
     * @param importedBeans imported beans from fl_image
     * @return importedBeans always
     * @see {@link ImageManager#setReferencedByMd5(ImageBean, StoreBean)
     */
    //3.3 SET IMPORTED
    public ImageBean[] setFlImageBeansByMd5(StoreBean bean , ImageBean[] importedBeans)
    {
        if(null != importedBeans){
            for( ImageBean importBean : importedBeans ){
                ImageManager.getInstance().setReferencedByMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    /**
     * set  the {@link ImageBean} object java.util.Collection associate to StoreBean by the fl_image.md5 field.<BR>
     * FK_NAME:fl_image_ibfk_1
     * @param bean the referenced {@link StoreBean} 
     * @param importedBeans imported beans from fl_image 
     * @return importedBeans always
     * @see {@link ImageManager#setReferencedByMd5(ImageBean, StoreBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<ImageBean>> C setFlImageBeansByMd5(StoreBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( ImageBean importBean : importedBeans ){
                ImageManager.getInstance().setReferencedByMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    /**
     * Retrieves the {@link ImageBean} object from the fl_image.thumb_md5 field.<BR>
     * FK_NAME : fl_image_ibfk_2 
     * @param bean the {@link StoreBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public ImageBean[] getFlImageBeansByThumbMd5(StoreBean bean)
    {
        return this.getFlImageBeansByThumbMd5AsList(bean).toArray(new ImageBean[0]);
    }

    /**
     * Retrieves the {@link ImageBean} object from fl_image.thumb_md5 field.<BR>
     * FK_NAME:fl_image_ibfk_2
     * @param bean the {@link StoreBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.2 GET IMPORTED
    public java.util.List<ImageBean> getFlImageBeansByThumbMd5AsList(StoreBean bean)
    {
        try {
            return this.dbConverter.getImageBeanConverter().fromRight(nativeManager.getFlImageBeansByThumbMd5AsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link ImageBean} object array associate to StoreBean by the fl_image.thumb_md5 field.<BR>
     * FK_NAME : fl_image_ibfk_2 
     * @param bean the referenced {@link StoreBean}
     * @param importedBeans imported beans from fl_image
     * @return importedBeans always
     * @see {@link ImageManager#setReferencedByThumbMd5(ImageBean, StoreBean)
     */
    //3.3 SET IMPORTED
    public ImageBean[] setFlImageBeansByThumbMd5(StoreBean bean , ImageBean[] importedBeans)
    {
        if(null != importedBeans){
            for( ImageBean importBean : importedBeans ){
                ImageManager.getInstance().setReferencedByThumbMd5(importBean , bean);
            }
        }
        return importedBeans;
    }

    /**
     * set  the {@link ImageBean} object java.util.Collection associate to StoreBean by the fl_image.thumb_md5 field.<BR>
     * FK_NAME:fl_image_ibfk_2
     * @param bean the referenced {@link StoreBean} 
     * @param importedBeans imported beans from fl_image 
     * @return importedBeans always
     * @see {@link ImageManager#setReferencedByThumbMd5(ImageBean, StoreBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<ImageBean>> C setFlImageBeansByThumbMd5(StoreBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( ImageBean importBean : importedBeans ){
                ImageManager.getInstance().setReferencedByThumbMd5(importBean , bean);
            }
        }
        return importedBeans;
    }



    /**
     * Save the StoreBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link StoreBean} bean to be saved
         * @param impFlImagebyMd5 the {@link ImageBean} bean refer to {@link StoreBean} 
     * @param impFlImagebyThumbMd5 the {@link ImageBean} bean refer to {@link StoreBean} 
     * @return the inserted or updated {@link StoreBean} bean
     */
    //3.5 SYNC SAVE 
    public StoreBean save(StoreBean bean
        
        , ImageBean[] impFlImagebyMd5 , ImageBean[] impFlImagebyThumbMd5 )
    {
        try{
            return this.beanConverter.fromRight(bean,nativeManager.save(this.beanConverter.toRight(bean)
                                , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyMd5)  , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyThumbMd5)  ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    } 
    /**
     * Transaction version for sync save
     * @see {@link #save(StoreBean , ImageBean[] , ImageBean[] )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public StoreBean saveAsTransaction(final StoreBean bean
        
        ,final ImageBean[] impFlImagebyMd5 ,final ImageBean[] impFlImagebyThumbMd5 )
    {
        return this.runAsTransaction(new Callable<StoreBean>(){
            @Override
            public StoreBean call() throws Exception {
                return save(bean , impFlImagebyMd5 , impFlImagebyThumbMd5 );
            }});
    }
    /**
     * Save the StoreBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link StoreBean} bean to be saved
         * @param impFlImagebyMd5 the {@link ImageBean} bean refer to {@link StoreBean} 
     * @param impFlImagebyThumbMd5 the {@link ImageBean} bean refer to {@link StoreBean} 
     * @return the inserted or updated {@link StoreBean} bean
     */
    //3.7 SYNC SAVE 
    public StoreBean save(StoreBean bean
        
        , java.util.Collection<ImageBean> impFlImagebyMd5 , java.util.Collection<ImageBean> impFlImagebyThumbMd5 )
    {
        try{
            return this.beanConverter.fromRight(bean,nativeManager.save(this.beanConverter.toRight(bean)
                                , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyMd5)  , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyThumbMd5)  ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }   
    /**
     * Transaction version for sync save
     * @see {@link #save(StoreBean , java.util.Collection , java.util.Collection )}
     */
    //3.8 SYNC SAVE AS TRANSACTION
    public StoreBean saveAsTransaction(final StoreBean bean
        
        ,final  java.util.Collection<ImageBean> impFlImagebyMd5 ,final  java.util.Collection<ImageBean> impFlImagebyThumbMd5 )
    {
        return this.runAsTransaction(new Callable<StoreBean>(){
            @Override
            public StoreBean call() throws Exception {
                return save(bean , impFlImagebyMd5 , impFlImagebyThumbMd5 );
            }});
    }
     /**
     * Save the {@link StoreBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link StoreBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(StoreBean , ImageBean[] , ImageBean[] )}
     * @return the inserted or updated {@link StoreBean} bean
     */
    //3.9 SYNC SAVE 
    @Override
    public StoreBean save(StoreBean bean,Object ...args) 
    {
        if(args.length > 2)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 2");
        if( args.length > 0 && null != args[0] && !(args[0] instanceof ImageBean[])){
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:ImageBean[]");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof ImageBean[])){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:ImageBean[]");
        }
        return save(bean,(args.length < 1 || null == args[0])?null:(ImageBean[])args[0],(args.length < 2 || null == args[1])?null:(ImageBean[])args[1]);
    } 

    /**
     * Save the {@link StoreBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link StoreBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(StoreBean , java.util.Collection , java.util.Collection )}
     * @return the inserted or updated {@link StoreBean} bean
     */
    //3.10 SYNC SAVE 
    @SuppressWarnings("unchecked")
    @Override
    public StoreBean saveCollection(StoreBean bean,Object ...inputs)
    {
        if(inputs.length > 2)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 2");
        Object[] args = new Object[2];
        System.arraycopy(inputs,0,args,0,2);
        if( args.length > 0 && null != args[0] && !(args[0] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:java.util.Collection<ImageBean>");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:java.util.Collection<ImageBean>");
        }
        return save(bean,null == args[0]?null:(java.util.Collection<ImageBean>)args[0],null == args[1]?null:(java.util.Collection<ImageBean>)args[1]);
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
    protected StoreBean insert(StoreBean bean)
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
    protected StoreBean update(StoreBean bean)
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
    public StoreBean loadUniqueUsingTemplate(StoreBean bean)
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
    public int loadUsingTemplate(StoreBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<StoreBean> action)
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
    public int deleteUsingTemplate(StoreBean bean)
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
    public int countUsingTemplate(StoreBean bean, int searchType)
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
    public void registerListener(TableListener<StoreBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<StoreBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlStoreBean> toNative(final TableListener<StoreBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlStoreBean> (){

            @Override
            public void beforeInsert(FlStoreBean bean) throws DAOException {
                listener.beforeInsert(StoreManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlStoreBean bean) throws DAOException {
                listener.afterInsert(StoreManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlStoreBean bean) throws DAOException {
                listener.beforeUpdate(StoreManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlStoreBean bean) throws DAOException {
                listener.afterUpdate(StoreManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlStoreBean bean) throws DAOException {
                listener.beforeDelete(StoreManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlStoreBean bean) throws DAOException {
                listener.afterDelete(StoreManager.this.beanConverter.fromRight(bean));
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<StoreBean> action){
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
    
    private net.gdface.facelog.dborm.TableManager.Action<FlStoreBean> toNative(final Action<StoreBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlStoreBean>(){

            @Override
            public void call(FlStoreBean bean) {
                action.call(StoreManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlStoreBean getBean() {
                return  StoreManager.this.beanConverter.toRight(action.getBean());
            }};
    }
}
