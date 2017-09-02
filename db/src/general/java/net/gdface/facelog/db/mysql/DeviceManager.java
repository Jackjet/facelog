// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.concurrent.Callable;

import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.BaseBean;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.device.FlDeviceManager;
import net.gdface.facelog.dborm.device.FlDeviceBean;
import net.gdface.facelog.dborm.image.FlImageBean;
import net.gdface.facelog.dborm.log.FlLogBean;
/**
 * Handles database calls (save, load, count, etc...) for the fl_device table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.
 * @author guyadong
 */
public class DeviceManager extends TableManager.Adapter<DeviceBean>
{
    private FlDeviceManager nativeManager = FlDeviceManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.face.FlFaceLightBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<DeviceBean,FlDeviceBean> beanConverter = dbConverter.getDeviceBeanConverter();
    private static DeviceManager singleton = new DeviceManager();

    /**
    * @return table name
    */
    public String getTableName() {
        return this.nativeManager.getTableName();
    }

    /**
    * @return field names of table
    */
    public String getFieldNames() {
        return this.nativeManager.getFieldNames();
    }
    
    public String[] getFullFieldNames() {
        return this.nativeManager.getFullFieldNames();
    }
    
    /**
    * @return primarykeyNames
    */
    public String[] getPrimarykeyNames() {
        return this.nativeManager.getPrimarykeyNames();
    }
    
    /**
     * Get the {@link DeviceManager} singleton.
     *
     * @return {@link DeviceManager}
     */
    public static DeviceManager getInstance()
    {
        return singleton;
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
        this.beanConverter = this.dbConverter.getDeviceBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a {@link DeviceBean} from the fl_device using primary key fields.
     *
     * @param id Integer - PK# 1
     * @return a unique DeviceBean or {@code null} if not found
     */
    //1
    public DeviceBean loadByPrimaryKey(Integer id)
    {
        try{
            return this.beanConverter.fromRight(nativeManager.loadByPrimaryKey(id));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //1.2
    @Override
    public DeviceBean loadByPrimaryKey(DeviceBean bean)
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
     * Loads a {@link DeviceBean} from the fl_device using primary key fields.
     * when you don't know which is primary key of table,you can use the method.
     * @param keys primary keys value:<br> 
     *             PK# 1:Integer     
     * @return a unique {@link DeviceBean} or {@code null} if not found
     * @see {@link #loadByPrimaryKey(Integer id)}
     */
    //1.3
    public DeviceBean loadByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        return loadByPrimaryKey((Integer)keys[0]);
    }
    
    /**
     * Returns true if this fl_device contains row with primary key fields.
     * @param id Integer - PK# 1
     * @see #loadByPrimaryKey(Integer id)
     */
    //1.4
    public boolean existsPrimaryKey(Integer id)
    {
        return null!=loadByPrimaryKey(id );
    }
    
    /**
     * Delete row according to its primary keys.<br>
     * all keys must not be null
     *
     * @param id Integer - PK# 1
     * @return the number of deleted rows
     */
    //2
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

    /**
     * Delete row according to its primary keys.
     *
     * @param keys primary keys value:<br> 
     *             PK# 1:Integer     
     * @return the number of deleted rows
     * @see {@link #deleteByPrimaryKey(Integer id)}
     */   
    //2.1
    public int deleteByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        return deleteByPrimaryKey((Integer)keys[0]);
    }

 
    //////////////////////////////////////
    // IMPORT KEY GENERIC METHOD
    //////////////////////////////////////
    
    /**
     * Retrieves imported T objects by ikIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID} -> {@link FlImageBean}</li>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID} -> {@link FlLogBean}</li>
     * </ul>
     * @param bean the {@link DeviceBean} object to use
     * @param ikIndex valid values: {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID},{@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID}
     * @return the associated T beans or {@code null} if {@code bean} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BaseBean> java.util.List<T> getImportedBeansAsList(DeviceBean bean,int ikIndex){
        switch(ikIndex){
        case FL_DEVICE_IK_FL_IMAGE_DEVICE_ID:
            return (java.util.List<T>)this.getFlImageBeansByDeviceIdAsList(bean);
        case FL_DEVICE_IK_FL_LOG_DEVICE_ID:
            return (java.util.List<T>)this.getFlLogBeansByDeviceIdAsList(bean);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the T objects as imported beans of bean object by ikIndex.<br>
     * @param <T>
     * 
     * <ul>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID} -> {@link FlImageBean}</li>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID} -> {@link FlLogBean}</li>
     * </ul>
     * @param bean the {@link DeviceBean} object to use
     * @param importedBeans the FlLogBean array to associate to the {@link DeviceBean}
     * @param ikIndex valid values: {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID},{@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BaseBean> T[] setImportedBeans(DeviceBean bean,T[] importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_DEVICE_IK_FL_IMAGE_DEVICE_ID:
            return (T[])setFlImageBeansByDeviceId(bean,(ImageBean[])importedBeans);
        case FL_DEVICE_IK_FL_LOG_DEVICE_ID:
            return (T[])setFlLogBeansByDeviceId(bean,(LogBean[])importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the importedBeans associates to the bean by ikIndex<br>
     * @param <T>
     * <ul>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID} -> {@link FlImageBean}</li>
     *     <li> {@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID} -> {@link FlLogBean}</li>
     * </ul>
     * @param bean the {@link DeviceBean} object to use
     * @param importedBeans the <T> object to associate to the {@link DeviceBean}
     * @param ikIndex valid values: {@link TableManager#FL_DEVICE_IK_FL_IMAGE_DEVICE_ID},{@link TableManager#FL_DEVICE_IK_FL_LOG_DEVICE_ID}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends BaseBean,C extends java.util.Collection<T>> C setImportedBeans(DeviceBean bean,C importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_DEVICE_IK_FL_IMAGE_DEVICE_ID:
            return (C)setFlImageBeansByDeviceId(bean,(java.util.Collection<ImageBean>)importedBeans);
        case FL_DEVICE_IK_FL_LOG_DEVICE_ID:
            return (C)setFlLogBeansByDeviceId(bean,(java.util.Collection<LogBean>)importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    /**
     * Retrieves the {@link ImageBean} object from the fl_image.device_id field.<BR>
     * FK_NAME : fl_image_ibfk_3 
     * @param bean the {@link DeviceBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public ImageBean[] getFlImageBeansByDeviceId(DeviceBean bean)
    {
        return this.getFlImageBeansByDeviceIdAsList(bean).toArray(new ImageBean[0]);
    }

    /**
     * Retrieves the {@link ImageBean} object from fl_image.device_id field.<BR>
     * FK_NAME:fl_image_ibfk_3
     * @param bean the {@link DeviceBean}
     * @return the associated {@link ImageBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.2 GET IMPORTED
    public java.util.List<ImageBean> getFlImageBeansByDeviceIdAsList(DeviceBean bean)
    {
        try {
            return this.dbConverter.getImageBeanConverter().fromRight(nativeManager.getFlImageBeansByDeviceIdAsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link ImageBean} object array associate to DeviceBean by the fl_image.device_id field.<BR>
     * FK_NAME : fl_image_ibfk_3 
     * @param bean the referenced {@link DeviceBean}
     * @param importedBeans imported beans from fl_image
     * @return importedBeans always
     * @see {@link FlImageManager#setReferencedByDeviceId(ImageBean, DeviceBean)
     */
    //3.3 SET IMPORTED
    public ImageBean[] setFlImageBeansByDeviceId(DeviceBean bean , ImageBean[] importedBeans)
    {
        try {
            IBeanConverter<ImageBean,FlImageBean> importedConverter = this.dbConverter.getImageBeanConverter();
            return importedConverter.fromRight(importedBeans,
                this.nativeManager.setFlImageBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(importedBeans)
                ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link ImageBean} object java.util.Collection associate to DeviceBean by the fl_image.device_id field.<BR>
     * FK_NAME:fl_image_ibfk_3
     * @param bean the referenced {@link DeviceBean} 
     * @param importedBeans imported beans from fl_image 
     * @return importedBeans always
     * @see {@link FlImageManager#setReferencedByDeviceId(ImageBean, DeviceBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<ImageBean>> C setFlImageBeansByDeviceId(DeviceBean bean , C importedBeans)
    {
        try {
            IBeanConverter<ImageBean,FlImageBean> importedConverter = this.dbConverter.getImageBeanConverter();
            if(importedBeans instanceof java.util.List){
                importedConverter.fromRight((java.util.List<ImageBean>)importedBeans,nativeManager.setFlImageBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(importedBeans)
                    ));
            }else{
                ImageBean[] array = importedBeans.toArray(new ImageBean[0]);
                importedConverter.fromRight(array,nativeManager.setFlImageBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(array)
                    ));
            }
            return importedBeans;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * Retrieves the {@link LogBean} object from the fl_log.device_id field.<BR>
     * FK_NAME : fl_log_ibfk_2 
     * @param bean the {@link DeviceBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.1 GET IMPORTED
    public LogBean[] getFlLogBeansByDeviceId(DeviceBean bean)
    {
        return this.getFlLogBeansByDeviceIdAsList(bean).toArray(new LogBean[0]);
    }

    /**
     * Retrieves the {@link LogBean} object from fl_log.device_id field.<BR>
     * FK_NAME:fl_log_ibfk_2
     * @param bean the {@link DeviceBean}
     * @return the associated {@link LogBean} beans or {@code null} if {@code bean} is {@code null}
     */
    //3.2 GET IMPORTED
    public java.util.List<LogBean> getFlLogBeansByDeviceIdAsList(DeviceBean bean)
    {
        try {
            return this.dbConverter.getLogBeanConverter().fromRight(nativeManager.getFlLogBeansByDeviceIdAsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link LogBean} object array associate to DeviceBean by the fl_log.device_id field.<BR>
     * FK_NAME : fl_log_ibfk_2 
     * @param bean the referenced {@link DeviceBean}
     * @param importedBeans imported beans from fl_log
     * @return importedBeans always
     * @see {@link FlLogManager#setReferencedByDeviceId(LogBean, DeviceBean)
     */
    //3.3 SET IMPORTED
    public LogBean[] setFlLogBeansByDeviceId(DeviceBean bean , LogBean[] importedBeans)
    {
        try {
            IBeanConverter<LogBean,FlLogBean> importedConverter = this.dbConverter.getLogBeanConverter();
            return importedConverter.fromRight(importedBeans,
                this.nativeManager.setFlLogBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(importedBeans)
                ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    /**
     * set  the {@link LogBean} object java.util.Collection associate to DeviceBean by the fl_log.device_id field.<BR>
     * FK_NAME:fl_log_ibfk_2
     * @param bean the referenced {@link DeviceBean} 
     * @param importedBeans imported beans from fl_log 
     * @return importedBeans always
     * @see {@link FlLogManager#setReferencedByDeviceId(LogBean, DeviceBean)
     */
    //3.4 SET IMPORTED
    public <C extends java.util.Collection<LogBean>> C setFlLogBeansByDeviceId(DeviceBean bean , C importedBeans)
    {
        try {
            IBeanConverter<LogBean,FlLogBean> importedConverter = this.dbConverter.getLogBeanConverter();
            if(importedBeans instanceof java.util.List){
                importedConverter.fromRight((java.util.List<LogBean>)importedBeans,nativeManager.setFlLogBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(importedBeans)
                    ));
            }else{
                LogBean[] array = importedBeans.toArray(new LogBean[0]);
                importedConverter.fromRight(array,nativeManager.setFlLogBeansByDeviceId(
                    this.beanConverter.toRight(bean),
                    importedConverter.toRight(array)
                    ));
            }
            return importedBeans;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }



    /**
     * Save the DeviceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link DeviceBean} bean to be saved
         * @param impFlImagebyDeviceId the {@link ImageBean} bean refer to {@link DeviceBean} 
     * @param impFlLogbyDeviceId the {@link LogBean} bean refer to {@link DeviceBean} 
     * @return the inserted or updated {@link DeviceBean} bean
     */
    //3.5 SYNC SAVE 
    public DeviceBean save(DeviceBean bean
        
        , ImageBean[] impFlImagebyDeviceId , LogBean[] impFlLogbyDeviceId )
    {
        try{
            return this.beanConverter.fromRight(bean,nativeManager.save(this.beanConverter.toRight(bean)
                                , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyDeviceId)  , this.dbConverter.getLogBeanConverter().toRight(impFlLogbyDeviceId)  ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    } 
    /**
     * Transaction version for sync save
     * @see {@link #save(DeviceBean , ImageBean[] , LogBean[] )}
     */
    //3.6 SYNC SAVE AS TRANSACTION
    public DeviceBean saveAsTransaction(final DeviceBean bean
        
        ,final ImageBean[] impFlImagebyDeviceId ,final LogBean[] impFlLogbyDeviceId )
    {
        return this.runAsTransaction(new Callable<DeviceBean>(){
            @Override
            public DeviceBean call() throws Exception {
                return save(bean , impFlImagebyDeviceId , impFlLogbyDeviceId );
            }});
    }
    /**
     * Save the DeviceBean bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link DeviceBean} bean to be saved
         * @param impFlImagebyDeviceId the {@link ImageBean} bean refer to {@link DeviceBean} 
     * @param impFlLogbyDeviceId the {@link LogBean} bean refer to {@link DeviceBean} 
     * @return the inserted or updated {@link DeviceBean} bean
     */
    //3.7 SYNC SAVE 
    public DeviceBean save(DeviceBean bean
        
        , java.util.Collection<ImageBean> impFlImagebyDeviceId , java.util.Collection<LogBean> impFlLogbyDeviceId )
    {
        try{
            return this.beanConverter.fromRight(bean,nativeManager.save(this.beanConverter.toRight(bean)
                                , this.dbConverter.getImageBeanConverter().toRight(impFlImagebyDeviceId)  , this.dbConverter.getLogBeanConverter().toRight(impFlLogbyDeviceId)  ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }   
    /**
     * Transaction version for sync save
     * @see {@link #save(DeviceBean , java.util.Collection , java.util.Collection )}
     */
    //3.8 SYNC SAVE AS TRANSACTION
    public DeviceBean saveAsTransaction(final DeviceBean bean
        
        ,final  java.util.Collection<ImageBean> impFlImagebyDeviceId ,final  java.util.Collection<LogBean> impFlLogbyDeviceId )
    {
        return this.runAsTransaction(new Callable<DeviceBean>(){
            @Override
            public DeviceBean call() throws Exception {
                return save(bean , impFlImagebyDeviceId , impFlLogbyDeviceId );
            }});
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
    protected DeviceBean insert(DeviceBean bean)
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
    protected DeviceBean update(DeviceBean bean)
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
    public DeviceBean loadUniqueUsingTemplate(DeviceBean bean)
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
    public int loadUsingTemplate(DeviceBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<DeviceBean> action)
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
    public int deleteUsingTemplate(DeviceBean bean)
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
    public int countUsingTemplate(DeviceBean bean, int searchType)
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
    public void registerListener(TableListener<DeviceBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<DeviceBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlDeviceBean> toNative(final TableListener<DeviceBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlDeviceBean> (){

            @Override
            public void beforeInsert(FlDeviceBean bean) throws DAOException {
                listener.beforeInsert(DeviceManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlDeviceBean bean) throws DAOException {
                listener.afterInsert(DeviceManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlDeviceBean bean) throws DAOException {
                listener.beforeUpdate(DeviceManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlDeviceBean bean) throws DAOException {
                listener.afterUpdate(DeviceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlDeviceBean bean) throws DAOException {
                listener.beforeDelete(DeviceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlDeviceBean bean) throws DAOException {
                listener.afterDelete(DeviceManager.this.beanConverter.fromRight(bean));
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<DeviceBean> action){
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
    
    @Override
    public void runAsTransaction(final Runnable fun){
        try{
            this.nativeManager.runAsTransaction(fun);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    private net.gdface.facelog.dborm.TableManager.Action<FlDeviceBean> toNative(final Action<DeviceBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlDeviceBean>(){

            @Override
            public void call(FlDeviceBean bean) {
                action.call(DeviceManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlDeviceBean getBean() {
                return  DeviceManager.this.beanConverter.toRight(action.getBean());
            }};
    }
}
