// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db.mysql;

import java.util.concurrent.Callable;

import net.gdface.facelog.db.Constant;
import net.gdface.facelog.db.PersonBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IPersonManager;
import net.gdface.facelog.db.FeatureBean;
import net.gdface.facelog.db.LogBean;
import net.gdface.facelog.db.ImageBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.WrapDAOException;

import net.gdface.facelog.dborm.exception.DAOException;
import net.gdface.facelog.dborm.person.FlPersonManager;
import net.gdface.facelog.dborm.person.FlPersonBean;

/**
 * Handles database calls (save, load, count, etc...) for the fl_person table.<br>
 * all {@link DAOException} be wrapped as {@link WrapDAOException} to throw.
 * @author guyadong
 */
public class PersonManager extends TableManager.Adapter<PersonBean> implements IPersonManager
{
    private FlPersonManager nativeManager = FlPersonManager.getInstance();
    private IDbConverter<net.gdface.facelog.dborm.device.FlDeviceBean,net.gdface.facelog.dborm.face.FlFaceBean,net.gdface.facelog.dborm.face.FlFeatureBean,net.gdface.facelog.dborm.image.FlImageBean,net.gdface.facelog.dborm.log.FlLogBean,net.gdface.facelog.dborm.person.FlPersonBean,net.gdface.facelog.dborm.image.FlStoreBean,net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<PersonBean,FlPersonBean> beanConverter = dbConverter.getPersonBeanConverter();
    private static PersonManager singleton = new PersonManager();

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
     * Get the {@link PersonManager} singleton.
     *
     * @return {@link PersonManager}
     */
    public static PersonManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<PersonBean> _beanType(){
        return PersonBean.class;
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
        this.beanConverter = this.dbConverter.getPersonBeanConverter();
    }
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IPersonManager
    @Override 
    public PersonBean loadByPrimaryKey(Integer id)
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
    public PersonBean loadByPrimaryKey(PersonBean bean)
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
    public PersonBean loadByPrimaryKey(Object ...keys){
        if(keys.length != 1 )
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        if(! (keys[0] instanceof Integer))
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        return loadByPrimaryKey((Integer)keys[0]);
    }
    
    //1.4 override IPersonManager
    @Override 
    public boolean existsPrimaryKey(Integer id)
    {
        return null!=loadByPrimaryKey(id );
    }
    
    //2 override IPersonManager
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

    //2.1
    @Override
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
    
    private static final Class<?>[] importedBeanTypes = new Class<?>[]{FeatureBean.class,LogBean.class};

    /**
     * @see #getImportedBeansAsList(PersonBean,int)
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] getImportedBeans(PersonBean bean, int ikIndex){
        return getImportedBeansAsList(bean, ikIndex).toArray((T[])java.lang.reflect.Array.newInstance(importedBeanTypes[ikIndex],0));
    }
    
    /**
     * Retrieves imported T objects by ikIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID} -> {@link FeatureBean}</li>
     *     <li> {@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link PersonBean} object to use
     * @param ikIndex valid values: {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID},{@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID}
     * @return the associated T beans or {@code null} if {@code bean} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> java.util.List<T> getImportedBeansAsList(PersonBean bean,int ikIndex){
        switch(ikIndex){
        case FL_PERSON_IK_FL_FEATURE_PERSON_ID:
            return (java.util.List<T>)this.getFlFeatureBeansByPersonIdAsList(bean);
        case FL_PERSON_IK_FL_LOG_PERSON_ID:
            return (java.util.List<T>)this.getFlLogBeansByPersonIdAsList(bean);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the T objects as imported beans of bean object by ikIndex.<br>
     * @param <T>
     * 
     * <ul>
     *     <li> {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID} -> {@link FeatureBean}</li>
     *     <li> {@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link PersonBean} object to use
     * @param importedBeans the FlLogBean array to associate to the {@link PersonBean}
     * @param ikIndex valid values: {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID},{@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T[] setImportedBeans(PersonBean bean,T[] importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_PERSON_IK_FL_FEATURE_PERSON_ID:
            return (T[])setFlFeatureBeansByPersonId(bean,(FeatureBean[])importedBeans);
        case FL_PERSON_IK_FL_LOG_PERSON_ID:
            return (T[])setFlLogBeansByPersonId(bean,(LogBean[])importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
    /**
     * Set the importedBeans associates to the bean by ikIndex<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID} -> {@link FeatureBean}</li>
     *     <li> {@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID} -> {@link LogBean}</li>
     * </ul>
     * @param bean the {@link PersonBean} object to use
     * @param importedBeans the <T> object to associate to the {@link PersonBean}
     * @param ikIndex valid values: {@link Constant#FL_PERSON_IK_FL_FEATURE_PERSON_ID},{@link Constant#FL_PERSON_IK_FL_LOG_PERSON_ID}
     * @return importedBeans always
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>,C extends java.util.Collection<T>> C setImportedBeans(PersonBean bean,C importedBeans,int ikIndex){
        switch(ikIndex){
        case FL_PERSON_IK_FL_FEATURE_PERSON_ID:
            return (C)setFlFeatureBeansByPersonId(bean,(java.util.Collection<FeatureBean>)importedBeans);
        case FL_PERSON_IK_FL_LOG_PERSON_ID:
            return (C)setFlLogBeansByPersonId(bean,(java.util.Collection<LogBean>)importedBeans);
        }
        throw new IllegalArgumentException(String.format("invalid ikIndex %d", ikIndex));
    }
 

    //////////////////////////////////////
    // GET/SET IMPORTED KEY BEAN METHOD
    //////////////////////////////////////
    //3.1 GET IMPORTED override IPersonManager
    @Override 
    public FeatureBean[] getFlFeatureBeansByPersonId(PersonBean bean)
    {
        return this.getFlFeatureBeansByPersonIdAsList(bean).toArray(new FeatureBean[0]);
    }
    //3.1.2 GET IMPORTED override IPersonManager
    @Override
    public FeatureBean[] getFlFeatureBeansByPersonId(Integer personId)
    {
        PersonBean bean = new PersonBean();
        bean.setId(personId);
        return getFlFeatureBeansByPersonId(bean);
    }
    //3.2 GET IMPORTED override IPersonManager
    @Override 
    public java.util.List<FeatureBean> getFlFeatureBeansByPersonIdAsList(PersonBean bean)
    {
        try {
            return this.dbConverter.getFeatureBeanConverter().fromRight(nativeManager.getFlFeatureBeansByPersonIdAsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //3.2.2 GET IMPORTED override IPersonManager
    @Override
    public java.util.List<FeatureBean> getFlFeatureBeansByPersonIdAsList(Integer personId)
    {
         PersonBean bean = new PersonBean();
        bean.setId(personId);
        return getFlFeatureBeansByPersonIdAsList(bean);
    }
    //3.3 SET IMPORTED override IPersonManager
    @Override 
    public FeatureBean[] setFlFeatureBeansByPersonId(PersonBean bean , FeatureBean[] importedBeans)
    {
        if(null != importedBeans){
            for( FeatureBean importBean : importedBeans ){
                FeatureManager.getInstance().setReferencedByPersonId(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.4 SET IMPORTED override IPersonManager
    @Override 
    public <C extends java.util.Collection<FeatureBean>> C setFlFeatureBeansByPersonId(PersonBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( FeatureBean importBean : importedBeans ){
                FeatureManager.getInstance().setReferencedByPersonId(importBean , bean);
            }
        }
        return importedBeans;
    }
    //3.1 GET IMPORTED override IPersonManager
    @Override 
    public LogBean[] getFlLogBeansByPersonId(PersonBean bean)
    {
        return this.getFlLogBeansByPersonIdAsList(bean).toArray(new LogBean[0]);
    }
    //3.1.2 GET IMPORTED override IPersonManager
    @Override
    public LogBean[] getFlLogBeansByPersonId(Integer personId)
    {
        PersonBean bean = new PersonBean();
        bean.setId(personId);
        return getFlLogBeansByPersonId(bean);
    }
    //3.2 GET IMPORTED override IPersonManager
    @Override 
    public java.util.List<LogBean> getFlLogBeansByPersonIdAsList(PersonBean bean)
    {
        try {
            return this.dbConverter.getLogBeanConverter().fromRight(nativeManager.getFlLogBeansByPersonIdAsList( this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    //3.2.2 GET IMPORTED override IPersonManager
    @Override
    public java.util.List<LogBean> getFlLogBeansByPersonIdAsList(Integer personId)
    {
         PersonBean bean = new PersonBean();
        bean.setId(personId);
        return getFlLogBeansByPersonIdAsList(bean);
    }
    //3.3 SET IMPORTED override IPersonManager
    @Override 
    public LogBean[] setFlLogBeansByPersonId(PersonBean bean , LogBean[] importedBeans)
    {
        if(null != importedBeans){
            for( LogBean importBean : importedBeans ){
                LogManager.getInstance().setReferencedByPersonId(importBean , bean);
            }
        }
        return importedBeans;
    }

    //3.4 SET IMPORTED override IPersonManager
    @Override 
    public <C extends java.util.Collection<LogBean>> C setFlLogBeansByPersonId(PersonBean bean , C importedBeans)
    {
        if(null != importedBeans){
            for( LogBean importBean : importedBeans ){
                LogManager.getInstance().setReferencedByPersonId(importBean , bean);
            }
        }
        return importedBeans;
    }


    //3.5 SYNC SAVE override IPersonManager
    @Override  
    public PersonBean save(PersonBean bean
        , ImageBean refFlImagebyImageMd5 
        , FeatureBean[] impFlFeaturebyPersonId , LogBean[] impFlLogbyPersonId )
    {
        try{
            FlPersonBean nativeBean = this.beanConverter.toRight(bean);
            net.gdface.facelog.dborm.image.FlImageBean native_refFlImagebyImageMd5 = this.dbConverter.getImageBeanConverter().toRight(refFlImagebyImageMd5);
            net.gdface.facelog.dborm.face.FlFeatureBean[] native_impFlFeaturebyPersonId = this.dbConverter.getFeatureBeanConverter().toRight(impFlFeaturebyPersonId);
net.gdface.facelog.dborm.log.FlLogBean[] native_impFlLogbyPersonId = this.dbConverter.getLogBeanConverter().toRight(impFlLogbyPersonId);
            nativeManager.save(nativeBean
                , native_refFlImagebyImageMd5 
                , native_impFlFeaturebyPersonId  , native_impFlLogbyPersonId  );
            if(null != bean)
                this.beanConverter.fromRight(bean,nativeBean);
            if(null != refFlImagebyImageMd5) this.dbConverter.getImageBeanConverter().fromRight(refFlImagebyImageMd5,native_refFlImagebyImageMd5);
            if(null != impFlFeaturebyPersonId) this.dbConverter.getFeatureBeanConverter().fromRight(impFlFeaturebyPersonId,native_impFlFeaturebyPersonId);
if(null != impFlLogbyPersonId) this.dbConverter.getLogBeanConverter().fromRight(impFlLogbyPersonId,native_impFlLogbyPersonId);
            return bean;
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    } 

    //3.6 SYNC SAVE AS TRANSACTION override IPersonManager
    @Override 
    public PersonBean saveAsTransaction(final PersonBean bean
        ,final ImageBean refFlImagebyImageMd5 
        ,final FeatureBean[] impFlFeaturebyPersonId ,final LogBean[] impFlLogbyPersonId )
    {
        return this.runAsTransaction(new Callable<PersonBean>(){
            @Override
            public PersonBean call() throws Exception {
                return save(bean , refFlImagebyImageMd5 , impFlFeaturebyPersonId , impFlLogbyPersonId );
            }});
    }
    //3.7 SYNC SAVE override IPersonManager
    @Override 
    public PersonBean save(PersonBean bean
        , ImageBean refFlImagebyImageMd5 
        , java.util.Collection<FeatureBean> impFlFeaturebyPersonId , java.util.Collection<LogBean> impFlLogbyPersonId )
    {
        try{
                    
            return this.beanConverter.fromRight(bean,nativeManager.save(this.beanConverter.toRight(bean)
                , this.dbConverter.getImageBeanConverter().toRight(refFlImagebyImageMd5)                 , this.dbConverter.getFeatureBeanConverter().toRight(impFlFeaturebyPersonId)  , this.dbConverter.getLogBeanConverter().toRight(impFlLogbyPersonId)  ));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }   

    //3.8 SYNC SAVE AS TRANSACTION override IPersonManager
    @Override 
    public PersonBean saveAsTransaction(final PersonBean bean
        ,final ImageBean refFlImagebyImageMd5 
        ,final  java.util.Collection<FeatureBean> impFlFeaturebyPersonId ,final  java.util.Collection<LogBean> impFlLogbyPersonId )
    {
        return this.runAsTransaction(new Callable<PersonBean>(){
            @Override
            public PersonBean call() throws Exception {
                return save(bean , refFlImagebyImageMd5 , impFlFeaturebyPersonId , impFlLogbyPersonId );
            }});
    }
     /**
     * Save the {@link PersonBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(PersonBean , ImageBean , FeatureBean[] , LogBean[] )}
     * @return the inserted or updated {@link PersonBean} bean
     */
    //3.9 SYNC SAVE 
    @Override
    public PersonBean save(PersonBean bean,Object ...args) 
    {
        if(args.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        if( args.length > 0 && null != args[0] && !(args[0] instanceof ImageBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:ImageBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof FeatureBean[])){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:FeatureBean[]");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof LogBean[])){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:LogBean[]");
        }
        return save(bean,(args.length < 1 || null == args[0])?null:(ImageBean)args[0],(args.length < 2 || null == args[1])?null:(FeatureBean[])args[1],(args.length < 3 || null == args[2])?null:(LogBean[])args[2]);
    } 

    /**
     * Save the {@link PersonBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PersonBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(PersonBean , ImageBean , java.util.Collection , java.util.Collection )}
     * @return the inserted or updated {@link PersonBean} bean
     */
    //3.10 SYNC SAVE 
    @SuppressWarnings("unchecked")
    @Override
    public PersonBean saveCollection(PersonBean bean,Object ...inputs)
    {
        if(inputs.length > 3)
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 3");
        Object[] args = new Object[3];
        System.arraycopy(inputs,0,args,0,3);
        if( args.length > 0 && null != args[0] && !(args[0] instanceof ImageBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:ImageBean");
        }
        if( args.length > 1 && null != args[1] && !(args[1] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:java.util.Collection<FeatureBean>");
        }
        if( args.length > 2 && null != args[2] && !(args[2] instanceof java.util.Collection)){
            throw new IllegalArgumentException("invalid type for the No.3 argument,expected type:java.util.Collection<LogBean>");
        }
        return save(bean,null == args[0]?null:(ImageBean)args[0],null == args[1]?null:(java.util.Collection<FeatureBean>)args[1],null == args[2]?null:(java.util.Collection<LogBean>)args[2]);
    }

     //////////////////////////////////////
    // FOREIGN KEY GENERIC METHOD
    //////////////////////////////////////

    /**
     * Retrieves the bean object referenced by fkIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_PERSON_FK_IMAGE_MD5} -> {@link ImageBean}</li>
     * </ul>
     * @param bean the {@link PersonBean} object to use
     * @param fkIndex valid values: <br>
     *        {@link Constant#FL_PERSON_FK_IMAGE_MD5}
     * @return the associated <T> bean or {@code null} if {@code bean} or {@code beanToSet} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T getReferencedBean(PersonBean bean,int fkIndex){
        switch(fkIndex){
        case FL_PERSON_FK_IMAGE_MD5:
            return  (T)this.getReferencedByImageMd5(bean);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    /**
     * Associates the {@link PersonBean} object to the bean object by fkIndex field.<br>
     * 
     * @param <T> see also {@link #getReferencedBean(PersonBean,int)}
     * @param bean the {@link PersonBean} object to use
     * @param beanToSet the <T> object to associate to the {@link PersonBean}
     * @param fkIndex valid values: see also {@link #getReferencedBean(PersonBean,int)}
     * @return always beanToSet saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<?>> T setReferencedBean(PersonBean bean,T beanToSet,int fkIndex){
        switch(fkIndex){
        case FL_PERSON_FK_IMAGE_MD5:
            return  (T)this.setReferencedByImageMd5(bean, (ImageBean)beanToSet);
        }
        throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////


    //5.1 GET REFERENCED VALUE override IPersonManager
    @Override 
    public ImageBean getReferencedByImageMd5(PersonBean bean)
    {
        try{
            return this.dbConverter.getImageBeanConverter().fromRight(this.nativeManager.getReferencedByImageMd5(this.beanConverter.toRight(bean)));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
        
    }

    //5.2 SET REFERENCED override IPersonManager
    @Override 
    public ImageBean setReferencedByImageMd5(PersonBean bean, ImageBean beanToSet)
    {
        try{
            FlPersonBean nativeBean = this.beanConverter.toRight(bean);
            net.gdface.facelog.dborm.image.FlImageBean foreignNativeBean = this.dbConverter.getImageBeanConverter().toRight(beanToSet);
            this.nativeManager.setReferencedByImageMd5(nativeBean,foreignNativeBean);
            if(null != bean)
                this.beanConverter.fromRight(bean, nativeBean);
            if(null != beanToSet)
                this.dbConverter.getImageBeanConverter().fromRight(beanToSet,foreignNativeBean);
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
    protected PersonBean insert(PersonBean bean)
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
    protected PersonBean update(PersonBean bean)
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
    public PersonBean loadUniqueUsingTemplate(PersonBean bean)
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
    public int loadUsingTemplate(PersonBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PersonBean> action)
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
    public int deleteUsingTemplate(PersonBean bean)
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

    // override IPersonManager
    @Override 
    public PersonBean loadByIndexImageMd5(String imageMd5)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexImageMd5(imageMd5));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }


    // override IPersonManager
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
    
    // override IPersonManager
    @Override 
    public PersonBean loadByIndexPapersNum(String papersNum)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexPapersNum(papersNum));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }


    // override IPersonManager
    @Override 
    public int deleteByIndexPapersNum(String papersNum)
    {
        try{
            return this.nativeManager.deleteByIndexPapersNum(papersNum);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
     // override IPersonManager
    @Override 
    public PersonBean[] loadByIndexExpiryDate(java.util.Date expiryDate)
    {
        return this.loadByIndexExpiryDateAsList(expiryDate).toArray(new PersonBean[0]);
    }
    
    // override IPersonManager
    @Override 
    public java.util.List<PersonBean> loadByIndexExpiryDateAsList(java.util.Date expiryDate)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexExpiryDateAsList(expiryDate));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override IPersonManager
    @Override 
    public int deleteByIndexExpiryDate(java.util.Date expiryDate)
    {
        try{
            return this.nativeManager.deleteByIndexExpiryDate(expiryDate);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
     // override IPersonManager
    @Override 
    public PersonBean[] loadByIndexGroupId(Integer groupId)
    {
        return this.loadByIndexGroupIdAsList(groupId).toArray(new PersonBean[0]);
    }
    
    // override IPersonManager
    @Override 
    public java.util.List<PersonBean> loadByIndexGroupIdAsList(Integer groupId)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadByIndexGroupIdAsList(groupId));
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }

    // override IPersonManager
    @Override 
    public int deleteByIndexGroupId(Integer groupId)
    {
        try{
            return this.nativeManager.deleteByIndexGroupId(groupId);
        }
        catch(DAOException e)
        {
            throw new WrapDAOException(e);
        }
    }
    
    
    /**
     * Retrieves a list of PersonBean using the index specified by keyIndex.
     * @param keyIndex valid values: <br>
     *        {@link Constant#FL_PERSON_INDEX_IMAGE_MD5},{@link Constant#FL_PERSON_INDEX_PAPERS_NUM},{@link Constant#FL_PERSON_INDEX_EXPIRY_DATE},{@link Constant#FL_PERSON_INDEX_GROUP_ID}
     * @param keys key values of index
     * @return a list of PersonBean
     */
    @Override
    public java.util.List<PersonBean> loadByIndexAsList(int keyIndex,Object ...keys)
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
     *        {@link Constant#FL_PERSON_INDEX_IMAGE_MD5},{@link Constant#FL_PERSON_INDEX_PAPERS_NUM},{@link Constant#FL_PERSON_INDEX_EXPIRY_DATE},{@link Constant#FL_PERSON_INDEX_GROUP_ID}
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
    public int countUsingTemplate(PersonBean bean, int searchType)
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
    public void registerListener(TableListener<PersonBean> listener)
    {
        this.nativeManager.registerListener(this.toNative(listener));
    }

    //36
    @Override
    public void unregisterListener(TableListener<PersonBean> listener)
    {
        this.nativeManager.unregisterListener(this.toNative(listener));
    }
    
    private net.gdface.facelog.dborm.TableListener<FlPersonBean> toNative(final TableListener<PersonBean> listener) {
        return null == listener ?null:new net.gdface.facelog.dborm.TableListener<FlPersonBean> (){

            @Override
            public void beforeInsert(FlPersonBean bean) throws DAOException {
                listener.beforeInsert(PersonManager.this.beanConverter.fromRight(bean));                
            }

            @Override
            public void afterInsert(FlPersonBean bean) throws DAOException {
                listener.afterInsert(PersonManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void beforeUpdate(FlPersonBean bean) throws DAOException {
                listener.beforeUpdate(PersonManager.this.beanConverter.fromRight(bean));
                
            }

            @Override
            public void afterUpdate(FlPersonBean bean) throws DAOException {
                listener.afterUpdate(PersonManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void beforeDelete(FlPersonBean bean) throws DAOException {
                listener.beforeDelete(PersonManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public void afterDelete(FlPersonBean bean) throws DAOException {
                listener.afterDelete(PersonManager.this.beanConverter.fromRight(bean));
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<PersonBean> action){
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
    
    private net.gdface.facelog.dborm.TableManager.Action<FlPersonBean> toNative(final Action<PersonBean> action){
        if(null == action)
            throw new NullPointerException();
        return new net.gdface.facelog.dborm.TableManager.Action<FlPersonBean>(){

            @Override
            public void call(FlPersonBean bean) {
                action.call(PersonManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public FlPersonBean getBean() {
                return  PersonManager.this.beanConverter.toRight(action.getBean());
            }};
    }
}
