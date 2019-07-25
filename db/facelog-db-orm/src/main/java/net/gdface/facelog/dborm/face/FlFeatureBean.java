// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: bean.java.vm
// ______________________________________________________
package net.gdface.facelog.dborm.face;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import net.gdface.facelog.dborm.Constant;
import net.gdface.facelog.dborm.BaseBean;
import net.gdface.facelog.dborm.person.FlPersonBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;
/**
 * FlFeatureBean is a mapping of fl_feature Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 用于验证身份的人脸特征数据表 </li>
 * </ul>
 * @author guyadong
*/
public  class FlFeatureBean
    implements Serializable,BaseBean<FlFeatureBean>,Comparable<FlFeatureBean>,Constant,Cloneable
{
    private static final long serialVersionUID = 9009645819979798812L;
    /** NULL {@link FlFeatureBean} bean , IMMUTABLE instance */
    public static final FlFeatureBean NULL = new FlFeatureBean().asNULL().asImmutable();
    /** comments:主键,特征码md5校验码 */
    private String md5;

    /** comments:特征码(算法)版本号,用于区分不同人脸识别算法生成的特征数据(允许字母,数字,-,.,_符号) */
    private String version;

    /** comments:外键,所属用户id */
    private Integer personId;

    /** comments:二进制特征数据 */
    private java.nio.ByteBuffer feature;

    private java.util.Date updateTime;

    /** flag whether {@code this} can be modified */
    private Boolean immutable;
    /** columns modified flag */
    private int modified;
    /** columns initialized flag */
    private int initialized;
    /** new record flag  */
    private boolean isNew;        
    /** 
     * set immutable status
     * @return {@code this} 
     */
    private FlFeatureBean immutable(Boolean immutable) {
        this.immutable = immutable;
        return this;
    }
    /** 
     * set {@code this} as immutable object
     * @return {@code this} 
     */
    public FlFeatureBean asImmutable() {
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
    private FlFeatureBean checkMutable(){
        if(!mutable()){
            throw new IllegalStateException("this is a immutable object");
        }
        return this;
    }
    /**
     * @return return a new mutable copy of this object.
     */
    public FlFeatureBean cloneMutable(){
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
    public int getModified(){
        return modified;
    }

    /**
     * @param modified the modified status bit to be assigned to {@link #modified}
     */
    public void setModified(int modified){
        this.modified = modified;
    }
    /**
     * @return the initialized status of columns
     */
    public int getInitialized(){
        return initialized;
    }

    /**
     * @param initialized the initialized status bit to be assigned to {@link #initialized}
     */
    public void setInitialized(int initialized){
        this.initialized = initialized;
    }
    protected static final <T extends Comparable<T>>boolean equals(T a, T b) {
        return a == b || (a != null && 0==a.compareTo(b));
    }
    public FlFeatureBean(){
        super();
        reset();
    }
    /**
     * construct a new instance filled with primary keys
     * @param md5 PK# 1 
     */
    public FlFeatureBean(String md5){
        this();
        setMd5(md5);
    }
    /**
     * Getter method for {@link #md5}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_feature.md5</li>
     * <li> imported key: fl_log.verify_feature</li>
     * <li> imported key: fl_face.feature_md5</li>
     * <li>comments: 主键,特征码md5校验码</li>
     * <li>NOT NULL</li>
     * <li>column size: 32</li>
     * <li>JDBC type returned by the driver: Types.CHAR</li>
     * </ul>
     *
     * @return the value of md5
     */
    public String getMd5(){
        return md5;
    }
    /**
     * Setter method for {@link #md5}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to md5
     */
    public void setMd5(String newVal)
    {
        checkMutable();

        modified |= FL_FEATURE_ID_MD5_MASK;
        initialized |= FL_FEATURE_ID_MD5_MASK;

        if (Objects.equals(newVal, md5)) {
            return;
        }
        md5 = newVal;
    }
    /**
     * Determines if the md5 has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkMd5Modified()
    {
        return 0L !=  (modified & FL_FEATURE_ID_MD5_MASK);
    }

    /**
     * Determines if the md5 has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkMd5Initialized()
    {
        return 0L !=  (initialized & FL_FEATURE_ID_MD5_MASK);
    }
    /**
     * Getter method for {@link #version}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_feature.version</li>
     * <li>comments: 特征码(算法)版本号,用于区分不同人脸识别算法生成的特征数据(允许字母,数字,-,.,_符号)</li>
     * <li>NOT NULL</li>
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
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to version
     */
    public void setVersion(String newVal)
    {
        checkMutable();

        modified |= FL_FEATURE_ID_VERSION_MASK;
        initialized |= FL_FEATURE_ID_VERSION_MASK;

        if (Objects.equals(newVal, version)) {
            return;
        }
        version = newVal;
    }
    /**
     * Determines if the version has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkVersionModified()
    {
        return 0L !=  (modified & FL_FEATURE_ID_VERSION_MASK);
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
        return 0L !=  (initialized & FL_FEATURE_ID_VERSION_MASK);
    }
    /**
     * Getter method for {@link #personId}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_feature.person_id</li>
     * <li> foreign key: fl_person.id</li>
     * <li>comments: 外键,所属用户id</li>
     * <li>column size: 10</li>
     * <li>JDBC type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of personId
     */
    public Integer getPersonId(){
        return personId;
    }
    /**
     * Setter method for {@link #personId}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(Integer newVal)
    {
        checkMutable();

        modified |= FL_FEATURE_ID_PERSON_ID_MASK;
        initialized |= FL_FEATURE_ID_PERSON_ID_MASK;

        if (Objects.equals(newVal, personId)) {
            return;
        }
        personId = newVal;
    }
    /**
     * Determines if the personId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkPersonIdModified()
    {
        return 0L !=  (modified & FL_FEATURE_ID_PERSON_ID_MASK);
    }

    /**
     * Determines if the personId has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkPersonIdInitialized()
    {
        return 0L !=  (initialized & FL_FEATURE_ID_PERSON_ID_MASK);
    }
    /**
     * Getter method for {@link #feature}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_feature.feature</li>
     * <li>comments: 二进制特征数据</li>
     * <li>NOT NULL</li>
     * <li>column size: 65535</li>
     * <li>JDBC type returned by the driver: Types.LONGVARBINARY</li>
     * </ul>
     *
     * @return the value of feature
     */
    public java.nio.ByteBuffer getFeature(){
        return feature;
    }
    /**
     * Setter method for {@link #feature}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to feature
     */
    public void setFeature(java.nio.ByteBuffer newVal)
    {
        checkMutable();

        modified |= FL_FEATURE_ID_FEATURE_MASK;
        initialized |= FL_FEATURE_ID_FEATURE_MASK;

        if (Objects.equals(newVal, feature)) {
            return;
        }
        feature = newVal;
    }
    /**
     * Determines if the feature has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkFeatureModified()
    {
        return 0L !=  (modified & FL_FEATURE_ID_FEATURE_MASK);
    }

    /**
     * Determines if the feature has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkFeatureInitialized()
    {
        return 0L !=  (initialized & FL_FEATURE_ID_FEATURE_MASK);
    }
    /**
     * Getter method for {@link #updateTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_feature.update_time</li>
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
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to updateTime
     */
    public void setUpdateTime(java.util.Date newVal)
    {
        checkMutable();

        modified |= FL_FEATURE_ID_UPDATE_TIME_MASK;
        initialized |= FL_FEATURE_ID_UPDATE_TIME_MASK;

        if (Objects.equals(newVal, updateTime)) {
            return;
        }
        updateTime = newVal;
    }
    /**
     * Setter method for {@link #updateTime}.<br>
     * @param newVal the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object.
     */
    public void setUpdateTime(Long newVal)
    {
        setUpdateTime(null == newVal ? null : new java.util.Date(newVal));
    }
    /**
     * Determines if the updateTime has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkUpdateTimeModified()
    {
        return 0L !=  (modified & FL_FEATURE_ID_UPDATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_FEATURE_ID_UPDATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link FlPersonBean} by {@link #personId} . <br>
     * FOREIGN KEY (person_id) REFERENCES fl_person(id)
     */
    private FlPersonBean referencedByPersonId;
    /**
     * Getter method for {@link #referencedByPersonId}.
     * @return FlPersonBean
     */
    public FlPersonBean getReferencedByPersonId() {
        return this.referencedByPersonId;
    }
    /**
     * Setter method for {@link #referencedByPersonId}.
     * @param reference FlPersonBean
     */
    public void setReferencedByPersonId(FlPersonBean reference) {
        this.referencedByPersonId = reference;
    }

    @Override
    public boolean isModified()
    {
        return 0 != modified;
    }
  
    @Override
    public boolean isModified(int columnID){
        switch ( columnID ){
        case FL_FEATURE_ID_MD5:
            return checkMd5Modified();
        case FL_FEATURE_ID_VERSION:
            return checkVersionModified();
        case FL_FEATURE_ID_PERSON_ID:
            return checkPersonIdModified();
        case FL_FEATURE_ID_FEATURE:
            return checkFeatureModified();
        case FL_FEATURE_ID_UPDATE_TIME:
            return checkUpdateTimeModified();
        default:
            return false;
        }        
    }

    @Override
    public boolean isInitialized(int columnID){
        switch(columnID) {
        case FL_FEATURE_ID_MD5:
            return checkMd5Initialized();
        case FL_FEATURE_ID_VERSION:
            return checkVersionInitialized();
        case FL_FEATURE_ID_PERSON_ID:
            return checkPersonIdInitialized();
        case FL_FEATURE_ID_FEATURE:
            return checkFeatureInitialized();
        case FL_FEATURE_ID_UPDATE_TIME:
            return checkUpdateTimeInitialized();
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
        modified = 0;
    }

    @Override
    public void resetPrimaryKeysModified()
    {
        modified &= (~(FL_FEATURE_ID_MD5_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_FEATURE_ID_VERSION_MASK |
            FL_FEATURE_ID_PERSON_ID_MASK |
            FL_FEATURE_ID_FEATURE_MASK |
            FL_FEATURE_ID_UPDATE_TIME_MASK));
    }
    /**
     * Resets the object initialization status to 'not initialized'.
     */
    private void resetInitialized()
    {
        initialized = 0;
    }
    /** reset all fields to initial value, equal to a new bean */
    public void reset(){
        checkMutable();
        this.md5 = null;
        this.version = null;
        this.personId = null;
        this.feature = null;
        /* DEFAULT:'CURRENT_TIMESTAMP'*/
        this.updateTime = null;
        this.isNew = true;
        this.modified = 0;
        this.initialized = 0;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FlFeatureBean)) {
            return false;
        }

        FlFeatureBean obj = (FlFeatureBean) object;
        return new EqualsBuilder()
            .append(getMd5(), obj.getMd5())
            .append(getVersion(), obj.getVersion())
            .append(getPersonId(), obj.getPersonId())
            .append(getFeature(), obj.getFeature())
            .append(getUpdateTime(), obj.getUpdateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getMd5())
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
        if(checkMd5Initialized()){
            if(!notNull || null != getMd5()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("md5=");
                append(builder,fullIfStringOrBytes,getMd5());
            }
        }
        if(checkVersionInitialized()){
            if(!notNull || null != getVersion()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("version=");
                append(builder,fullIfStringOrBytes,getVersion());
            }
        }
        if(checkPersonIdInitialized()){
            if(!notNull || null != getPersonId()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("person_id=");
                append(builder,fullIfStringOrBytes,getPersonId());
            }
        }
        if(checkFeatureInitialized()){
            if(!notNull || null != getFeature()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("feature=");
                append(builder,fullIfStringOrBytes,getFeature());
            }
        }
        if(checkUpdateTimeInitialized()){
            if(!notNull || null != getUpdateTime()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("update_time=");
                append(builder,fullIfStringOrBytes,getUpdateTime());
            }
        }
        builder.append("]");
        return builder.toString();
    }
    @Override
    public int compareTo(FlFeatureBean object){
        return new CompareToBuilder()
            .append(getMd5(), object.getMd5())
            .append(getVersion(), object.getVersion())
            .append(getPersonId(), object.getPersonId())
            .append(getFeature(), object.getFeature())
            .append(getUpdateTime(), object.getUpdateTime())
            .toComparison();
    }
    @Override
    public FlFeatureBean clone(){
        try {
            return (FlFeatureBean) super.clone();
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
    public FlFeatureBean asNULL()
    {   
        checkMutable();
        
        setMd5((String)null);
        setVersion((String)null);
        setPersonId((Integer)null);
        setFeature((java.nio.ByteBuffer)null);
        setUpdateTime((java.util.Date)null);
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
        return 0 == getInitialized();
    }
    /** 
     * @param source source list
     * @return {@code source} replace {@code null} element with null instance({@link #NULL})
     */
    public static final List<FlFeatureBean> replaceNull(List<FlFeatureBean> source){
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
    public static final List<FlFeatureBean> replaceNullInstance(List<FlFeatureBean> source){
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
    public FlFeatureBean copy(FlFeatureBean bean)
    {
        return copy(bean,new int[]{});
    }
    @Override
    public FlFeatureBean copy(FlFeatureBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length){
            fieldList = new int[]{0,1,2,3,4};
        }
        for (int i = 0; i < fieldList.length; ++i) {
            if( bean.isInitialized(fieldList[i]) && !Objects.deepEquals(bean.getValue(fieldList[i]), getValue(fieldList[i]))){
                setValue(fieldList[i], bean.getValue(fieldList[i]));
            }
        }
        return this;
    }
        
    @Override
    public FlFeatureBean copy(FlFeatureBean bean, String... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length){
            copy(bean,(int[])null);
        }else{
            int field;
            for (int i = 0; i < fieldList.length; i++) {
                field = columnIDOf(fieldList[i].trim());
                if(bean.isInitialized(field) && !Objects.deepEquals(bean.getValue(field), getValue(field))){
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
        case FL_FEATURE_ID_MD5: 
            return (T)getMd5();        
        case FL_FEATURE_ID_VERSION: 
            return (T)getVersion();        
        case FL_FEATURE_ID_PERSON_ID: 
            return (T)getPersonId();        
        case FL_FEATURE_ID_FEATURE: 
            return (T)getFeature();        
        case FL_FEATURE_ID_UPDATE_TIME: 
            return (T)getUpdateTime();        
        default:
            return null;
        }
    }

    @Override
    public <T> void setValue(int columnID,T value)
    {
        switch( columnID ) {
        case FL_FEATURE_ID_MD5:
            setMd5((String)value);
            break;
        case FL_FEATURE_ID_VERSION:
            setVersion((String)value);
            break;
        case FL_FEATURE_ID_PERSON_ID:
            setPersonId((Integer)value);
            break;
        case FL_FEATURE_ID_FEATURE:
            setFeature((java.nio.ByteBuffer)value);
            break;
        case FL_FEATURE_ID_UPDATE_TIME:
            setUpdateTime((java.util.Date)value);
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
        int index = FL_FEATURE_FIELDS_LIST.indexOf(column);
        return  index < 0 
            ? FL_FEATURE_JAVA_FIELDS_LIST.indexOf(column)
            : index;
    }
    
    public static String columnNameOf(int columnId){
        try{
            return FL_FEATURE_FIELDS_LIST.get(columnId);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static Class<?> typeOf(int columnId){
        try{
            return FL_FEATURE_FIELD_TYPES[columnId];
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static final Builder builder(){
        return new Builder().reset();
    }
    /** 
     * a builder for FlFeatureBean,the template instance is thread local variable
     * a instance of Builder can be reused.
     */
    public static final class Builder{
        /** FlFeatureBean instance used for template to create new FlFeatureBean instance. */
        static final ThreadLocal<FlFeatureBean> TEMPLATE = new ThreadLocal<FlFeatureBean>(){
            @Override
            protected FlFeatureBean initialValue() {
                return new FlFeatureBean();
            }};
        private Builder() {}
        /** 
         * reset the bean as template 
         * @see FlFeatureBean#reset()
         */
        public Builder reset(){
            TEMPLATE.get().reset();
            return this;
        }
        /** set a bean as template,must not be {@code null} */
        public Builder template(FlFeatureBean bean){
            if(null == bean){
                throw new NullPointerException();
            }
            TEMPLATE.set(bean);
            return this;
        }
        /** return a clone instance of {@link #TEMPLATE}*/
        public FlFeatureBean build(){
            return TEMPLATE.get().clone();
        }
        /** 
         * fill the field : fl_feature.md5
         * @param md5 主键,特征码md5校验码
         * @see FlFeatureBean#getMd5()
         * @see FlFeatureBean#setMd5(String)
         */
        public Builder md5(String md5){
            TEMPLATE.get().setMd5(md5);
            return this;
        }
        /** 
         * fill the field : fl_feature.version
         * @param version 特征码(算法)版本号,用于区分不同人脸识别算法生成的特征数据(允许字母,数字,-,.,_符号)
         * @see FlFeatureBean#getVersion()
         * @see FlFeatureBean#setVersion(String)
         */
        public Builder version(String version){
            TEMPLATE.get().setVersion(version);
            return this;
        }
        /** 
         * fill the field : fl_feature.person_id
         * @param personId 外键,所属用户id
         * @see FlFeatureBean#getPersonId()
         * @see FlFeatureBean#setPersonId(Integer)
         */
        public Builder personId(Integer personId){
            TEMPLATE.get().setPersonId(personId);
            return this;
        }
        /** 
         * fill the field : fl_feature.feature
         * @param feature 二进制特征数据
         * @see FlFeatureBean#getFeature()
         * @see FlFeatureBean#setFeature(java.nio.ByteBuffer)
         */
        public Builder feature(java.nio.ByteBuffer feature){
            TEMPLATE.get().setFeature(feature);
            return this;
        }
        /** 
         * fill the field : fl_feature.update_time
         * @param updateTime 
         * @see FlFeatureBean#getUpdateTime()
         * @see FlFeatureBean#setUpdateTime(java.util.Date)
         */
        public Builder updateTime(java.util.Date updateTime){
            TEMPLATE.get().setUpdateTime(updateTime);
            return this;
        }
    }
}
