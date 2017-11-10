// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: bean.java.vm
// ______________________________________________________
package net.gdface.facelog.db;
import java.io.Serializable;
import java.util.List;
import com.facebook.swift.codec.ThriftStruct;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftField.Requiredness;
/**
 * FeatureBean is a mapping of fl_feature Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 用于验证身份的人脸特征数据表 </li>
 * </ul>
 * @author guyadong
*/
@ThriftStruct
public final class FeatureBean
    implements Serializable,BaseBean<FeatureBean>,Comparable<FeatureBean>,Constant,Cloneable
{
    private static final long serialVersionUID = -2191238184879882524L;
    /** NULL {@link FeatureBean} bean , IMMUTABLE instance */
    public static final FeatureBean NULL = new FeatureBean().asNULL().immutable(Boolean.TRUE);
    /** comments:主键,特征码md5校验码 */
    private String md5;

    /** comments:外键,所属用户id */
    private Integer personId;

    /** comments:二进制特征数据 */
    private java.nio.ByteBuffer feature;

    private java.util.Date updateTime;

    /** flag whether {@code this} can be modified */
    private Boolean _immutable;
    /** columns modified flag */
    private long modified;
    /** columns initialized flag */
    private long initialized;
    private boolean _isNew;        
    /** 
     * set {@code this} as immutable object
     * @return {@code this} 
     */
    public synchronized FeatureBean immutable(Boolean immutable) {
        if(this._immutable != immutable){
            checkMutable();
            this._immutable = immutable;
        }
        return this;
    }
    /**
     * @return {@code true} if {@code this} is a mutable object  
     */
    public boolean mutable(){
        return Boolean.TRUE != this._immutable;
    }
    /**
     * @return {@code this}
     * @throws IllegalStateException if {@code this} is a immutable object 
     */
    private FeatureBean checkMutable(){
        if(Boolean.TRUE == this._immutable)
            throw new IllegalStateException("this is a immutable object");
        return this;
    }
    /**
     * Determines if the current object is new.
     *
     * @return true if the current object is new, false if the object is not new
     */
    @ThriftField(value=1,name="_new",requiredness=Requiredness.REQUIRED)
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
    @ThriftField()
    public void setNew(boolean isNew)
    {
        this._isNew = isNew;
    }
    /**
     * @return the modified status of columns
     */
    @ThriftField(value=2,requiredness=Requiredness.REQUIRED)
    public long getModified(){
        return modified;
    }

    /**
     * @param modified the modified status bit to be assigned to {@link #modified}
     */
    @ThriftField()
    public void setModified(long modified){
        this.modified = modified;
    }
    /**
     * @return the initialized status of columns
     */
    @ThriftField(value=3,requiredness=Requiredness.REQUIRED)
    public long getInitialized(){
        return initialized;
    }

    /**
     * @param initialized the initialized status bit to be assigned to {@link #initialized}
     */
    @ThriftField()
    public void setInitialized(long initialized){
        this.initialized = initialized;
    }
    public static final boolean equal(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }
    public static final <T extends Comparable<T>>boolean compare(T a, T b) {
        return a == b || (a != null && 0==a.compareTo(b));
    }
    public FeatureBean(){
        super();
        reset();
    }
    /**
     * construct a new instance filled with primary keys
     * @param md5 PK# 1 
     */
    public FeatureBean(String md5){
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
    @ThriftField(value=4)
    public String getMd5(){
        return md5;
    }
    /**
     * Setter method for {@link #md5}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to md5
     */
    public void setMd5(String newVal)
    {
        checkMutable();
        if (equal(newVal, md5) && checkMd5Initialized()) {
            return;
        }
        md5 = newVal;

        modified |= FL_FEATURE_ID_MD5_MASK;
        initialized |= FL_FEATURE_ID_MD5_MASK;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "md5")
    public void writeMd5(String newVal){
        checkMutable();
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
    @ThriftField(value=5)
    public Integer getPersonId(){
        return personId;
    }
    /**
     * Setter method for {@link #personId}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(Integer newVal)
    {
        checkMutable();
        if (equal(newVal, personId) && checkPersonIdInitialized()) {
            return;
        }
        personId = newVal;

        modified |= FL_FEATURE_ID_PERSON_ID_MASK;
        initialized |= FL_FEATURE_ID_PERSON_ID_MASK;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "personId")
    public void writePersonId(Integer newVal){
        checkMutable();
        personId = newVal;
    }
    /**
     * Setter method for {@link #personId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(int newVal)
    {
        setPersonId(new Integer(newVal));
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
    @ThriftField(value=6)
    public java.nio.ByteBuffer getFeature(){
        return feature;
    }
    /**
     * Setter method for {@link #feature}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to feature
     */
    public void setFeature(java.nio.ByteBuffer newVal)
    {
        checkMutable();
        if (equal(newVal, feature) && checkFeatureInitialized()) {
            return;
        }
        feature = newVal;

        modified |= FL_FEATURE_ID_FEATURE_MASK;
        initialized |= FL_FEATURE_ID_FEATURE_MASK;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "feature")
    public void writeFeature(java.nio.ByteBuffer newVal){
        checkMutable();
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
     * use Long to represent date type for thrift:swift support 
     * @see #getUpdateTime()
     */
    @ThriftField(name = "updateTime",value = 7)
    public Long readUpdateTime(){
        return null == updateTime ? null:updateTime.getTime();
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
        checkMutable();
        if (equal(newVal, updateTime) && checkUpdateTimeInitialized()) {
            return;
        }
        updateTime = newVal;

        modified |= FL_FEATURE_ID_UPDATE_TIME_MASK;
        initialized |= FL_FEATURE_ID_UPDATE_TIME_MASK;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "updateTime")
    public void writeUpdateTime(Long newVal){
        checkMutable();
        updateTime = null == newVal?null:new java.util.Date(newVal);
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
     * The referenced {@link PersonBean} by {@link #personId} . <br>
     * FOREIGN KEY (person_id) REFERENCES fl_person(id)
     */
    private PersonBean referencedByPersonId;
    /** Getter method for {@link #referencedByPersonId}. */
    public PersonBean getReferencedByPersonId() {
        return this.referencedByPersonId;
    }
    /** Setter method for {@link #referencedByPersonId}. */
    public void setReferencedByPersonId(PersonBean reference) {
        this.referencedByPersonId = reference;
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
        case FL_FEATURE_ID_MD5:
            return checkMd5Modified();
        case FL_FEATURE_ID_PERSON_ID:
            return checkPersonIdModified();
        case FL_FEATURE_ID_FEATURE:
            return checkFeatureModified();
        case FL_FEATURE_ID_UPDATE_TIME:
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
        case FL_FEATURE_ID_MD5:
            return checkMd5Initialized();
        case FL_FEATURE_ID_PERSON_ID:
            return checkPersonIdInitialized();
        case FL_FEATURE_ID_FEATURE:
            return checkFeatureInitialized();
        case FL_FEATURE_ID_UPDATE_TIME:
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
        checkMutable();
        modified = 0L;
    }
    /**
     * Resets the primary keys ( {@link #md5} ) modification status to 'not modified'.
     */
    public void resetPrimaryKeysModified()
    {
        modified &= (~(FL_FEATURE_ID_MD5_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_FEATURE_ID_PERSON_ID_MASK |
            FL_FEATURE_ID_FEATURE_MASK |
            FL_FEATURE_ID_UPDATE_TIME_MASK));
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
        this.md5 = null;
        this.personId = null;
        this.feature = null;
        this.updateTime = null/* DEFAULT:'CURRENT_TIMESTAMP'*/;
        this._isNew = true;
        this.modified = 0L;
        this.initialized = 0L;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FeatureBean)) {
            return false;
        }

        FeatureBean obj = (FeatureBean) object;
        return new EqualsBuilder()
            .append(getMd5(), obj.getMd5())
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
        // only output initialized field
        StringBuilder builder = new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[");
        int count = 0;        
        if(checkMd5Initialized()){
            if(count++ >0)builder.append(",");
            builder.append("md5=").append(getMd5());
        }
        if(checkPersonIdInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("person_id=").append(getPersonId());
        }
        if(checkFeatureInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("feature=").append(getFeature());
        }
        if(checkUpdateTimeInitialized()){
            if(count++ >0)builder.append(",");
            builder.append("update_time=").append(getUpdateTime());
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int compareTo(FeatureBean object){
        return new CompareToBuilder()
            .append(getMd5(), object.getMd5())
            .append(getPersonId(), object.getPersonId())
            .append(getFeature(), object.getFeature())
            .append(getUpdateTime(), object.getUpdateTime())
            .toComparison();
    }
    @Override
    public FeatureBean clone(){
        try {
            return (FeatureBean) super.clone();
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
    public FeatureBean asNULL()
    {   
        checkMutable();
        
        setMd5(null);
        setPersonId(null);
        setFeature(null);
        setUpdateTime(null);
        isNew(true);
        resetInitialized();
        resetIsModified();
        return this;
    }
    /**
     * check whether this bean is a NULL bean 
     * @return {@code true} if {@link {@link #initialized} be set to zero
     * @see #asNULL()
     */
    public boolean beNULL(){
        return 0L == getInitialized();
    }
    /** 
     * @return {@code source} replace {@code null} element with null instance({@link #NULL})
     */
    public static final List<FeatureBean> replaceNull(List<FeatureBean> source){
        if(null != source){
            for(int i = 0,end_i = source.size();i<end_i;++i){
                if(null == source.get(i))source.set(i, NULL);
            }
        }
        return source;
    }
    /** 
     * @return replace null instance element with {@code null}
     * @see {@link #beNULL()} 
     */
    public static final List<FeatureBean> replaceNullInstance(List<FeatureBean> source){
        if(null != source){
            for(int i = 0,end_i = source.size();i<end_i;++i){
                if(source.get(i).beNULL())source.set(i, null);
            }
        }
        return source;
    }
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @return always {@code bean}
     */
    public FeatureBean copy(FeatureBean bean)
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
    public FeatureBean copy(FeatureBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length)
            for (int i = 0; i < 4; ++i) {
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
    public FeatureBean copy(FeatureBean bean, String... fieldList)
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
        case FL_FEATURE_ID_MD5: 
            return (T)getMd5();        
        case FL_FEATURE_ID_PERSON_ID: 
            return (T)getPersonId();        
        case FL_FEATURE_ID_FEATURE: 
            return (T)getFeature();        
        case FL_FEATURE_ID_UPDATE_TIME: 
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
        case FL_FEATURE_ID_MD5:        
            setMd5((String)value);
        case FL_FEATURE_ID_PERSON_ID:        
            setPersonId((Integer)value);
        case FL_FEATURE_ID_FEATURE:        
            setFeature((java.nio.ByteBuffer)value);
        case FL_FEATURE_ID_UPDATE_TIME:        
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
        int index = FL_FEATURE_FIELDS_LIST.indexOf(column);
        if( 0 > index ) 
            index = FL_FEATURE_JAVA_FIELDS_LIST.indexOf(column);
        return index;    
    }
    public static final Builder builder(){
        return new Builder();
    }
    /** 
     * a builder for FeatureBean,the template instance is thread local variable
     * a instance of Builder can be reused.
     */
    public static final class Builder{
        /** FeatureBean instance used for template to create new FeatureBean instance. */
        static final ThreadLocal<FeatureBean> template = new ThreadLocal<FeatureBean>(){
            @Override
            protected FeatureBean initialValue() {
                return new FeatureBean();
            }};
        private Builder() {}
        /** 
         * reset the bean as template 
         * @see FeatureBean#reset()
         */
        public Builder reset(){
            template.get().reset();
            return this;
        }
        /** 
         * set as a immutable object
         * @see FeatureBean#immutable(Boolean)
         */
        public Builder immutable(){
            template.get().immutable(Boolean.TRUE);
            return this;
        }
        /** set a bean as template,must not be {@code null} */
        public Builder template(FeatureBean bean){
            if(null == bean)
                throw new NullPointerException();
            template.set(bean);
            return this;
        }
        /** return a clone instance of {@link #template}*/
        public FeatureBean build(){
            return template.get().clone();
        }
        /** 
         * fill the field : fl_feature.md5
         * @param md5 主键,特征码md5校验码
         * @see {@link FeatureBean#getMd5()}
         * @see {@link FeatureBean#setMd5(String)}
         */
        public Builder md5(String md5){
            template.get().setMd5(md5);
            return this;
        }
        /** 
         * fill the field : fl_feature.person_id
         * @param personId 外键,所属用户id
         * @see {@link FeatureBean#getPersonId()}
         * @see {@link FeatureBean#setPersonId(Integer)}
         */
        public Builder personId(Integer personId){
            template.get().setPersonId(personId);
            return this;
        }
        /** 
         * fill the field : fl_feature.feature
         * @param feature 二进制特征数据
         * @see {@link FeatureBean#getFeature()}
         * @see {@link FeatureBean#setFeature(java.nio.ByteBuffer)}
         */
        public Builder feature(java.nio.ByteBuffer feature){
            template.get().setFeature(feature);
            return this;
        }
        /** 
         * fill the field : fl_feature.update_time
         * @param updateTime 
         * @see {@link FeatureBean#getUpdateTime()}
         * @see {@link FeatureBean#setUpdateTime(java.util.Date)}
         */
        public Builder updateTime(java.util.Date updateTime){
            template.get().setUpdateTime(updateTime);
            return this;
        }
    }
}
