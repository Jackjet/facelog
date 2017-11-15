// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: manager.java.vm
// ______________________________________________________
package net.gdface.facelog.db.mysql;

import java.util.concurrent.Callable;

import net.gdface.facelog.db.Constant;
import net.gdface.facelog.db.PermitBean;
import net.gdface.facelog.db.IBeanConverter;
import net.gdface.facelog.db.IDbConverter;
import net.gdface.facelog.db.TableManager;
import net.gdface.facelog.db.IPermitManager;
import net.gdface.facelog.db.DeviceGroupBean;
import net.gdface.facelog.db.PersonGroupBean;
import net.gdface.facelog.db.TableListener;
import net.gdface.facelog.db.exception.RuntimeDaoException;
import net.gdface.facelog.db.exception.ObjectRetrievalException;

import net.gdface.facelog.dborm.exception.DaoException;

/**
 * Handles database calls (save, load, count, etc...) for the fl_permit table.<br>
 * all {@link DaoException} be wrapped as {@link RuntimeDaoException} to throw.<br>
 * Remarks: 通行权限关联表<br>
 * @author guyadong
 */
public class PermitManager extends TableManager.BaseAdapter<PermitBean> implements IPermitManager
{
    private net.gdface.facelog.dborm.permit.FlPermitManager nativeManager = net.gdface.facelog.dborm.permit.FlPermitManager.getInstance();
    private IDbConverter<
                        net.gdface.facelog.dborm.device.FlDeviceBean,
                        net.gdface.facelog.dborm.device.FlDeviceGroupBean,
                        net.gdface.facelog.dborm.face.FlFaceBean,
                        net.gdface.facelog.dborm.face.FlFeatureBean,
                        net.gdface.facelog.dborm.image.FlImageBean,
                        net.gdface.facelog.dborm.log.FlLogBean,
                        net.gdface.facelog.dborm.permit.FlPermitBean,
                        net.gdface.facelog.dborm.person.FlPersonBean,
                        net.gdface.facelog.dborm.person.FlPersonGroupBean,
                        net.gdface.facelog.dborm.image.FlStoreBean,
                        net.gdface.facelog.dborm.log.FlLogLightBean> dbConverter = DbConverter.INSTANCE;
    private IBeanConverter<PermitBean,net.gdface.facelog.dborm.permit.FlPermitBean> beanConverter = dbConverter.getPermitBeanConverter();
    private static PermitManager singleton = new PermitManager();
    protected PermitManager(){}
    
    protected DeviceGroupManager instanceOfDeviceGroupManager(){
        return DeviceGroupManager.getInstance();
    }
    protected PersonGroupManager instanceOfPersonGroupManager(){
        return PersonGroupManager.getInstance();
    }

    @Override
    public String getTableName() {
        return this.nativeManager.getTableName();
    }

    @Override
    public String getFields() {
        return this.nativeManager.getFields();
    }

    @Override
    public String getFullFields() {
        return this.nativeManager.getFullFields();
    }
    
    @Override
    public String[] getPrimarykeyNames() {
        return this.nativeManager.getPrimarykeyNames();
    }
    
    /**
     * Get the {@link PermitManager} singleton.
     *
     * @return {@link PermitManager}
     */
    public static PermitManager getInstance()
    {
        return singleton;
    }
   
    @Override
    protected Class<PermitBean> beanType(){
        return PermitBean.class;
    }
    
    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    //1 override IPermitManager

    @Override 
    public PermitBean loadByPrimaryKey(Integer deviceGroupId,Integer personGroupId)
    {
        try{
            return loadByPrimaryKeyChecked(deviceGroupId,personGroupId);
        }catch(ObjectRetrievalException e){
            // not found
            return null;
        }
    }
    //1.1 override IPermitManager

    @Override
    public PermitBean loadByPrimaryKeyChecked(Integer deviceGroupId,Integer personGroupId) throws ObjectRetrievalException
    {
        try{
            return this.beanConverter.fromRight(nativeManager.loadByPrimaryKeyChecked(deviceGroupId,personGroupId));
        }catch(net.gdface.facelog.dborm.exception.ObjectRetrievalException e){
            throw new ObjectRetrievalException();
        }catch(DaoException e){
            throw new RuntimeDaoException(e);
        }
    }
    //1.2

    @Override
    public PermitBean loadByPrimaryKey(PermitBean bean)
    {
        return bean==null?null:loadByPrimaryKey(bean.getDeviceGroupId(),bean.getPersonGroupId());
    }

    //1.2.2

    @Override
    public PermitBean loadByPrimaryKeyChecked(PermitBean bean) throws ObjectRetrievalException
    {
        if(null == bean){
            throw new NullPointerException();
        }
        return loadByPrimaryKeyChecked(bean.getDeviceGroupId(),bean.getPersonGroupId());
    }
    
    //1.3

    @Override
    public PermitBean loadByPrimaryKey(Object ...keys){
        try{
            return loadByPrimaryKeyChecked(keys);
        }catch(ObjectRetrievalException e){
            // not found
            return null;
        }
    }
    
    //1.3.2

    @Override
    public PermitBean loadByPrimaryKeyChecked(Object ...keys) throws ObjectRetrievalException{
        if(null == keys){
            throw new NullPointerException();
        }
        if(keys.length != FL_PERMIT_PK_COUNT){
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        }
        
        if(! (keys[0] instanceof Integer)){
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        }
        if(! (keys[1] instanceof Integer)){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:Integer");
        }
        return loadByPrimaryKeyChecked((Integer)keys[0],(Integer)keys[1]);
    }

    //1.4 override IPermitManager

    @Override 
    public boolean existsPrimaryKey(Integer deviceGroupId,Integer personGroupId)
    {
        try{
            return nativeManager.existsPrimaryKey(deviceGroupId,personGroupId);
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }
    //1.6

    @Override
    public boolean existsByPrimaryKey(PermitBean bean)
    {
        return null == bean ? false : existsPrimaryKey(bean.getDeviceGroupId(),bean.getPersonGroupId());
    }
    //1.7

    @Override
    public PermitBean checkDuplicate(PermitBean bean)throws ObjectRetrievalException{
        try{
            nativeManager.checkDuplicate(this.beanConverter.toRight(bean));            
        }catch(DaoException e){
            throw new RuntimeDaoException(e);
        }
        return bean;   
    }
    //2 override IPermitManager

    @Override 
    public int deleteByPrimaryKey(Integer deviceGroupId,Integer personGroupId)
    {
        try
        {
            return nativeManager.deleteByPrimaryKey(deviceGroupId,personGroupId);
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }
    //2

    @Override
    public int delete(PermitBean bean){
        try
        {
            return nativeManager.delete(this.beanConverter.toRight(bean));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }   
    }
    //2.1

    @Override
    public int deleteByPrimaryKey(Object ...keys){
        if(null == keys){
            throw new NullPointerException();
        }
        if(keys.length != FL_PERMIT_PK_COUNT){
            throw new IllegalArgumentException("argument number mismatch with primary key number");
        }
        if(! (keys[0] instanceof Integer)){
            throw new IllegalArgumentException("invalid type for the No.1 argument,expected type:Integer");
        }
        if(! (keys[1] instanceof Integer)){
            throw new IllegalArgumentException("invalid type for the No.2 argument,expected type:Integer");
        }
        return deleteByPrimaryKey((Integer)keys[0],(Integer)keys[1]);
    }
    //2.4 override IPermitManager

    @Override 
    public int delete(PermitBean... beans){
        int count = 0;
        if(null != beans){
            for(PermitBean bean :beans){
                count += delete(bean);
            }
        }
        return count;
    }
    //2.5 override IPermitManager

    @Override 
    public int delete(java.util.Collection<PermitBean> beans){
        int count = 0;
        if(null != beans){
            for(PermitBean bean :beans){
                count += delete(bean);
            }
        }
        return count;
    }
 
 


    //3.5 SYNC SAVE override IPermitManager

    @Override  
    public PermitBean save(PermitBean bean
        , DeviceGroupBean refDevicegroupByDeviceGroupId , PersonGroupBean refPersongroupByPersonGroupId 
        )
    {
        if(null == bean){
            return null;
        }
        if(null != refDevicegroupByDeviceGroupId){
            this.setReferencedByDeviceGroupId(bean,refDevicegroupByDeviceGroupId);
        }
        if(null != refPersongroupByPersonGroupId){
            this.setReferencedByPersonGroupId(bean,refPersongroupByPersonGroupId);
        }
        bean = this.save( bean );
        return bean;
    } 

    //3.6 SYNC SAVE AS TRANSACTION override IPermitManager

    @Override 
    public PermitBean saveAsTransaction(final PermitBean bean
        ,final DeviceGroupBean refDevicegroupByDeviceGroupId ,final PersonGroupBean refPersongroupByPersonGroupId 
        )
    {
        return this.runAsTransaction(new Callable<PermitBean>(){
            @Override
            public PermitBean call() throws Exception {
                return save(bean , refDevicegroupByDeviceGroupId , refPersongroupByPersonGroupId );
            }});
    }
 
    private static final int SYNC_SAVE_ARG_LEN = 2;
    private static final int SYNC_SAVE_ARG_0 = 0;
    private static final int SYNC_SAVE_ARG_1 = 1;
    //3.9 SYNC SAVE 
    /**
     * Save the {@link PermitBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PermitBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(PermitBean , DeviceGroupBean , PersonGroupBean )}
     * @return the inserted or updated {@link PermitBean} bean
     */
    @Override
    public PermitBean save(PermitBean bean,Object ...inputs) 
    {
        if(null == inputs){
            return save(bean);
        }
        if(inputs.length > SYNC_SAVE_ARG_LEN){
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 2");
        }
        Object[] args = new Object[SYNC_SAVE_ARG_LEN];
        System.arraycopy(inputs, 0, args, 0, inputs.length);
        if( null != args[SYNC_SAVE_ARG_0] && !(args[SYNC_SAVE_ARG_0] instanceof DeviceGroupBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceGroupBean");
        }
        if( null != args[SYNC_SAVE_ARG_1] && !(args[SYNC_SAVE_ARG_1] instanceof PersonGroupBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:PersonGroupBean");
        }
        return save(bean,
                    (DeviceGroupBean)args[SYNC_SAVE_ARG_0],
                    (PersonGroupBean)args[SYNC_SAVE_ARG_1]);
    } 

    //3.10 SYNC SAVE 
    /**
     * Save the {@link PermitBean} bean and referenced beans and imported beans into the database.
     *
     * @param bean the {@link PermitBean} bean to be saved
     * @param args referenced beans or imported beans<br>
     *      see also {@link #save(PermitBean , DeviceGroupBean , PersonGroupBean )}
     * @return the inserted or updated {@link PermitBean} bean
     */
    @SuppressWarnings("unchecked")
    @Override
    public PermitBean saveCollection(PermitBean bean,Object ...inputs)
    {
        if(null == inputs){
            return save(bean);
        }
        if(inputs.length > SYNC_SAVE_ARG_LEN){
            throw new IllegalArgumentException("too many dynamic arguments,max dynamic arguments number: 2");
        }
        Object[] args = new Object[SYNC_SAVE_ARG_LEN];
        System.arraycopy(inputs, 0, args, 0, inputs.length);
        if( null != args[SYNC_SAVE_ARG_0] && !(args[SYNC_SAVE_ARG_0] instanceof DeviceGroupBean)){
            throw new IllegalArgumentException("invalid type for the No.1 dynamic argument,expected type:DeviceGroupBean");
        }
        if( null != args[SYNC_SAVE_ARG_1] && !(args[SYNC_SAVE_ARG_1] instanceof PersonGroupBean)){
            throw new IllegalArgumentException("invalid type for the No.2 dynamic argument,expected type:PersonGroupBean");
        }
        return save(bean,
                    (DeviceGroupBean)args[SYNC_SAVE_ARG_0],
                    (PersonGroupBean)args[SYNC_SAVE_ARG_1]);
    }

     //////////////////////////////////////
    // FOREIGN KEY GENERIC METHOD
    //////////////////////////////////////

    /**
     * Retrieves the bean object referenced by fkIndex.<br>
     * @param <T>
     * <ul>
     *     <li> {@link Constant#FL_PERMIT_FK_DEVICE_GROUP_ID} -> {@link DeviceGroupBean}</li>
     *     <li> {@link Constant#FL_PERMIT_FK_PERSON_GROUP_ID} -> {@link PersonGroupBean}</li>
     * </ul>
     * @param bean the {@link PermitBean} object to use
     * @param fkIndex valid values: <br>
     *        {@link Constant#FL_PERMIT_FK_DEVICE_GROUP_ID},{@link Constant#FL_PERMIT_FK_PERSON_GROUP_ID}
     * @return the associated <T> bean or {@code null} if {@code bean} or {@code beanToSet} is {@code null}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<T>> T getReferencedBean(PermitBean bean,int fkIndex){
        switch(fkIndex){
        case FL_PERMIT_FK_DEVICE_GROUP_ID:
            return  (T)this.getReferencedByDeviceGroupId(bean);
        case FL_PERMIT_FK_PERSON_GROUP_ID:
            return  (T)this.getReferencedByPersonGroupId(bean);
        default:
            throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
        }
    }
    /**
     * Associates the {@link PermitBean} object to the bean object by fkIndex field.<br>
     * 
     * @param <T> see also {@link #getReferencedBean(PermitBean,int)}
     * @param bean the {@link PermitBean} object to use
     * @param beanToSet the <T> object to associate to the {@link PermitBean}
     * @param fkIndex valid values: see also {@link #getReferencedBean(PermitBean,int)}
     * @return always beanToSet saved
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T extends net.gdface.facelog.db.BaseBean<T>> T setReferencedBean(PermitBean bean,T beanToSet,int fkIndex){
        switch(fkIndex){
        case FL_PERMIT_FK_DEVICE_GROUP_ID:
            return  (T)this.setReferencedByDeviceGroupId(bean, (DeviceGroupBean)beanToSet);
        case FL_PERMIT_FK_PERSON_GROUP_ID:
            return  (T)this.setReferencedByPersonGroupId(bean, (PersonGroupBean)beanToSet);
        default:
            throw new IllegalArgumentException(String.format("invalid fkIndex %d", fkIndex));
        }
    }
    
    //////////////////////////////////////
    // GET/SET FOREIGN KEY BEAN METHOD
    //////////////////////////////////////


    //5.1 GET REFERENCED VALUE override IPermitManager

    @Override 
    public DeviceGroupBean getReferencedByDeviceGroupId(PermitBean bean)
    {
        if(null == bean){
            return null;
        }
        bean.setReferencedByDeviceGroupId(instanceOfDeviceGroupManager().loadByPrimaryKey(bean.getDeviceGroupId())); 
        return bean.getReferencedByDeviceGroupId();
    }

    //5.2 SET REFERENCED override IPermitManager

    @Override 
    public DeviceGroupBean setReferencedByDeviceGroupId(PermitBean bean, DeviceGroupBean beanToSet)
    {
        try{
            net.gdface.facelog.dborm.permit.FlPermitBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<DeviceGroupBean,net.gdface.facelog.dborm.device.FlDeviceGroupBean> foreignConverter = this.dbConverter.getDeviceGroupBeanConverter();
            net.gdface.facelog.dborm.device.FlDeviceGroupBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByDeviceGroupId(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //5.1 GET REFERENCED VALUE override IPermitManager

    @Override 
    public PersonGroupBean getReferencedByPersonGroupId(PermitBean bean)
    {
        if(null == bean){
            return null;
        }
        bean.setReferencedByPersonGroupId(instanceOfPersonGroupManager().loadByPrimaryKey(bean.getPersonGroupId())); 
        return bean.getReferencedByPersonGroupId();
    }

    //5.2 SET REFERENCED override IPermitManager

    @Override 
    public PersonGroupBean setReferencedByPersonGroupId(PermitBean bean, PersonGroupBean beanToSet)
    {
        try{
            net.gdface.facelog.dborm.permit.FlPermitBean nativeBean = this.beanConverter.toRight(bean);
            IBeanConverter<PersonGroupBean,net.gdface.facelog.dborm.person.FlPersonGroupBean> foreignConverter = this.dbConverter.getPersonGroupBeanConverter();
            net.gdface.facelog.dborm.person.FlPersonGroupBean foreignNativeBean = foreignConverter.toRight(beanToSet);
            this.nativeManager.setReferencedByPersonGroupId(nativeBean,foreignNativeBean);
            this.beanConverter.fromRight(bean, nativeBean);
            foreignConverter.fromRight(beanToSet,foreignNativeBean);
            return beanToSet;
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
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
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //_____________________________________________________________________
    //
    // SAVE
    //_____________________________________________________________________

    //13

    @Override
    protected PermitBean insert(PermitBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.insert(this.beanConverter.toRight(bean)));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //14
    @Override

    protected PermitBean update(PermitBean bean)
    {
        try{
            return this.beanConverter.fromRight(bean,this.nativeManager.update(this.beanConverter.toRight(bean)));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //_____________________________________________________________________
    //
    // USING TEMPLATE
    //_____________________________________________________________________
    //18
    @Override

    public PermitBean loadUniqueUsingTemplate(PermitBean bean)
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplate(this.beanConverter.toRight(bean)));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
     }
    //18-1
    @Override

    public PermitBean loadUniqueUsingTemplateChecked(PermitBean bean) throws ObjectRetrievalException
    {
        try{
            return this.beanConverter.fromRight(this.nativeManager.loadUniqueUsingTemplateChecked(this.beanConverter.toRight(bean)));
        }
        catch(net.gdface.facelog.dborm.exception.ObjectRetrievalException e)
        {
            throw new ObjectRetrievalException();
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
     }
    //20-5

    @Override
    public int loadUsingTemplate(PermitBean bean, int[] fieldList, int startRow, int numRows,int searchType, Action<PermitBean> action)
    {
        try {
            return this.nativeManager.loadUsingTemplate(this.beanConverter.toRight(bean),fieldList,startRow,numRows,searchType,this.toNative(action));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //21

    @Override
    public int deleteUsingTemplate(PermitBean bean)
    {
        try{
            return this.nativeManager.deleteUsingTemplate(this.beanConverter.toRight(bean));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
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
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }

    //20

    @Override
    public int countUsingTemplate(PermitBean bean, int searchType)
    {
        try{
            return this.nativeManager.countUsingTemplate(this.beanConverter.toRight(bean),searchType);
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }


    //_____________________________________________________________________
    //
    // LISTENER
    //_____________________________________________________________________

    //35
    /**
     * @return {@link WrapListener} instance
     */
    @Override
    public TableListener<PermitBean> registerListener(TableListener<PermitBean> listener)
    {
        WrapListener wrapListener;
        if(listener instanceof WrapListener){
            wrapListener = (WrapListener)listener;
            this.nativeManager.registerListener(wrapListener.nativeListener);
        }else{
            wrapListener = new WrapListener(listener);
            this.nativeManager.registerListener(wrapListener.nativeListener);
        }
        return wrapListener;
    }

    //36

    @Override
    public void unregisterListener(TableListener<PermitBean> listener)
    {
        if(!(listener instanceof WrapListener)){
            throw new IllegalArgumentException("invalid listener type: " + WrapListener.class.getName() +" required");
        }
        this.nativeManager.unregisterListener(((WrapListener)listener).nativeListener);
    }
    
    //37

    @Override
    public void fire(TableListener.Event event, PermitBean bean){
        fire(event.ordinal(), bean);
    }
    
    //37-1

    @Override
    public void fire(int event, PermitBean bean){
        try{
            this.nativeManager.fire(event, this.beanConverter.toRight(bean));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }
    //37-2
    /**
     * bind foreign key listener to foreign table for DELETE RULE
     */
    void bindForeignKeyListenerForDeleteRule(){
        this.nativeManager.bindForeignKeyListenerForDeleteRule();
    }
    //37-3
    /**
     * unbind foreign key listener from all of foreign tables <br>
     * @see #bindForeignKeyListenerForDeleteRule()
     */
    void unbindForeignKeyListenerForDeleteRule(){
        this.nativeManager.unbindForeignKeyListenerForDeleteRule();

    }
    /**
     * wrap {@code TableListener<PermitBean>} as native listener
     */
    public class WrapListener implements TableListener<PermitBean>{
        private final TableListener<PermitBean> listener;
        private final net.gdface.facelog.dborm.TableListener<net.gdface.facelog.dborm.permit.FlPermitBean> nativeListener;
        private WrapListener(final TableListener<PermitBean> listener) {
            if(null == listener){
                throw new NullPointerException();
            }
            this.listener = listener;
            this.nativeListener = new net.gdface.facelog.dborm.TableListener<net.gdface.facelog.dborm.permit.FlPermitBean> (){

                @Override
                public void beforeInsert(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.beforeInsert(PermitManager.this.beanConverter.fromRight(bean));                
                }

                @Override
                public void afterInsert(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.afterInsert(PermitManager.this.beanConverter.fromRight(bean));
                }

                @Override
                public void beforeUpdate(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.beforeUpdate(PermitManager.this.beanConverter.fromRight(bean));
                }

                @Override
                public void afterUpdate(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.afterUpdate(PermitManager.this.beanConverter.fromRight(bean));
                }

                @Override
                public void beforeDelete(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.beforeDelete(PermitManager.this.beanConverter.fromRight(bean));
                }

                @Override
                public void afterDelete(net.gdface.facelog.dborm.permit.FlPermitBean bean) throws DaoException {
                    listener.afterDelete(PermitManager.this.beanConverter.fromRight(bean));
                }};
        }

        @Override
        public void beforeInsert(PermitBean bean) {
            listener.beforeInsert(bean);
        }

        @Override
        public void afterInsert(PermitBean bean) {
            listener.afterInsert(bean);
        }

        @Override
        public void beforeUpdate(PermitBean bean) {
            listener.beforeUpdate(bean);
        }

        @Override
        public void afterUpdate(PermitBean bean) {
            listener.afterUpdate(bean);
        }

        @Override
        public void beforeDelete(PermitBean bean) {
            listener.beforeDelete(bean);
        }

        @Override
        public void afterDelete(PermitBean bean) {
            listener.afterDelete(bean);
        }        
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
    public int loadBySqlForAction(String sql, Object[] argList, int[] fieldList,int startRow, int numRows,Action<PermitBean> action){
        try{
            return this.nativeManager.loadBySqlForAction(sql,argList,fieldList,startRow,numRows,this.toNative(action));
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }
    
    @Override
    public <T>T runAsTransaction(Callable<T> fun) {
        try{
            return this.nativeManager.runAsTransaction(fun);
        }
        catch(DaoException e)
        {
            throw new RuntimeDaoException(e);
        }
    }
    
    private net.gdface.facelog.dborm.TableManager.Action<net.gdface.facelog.dborm.permit.FlPermitBean> toNative(final Action<PermitBean> action){
        if(null == action){
            throw new NullPointerException();
        }
        return new net.gdface.facelog.dborm.TableManager.Action<net.gdface.facelog.dborm.permit.FlPermitBean>(){

            @Override
            public void call(net.gdface.facelog.dborm.permit.FlPermitBean bean) {
                action.call(PermitManager.this.beanConverter.fromRight(bean));
            }

            @Override
            public net.gdface.facelog.dborm.permit.FlPermitBean getBean() {
                return  PermitManager.this.beanConverter.toRight(action.getBean());
            }};
    }
    
}
