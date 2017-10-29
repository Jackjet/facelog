// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: bean.java.vm
// ______________________________________________________
package net.gdface.facelog.dborm.person;
import java.io.Serializable;
import net.gdface.facelog.dborm.Constant;
import net.gdface.facelog.dborm.BaseBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;
/**
 * FlJunctionPersonGroupBean is a mapping of fl_junction_person_group Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 用户组信息关联表 </li>
 * </ul>
 * @author guyadong
*/
public  class FlJunctionPersonGroupBean
    implements Serializable,BaseBean<FlJunctionPersonGroupBean>,Comparable<FlJunctionPersonGroupBean>,Constant,Cloneable
{
    private static final long serialVersionUID = 243061864781994271L;
    
    /** comments:外键,设备id */
    private Integer personId;

    /** comments:外键,设备组id */
    private Integer groupId;

    private java.util.Date createTime/* DEFAULT:'CURRENT_TIMESTAMP'*/;

    /** columns modified flag */
    private long modified = 0L;
    /** columns initialized flag */
    private long initialized = 0L;
    private boolean _isNew = true;
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
    public FlJunctionPersonGroupBean(){
        super();
    }
    /**
     * Getter method for {@link #personId}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_junction_person_group.person_id</li>
     * <li> foreign key: fl_person.id</li>
     * <li>comments: 外键,设备id</li>
     * <li>NOT NULL</li>
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
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value (NOT NULL) to be assigned to personId
     */
    public void setPersonId(Integer newVal)
    {
        if ((newVal != null && personId != null && (newVal.compareTo(personId) == 0)) ||
            (newVal == null && personId == null && checkPersonIdInitialized())) {
            return;
        }
        personId = newVal;

        modified |= FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID_MASK;
        initialized |= FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID_MASK;
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
        return 0L !=  (modified & FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID_MASK);
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
        return 0L !=  (initialized & FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID_MASK);
    }
    /**
     * Getter method for {@link #groupId}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_junction_person_group.group_id</li>
     * <li> foreign key: fl_person_group.id</li>
     * <li>comments: 外键,设备组id</li>
     * <li>NOT NULL</li>
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
     * @param newVal the new value (NOT NULL) to be assigned to groupId
     */
    public void setGroupId(Integer newVal)
    {
        if ((newVal != null && groupId != null && (newVal.compareTo(groupId) == 0)) ||
            (newVal == null && groupId == null && checkGroupIdInitialized())) {
            return;
        }
        groupId = newVal;

        modified |= FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID_MASK;
        initialized |= FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID_MASK;
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
        return 0L !=  (modified & FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID_MASK);
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
        return 0L !=  (initialized & FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID_MASK);
    }
    /**
     * Getter method for {@link #createTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_junction_person_group.create_time</li>
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
     * @param newVal the new value (NOT NULL) to be assigned to createTime
     */
    public void setCreateTime(java.util.Date newVal)
    {
        if ((newVal != null && createTime != null && (newVal.compareTo(createTime) == 0)) ||
            (newVal == null && createTime == null && checkCreateTimeInitialized())) {
            return;
        }
        createTime = newVal;

        modified |= FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME_MASK;
        initialized |= FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME_MASK;
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
        return 0L !=  (modified & FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link FlPersonBean} by {@link #personId} . <br>
     * FOREIGN KEY (person_id) REFERENCES fl_person(id)
     */
    private FlPersonBean referencedByPersonId;
    /** Getter method for {@link #referencedByPersonId}. */
    public FlPersonBean getReferencedByPersonId() {
        return this.referencedByPersonId;
    }
    /** Setter method for {@link #referencedByPersonId}. */
    public void setReferencedByPersonId(FlPersonBean reference) {
        this.referencedByPersonId = reference;
    }
    /** 
     * The referenced {@link FlPersonGroupBean} by {@link #groupId} . <br>
     * FOREIGN KEY (group_id) REFERENCES fl_person_group(id)
     */
    private FlPersonGroupBean referencedByGroupId;
    /** Getter method for {@link #referencedByGroupId}. */
    public FlPersonGroupBean getReferencedByGroupId() {
        return this.referencedByGroupId;
    }
    /** Setter method for {@link #referencedByGroupId}. */
    public void setReferencedByGroupId(FlPersonGroupBean reference) {
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
        case FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID:
            return checkPersonIdModified();
        case FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID:
            return checkGroupIdModified();
        case FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME:
            return checkCreateTimeModified();
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
        case FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID:
            return checkPersonIdInitialized();
        case FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID:
            return checkGroupIdInitialized();
        case FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME:
            return checkCreateTimeInitialized();
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
     * Resets the primary keys ( {@link #personId},{@link #groupId} ) modification status to 'not modified'.
     */
    public void resetPrimaryKeysModified()
    {
        modified &= (~(FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID_MASK |
            FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID_MASK));
    }
    /**
     * Resets columns modification status except primary keys to 'not modified'.
     */
    public void resetModifiedExceptPrimaryKeys()
    {
        modified &= (~(FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME_MASK));
    }
    /**
     * Resets the object initialization status to 'not initialized'.
     */
    private void resetInitialized()
    {
        initialized = 0L;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FlJunctionPersonGroupBean)) {
            return false;
        }

        FlJunctionPersonGroupBean obj = (FlJunctionPersonGroupBean) object;
        return new EqualsBuilder()
            .append(getPersonId(), obj.getPersonId())
            .append(getGroupId(), obj.getGroupId())
            .append(getCreateTime(), obj.getCreateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getPersonId())
            .append(getGroupId())
            .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tperson_id=").append(getPersonId()).append("\n")
            .append("\tgroup_id=").append(getGroupId()).append("\n")
            .append("\tcreate_time=").append(getCreateTime()).append("\n")
            .append("]\n")
            .toString();
    }

    @Override
    public int compareTo(FlJunctionPersonGroupBean object){
        return new CompareToBuilder()
            .append(getPersonId(), object.getPersonId())
            .append(getGroupId(), object.getGroupId())
            .append(getCreateTime(), object.getCreateTime())
            .toComparison();
    }
    @Override
    public FlJunctionPersonGroupBean clone(){
        try {
            return (FlJunctionPersonGroupBean) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlJunctionPersonGroupBean clean()
    {
        setPersonId(null);
        setGroupId(null);
        setCreateTime(null);
        isNew(true);
        resetInitialized();
        resetIsModified();
        return this;
    }
    
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column id list to copy into the current bean
     */
    public void copy(FlJunctionPersonGroupBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length)
            for (int i = 0; i < 3; ++i) {
                if( bean.isInitialized(i))
                    setValue(i, bean.getValue(i));
            }
        else
            for (int i = 0; i < fieldList.length; ++i) {
                if( bean.isInitialized(fieldList[i]))
                    setValue(fieldList[i], bean.getValue(fieldList[i]));
            }
    }
        
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     */
    public void copy(FlJunctionPersonGroupBean bean, String... fieldList)
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
    }

    /**
     * return a object representation of the given column id
     */
    @SuppressWarnings("unchecked")
    public <T>T getValue(int columnID)
    {
        switch( columnID ){
        case FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID: 
            return (T)getPersonId();        
        case FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID: 
            return (T)getGroupId();        
        case FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME: 
            return (T)getCreateTime();        
        }
        return null;
    }

    /**
     * set a value representation of the given column id
     */
    public <T> void setValue(int columnID,T value)
    {
        switch( columnID ) {
        case FL_JUNCTION_PERSON_GROUP_ID_PERSON_ID:        
            setPersonId((Integer)value);
        case FL_JUNCTION_PERSON_GROUP_ID_GROUP_ID:        
            setGroupId((Integer)value);
        case FL_JUNCTION_PERSON_GROUP_ID_CREATE_TIME:        
            setCreateTime((java.util.Date)value);
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
        int index = FL_JUNCTION_PERSON_GROUP_FIELDS_LIST.indexOf(column);
        if( 0 > index ) 
            index = FL_JUNCTION_PERSON_GROUP_JAVA_FIELDS_LIST.indexOf(column);
        return index;    
    }
}
