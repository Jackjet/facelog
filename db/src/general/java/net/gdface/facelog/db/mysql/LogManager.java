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
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.ILogManager;
import net.gdface.facelog.db.DeviceBean;
import net.gdface.facelog.db.FaceBean;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.exception.WrapDAOException;
import net.gdface.facelog.db.exception.ObjectRetrievalException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.log.FlLogManager;
import net.gdface.facelog.dborm.log.FlLogBean;

/**
 * Handles database calls (save, load, count, etc...) for the fl_log table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.<br>
 * Remarks: 人脸验证日志,记录所有通过验证的人员<br>
 * @author guyadong
 */
public class LogManager extends TableManager.Adapter<LogBean> implements ILogManager
{
    private FlLogManager nativeManager = FlLogManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<LogBean,FlLogBean> beanConverter = dbConverter.getLogBeanConverter();
    private static LogManager singleton = new LogManager();
    protected LogManager(){}
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
     * Get the {@link LogManager} singleton.
     *
     * @return {@link LogManager}
     */
    public static LogManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<LogBean> _beanType(){
        return LogBean.class;
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
        this.beanConverter = this.dbConverter.getLogBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override ILogManager
    @Override 
    public LogBean loadByPrimaryKey(Integer id)
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
    public LogBean loadByPrimaryKeyChecked(Integer id) throws ObjectRetrievalException
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
    public LogBean loadByPrimaryKey(LogBean bean)
    {
        return bean==null?null:loadByPrimaryKey(bean.getId());
    }

    //1.2.2
    @Override
    public LogBean loadByPrimaryKeyChecked(LogBean bean) throws ObjectRetrievalException
    {
        if(null == bean)
            throw new NullPointerException();
        return loadByPrimaryKeyChecked(bean.getId());
    }
    
    //1.3
    @Override
    public LogBean loadByPrimaryKey(Object ...keys){
        try{
            return loadByPrimaryKeyChecked(keys);
        }catch(ObjectRetrievalException e){
            // not found
            return null;
        }
    }
    
    //1.3.2
    @Override
    public LogBean loadByPrimaryKeyChecked(Object ...keys) throws ObjectRetrievalException{
        if(null == keys)
            throw new NullPointerException();
        if(keys.length != 1)
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
          return loadByPrimaryKeyChecked((Integer)keys[0]);
    }

    //1.4 override ILogManager
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
    public boolean existsByPrimaryKey(LogBean bean)
    {
        return null == bean ? false : existsPrimaryKey(bean.getId());
    }
    //1.7
    @Override
    public LogBean checkDuplicate(LogBean bean){
        if(null != bean)
            checkDuplicate(bean.getId());            
        return bean;   
    }
    //1.4.1 override ILogManager
    @Override 
    public Integer checkDuplicate(Integer id){
        try{
            return this.nativeManager.checkDuplicate(id);
        }catch(DAOException e){
            throw new WrapDAOException(e);
        }
    }
    //1.8 override ILogManager
    @Override 
    public java.util.List<LogBean> loadByPrimaryKey(int... keys){
        if(null == keys)return new java.util.ArrayList<LogBean>();
        java.util.ArrayList<LogBean> list = new java.util.ArrayList<LogBean>(keys.length);
        for(int i = 0 ;i< keys.length;++i){
            list.add(loadByPrimaryKey(keys[i]));
        }
        return list;
    }
    //1.9 override ILogManager
    @Override 
    public java.util.List<LogBean> loadByPrimaryKey(java.util.Collection<Integer> keys){
        if(null == keys )return new java.util.ArrayList<LogBean>();
        java.util.ArrayList<LogBean> list = new java.util.ArrayList<LogBean>(keys.size());
        if(keys instanceof java.util.List){
            for(Integer key: keys){
                list.add(loadByPrimaryKey(key));
            }
        }else{
            LogBean bean;
            for(Integer key: keys){
                if(null != (bean = loadByPrimaryKey(key)))
                    list.add(bean);
            }
        }
        return list;
    }
    //2 override ILogManager
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
    public int delete(LogBean bean){
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
    //2.2 override ILogManager
    @Override 
    public int deleteByPrimaryKey(int... keys){
        if(null == keys)return 0;
        int count = 0;
        for(int key:keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.3 override ILogManager
    @Override 
    public int deleteByPrimaryKey(java.util.Collection<Integer> keys){
        if(null == keys)return 0;
        int count = 0;
        for(Integer key :keys){
            count += deleteByPrimaryKey(key);
        }
        return count;
    }
    //2.4 override ILogManager
    @Override 
    public int delete(LogBean... beans){
        if(null == beans)return 0;
        int count = 0;
        for(LogBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
    //2.5 override ILogManager
    @Override 
    public int delete(java.util.Collection<LogBean> beans){
        if(null == beans)return 0;
        int count = 0;
        for(LogBean bean :beans){
            count += delete(bean);
        }
        return count;
    }
 
 


    //3.5 SYNC SAVE override ILogManager
    @Override  
    public LogBean save(LogBean bean
        , DeviceBean refDeviceByDeviceId , FaceBean refFaceByCompareFace , FeatureBean refFeatureByVerifyFeature , PersonBean refPersonByPersonId 
        )
    {
        if(null == bean) return null;
        if(null != refDeviceByDeviceId)
            this.setReferencedByDeviceId(bean,refDeviceByDeviceId);
        if(null != refFaceByCompareFace)
            this.setReferencedByCompareFace(bean,refFaceByCompareFace);
        if(null != refFeatureByVerifyFeature)
            this.setReferencedByVerifyFeature(bean,refFeatureByVerifyFeature);
        if(null != refPersonByPersonId)
            this.setReferencedByPersonId(bean,refPersonByPersonId);
        bean = this.save( bean );
        return bean;
    } 

    //3.6 SYNC SAVE AS TRANSACTION override ILogManager
    @Override 
    public LogBean saveAsTransaction(final LogBean bean
        ,final DeviceBean refDeviceByDeviceId ,final FaceBean refFaceByCompareFace ,final FeatureBean refFeatureByVerifyFeature ,final PersonBean refPersonByPersonId 
        )
    {
        return this.runAsTransaction(new Callable<LogBean>(){
            @Override
            public LogBean call() throws Exception {
                return save(bean , refDeviceByDeviceId , refFaceByCompareFace , refFeatureByVerifyFeature , refPersonByPersonId );
            }});
    }
     /**
     * Save the {@link LogBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link LogBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(LogBean , DeviceBean , FaceBean , FeatureBean , PersonBean )}
     * @return the inserted or updated {@link LogBean} bean
     */
    //3.9 SYNC SAVE 
    @Override
    public LogBean save(LogBean bean,Object ...args) 
    {
        if(null == args)
            return save(bean);
        if(args.length > 4)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 4");
        if( args.length > 0 && null != args[0] && !(args[0] instanceof DeviceBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof FaceBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:FaceBean");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof FeatureBean)){
            throw new IllegalArgumentException("invalid type for the No.3 dynamic argument,expected type:FeatureBean");
        }
        if( args.length > 3 && null != args[3] && !(args[3] instanceof PersonBean)){
            throw new IllegalArgumentException("invalid type for the No.4 dynamic argument,expected type:PersonBean");
        }
        return save(bean,(args.length < 1 || null == args[0])?null:(DeviceBean)args[0],(args.length < 2 || null == args[1])?null:(FaceBean)args[1],(args.length < 3 || null == args[2])?null:(FeatureBean)args[2],(args.length < 4 || null == args[3])?null:(PersonBean)args[3]);
    } 

    /**
     * Save the {@link LogBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link LogBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(LogBean , DeviceBean , FaceBean , FeatureBean , PersonBean )}
     * @return the inserted or updated {@link LogBean} bean
     */
    //3.10 SYNC SAVE 
    @SuppressWarnings("unchecked")
    @Override
    public LogBean saveCollection(LogBean bean,Object ...inputs)
    {
        if(null == inputs)
            return save(bean);
        if(inputs.length > 4)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 4");
        Object[] args = new Object[4];
        System.arraycopy(inputs,0,args,0,4);
        if( args.length > 0 && null != args[0] && !(args[0] instanceof DeviceBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof FaceBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:FaceBean");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof FeatureBean)){
            throw new IllegalArgumentException("invalid type for the No.3 dynamic argument,expected type:FeatureBean");
        }
        if( args.length > 3 && null != args[3] && !(args[3] instanceof PersonBean)){
            throw new IllegalArgumentException("invalid type for the No.4 dynamic argument,expected type:PersonBean");
        }
        return save(bean,null == args[0]?null:(DeviceBean)args[0],null == args[1]?null:(FaceBean)args[1],null == args[2]?null:(FeatureBean)args[2],null == args[3]?null:(PersonBean)args[3]);
    }

     //////////////////////////////////////
    // FOREIGN KEY GENERIC METHOD
    //////////////////////////////////////

    /**
     * Retrieves the bean object referenced by fkIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_LOG_FK_DEVICE_ID} -> {@link DeviceBean}</li>
     *     <li> {@link Constant#FL_LOG_FK_COMPARE_FACE} -> {@link FaceBean}</li>
     *     <li> {@link Constant#FL_LOG_FK_VERIFY_FEATURE} -> {@link FeatureBean}</li>
     *     <li> {@link Constant#FL_LOG_FK_PERSON_ID} -> {@link PersonBean}</li>
     * </ul>
     * @param bean the {@link LogBean} object to use
     * @param fkIndex valid values: <br>
     *        {@link Constant#FL_LOG_FK_DEVICE_ID},{@link Constant#FL_LOG_FK_COMPARE_FACE},{@link Constant#FL_LOG_FK_VERIFY_FEATURE},{@link Constant#FL_LOG_FK_PERSON_ID}
     * @return the associated <T> bean or {@code null} if {@code bean} or {@code beanToSet} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T getReferencedBean(LogBean bean,int fkIndex){
        switch(fkIndex){
        case FL_LOG_FK_DEVICE_ID:
            return  (T)this.getReferencedByDeviceId(bean);
        case FL_LOG_FK_COMPARE_FACE:
            return  (T)this.getReferencedByCompareFace(bean);
        case FL_LOG_FK_VERIFY_FEATURE:
            return  (T)this.getReferencedByVerifyFeature(bean);
        case FL_LOG_FK_PERSON_ID:
            return  (T)this.getReferencedByPersonId(bean);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    /**
     * Associates the {@link LogBean} object to the bean object by fkIndex field.<br>
     * 
     * @param <T> see also {@link #getReferencedBean(LogBean,int)}
     * @param bean the {@link LogBean} object to use
     * @param beanToSet the <T> object to associate to the {@link LogBean}
     * @param fkIndex valid values: see also {@link #getReferencedBean(LogBean,int)}
     * @return always beanToSet saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T setReferencedBean(LogBean bean,T beanToSet,int fkIndex){
        switch(fkIndex){
        case FL_LOG_FK_DEVICE_ID:
            return  (T)this.setReferencedByDeviceId(bean, (DeviceBean)beanToSet);
        case FL_LOG_FK_COMPARE_FACE:
            return  (T)this.setReferencedByCompareFace(bean, (FaceBean)beanToSet);
        case FL_LOG_FK_VERIFY_FEATURE:
            return  (T)this.setReferencedByVerifyFeature(bean, (FeatureBean)beanToSet);
        case FL_LOG_FK_PERSON_ID:
            return  (T)this.setReferencedByPersonId(bean, (PersonBean)beanToSet);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////


    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public DeviceBean getReferencedByDeviceId(LogBean bean)
    {
        try{
            return this.dbConverter.getDeviceBeanConverter().fromRight(this.nativeManager.getReferencedByDeviceId(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override ILogManager
    @Override 
    public DeviceBean setReferencedByDeviceId(LogBean bean, DeviceBean beanToSet)
    {
        try{
            FlLogBean nativeBean = this.beanConverter.toRight(bean);
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

    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public FaceBean getReferencedByCompareFace(LogBean bean)
    {
        try{
            return this.dbConverter.getFaceBeanConverter().fromRight(this.nativeManager.getReferencedByCompareFace(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override ILogManager
    @Override 
    public FaceBean setReferencedByCompareFace(LogBean bean, FaceBean beanToSet)
    {
        try{
            FlLogBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<FaceBean,net.gdface.facelog.dborm.face.FlFaceBean> foreignConverter = this.dbConverter.getFaceBeanConverter();
            net.gdface.facelog.dborm.face.FlFaceBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByCompareFace(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public FeatureBean getReferencedByVerifyFeature(LogBean bean)
    {
        try{
            return this.dbConverter.getFeatureBeanConverter().fromRight(this.nativeManager.getReferencedByVerifyFeature(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override ILogManager
    @Override 
    public FeatureBean setReferencedByVerifyFeature(LogBean bean, FeatureBean beanToSet)
    {
        try{
            FlLogBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<FeatureBean,net.gdface.facelog.dborm.face.FlFeatureBean> foreignConverter = this.dbConverter.getFeatureBeanConverter();
            net.gdface.facelog.dborm.face.FlFeatureBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByVerifyFeature(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    //5.1 GET REFERENCED VALUE override ILogManager
    @Override 
    public PersonBean getReferencedByPersonId(LogBean bean)
    {
        try{
            return this.dbConverter.getPersonBeanConverter().fromRight(this.nativeManager.getReferencedByPersonId(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override ILogManager
    @Override 
    public PersonBean setReferencedByPersonId(LogBean bean, PersonBean beanToSet)
    {
        try{
            FlLogBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<PersonBean,net.gdface.facelog.dborm.person.FlPersonBean> foreignConverter = this.dbConverter.getPersonBeanConverter();
            net.gdface.facelog.dborm.person.FlPersonBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByPersonId(nativeBean,foreignNativeBean);
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
    protected LogBean insert(LogBean bean)
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
    protected LogBean update(LogBean bean)
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
    public LogBean loadUniqueUsingTemplate(LogBean bean)
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
    public LogBean loadUniqueUsingTemplateChecked(LogBean bean) throws ObjectRetrievalException
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
    public int loadUsingTemplate(LogBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<LogBean> action)
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
    public int deleteUsingTemplate(LogBean bean)
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

     // override ILogManager
    @Override 
    public LogBean[] loadByIndexCompareFace(Integer compareFace)
    {
        return this.loadByIndexCompareFaceAsList(compareFace).toArray(new LogBean[0]);
    }
    
    // override ILogManager
    @Override 
    public java.util.List<LogBean> loadByIndexCompareFaceAsList(Integer compareFace)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexCompareFaceAsList(compareFace));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override ILogManager
    @Override 
    public int deleteByIndexCompareFace(Integer compareFace)
    {
        try{
            return this.nativeManager.deleteByIndexCompareFace(compareFace);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
     // override ILogManager
    @Override 
    public LogBean[] loadByIndexDeviceId(Integer deviceId)
    {
        return this.loadByIndexDeviceIdAsList(deviceId).toArray(new LogBean[0]);
    }
    
    // override ILogManager
    @Override 
    public java.util.List<LogBean> loadByIndexDeviceIdAsList(Integer deviceId)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexDeviceIdAsList(deviceId));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override ILogManager
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
    
     // override ILogManager
    @Override 
    public LogBean[] loadByIndexPersonId(Integer personId)
    {
        return this.loadByIndexPersonIdAsList(personId).toArray(new LogBean[0]);
    }
    
    // override ILogManager
    @Override 
    public java.util.List<LogBean> loadByIndexPersonIdAsList(Integer personId)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexPersonIdAsList(personId));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override ILogManager
    @Override 
    public int deleteByIndexPersonId(Integer personId)
    {
        try{
            return this.nativeManager.deleteByIndexPersonId(personId);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
     // override ILogManager
    @Override 
    public LogBean[] loadByIndexVerifyFeature(String verifyFeature)
    {
        return this.loadByIndexVerifyFeatureAsList(verifyFeature).toArray(new LogBean[0]);
    }
    
    // override ILogManager
    @Override 
    public java.util.List<LogBean> loadByIndexVerifyFeatureAsList(String verifyFeature)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexVerifyFeatureAsList(verifyFeature));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override ILogManager
    @Override 
    public int deleteByIndexVerifyFeature(String verifyFeature)
    {
        try{
            return this.nativeManager.deleteByIndexVerifyFeature(verifyFeature);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    
    /**
     * Retrieves a list of LogBean using the index specified by keyIndex.
     * @param keyIndex valid values: <br>
     *        {@link Constant#FL_LOG_INDEX_COMPARE_FACE},{@link Constant#FL_LOG_INDEX_DEVICE_ID},{@link Constant#FL_LOG_INDEX_PERSON_ID},{@link Constant#FL_LOG_INDEX_VERIFY_FEATURE}
     * @param keys key values of index
     * @return a list of LogBean
     */
    @Override
    public java.util.List<LogBean> loadByIndexAsList(int keyIndex,Object ...keys)
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
     *        {@link Constant#FL_LOG_INDEX_COMPARE_FACE},{@link Constant#FL_LOG_INDEX_DEVICE_ID},{@link Constant#FL_LOG_INDEX_PERSON_ID},{@link Constant#FL_LOG_INDEX_VERIFY_FEATURE}
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
    public int countUsingTemplate(LogBean bean, int searchType)
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
    public void registerListener(TableListener<LogBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<LogBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlLogBean> toNative(final TableListener<LogBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlLogBean> (){

            @Override
            public void beforeInsert(FlLogBean bean) throws DAOException {
                listener.beforeInsert(LogManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlLogBean bean) throws DAOException {
                listener.afterInsert(LogManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlLogBean bean) throws DAOException {
                listener.beforeUpdate(LogManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlLogBean bean) throws DAOException {
                listener.afterUpdate(LogManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlLogBean bean) throws DAOException {
                listener.beforeDelete(LogManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlLogBean bean) throws DAOException {
                listener.afterDelete(LogManager.this.beanConverter.fromRight(bean));
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<LogBean> action){
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
    
    private net.gdface.facelog.dborm.TableManager.Action<FlLogBean> toNative(final Action<LogBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlLogBean>(){

            @Override
            public void call(FlLogBean bean) {
                action.call(LogManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlLogBean getBean() {
                return  LogManager.this.beanConverter.toRight(action.getBean());
            }};
    }
    
    //45 override ILogManager
    @Override 
    public java.util.List<Integer> toPrimaryKeyList(LogBean... array){        
        if(null == array)return new java.util.ArrayList<Integer>();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>(array.length);
        for(LogBean bean:array){
            list.add(null == bean ? null : bean.getId());
        }
        return list;
    }
    //46 override ILogManager
    @Override 
    public java.util.List<Integer> toPrimaryKeyList(java.util.Collection<LogBean> collection){        
        if(null == collection)return new java.util.ArrayList<Integer>();
        java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>(collection.size());
        for(LogBean bean:collection){
            list.add(null == bean ? null : bean.getId());
        }
        return list;
    }
}
