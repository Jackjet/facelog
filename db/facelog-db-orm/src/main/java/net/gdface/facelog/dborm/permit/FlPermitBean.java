// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: bean.java.vm
// ______________________________________________________
package net.gdface.facelog.dborm.permit;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import net.gdface.facelog.dborm.Constant;
import net.gdface.facelog.dborm.BaseBean;
import net.gdface.facelog.dborm.device.FlDeviceGroupBean;
import net.gdface.facelog.dborm.person.FlPersonGroupBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;
/**
 * FlPermitBean is a mapping of fl_permit Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 通行权限关联表 </li>
 * </ul>
 * @author guyadong
*/
public  class FlPermitBean
    implements Serializable,BaseBean<FlPermitBean>,Comparable<FlPermitBean>,Constant,Cloneable
{
    private static final long serialVersionUID = 6130251228058473821L;
    /** NULL {@link FlPermitBean} bean , IMMUTABLE instance */
    public static final FlPermitBean NULL = new FlPermitBean().asNULL().asImmutable();
    /** comments:外键,设备组id */
    private Integer deviceGroupId;

    /** comments:外键,人员组id */
    private Integer personGroupId;

    /** comments:备注 */
    private String remark;

    /** comments:应用项目自定义二进制扩展字段(最大64KB) */
    private java.nio.ByteBuffer extBin;

    /** comments:应用项目自定义文本扩展字段(最大64KB) */
    private String extTxt;

    private java.util.Date createTime;

    /** flag whether {@code this} can be modified */
    private Boolean immutable;
    /** columns modified flag */
    private long modified;
    /** columns initialized flag */
    private long initialized;
    private boolean isNew;        
    /** 
     * set immutable status
     * @return {@code this} 
     */
    private FlPermitBean immutable(Boolean immutable) {
        this.immutable = immutable;
        return this;
    }
    /** 
     * set {@code this} as immutable object
     * @return {@code this} 
     */
    public FlPermitBean asImmutable() {
        return immutable(Boolean.TRUE);
    }
    /**
     * @return {@code true} if {@code this} is a mutable object  
     */
    public boolean mutable(){
        return !Boolean.TRUE.equals(this.immutable);
    }
    /**
     * @return {@code this}
     * @throws IllegalStateException if {@code this} is a immutable object 
     */
    private FlPermitBean checkMutable(){
        if(!mutable()){
            throw new IllegalStateException("this is a immutable object");
        }
        return this;
    }
    /**
     * @return return a new mutable copy of this object.
     */
    public FlPermitBean cloneMutable(){
        return clone().immutable(null);
    }
    @Override
    public boolean isNew()
    {
        return this.isNew;
    }


    @Override
    public void isNew(boolean isNew)
    {
        this.isNew = isNew;
    }
    /**
     * Specifies to the object if it has been set as new.
     *
     * @param isNew the boolean value to be assigned to the isNew field
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
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
    protected static final <T extends Comparable<T>>boolean equals(T a, T b) {
        return a == b || (a != null && 0==a.compareTo(b));
    }
    public FlPermitBean(){
        super();
        reset();
    }
    /**
     * construct a new instance filled with primary keys
     * @param deviceGroupId PK# 1 
     @param personGroupId PK# 2 
     */
    public FlPermitBean(Integer deviceGroupId,Integer personGroupId){
        this();
        setDeviceGroupId(deviceGroupId);
        setPersonGroupId(personGroupId);
    }
    /**
     * Getter method for {@link #deviceGroupId}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.device_group_id</li>
     * <li> foreign key: fl_device_group.id</li>
     * <li>comments: 外键,设备组id</li>
     * <li>NOT NULL</li>
     * <li>column size: 10</li>
     * <li>JDBC type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of deviceGroupId
     */
    public Integer getDeviceGroupId(){
        return deviceGroupId;
    }
    /**
     * Setter method for {@link #deviceGroupId}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to deviceGroupId
     */
    public void setDeviceGroupId(Integer newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, deviceGroupId)) {
            return;
        }
        deviceGroupId = newVal;

        modified |= FL_PERMIT_ID_DEVICE_GROUP_ID_MASK;
        initialized |= FL_PERMIT_ID_DEVICE_GROUP_ID_MASK;
    }
    /**
     * Setter method for {@link #deviceGroupId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to deviceGroupId
     */
    public void setDeviceGroupId(int newVal)
    {
        setDeviceGroupId(new Integer(newVal));
    }
    /**
     * Determines if the deviceGroupId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkDeviceGroupIdModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_DEVICE_GROUP_ID_MASK);
    }

    /**
     * Determines if the deviceGroupId has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkDeviceGroupIdInitialized()
    {
        return 0L !=  (initialized & FL_PERMIT_ID_DEVICE_GROUP_ID_MASK);
    }
    /**
     * Getter method for {@link #personGroupId}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.person_group_id</li>
     * <li> foreign key: fl_person_group.id</li>
     * <li>comments: 外键,人员组id</li>
     * <li>NOT NULL</li>
     * <li>column size: 10</li>
     * <li>JDBC type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of personGroupId
     */
    public Integer getPersonGroupId(){
        return personGroupId;
    }
    /**
     * Setter method for {@link #personGroupId}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to personGroupId
     */
    public void setPersonGroupId(Integer newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, personGroupId)) {
            return;
        }
        personGroupId = newVal;

        modified |= FL_PERMIT_ID_PERSON_GROUP_ID_MASK;
        initialized |= FL_PERMIT_ID_PERSON_GROUP_ID_MASK;
    }
    /**
     * Setter method for {@link #personGroupId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to personGroupId
     */
    public void setPersonGroupId(int newVal)
    {
        setPersonGroupId(new Integer(newVal));
    }
    /**
     * Determines if the personGroupId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkPersonGroupIdModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_PERSON_GROUP_ID_MASK);
    }

    /**
     * Determines if the personGroupId has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkPersonGroupIdInitialized()
    {
        return 0L !=  (initialized & FL_PERMIT_ID_PERSON_GROUP_ID_MASK);
    }
    /**
     * Getter method for {@link #remark}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.remark</li>
     * <li>comments: 备注</li>
     * <li>column size: 256</li>
     * <li>JDBC type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of remark
     */
    public String getRemark(){
        return remark;
    }
    /**
     * Setter method for {@link #remark}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to remark
     */
    public void setRemark(String newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, remark)) {
            return;
        }
        remark = newVal;

        modified |= FL_PERMIT_ID_REMARK_MASK;
        initialized |= FL_PERMIT_ID_REMARK_MASK;
    }
    /**
     * Determines if the remark has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkRemarkModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_REMARK_MASK);
    }

    /**
     * Determines if the remark has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkRemarkInitialized()
    {
        return 0L !=  (initialized & FL_PERMIT_ID_REMARK_MASK);
    }
    /**
     * Getter method for {@link #extBin}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.ext_bin</li>
     * <li>comments: 应用项目自定义二进制扩展字段(最大64KB)</li>
     * <li>column size: 65535</li>
     * <li>JDBC type returned by the driver: Types.LONGVARBINARY</li>
     * </ul>
     *
     * @return the value of extBin
     */
    public java.nio.ByteBuffer getExtBin(){
        return extBin;
    }
    /**
     * Setter method for {@link #extBin}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to extBin
     */
    public void setExtBin(java.nio.ByteBuffer newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, extBin)) {
            return;
        }
        extBin = newVal;

        modified |= FL_PERMIT_ID_EXT_BIN_MASK;
        initialized |= FL_PERMIT_ID_EXT_BIN_MASK;
    }
    /**
     * Determines if the extBin has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkExtBinModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_EXT_BIN_MASK);
    }

    /**
     * Determines if the extBin has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkExtBinInitialized()
    {
        return 0L !=  (initialized & FL_PERMIT_ID_EXT_BIN_MASK);
    }
    /**
     * Getter method for {@link #extTxt}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.ext_txt</li>
     * <li>comments: 应用项目自定义文本扩展字段(最大64KB)</li>
     * <li>column size: 65535</li>
     * <li>JDBC type returned by the driver: Types.LONGVARCHAR</li>
     * </ul>
     *
     * @return the value of extTxt
     */
    public String getExtTxt(){
        return extTxt;
    }
    /**
     * Setter method for {@link #extTxt}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to extTxt
     */
    public void setExtTxt(String newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, extTxt)) {
            return;
        }
        extTxt = newVal;

        modified |= FL_PERMIT_ID_EXT_TXT_MASK;
        initialized |= FL_PERMIT_ID_EXT_TXT_MASK;
    }
    /**
     * Determines if the extTxt has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkExtTxtModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_EXT_TXT_MASK);
    }

    /**
     * Determines if the extTxt has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkExtTxtInitialized()
    {
        return 0L !=  (initialized & FL_PERMIT_ID_EXT_TXT_MASK);
    }
    /**
     * Getter method for {@link #createTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_permit.create_time</li>
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
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to createTime
     */
    public void setCreateTime(java.util.Date newVal)
    {
        checkMutable();
        if (Objects.equals(newVal, createTime)) {
            return;
        }
        createTime = newVal;

        modified |= FL_PERMIT_ID_CREATE_TIME_MASK;
        initialized |= FL_PERMIT_ID_CREATE_TIME_MASK;
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
     * Setter method for {@link #createTime}.<br>
     * @param newVal the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
     */
    public void setCreateTime(Long newVal)
    {
        setCreateTime(null == newVal ? null : new java.util.Date(newVal));
    }
    /**
     * Determines if the createTime has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkCreateTimeModified()
    {
        return 0L !=  (modified & FL_PERMIT_ID_CREATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_PERMIT_ID_CREATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link FlDeviceGroupBean} by {@link #deviceGroupId} . <br>
     * FOREIGN KEY (device_group_id) REFERENCES fl_device_group(id)
     */
    private FlDeviceGroupBean referencedByDeviceGroupId;
    /**
     * Getter method for {@link #referencedByDeviceGroupId}.
     * @return FlDeviceGroupBean
     */
    public FlDeviceGroupBean getReferencedByDeviceGroupId() {
        return this.referencedByDeviceGroupId;
    }
    /**
     * Setter method for {@link #referencedByDeviceGroupId}.
     * @param reference FlDeviceGroupBean
     */
    public void setReferencedByDeviceGroupId(FlDeviceGroupBean reference) {
        this.referencedByDeviceGroupId = reference;
    }
    /** 
     * The referenced {@link FlPersonGroupBean} by {@link #personGroupId} . <br>
     * FOREIGN KEY (person_group_id) REFERENCES fl_person_group(id)
     */
    private FlPersonGroupBean referencedByPersonGroupId;
    /**
     * Getter method for {@link #referencedByPersonGroupId}.
     * @return FlPersonGroupBean
     */
    public FlPersonGroupBean getReferencedByPersonGroupId() {
        return this.referencedByPersonGroupId;
    }
    /**
     * Setter method for {@link #referencedByPersonGroupId}.
     * @param reference FlPersonGroupBean
     */
    public void setReferencedByPersonGroupId(FlPersonGroupBean reference) {
        this.referencedByPersonGroupId = reference;
    }

    @Override
    public boolean isModified()
    {
        return 0 != modified;
    }
  
    @Override
    public boolean isModified(int columnID){
        switch ( columnID ){
        case FL_PERMIT_ID_DEVICE_GROUP_ID:
            return checkDeviceGroupIdModified();
        case FL_PERMIT_ID_PERSON_GROUP_ID:
            return checkPersonGroupIdModified();
        case FL_PERMIT_ID_REMARK:
            return checkRemarkModified();
        case FL_PERMIT_ID_EXT_BIN:
            return checkExtBinModified();
        case FL_PERMIT_ID_EXT_TXT:
            return checkExtTxtModified();
        case FL_PERMIT_ID_CREATE_TIME:
            return checkCreateTimeModified();
        default:
            return false;
        }        
    }

    @Override
    public boolean isInitialized(int columnID){
        switch(columnID) {
        case FL_PERMIT_ID_DEVICE_GROUP_ID:
            return checkDeviceGroupIdInitialized();
        case FL_PERMIT_ID_PERSON_GROUP_ID:
            return checkPersonGroupIdInitialized();
        case FL_PERMIT_ID_REMARK:
            return checkRemarkInitialized();
        case FL_PERMIT_ID_EXT_BIN:
            return checkExtBinInitialized();
        case FL_PERMIT_ID_EXT_TXT:
            return checkExtTxtInitialized();
        case FL_PERMIT_ID_CREATE_TIME:
            return checkCreateTimeInitialized();
        default:
            return false;
        }
    }
    
    @Override
    public boolean isModified(String column){        
        return isModified(columnIDOf(column));
    }

    @Override
    public boolean isInitialized(String column){
        return isInitialized(columnIDOf(column));
    }
    
    @Override
    public void resetIsModified()
    {
        checkMutable();
        modified = 0L;
    }

    @Override
    public void resetPrimaryKeysModified()
    {
        modified &= (~(FL_PERMIT_ID_DEVICE_GROUP_ID_MASK |
            FL_PERMIT_ID_PERSON_GROUP_ID_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_PERMIT_ID_REMARK_MASK |
            FL_PERMIT_ID_EXT_BIN_MASK |
            FL_PERMIT_ID_EXT_TXT_MASK |
            FL_PERMIT_ID_CREATE_TIME_MASK));
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
        checkMutable();
        this.deviceGroupId = null;
        this.personGroupId = null;
        this.remark = null;
        this.extBin = null;
        this.extTxt = null;
        /* DEFAULT:'CURRENT_TIMESTAMP'*/
        this.createTime = null;
        this.isNew = true;
        this.modified = 0L;
        this.initialized = 0L;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FlPermitBean)) {
            return false;
        }

        FlPermitBean obj = (FlPermitBean) object;
        return new EqualsBuilder()
            .append(getDeviceGroupId(), obj.getDeviceGroupId())
            .append(getPersonGroupId(), obj.getPersonGroupId())
            .append(getRemark(), obj.getRemark())
            .append(getExtBin(), obj.getExtBin())
            .append(getExtTxt(), obj.getExtTxt())
            .append(getCreateTime(), obj.getCreateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getDeviceGroupId())
            .append(getPersonGroupId())
            .toHashCode();
    }

    @Override
    public String toString() {
        return toString(true,false);
    }
    /**
     * cast byte array to HEX string
     * 
     * @param input
     * @return {@code null} if {@code input} is null
     */
    private static final String toHex(byte[] input) {
        if (null == input){
            return null;
        }
        StringBuffer sb = new StringBuffer(input.length * 2);
        for (int i = 0; i < input.length; i++) {
            sb.append(Character.forDigit((input[i] & 240) >> 4, 16));
            sb.append(Character.forDigit(input[i] & 15, 16));
        }
        return sb.toString();
    }
    protected static final StringBuilder append(StringBuilder buffer,boolean full,byte[] value){
        if(full || null == value){
            buffer.append(toHex(value));
        }else{
            buffer.append(value.length).append(" bytes");
        }
        return buffer;
    }
    private static int stringLimit = 64;
    private static final int MINIMUM_LIMIT = 16;
    protected static final StringBuilder append(StringBuilder buffer,boolean full,String value){
        if(full || null == value || value.length() <= stringLimit){
            buffer.append(value);
        }else{
            buffer.append(value.substring(0,stringLimit - 8)).append(" ...").append(value.substring(stringLimit-4,stringLimit));
        }
        return buffer;
    }
    protected static final <T>StringBuilder append(StringBuilder buffer,boolean full,T value){
        return buffer.append(value);
    }
    public static final void setStringLimit(int limit){
        if(limit < MINIMUM_LIMIT){
            throw new IllegalArgumentException(String.format("INVALID limit %d,minimum value %d",limit,MINIMUM_LIMIT));
        }
        stringLimit = limit;
    }
    @Override
    public String toString(boolean notNull, boolean fullIfStringOrBytes) {
        // only output initialized field
        StringBuilder builder = new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[");
        int count = 0;        
        if(checkDeviceGroupIdInitialized()){
            if(!notNull || null != getDeviceGroupId()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("device_group_id=");
                append(builder,fullIfStringOrBytes,getDeviceGroupId());
            }
        }
        if(checkPersonGroupIdInitialized()){
            if(!notNull || null != getPersonGroupId()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("person_group_id=");
                append(builder,fullIfStringOrBytes,getPersonGroupId());
            }
        }
        if(checkRemarkInitialized()){
            if(!notNull || null != getRemark()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("remark=");
                append(builder,fullIfStringOrBytes,getRemark());
            }
        }
        if(checkExtBinInitialized()){
            if(!notNull || null != getExtBin()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("ext_bin=");
                append(builder,fullIfStringOrBytes,getExtBin());
            }
        }
        if(checkExtTxtInitialized()){
            if(!notNull || null != getExtTxt()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("ext_txt=");
                append(builder,fullIfStringOrBytes,getExtTxt());
            }
        }
        if(checkCreateTimeInitialized()){
            if(!notNull || null != getCreateTime()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("create_time=");
                append(builder,fullIfStringOrBytes,getCreateTime());
            }
        }
        builder.append("]");
        return builder.toString();
    }
    @Override
    public int compareTo(FlPermitBean object){
        return new CompareToBuilder()
            .append(getDeviceGroupId(), object.getDeviceGroupId())
            .append(getPersonGroupId(), object.getPersonGroupId())
            .append(getRemark(), object.getRemark())
            .append(getExtBin(), object.getExtBin())
            .append(getExtTxt(), object.getExtTxt())
            .append(getCreateTime(), object.getCreateTime())
            .toComparison();
    }
    @Override
    public FlPermitBean clone(){
        try {
            return (FlPermitBean) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Make {@code this} to a NULL bean<br>
     * set all fields to null, {@link #modified} and {@link #initialized} be set to 0
     * @return {@code this} bean
     * @author guyadong
     */
    public FlPermitBean asNULL()
    {   
        checkMutable();
        
        setDeviceGroupId((Integer)null);
        setPersonGroupId((Integer)null);
        setRemark((String)null);
        setExtBin((java.nio.ByteBuffer)null);
        setExtTxt((String)null);
        setCreateTime((java.util.Date)null);
        isNew(true);
        resetInitialized();
        resetIsModified();
        return this;
    }
    /**
     * check whether this bean is a NULL bean 
     * @return {@code true} if {@link #initialized} be set to zero
     * @see #asNULL()
     */
    public boolean checkNULL(){
        return 0L == getInitialized();
    }
    /** 
     * @param source source list
     * @return {@code source} replace {@code null} element with null instance({@link #NULL})
     */
    public static final List<FlPermitBean> replaceNull(List<FlPermitBean> source){
        if(null != source){
            for(int i = 0,endIndex = source.size();i<endIndex;++i){
                if(null == source.get(i)){
                    source.set(i, NULL);
                }
            }
        }
        return source;
    }
    /** 
     * @param source input list
     * @return replace null instance element with {@code null}
     * @see #checkNULL()
     */
    public static final List<FlPermitBean> replaceNullInstance(List<FlPermitBean> source){
        if(null != source){
            for(int i = 0,endIndex = source.size();i<endIndex;++i){
                if(source.get(i).checkNULL()){
                    source.set(i, null);
                }
            }
        }
        return source;
    }
    @Override
    public FlPermitBean copy(FlPermitBean bean)
    {
        return copy(bean,new int[]{});
    }
    @Override
    public FlPermitBean copy(FlPermitBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length){
            for (int i = 0; i < FL_PERMIT_COLUMN_COUNT; ++i) {
                if( bean.isInitialized(i)){
                    setValue(i, bean.getValue(i));
                }
            }
        }
        else{
            for (int i = 0; i < fieldList.length; ++i) {
                if( bean.isInitialized(fieldList[i])){
                    setValue(fieldList[i], bean.getValue(fieldList[i]));
                }
            }
        }
        return this;
    }
        
    @Override
    public FlPermitBean copy(FlPermitBean bean, String... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length){
            copy(bean,(int[])null);
        }else{
            int field;
            for (int i = 0; i < fieldList.length; i++) {
                field = columnIDOf(fieldList[i].trim());
                if(bean.isInitialized(field)){
                    setValue(field, bean.getValue(field));
                }
            }
        }
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T>T getValue(int columnID)
    {
        switch( columnID ){
        case FL_PERMIT_ID_DEVICE_GROUP_ID: 
            return (T)getDeviceGroupId();        
        case FL_PERMIT_ID_PERSON_GROUP_ID: 
            return (T)getPersonGroupId();        
        case FL_PERMIT_ID_REMARK: 
            return (T)getRemark();        
        case FL_PERMIT_ID_EXT_BIN: 
            return (T)getExtBin();        
        case FL_PERMIT_ID_EXT_TXT: 
            return (T)getExtTxt();        
        case FL_PERMIT_ID_CREATE_TIME: 
            return (T)getCreateTime();        
        default:
            return null;
        }
    }

    @Override
    public <T> void setValue(int columnID,T value)
    {
        switch( columnID ) {
        case FL_PERMIT_ID_DEVICE_GROUP_ID:
            setDeviceGroupId((Integer)value);
            break;
        case FL_PERMIT_ID_PERSON_GROUP_ID:
            setPersonGroupId((Integer)value);
            break;
        case FL_PERMIT_ID_REMARK:
            setRemark((String)value);
            break;
        case FL_PERMIT_ID_EXT_BIN:
            setExtBin((java.nio.ByteBuffer)value);
            break;
        case FL_PERMIT_ID_EXT_TXT:
            setExtTxt((String)value);
            break;
        case FL_PERMIT_ID_CREATE_TIME:
            setCreateTime((java.util.Date)value);
            break;
        default:
            break;
        }
    }
    
    @Override
    public <T> T getValue(String column)
    {
        return getValue(columnIDOf(column));
    }

    @Override
    public <T> void setValue(String column,T value)
    {
        setValue(columnIDOf(column),value);
    }
    
    /**
     * @param column column name
     * @return column id for the given field name or negative if {@code column} is invalid name 
     */
    public static int columnIDOf(String column){
        int index = FL_PERMIT_FIELDS_LIST.indexOf(column);
        return  index < 0 
            ? FL_PERMIT_JAVA_FIELDS_LIST.indexOf(column)
            : index;
    }
    
    public static final Builder builder(){
        return new Builder();
    }
    /** 
     * a builder for FlPermitBean,the template instance is thread local variable
     * a instance of Builder can be reused.
     */
    public static final class Builder{
        /** FlPermitBean instance used for template to create new FlPermitBean instance. */
        static final ThreadLocal<FlPermitBean> TEMPLATE = new ThreadLocal<FlPermitBean>(){
            @Override
            protected FlPermitBean initialValue() {
                return new FlPermitBean();
            }};
        private Builder() {}
        /** 
         * reset the bean as template 
         * @see FlPermitBean#reset()
         */
        public Builder reset(){
            TEMPLATE.get().reset();
            return this;
        }
        /** set a bean as template,must not be {@code null} */
        public Builder template(FlPermitBean bean){
            if(null == bean){
                throw new NullPointerException();
            }
            TEMPLATE.set(bean);
            return this;
        }
        /** return a clone instance of {@link #TEMPLATE}*/
        public FlPermitBean build(){
            return TEMPLATE.get().clone();
        }
        /** 
         * fill the field : fl_permit.device_group_id
         * @param deviceGroupId 外键,设备组id
         * @see FlPermitBean#getDeviceGroupId()
         * @see FlPermitBean#setDeviceGroupId(Integer)
         */
        public Builder deviceGroupId(Integer deviceGroupId){
            TEMPLATE.get().setDeviceGroupId(deviceGroupId);
            return this;
        }
        /** 
         * fill the field : fl_permit.person_group_id
         * @param personGroupId 外键,人员组id
         * @see FlPermitBean#getPersonGroupId()
         * @see FlPermitBean#setPersonGroupId(Integer)
         */
        public Builder personGroupId(Integer personGroupId){
            TEMPLATE.get().setPersonGroupId(personGroupId);
            return this;
        }
        /** 
         * fill the field : fl_permit.remark
         * @param remark 备注
         * @see FlPermitBean#getRemark()
         * @see FlPermitBean#setRemark(String)
         */
        public Builder remark(String remark){
            TEMPLATE.get().setRemark(remark);
            return this;
        }
        /** 
         * fill the field : fl_permit.ext_bin
         * @param extBin 应用项目自定义二进制扩展字段(最大64KB)
         * @see FlPermitBean#getExtBin()
         * @see FlPermitBean#setExtBin(java.nio.ByteBuffer)
         */
        public Builder extBin(java.nio.ByteBuffer extBin){
            TEMPLATE.get().setExtBin(extBin);
            return this;
        }
        /** 
         * fill the field : fl_permit.ext_txt
         * @param extTxt 应用项目自定义文本扩展字段(最大64KB)
         * @see FlPermitBean#getExtTxt()
         * @see FlPermitBean#setExtTxt(String)
         */
        public Builder extTxt(String extTxt){
            TEMPLATE.get().setExtTxt(extTxt);
            return this;
        }
        /** 
         * fill the field : fl_permit.create_time
         * @param createTime 
         * @see FlPermitBean#getCreateTime()
         * @see FlPermitBean#setCreateTime(java.util.Date)
         */
        public Builder createTime(java.util.Date createTime){
            TEMPLATE.get().setCreateTime(createTime);
            return this;
        }
    }
}
