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
import java.util.Objects;

import com.facebook.swift.codec.ThriftStruct;
import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftField.Requiredness;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * StoreBean is a mapping of fl_store Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 二进制数据存储表 </li>
 * </ul>
 * @author guyadong
*/
@ThriftStruct
@ApiModel(description="二进制数据存储表")
public final class StoreBean
    implements Serializable,BaseBean<StoreBean>,Comparable<StoreBean>,Constant,Cloneable
{
    private static final long serialVersionUID = -1684185165668832146L;
    /** NULL {@link StoreBean} bean , IMMUTABLE instance */
    public static final StoreBean NULL = new StoreBean().asNULL().asImmutable();
    /** comments:主键,md5检验码 */
    @ApiModelProperty(value = "主键,md5检验码" ,required=true ,dataType="String")
    private String md5;

    /** comments:编码类型,GBK,UTF8... */
    @ApiModelProperty(value = "编码类型,GBK,UTF8..."  ,dataType="String")
    private String encoding;

    /** comments:二进制数据(最大16MB) */
    @ApiModelProperty(value = "二进制数据(最大16MB)"  ,dataType="ByteBuffer")
    private java.nio.ByteBuffer data;

    /** flag whether {@code this} can be modified */
    private Boolean immutable;
    /** columns modified flag */
    @ApiModelProperty(value="columns modified flag",dataType="int",required=true)
    private int modified;
    /** columns initialized flag */
    @ApiModelProperty(value="columns initialized flag",dataType="int",required=true)
    private int initialized;
    /** new record flag  */
    @ApiModelProperty(value="new record flag",dataType="boolean",required=true)
    private boolean isNew;        
    /** 
     * set immutable status
     * @return {@code this} 
     */
    private StoreBean immutable(Boolean immutable) {
        this.immutable = immutable;
        return this;
    }
    /** 
     * set {@code this} as immutable object
     * @return {@code this} 
     */
    public StoreBean asImmutable() {
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
    private StoreBean checkMutable(){
        if(!mutable()){
            throw new IllegalStateException("this is a immutable object");
        }
        return this;
    }
    /**
     * @return return a new mutable copy of this object.
     */
    public StoreBean cloneMutable(){
        return clone().immutable(null);
    }
    @ThriftField(value=1,name="_new",requiredness=Requiredness.REQUIRED)
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
    @ThriftField()
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }
    /**
     * @return the modified status of columns
     */
    @ThriftField(value=2,requiredness=Requiredness.REQUIRED)
    public int getModified(){
        return modified;
    }

    /**
     * @param modified the modified status bit to be assigned to {@link #modified}
     */
    @ThriftField()
    public void setModified(int modified){
        this.modified = modified;
    }
    /**
     * @return the initialized status of columns
     */
    @ThriftField(value=3,requiredness=Requiredness.REQUIRED)
    public int getInitialized(){
        return initialized;
    }

    /**
     * @param initialized the initialized status bit to be assigned to {@link #initialized}
     */
    @ThriftField()
    public void setInitialized(int initialized){
        this.initialized = initialized;
    }
    protected static final <T extends Comparable<T>>boolean equals(T a, T b) {
        return a == b || (a != null && 0==a.compareTo(b));
    }
    public StoreBean(){
        super();
        reset();
    }
    /**
     * construct a new instance filled with primary keys
     * @param md5 PK# 1 
     */
    public StoreBean(String md5){
        this();
        setMd5(md5);
    }
    /**
     * Getter method for {@link #md5}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_store.md5</li>
     * <li>comments: 主键,md5检验码</li>
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
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value( NOT NULL) to be assigned to md5
     */
    public void setMd5(String newVal)
    {
        checkMutable();

        modified |= FL_STORE_ID_MD5_MASK;
        initialized |= FL_STORE_ID_MD5_MASK;

        if (Objects.equals(newVal, md5)) {
            return;
        }
        md5 = newVal;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified} and {@link #initialized}<br>
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
        return 0L !=  (modified & FL_STORE_ID_MD5_MASK);
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
        return 0L !=  (initialized & FL_STORE_ID_MD5_MASK);
    }
    /**
     * Getter method for {@link #encoding}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_store.encoding</li>
     * <li>comments: 编码类型,GBK,UTF8...</li>
     * <li>column size: 16</li>
     * <li>JDBC type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of encoding
     */
    @ThriftField(value=5)
    public String getEncoding(){
        return encoding;
    }
    /**
     * Setter method for {@link #encoding}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to encoding
     */
    public void setEncoding(String newVal)
    {
        checkMutable();

        modified |= FL_STORE_ID_ENCODING_MASK;
        initialized |= FL_STORE_ID_ENCODING_MASK;

        if (Objects.equals(newVal, encoding)) {
            return;
        }
        encoding = newVal;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified} and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "encoding")
    public void writeEncoding(String newVal){
        checkMutable();
        encoding = newVal;
    }
    /**
     * Determines if the encoding has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkEncodingModified()
    {
        return 0L !=  (modified & FL_STORE_ID_ENCODING_MASK);
    }

    /**
     * Determines if the encoding has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkEncodingInitialized()
    {
        return 0L !=  (initialized & FL_STORE_ID_ENCODING_MASK);
    }
    /**
     * Getter method for {@link #data}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_store.data</li>
     * <li>comments: 二进制数据(最大16MB)</li>
     * <li>column size: 16777215</li>
     * <li>JDBC type returned by the driver: Types.LONGVARBINARY</li>
     * </ul>
     *
     * @return the value of data
     */
    @ThriftField(value=6)
    public java.nio.ByteBuffer getData(){
        return data;
    }
    /**
     * Setter method for {@link #data}.<br>
     * The new value is set only if equals() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to data
     */
    public void setData(java.nio.ByteBuffer newVal)
    {
        checkMutable();

        modified |= FL_STORE_ID_DATA_MASK;
        initialized |= FL_STORE_ID_DATA_MASK;

        if (Objects.equals(newVal, data)) {
            return;
        }
        data = newVal;
    }
    /** 
     * setter for thrift:swift support<br>
     * without modification for {@link #modified} and {@link #initialized}<br>
     * <b>NOTE:</b>DO NOT use the method in your code
     */
    @ThriftField(name = "data")
    public void writeData(java.nio.ByteBuffer newVal){
        checkMutable();
        data = newVal;
    }
    /**
     * Determines if the data has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkDataModified()
    {
        return 0L !=  (modified & FL_STORE_ID_DATA_MASK);
    }

    /**
     * Determines if the data has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkDataInitialized()
    {
        return 0L !=  (initialized & FL_STORE_ID_DATA_MASK);
    }

    @Override
    public boolean isModified()
    {
        return 0 != modified;
    }
  
    @Override
    public boolean isModified(int columnID){
        switch ( columnID ){
        case FL_STORE_ID_MD5:
            return checkMd5Modified();
        case FL_STORE_ID_ENCODING:
            return checkEncodingModified();
        case FL_STORE_ID_DATA:
            return checkDataModified();
        default:
            return false;
        }        
    }

    @Override
    public boolean isInitialized(int columnID){
        switch(columnID) {
        case FL_STORE_ID_MD5:
            return checkMd5Initialized();
        case FL_STORE_ID_ENCODING:
            return checkEncodingInitialized();
        case FL_STORE_ID_DATA:
            return checkDataInitialized();
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
        modified &= (~(FL_STORE_ID_MD5_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_STORE_ID_ENCODING_MASK |
            FL_STORE_ID_DATA_MASK));
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
        this.encoding = null;
        this.data = null;
        this.isNew = true;
        this.modified = 0;
        this.initialized = 0;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof StoreBean)) {
            return false;
        }

        StoreBean obj = (StoreBean) object;
        return new EqualsBuilder()
            .append(getMd5(), obj.getMd5())
            .append(getEncoding(), obj.getEncoding())
            .append(getData(), obj.getData())
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
        if(checkEncodingInitialized()){
            if(!notNull || null != getEncoding()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("encoding=");
                append(builder,fullIfStringOrBytes,getEncoding());
            }
        }
        if(checkDataInitialized()){
            if(!notNull || null != getData()){
                if(count++ >0){
                    builder.append(",");
                }
                builder.append("data=");
                append(builder,fullIfStringOrBytes,getData());
            }
        }
        builder.append("]");
        return builder.toString();
    }
    @Override
    public int compareTo(StoreBean object){
        return new CompareToBuilder()
            .append(getMd5(), object.getMd5())
            .append(getEncoding(), object.getEncoding())
            .append(getData(), object.getData())
            .toComparison();
    }
    @Override
    public StoreBean clone(){
        try {
            return (StoreBean) super.clone();
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
    public StoreBean asNULL()
    {   
        checkMutable();
        
        setMd5((String)null);
        setEncoding((String)null);
        setData((java.nio.ByteBuffer)null);
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
    public static final List<StoreBean> replaceNull(List<StoreBean> source){
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
    public static final List<StoreBean> replaceNullInstance(List<StoreBean> source){
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
    public StoreBean copy(StoreBean bean)
    {
        return copy(bean,new int[]{});
    }
    @Override
    public StoreBean copy(StoreBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length){
            fieldList = new int[]{0,1,2};
        }
        for (int i = 0; i < fieldList.length; ++i) {
            if( bean.isInitialized(fieldList[i]) && !Objects.deepEquals(bean.getValue(fieldList[i]), getValue(fieldList[i]))){
                setValue(fieldList[i], bean.getValue(fieldList[i]));
            }
        }
        return this;
    }
        
    @Override
    public StoreBean copy(StoreBean bean, String... fieldList)
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
        case FL_STORE_ID_MD5: 
            return (T)getMd5();        
        case FL_STORE_ID_ENCODING: 
            return (T)getEncoding();        
        case FL_STORE_ID_DATA: 
            return (T)getData();        
        default:
            return null;
        }
    }

    @Override
    public <T> void setValue(int columnID,T value)
    {
        switch( columnID ) {
        case FL_STORE_ID_MD5:
            setMd5((String)value);
            break;
        case FL_STORE_ID_ENCODING:
            setEncoding((String)value);
            break;
        case FL_STORE_ID_DATA:
            setData((java.nio.ByteBuffer)value);
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
        int index = FL_STORE_FIELDS_LIST.indexOf(column);
        return  index < 0 
            ? FL_STORE_JAVA_FIELDS_LIST.indexOf(column)
            : index;
    }
    
    public static String columnNameOf(int columnId){
        try{
            return FL_STORE_FIELDS_LIST.get(columnId);
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static Class<?> typeOf(int columnId){
        try{
            return FL_STORE_FIELD_TYPES[columnId];
        } catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public static final Builder builder(){
        return new Builder().reset();
    }
    /** 
     * a builder for StoreBean,the template instance is thread local variable
     * a instance of Builder can be reused.
     */
    public static final class Builder{
        /** StoreBean instance used for template to create new StoreBean instance. */
        static final ThreadLocal<StoreBean> TEMPLATE = new ThreadLocal<StoreBean>(){
            @Override
            protected StoreBean initialValue() {
                return new StoreBean();
            }};
        private Builder() {}
        /** 
         * reset the bean as template 
         * @see StoreBean#reset()
         */
        public Builder reset(){
            TEMPLATE.get().reset();
            return this;
        }
        /** set a bean as template,must not be {@code null} */
        public Builder template(StoreBean bean){
            if(null == bean){
                throw new NullPointerException();
            }
            TEMPLATE.set(bean);
            return this;
        }
        /** return a clone instance of {@link #TEMPLATE}*/
        public StoreBean build(){
            return TEMPLATE.get().clone();
        }
        /** 
         * fill the field : fl_store.md5
         * @param md5 主键,md5检验码
         * @see StoreBean#getMd5()
         * @see StoreBean#setMd5(String)
         */
        public Builder md5(String md5){
            TEMPLATE.get().setMd5(md5);
            return this;
        }
        /** 
         * fill the field : fl_store.encoding
         * @param encoding 编码类型,GBK,UTF8...
         * @see StoreBean#getEncoding()
         * @see StoreBean#setEncoding(String)
         */
        public Builder encoding(String encoding){
            TEMPLATE.get().setEncoding(encoding);
            return this;
        }
        /** 
         * fill the field : fl_store.data
         * @param data 二进制数据(最大16MB)
         * @see StoreBean#getData()
         * @see StoreBean#setData(java.nio.ByteBuffer)
         */
        public Builder data(java.nio.ByteBuffer data){
            TEMPLATE.get().setData(data);
            return this;
        }
    }
}
