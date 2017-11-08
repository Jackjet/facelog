// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: bean.java.vm
// ______________________________________________________
package net.gdface.facelog.dborm.device;
import java.io.Serializable;
import net.gdface.facelog.dborm.Constant;
import net.gdface.facelog.dborm.BaseBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;
/**
 * FlDeviceBean is a mapping of fl_device Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 前端设备基本信息 </li>
 * </ul>
 * @author guyadong
*/
public  class FlDeviceBean
    implements Serializable,BaseBean<FlDeviceBean>,Comparable<FlDeviceBean>,Constant,Cloneable
{
    private static final long serialVersionUID = -1873511050244238973L;
    
    /** comments:设备id */
    private Integer id;

    /** comments:所属设备组id */
    private Integer groupId;

    /** comments:设备名称 */
    private String name;

    /** comments:设备版本号 */
    private String version;

    /** comments:设备序列号 */
    private String serialNo;

    /** comments:6字节MAC地址(HEX) */
    private String mac;

    private java.util.Date createTime;

    private java.util.Date updateTime;

    /** columns modified flag */
    private long modified;
    /** columns initialized flag */
    private long initialized;
    private boolean _isNew;
    /**
     * Determines if the current object is new.
     *
     * @return true if the current object is new, false if the object is not new
     */
    public boolean isNew()
    {
        return _isNew;
    }

    /**
     * Specifies to the object if it has been set as new.
     *
     * @param isNew the boolean value to be assigned to the isNew field
     */
    public void isNew(boolean isNew)
    {
        this._isNew = isNew;
    }
    /**
     * Specifies to the object if it has been set as new.
     *
     * @param isNew the boolean value to be assigned to the isNew field
     */
    public void setNew(boolean isNew)
    {
        this._isNew = isNew;
    }
    /**
     * @return the modified status of columns
     */
    public long getModified(){
        return modified;
    }

    /**
     * @param modified the modified status bit to be assigned to {@link #modified}
     */
    public void setModified(long modified){
        this.modified = modified;
    }
    /**
     * @return the initialized status of columns
     */
    public long getInitialized(){
        return initialized;
    }

    /**
     * @param initialized the initialized status bit to be assigned to {@link #initialized}
     */
    public void setInitialized(long initialized){
        this.initialized = initialized;
    }
    public static final boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
    public static final <T extends Comparable<T>>boolean compare(T a, T b) {
        return a == b || (a != null && 0==a.compareTo(b));
    }
    public FlDeviceBean(){
        super();
        reset();
    }
    /**
     * construct a new instance filled with primary keys
     * @param id PK# 1 
     */
    public FlDeviceBean(Integer id){
        this();
        setId(id);
    }
    /**
     * Getter method for {@link #id}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.id</li>
     * <li> imported key: fl_log.device_id</li>
     * <li> imported key: fl_image.device_id</li>
     * <li>comments: 设备id</li>
     * <li>AUTO_INCREMENT</li>
     * <li>NOT NULL</li>
     * <li>column size: 10</li>
     * <li>JDBC type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of id
     */
    public Integer getId(){
        return id;
    }
    /**
     * Setter method for {@link #id}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to id
     */
    public void setId(Integer newVal)
    {
        if (equal(newVal, id) && checkIdInitialized()) {
            return;
        }
        id = newVal;

        modified |= FL_DEVICE_ID_ID_MASK;
        initialized |= FL_DEVICE_ID_ID_MASK;
    }
    /**
     * Setter method for {@link #id}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to id
     */
    public void setId(int newVal)
    {
        setId(new Integer(newVal));
    }
    /**
     * Determines if the id has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkIdModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_ID_MASK);
    }

    /**
     * Determines if the id has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkIdInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_ID_MASK);
    }
    /**
     * Getter method for {@link #groupId}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.group_id</li>
     * <li> foreign key: fl_device_group.id</li>
     * <li>comments: 所属设备组id</li>
     * <li>default value: '1'</li>
     * <li>column size: 10</li>
     * <li>JDBC type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of groupId
     */
    public Integer getGroupId(){
        return groupId;
    }
    /**
     * Setter method for {@link #groupId}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to groupId
     */
    public void setGroupId(Integer newVal)
    {
        if (equal(newVal, groupId) && checkGroupIdInitialized()) {
            return;
        }
        groupId = newVal;

        modified |= FL_DEVICE_ID_GROUP_ID_MASK;
        initialized |= FL_DEVICE_ID_GROUP_ID_MASK;
    }
    /**
     * Setter method for {@link #groupId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to groupId
     */
    public void setGroupId(int newVal)
    {
        setGroupId(new Integer(newVal));
    }
    /**
     * Determines if the groupId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkGroupIdModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_GROUP_ID_MASK);
    }

    /**
     * Determines if the groupId has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkGroupIdInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_GROUP_ID_MASK);
    }
    /**
     * Getter method for {@link #name}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.name</li>
     * <li>comments: 设备名称</li>
     * <li>column size: 32</li>
     * <li>JDBC type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of name
     */
    public String getName(){
        return name;
    }
    /**
     * Setter method for {@link #name}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to name
     */
    public void setName(String newVal)
    {
        if (equal(newVal, name) && checkNameInitialized()) {
            return;
        }
        name = newVal;

        modified |= FL_DEVICE_ID_NAME_MASK;
        initialized |= FL_DEVICE_ID_NAME_MASK;
    }
    /**
     * Determines if the name has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkNameModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_NAME_MASK);
    }

    /**
     * Determines if the name has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkNameInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_NAME_MASK);
    }
    /**
     * Getter method for {@link #version}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.version</li>
     * <li>comments: 设备版本号</li>
     * <li>column size: 32</li>
     * <li>JDBC type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of version
     */
    public String getVersion(){
        return version;
    }
    /**
     * Setter method for {@link #version}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to version
     */
    public void setVersion(String newVal)
    {
        if (equal(newVal, version) && checkVersionInitialized()) {
            return;
        }
        version = newVal;

        modified |= FL_DEVICE_ID_VERSION_MASK;
        initialized |= FL_DEVICE_ID_VERSION_MASK;
    }
    /**
     * Determines if the version has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkVersionModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_VERSION_MASK);
    }

    /**
     * Determines if the version has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkVersionInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_VERSION_MASK);
    }
    /**
     * Getter method for {@link #serialNo}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.serial_no</li>
     * <li>comments: 设备序列号</li>
     * <li>column size: 32</li>
     * <li>JDBC type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of serialNo
     */
    public String getSerialNo(){
        return serialNo;
    }
    /**
     * Setter method for {@link #serialNo}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to serialNo
     */
    public void setSerialNo(String newVal)
    {
        if (equal(newVal, serialNo) && checkSerialNoInitialized()) {
            return;
        }
        serialNo = newVal;

        modified |= FL_DEVICE_ID_SERIAL_NO_MASK;
        initialized |= FL_DEVICE_ID_SERIAL_NO_MASK;
    }
    /**
     * Determines if the serialNo has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkSerialNoModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_SERIAL_NO_MASK);
    }

    /**
     * Determines if the serialNo has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkSerialNoInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_SERIAL_NO_MASK);
    }
    /**
     * Getter method for {@link #mac}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.mac</li>
     * <li>comments: 6字节MAC地址(HEX)</li>
     * <li>column size: 12</li>
     * <li>JDBC type returned by the driver: Types.CHAR</li>
     * </ul>
     *
     * @return the value of mac
     */
    public String getMac(){
        return mac;
    }
    /**
     * Setter method for {@link #mac}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to mac
     */
    public void setMac(String newVal)
    {
        if (equal(newVal, mac) && checkMacInitialized()) {
            return;
        }
        mac = newVal;

        modified |= FL_DEVICE_ID_MAC_MASK;
        initialized |= FL_DEVICE_ID_MAC_MASK;
    }
    /**
     * Determines if the mac has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkMacModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_MAC_MASK);
    }

    /**
     * Determines if the mac has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkMacInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_MAC_MASK);
    }
    /**
     * Getter method for {@link #createTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.create_time</li>
     * <li>default value: 'CURRENT_TIMESTAMP'</li>
     * <li>NOT NULL</li>
     * <li>column size: 19</li>
     * <li>JDBC type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of createTime
     */
    public java.util.Date getCreateTime(){
        return createTime;
    }
    /**
     * Setter method for {@link #createTime}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to createTime
     */
    public void setCreateTime(java.util.Date newVal)
    {
        if (equal(newVal, createTime) && checkCreateTimeInitialized()) {
            return;
        }
        createTime = newVal;

        modified |= FL_DEVICE_ID_CREATE_TIME_MASK;
        initialized |= FL_DEVICE_ID_CREATE_TIME_MASK;
    }
    /**
     * Setter method for {@link #createTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to createTime
     */
    public void setCreateTime(long newVal)
    {
        setCreateTime(new java.util.Date(newVal));
    }
    /**
     * Determines if the createTime has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkCreateTimeModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_CREATE_TIME_MASK);
    }

    /**
     * Determines if the createTime has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkCreateTimeInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_CREATE_TIME_MASK);
    }
    /**
     * Getter method for {@link #updateTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.update_time</li>
     * <li>default value: 'CURRENT_TIMESTAMP'</li>
     * <li>NOT NULL</li>
     * <li>column size: 19</li>
     * <li>JDBC type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of updateTime
     */
    public java.util.Date getUpdateTime(){
        return updateTime;
    }
    /**
     * Setter method for {@link #updateTime}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to updateTime
     */
    public void setUpdateTime(java.util.Date newVal)
    {
        if (equal(newVal, updateTime) && checkUpdateTimeInitialized()) {
            return;
        }
        updateTime = newVal;

        modified |= FL_DEVICE_ID_UPDATE_TIME_MASK;
        initialized |= FL_DEVICE_ID_UPDATE_TIME_MASK;
    }
    /**
     * Setter method for {@link #updateTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to updateTime
     */
    public void setUpdateTime(long newVal)
    {
        setUpdateTime(new java.util.Date(newVal));
    }
    /**
     * Determines if the updateTime has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkUpdateTimeModified()
    {
        return 0L !=  (modified & FL_DEVICE_ID_UPDATE_TIME_MASK);
    }

    /**
     * Determines if the updateTime has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkUpdateTimeInitialized()
    {
        return 0L !=  (initialized & FL_DEVICE_ID_UPDATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link FlDeviceGroupBean} by {@link #groupId} . <br>
     * FOREIGN KEY (group_id) REFERENCES fl_device_group(id)
     */
    private FlDeviceGroupBean referencedByGroupId;
    /** Getter method for {@link #referencedByGroupId}. */
    public FlDeviceGroupBean getReferencedByGroupId() {
        return this.referencedByGroupId;
    }
    /** Setter method for {@link #referencedByGroupId}. */
    public void setReferencedByGroupId(FlDeviceGroupBean reference) {
        this.referencedByGroupId = reference;
    }

    /**
     * Determines if the object has been modified since the last time this method was called.
     * <br>
     * We can also determine if this object has ever been modified since its creation.
     *
     * @return true if the object has been modified, false if the object has not been modified
     */
    public boolean isModified()
    {
        return 0 != modified;
    }
  
    /**
     * Determines if the {@code column} has been modified.
     * @param columnID
     * @return true if the field has been modified, false if the field has not been modified
     * @author guyadong
     */
    public boolean isModified(int columnID){
        switch ( columnID ){
        case FL_DEVICE_ID_ID:
            return checkIdModified();
        case FL_DEVICE_ID_GROUP_ID:
            return checkGroupIdModified();
        case FL_DEVICE_ID_NAME:
            return checkNameModified();
        case FL_DEVICE_ID_VERSION:
            return checkVersionModified();
        case FL_DEVICE_ID_SERIAL_NO:
            return checkSerialNoModified();
        case FL_DEVICE_ID_MAC:
            return checkMacModified();
        case FL_DEVICE_ID_CREATE_TIME:
            return checkCreateTimeModified();
        case FL_DEVICE_ID_UPDATE_TIME:
            return checkUpdateTimeModified();
        }
        return false;
    }
    /**
     * Determines if the {@code column} has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     * @param columnID
     * @return true if the field has been initialized, false otherwise
     * @author guyadong
     */
    public boolean isInitialized(int columnID){
        switch(columnID) {
        case FL_DEVICE_ID_ID:
            return checkIdInitialized();
        case FL_DEVICE_ID_GROUP_ID:
            return checkGroupIdInitialized();
        case FL_DEVICE_ID_NAME:
            return checkNameInitialized();
        case FL_DEVICE_ID_VERSION:
            return checkVersionInitialized();
        case FL_DEVICE_ID_SERIAL_NO:
            return checkSerialNoInitialized();
        case FL_DEVICE_ID_MAC:
            return checkMacInitialized();
        case FL_DEVICE_ID_CREATE_TIME:
            return checkCreateTimeInitialized();
        case FL_DEVICE_ID_UPDATE_TIME:
            return checkUpdateTimeInitialized();
        }
        return false;
    }
    
    /**
     * Determines if the {@code column} has been modified.
     * @param column
     * @return true if the field has been modified, false if the field has not been modified
     * @author guyadong
     */
    public boolean isModified(String column){        
        return isModified(columnIDOf(column));
    }

    /**
     * Determines if the {@code column} has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     * @param column
     * @return true if the field has been initialized, false otherwise
     * @author guyadong
     */
    public boolean isInitialized(String column){
        return isInitialized(columnIDOf(column));
    }
    
    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified()
    {
        modified = 0L;
    }
    /**
     * Resets the primary keys ( {@link #id} ) modification status to 'not modified'.
     */
    public void resetPrimaryKeysModified()
    {
        modified &= (~(FL_DEVICE_ID_ID_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_DEVICE_ID_GROUP_ID_MASK |
            FL_DEVICE_ID_NAME_MASK |
            FL_DEVICE_ID_VERSION_MASK |
            FL_DEVICE_ID_SERIAL_NO_MASK |
            FL_DEVICE_ID_MAC_MASK |
            FL_DEVICE_ID_CREATE_TIME_MASK |
            FL_DEVICE_ID_UPDATE_TIME_MASK));
    }
    /**
     * Resets the object initialization status to 'not initialized'.
     */
    private void resetInitialized()
    {
        initialized = 0L;
    }
    /** reset all fields to initial value, equal to a new bean */
    public void reset(){
        this.id = null;
        this.groupId = new Integer(1)/* DEFAULT:'1'*/;
        this.name = null;
        this.version = null;
        this.serialNo = null;
        this.mac = null;
        this.createTime = null/* DEFAULT:'CURRENT_TIMESTAMP'*/;
        this.updateTime = null/* DEFAULT:'CURRENT_TIMESTAMP'*/;
        this._isNew = true;
        this.modified = 0L;
        this.initialized = (FL_DEVICE_ID_GROUP_ID_MASK);
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FlDeviceBean)) {
            return false;
        }

        FlDeviceBean obj = (FlDeviceBean) object;
        return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getGroupId(), obj.getGroupId())
            .append(getName(), obj.getName())
            .append(getVersion(), obj.getVersion())
            .append(getSerialNo(), obj.getSerialNo())
            .append(getMac(), obj.getMac())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getUpdateTime(), obj.getUpdateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .toHashCode();
    }

    @Override
    public String toString() {
        // only output initialized field
        StringBuilder builder = new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[");
        int count = 0;        
        if(checkIdInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("id=").append(getId());
        }
        if(checkGroupIdInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("group_id=").append(getGroupId());
        }
        if(checkNameInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("name=").append(getName());
        }
        if(checkVersionInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("version=").append(getVersion());
        }
        if(checkSerialNoInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("serial_no=").append(getSerialNo());
        }
        if(checkMacInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("mac=").append(getMac());
        }
        if(checkCreateTimeInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("create_time=").append(getCreateTime());
        }
        if(checkUpdateTimeInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("update_time=").append(getUpdateTime());
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(FlDeviceBean object){
        return new CompareToBuilder()
            .append(getId(), object.getId())
            .append(getGroupId(), object.getGroupId())
            .append(getName(), object.getName())
            .append(getVersion(), object.getVersion())
            .append(getSerialNo(), object.getSerialNo())
            .append(getMac(), object.getMac())
            .append(getCreateTime(), object.getCreateTime())
            .append(getUpdateTime(), object.getUpdateTime())
            .toComparison();
    }
    @Override
    public FlDeviceBean clone(){
        try {
            return (FlDeviceBean) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlDeviceBean clean()
    {
        setId(null);
        setGroupId(null);
        setName(null);
        setVersion(null);
        setSerialNo(null);
        setMac(null);
        setCreateTime(null);
        setUpdateTime(null);
        isNew(true);
        resetInitialized();
        resetIsModified();
        return this;
    }
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @return always {@code bean}
     */
    public FlDeviceBean copy(FlDeviceBean bean)
    {
        return copy(bean,new int[]{});
    }
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column id list to copy into the current bean
     * @return always {@code bean}
     */
    public FlDeviceBean copy(FlDeviceBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length)
            for (int i = 0; i < 8; ++i) {
                if( bean.isInitialized(i))
                    setValue(i, bean.getValue(i));
            }
        else
            for (int i = 0; i < fieldList.length; ++i) {
                if( bean.isInitialized(fieldList[i]))
                    setValue(fieldList[i], bean.getValue(fieldList[i]));
            }
        return this;
    }
        
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     * @return always {@code bean}
     */
    public FlDeviceBean copy(FlDeviceBean bean, String... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length)
            copy(bean,(int[])null);
        else{
            int field;
            for (int i = 0; i < fieldList.length; i++) {
                field = columnIDOf(fieldList[i].trim());
                if(bean.isInitialized(field))
                    setValue(field, bean.getValue(field));
            }
        }
        return this;
    }

    /**
     * return a object representation of the given column id
     */
    @SuppressWarnings("unchecked")
    public <T>T getValue(int columnID)
    {
        switch( columnID ){
        case FL_DEVICE_ID_ID: 
            return (T)getId();        
        case FL_DEVICE_ID_GROUP_ID: 
            return (T)getGroupId();        
        case FL_DEVICE_ID_NAME: 
            return (T)getName();        
        case FL_DEVICE_ID_VERSION: 
            return (T)getVersion();        
        case FL_DEVICE_ID_SERIAL_NO: 
            return (T)getSerialNo();        
        case FL_DEVICE_ID_MAC: 
            return (T)getMac();        
        case FL_DEVICE_ID_CREATE_TIME: 
            return (T)getCreateTime();        
        case FL_DEVICE_ID_UPDATE_TIME: 
            return (T)getUpdateTime();        
        }
        return null;
    }

    /**
     * set a value representation of the given column id
     */
    public <T> void setValue(int columnID,T value)
    {
        switch( columnID ) {
        case FL_DEVICE_ID_ID:        
            setId((Integer)value);
        case FL_DEVICE_ID_GROUP_ID:        
            setGroupId((Integer)value);
        case FL_DEVICE_ID_NAME:        
            setName((String)value);
        case FL_DEVICE_ID_VERSION:        
            setVersion((String)value);
        case FL_DEVICE_ID_SERIAL_NO:        
            setSerialNo((String)value);
        case FL_DEVICE_ID_MAC:        
            setMac((String)value);
        case FL_DEVICE_ID_CREATE_TIME:        
            setCreateTime((java.util.Date)value);
        case FL_DEVICE_ID_UPDATE_TIME:        
            setUpdateTime((java.util.Date)value);
        }
    }
    
    /**
     * return a object representation of the given field
     */
    public <T>T getValue(String column)
    {
        return getValue(columnIDOf(column));
    }

    /**
     * set a value representation of the given field
     */
    public <T>void setValue(String column,T value)
    {
        setValue(columnIDOf(column),value);
    }

    public static int columnIDOf(String column){
        int index = FL_DEVICE_FIELDS_LIST.indexOf(column);
        if( 0 > index ) 
            index = FL_DEVICE_JAVA_FIELDS_LIST.indexOf(column);
        return index;    
    }
    public static final Builder builder(){
        return new Builder();
    }
    /** 
     * a builder for FlDeviceBean,the template instance is thread local variable
     * a instance of Builder can be reused.
     */
    public static final class Builder{
        /** FlDeviceBean instance used for template to create new FlDeviceBean instance. */
        static final ThreadLocal<FlDeviceBean> template = new ThreadLocal<FlDeviceBean>(){
            @Override
            protected FlDeviceBean initialValue() {
                return new FlDeviceBean();
            }};
        private Builder() {}
        /** 
         * reset the bean as template 
         * @see FlDeviceBean#reset()
         */
        public Builder reset(){
            template.get().reset();
            return this;
        }
        /** set a bean as template,must not be {@code null} */
        public Builder template(FlDeviceBean bean){
            if(null == bean)
                throw new NullPointerException();
            template.set(bean);
            return this;
        }
        /** return a clone instance of {@link #template}*/
        public FlDeviceBean build(){
            return template.get().clone();
        }
        /** 
         * fill the field : fl_device.id
         * @param id 设备id
         * @see {@link FlDeviceBean#getId()}
         * @see {@link FlDeviceBean#setId(Integer)}
         */
        public Builder id(Integer id){
            template.get().setId(id);
            return this;
        }
        /** 
         * fill the field : fl_device.group_id
         * @param groupId 所属设备组id
         * @see {@link FlDeviceBean#getGroupId()}
         * @see {@link FlDeviceBean#setGroupId(Integer)}
         */
        public Builder groupId(Integer groupId){
            template.get().setGroupId(groupId);
            return this;
        }
        /** 
         * fill the field : fl_device.name
         * @param name 设备名称
         * @see {@link FlDeviceBean#getName()}
         * @see {@link FlDeviceBean#setName(String)}
         */
        public Builder name(String name){
            template.get().setName(name);
            return this;
        }
        /** 
         * fill the field : fl_device.version
         * @param version 设备版本号
         * @see {@link FlDeviceBean#getVersion()}
         * @see {@link FlDeviceBean#setVersion(String)}
         */
        public Builder version(String version){
            template.get().setVersion(version);
            return this;
        }
        /** 
         * fill the field : fl_device.serial_no
         * @param serialNo 设备序列号
         * @see {@link FlDeviceBean#getSerialNo()}
         * @see {@link FlDeviceBean#setSerialNo(String)}
         */
        public Builder serialNo(String serialNo){
            template.get().setSerialNo(serialNo);
            return this;
        }
        /** 
         * fill the field : fl_device.mac
         * @param mac 6字节MAC地址(HEX)
         * @see {@link FlDeviceBean#getMac()}
         * @see {@link FlDeviceBean#setMac(String)}
         */
        public Builder mac(String mac){
            template.get().setMac(mac);
            return this;
        }
        /** 
         * fill the field : fl_device.create_time
         * @param createTime 
         * @see {@link FlDeviceBean#getCreateTime()}
         * @see {@link FlDeviceBean#setCreateTime(java.util.Date)}
         */
        public Builder createTime(java.util.Date createTime){
            template.get().setCreateTime(createTime);
            return this;
        }
        /** 
         * fill the field : fl_device.update_time
         * @param updateTime 
         * @see {@link FlDeviceBean#getUpdateTime()}
         * @see {@link FlDeviceBean#setUpdateTime(java.util.Date)}
         */
        public Builder updateTime(java.util.Date updateTime){
            template.get().setUpdateTime(updateTime);
            return this;
        }
    }
}
