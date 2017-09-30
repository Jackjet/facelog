// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db;
import java.io.Serializable;
/**
 * PersonBean is a mapping of fl_person Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 人员基本描述信息 </li>
 * </ul>
 * @author guyadong
*/
@com.facebook.swift.codec.ThriftStruct
public class PersonBean
    implements Serializable,BaseBean<PersonBean>,Comparable<PersonBean>,Constant,Cloneable
{
    private static final long serialVersionUID = 7741617836285025804L;
    
    /** comments:用户id */
    private Integer id;

    /** comments:用户所属组id */
    private Integer groupId;

    /** comments:姓名 */
    private String name;

    /** comments:性别,0:女,1:男 */
    private Integer sex;

    /** comments:出生日期 */
    private java.util.Date birthdate;

    /** comments:证件类型,0:未知,1:身份证,2:护照,3:台胞证,4:港澳通行证,5:军官证,6:外国人居留证,7:员工卡,8:其他 */
    private Integer papersType;

    /** comments:证件号码 */
    private String papersNum;

    /** comments:用户默认照片(证件照,标准照)的md5校验码,外键 */
    private String imageMd5;

    /** comments:验证有效期限(超过期限不能通过验证),为NULL永久有效 */
    private java.util.Date expiryDate;

    private java.util.Date createTime;

    private java.util.Date updateTime;

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
    @com.facebook.swift.codec.ThriftField(1)
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
    @com.facebook.swift.codec.ThriftField
    public void setNew(boolean isNew)
    {
        this._isNew = isNew;
    }
    /**
     * @return the modified status of columns
     */
    @com.facebook.swift.codec.ThriftField(2)
    public long getModified(){
        return modified;
    }

    /**
     * @param modified the modified status bit to be assigned to {@link #modified}
     */
    @com.facebook.swift.codec.ThriftField
    public void setModified(long modified){
        this.modified = modified;
    }
    /**
     * @return the initialized status of columns
     */
    @com.facebook.swift.codec.ThriftField(3)
    public long getInitialized(){
        return initialized;
    }

    /**
     * @param initialized the initialized status bit to be assigned to {@link #initialized}
     */
    @com.facebook.swift.codec.ThriftField
    public void setInitialized(long initialized){
        this.initialized = initialized;
    }
    public PersonBean(){
        super();
    }
    /**
     * Getter method for {@link #id}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.id</li>
     * <li> imported key: fl_feature.person_id</li>
     * <li> imported key: fl_log.person_id</li>
     * <li>comments: 用户id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of id
     */
    @com.facebook.swift.codec.ThriftField(4)
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
    @com.facebook.swift.codec.ThriftField
    public void setId(Integer newVal)
    {
        if ((newVal != null && id != null && (newVal.compareTo(id) == 0)) ||
            (newVal == null && id == null && checkIdInitialized())) {
            return;
        }
        id = newVal;

        modified |= FL_PERSON_ID_ID_MASK;
        initialized |= FL_PERSON_ID_ID_MASK;
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
        return 0L !=  (modified & FL_PERSON_ID_ID_MASK);
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
        return 0L !=  (initialized & FL_PERSON_ID_ID_MASK);
    }
    /**
     * Getter method for {@link #groupId}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.group_id</li>
     * <li>comments: 用户所属组id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of groupId
     */
    @com.facebook.swift.codec.ThriftField(5)
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
    @com.facebook.swift.codec.ThriftField
    public void setGroupId(Integer newVal)
    {
        if ((newVal != null && groupId != null && (newVal.compareTo(groupId) == 0)) ||
            (newVal == null && groupId == null && checkGroupIdInitialized())) {
            return;
        }
        groupId = newVal;

        modified |= FL_PERSON_ID_GROUP_ID_MASK;
        initialized |= FL_PERSON_ID_GROUP_ID_MASK;
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
        return 0L !=  (modified & FL_PERSON_ID_GROUP_ID_MASK);
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
        return 0L !=  (initialized & FL_PERSON_ID_GROUP_ID_MASK);
    }
    /**
     * Getter method for {@link #name}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.name</li>
     * <li>comments: 姓名</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of name
     */
    @com.facebook.swift.codec.ThriftField(6)
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
    @com.facebook.swift.codec.ThriftField
    public void setName(String newVal)
    {
        if ((newVal != null && name != null && (newVal.compareTo(name) == 0)) ||
            (newVal == null && name == null && checkNameInitialized())) {
            return;
        }
        name = newVal;

        modified |= FL_PERSON_ID_NAME_MASK;
        initialized |= FL_PERSON_ID_NAME_MASK;
    }

    /**
     * Determines if the name has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkNameModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_NAME_MASK);
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
        return 0L !=  (initialized & FL_PERSON_ID_NAME_MASK);
    }
    /**
     * Getter method for {@link #sex}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.sex</li>
     * <li>comments: 性别,0:女,1:男</li>
     * <li>column size: 3</li>
     * <li>jdbc type returned by the driver: Types.TINYINT</li>
     * </ul>
     *
     * @return the value of sex
     */
    @com.facebook.swift.codec.ThriftField(7)
    public Integer getSex(){
        return sex;
    }
    /**
     * Setter method for {@link #sex}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to sex
     */
    @com.facebook.swift.codec.ThriftField
    public void setSex(Integer newVal)
    {
        if ((newVal != null && sex != null && (newVal.compareTo(sex) == 0)) ||
            (newVal == null && sex == null && checkSexInitialized())) {
            return;
        }
        sex = newVal;

        modified |= FL_PERSON_ID_SEX_MASK;
        initialized |= FL_PERSON_ID_SEX_MASK;
    }

    /**
     * Setter method for {@link #sex}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to sex
     */
    public void setSex(int newVal)
    {
        setSex(new Integer(newVal));
    }
    /**
     * Determines if the sex has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkSexModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_SEX_MASK);
    }

    /**
     * Determines if the sex has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkSexInitialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_SEX_MASK);
    }
    /**
     * Getter method for {@link #birthdate}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.birthdate</li>
     * <li>comments: 出生日期</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.DATE</li>
     * </ul>
     *
     * @return the value of birthdate
     */
    @com.facebook.swift.codec.ThriftField(8)
    public java.util.Date getBirthdate(){
        return birthdate;
    }
    /**
     * Setter method for {@link #birthdate}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to birthdate
     */
    @com.facebook.swift.codec.ThriftField
    public void setBirthdate(java.util.Date newVal)
    {
        if ((newVal != null && birthdate != null && (newVal.compareTo(birthdate) == 0)) ||
            (newVal == null && birthdate == null && checkBirthdateInitialized())) {
            return;
        }
        birthdate = newVal;

        modified |= FL_PERSON_ID_BIRTHDATE_MASK;
        initialized |= FL_PERSON_ID_BIRTHDATE_MASK;
    }

    /**
     * Setter method for {@link #birthdate}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to birthdate
     */
    public void setBirthdate(long newVal)
    {
        setBirthdate(new java.util.Date(newVal));
    }
    /**
     * Determines if the birthdate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkBirthdateModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_BIRTHDATE_MASK);
    }

    /**
     * Determines if the birthdate has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkBirthdateInitialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_BIRTHDATE_MASK);
    }
    /**
     * Getter method for {@link #papersType}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.papers_type</li>
     * <li>comments: 证件类型,0:未知,1:身份证,2:护照,3:台胞证,4:港澳通行证,5:军官证,6:外国人居留证,7:员工卡,8:其他</li>
     * <li>column size: 3</li>
     * <li>jdbc type returned by the driver: Types.TINYINT</li>
     * </ul>
     *
     * @return the value of papersType
     */
    @com.facebook.swift.codec.ThriftField(9)
    public Integer getPapersType(){
        return papersType;
    }
    /**
     * Setter method for {@link #papersType}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to papersType
     */
    @com.facebook.swift.codec.ThriftField
    public void setPapersType(Integer newVal)
    {
        if ((newVal != null && papersType != null && (newVal.compareTo(papersType) == 0)) ||
            (newVal == null && papersType == null && checkPapersTypeInitialized())) {
            return;
        }
        papersType = newVal;

        modified |= FL_PERSON_ID_PAPERS_TYPE_MASK;
        initialized |= FL_PERSON_ID_PAPERS_TYPE_MASK;
    }

    /**
     * Setter method for {@link #papersType}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to papersType
     */
    public void setPapersType(int newVal)
    {
        setPapersType(new Integer(newVal));
    }
    /**
     * Determines if the papersType has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkPapersTypeModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_PAPERS_TYPE_MASK);
    }

    /**
     * Determines if the papersType has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkPapersTypeInitialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_PAPERS_TYPE_MASK);
    }
    /**
     * Getter method for {@link #papersNum}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.papers_num</li>
     * <li>comments: 证件号码</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of papersNum
     */
    @com.facebook.swift.codec.ThriftField(10)
    public String getPapersNum(){
        return papersNum;
    }
    /**
     * Setter method for {@link #papersNum}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to papersNum
     */
    @com.facebook.swift.codec.ThriftField
    public void setPapersNum(String newVal)
    {
        if ((newVal != null && papersNum != null && (newVal.compareTo(papersNum) == 0)) ||
            (newVal == null && papersNum == null && checkPapersNumInitialized())) {
            return;
        }
        papersNum = newVal;

        modified |= FL_PERSON_ID_PAPERS_NUM_MASK;
        initialized |= FL_PERSON_ID_PAPERS_NUM_MASK;
    }

    /**
     * Determines if the papersNum has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkPapersNumModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_PAPERS_NUM_MASK);
    }

    /**
     * Determines if the papersNum has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkPapersNumInitialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_PAPERS_NUM_MASK);
    }
    /**
     * Getter method for {@link #imageMd5}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.image_md5</li>
     * <li> foreign key: fl_image.md5</li>
     * <li>comments: 用户默认照片(证件照,标准照)的md5校验码,外键</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.CHAR</li>
     * </ul>
     *
     * @return the value of imageMd5
     */
    @com.facebook.swift.codec.ThriftField(11)
    public String getImageMd5(){
        return imageMd5;
    }
    /**
     * Setter method for {@link #imageMd5}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to imageMd5
     */
    @com.facebook.swift.codec.ThriftField
    public void setImageMd5(String newVal)
    {
        if ((newVal != null && imageMd5 != null && (newVal.compareTo(imageMd5) == 0)) ||
            (newVal == null && imageMd5 == null && checkImageMd5Initialized())) {
            return;
        }
        imageMd5 = newVal;

        modified |= FL_PERSON_ID_IMAGE_MD5_MASK;
        initialized |= FL_PERSON_ID_IMAGE_MD5_MASK;
    }

    /**
     * Determines if the imageMd5 has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkImageMd5Modified()
    {
        return 0L !=  (modified & FL_PERSON_ID_IMAGE_MD5_MASK);
    }

    /**
     * Determines if the imageMd5 has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkImageMd5Initialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_IMAGE_MD5_MASK);
    }
    /**
     * Getter method for {@link #expiryDate}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.expiry_date</li>
     * <li>comments: 验证有效期限(超过期限不能通过验证),为NULL永久有效</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.DATE</li>
     * </ul>
     *
     * @return the value of expiryDate
     */
    @com.facebook.swift.codec.ThriftField(12)
    public java.util.Date getExpiryDate(){
        return expiryDate;
    }
    /**
     * Setter method for {@link #expiryDate}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to expiryDate
     */
    @com.facebook.swift.codec.ThriftField
    public void setExpiryDate(java.util.Date newVal)
    {
        if ((newVal != null && expiryDate != null && (newVal.compareTo(expiryDate) == 0)) ||
            (newVal == null && expiryDate == null && checkExpiryDateInitialized())) {
            return;
        }
        expiryDate = newVal;

        modified |= FL_PERSON_ID_EXPIRY_DATE_MASK;
        initialized |= FL_PERSON_ID_EXPIRY_DATE_MASK;
    }

    /**
     * Setter method for {@link #expiryDate}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to expiryDate
     */
    public void setExpiryDate(long newVal)
    {
        setExpiryDate(new java.util.Date(newVal));
    }
    /**
     * Determines if the expiryDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkExpiryDateModified()
    {
        return 0L !=  (modified & FL_PERSON_ID_EXPIRY_DATE_MASK);
    }

    /**
     * Determines if the expiryDate has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkExpiryDateInitialized()
    {
        return 0L !=  (initialized & FL_PERSON_ID_EXPIRY_DATE_MASK);
    }
    /**
     * Getter method for {@link #createTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.create_time</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of createTime
     */
    @com.facebook.swift.codec.ThriftField(13)
    public java.util.Date getCreateTime(){
        return createTime;
    }
    /**
     * Setter method for {@link #createTime}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to createTime
     */
    @com.facebook.swift.codec.ThriftField
    public void setCreateTime(java.util.Date newVal)
    {
        if ((newVal != null && createTime != null && (newVal.compareTo(createTime) == 0)) ||
            (newVal == null && createTime == null && checkCreateTimeInitialized())) {
            return;
        }
        createTime = newVal;

        modified |= FL_PERSON_ID_CREATE_TIME_MASK;
        initialized |= FL_PERSON_ID_CREATE_TIME_MASK;
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
        return 0L !=  (modified & FL_PERSON_ID_CREATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_PERSON_ID_CREATE_TIME_MASK);
    }
    /**
     * Getter method for {@link #updateTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.update_time</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of updateTime
     */
    @com.facebook.swift.codec.ThriftField(14)
    public java.util.Date getUpdateTime(){
        return updateTime;
    }
    /**
     * Setter method for {@link #updateTime}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to updateTime
     */
    @com.facebook.swift.codec.ThriftField
    public void setUpdateTime(java.util.Date newVal)
    {
        if ((newVal != null && updateTime != null && (newVal.compareTo(updateTime) == 0)) ||
            (newVal == null && updateTime == null && checkUpdateTimeInitialized())) {
            return;
        }
        updateTime = newVal;

        modified |= FL_PERSON_ID_UPDATE_TIME_MASK;
        initialized |= FL_PERSON_ID_UPDATE_TIME_MASK;
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
        return 0L !=  (modified & FL_PERSON_ID_UPDATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_PERSON_ID_UPDATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link ImageBean} by {@link #imageMd5} . <br>
     * FOREIGN KEY (image_md5) REFERENCES fl_image(md5)
     */
    private ImageBean referencedByImageMd5;
    /** Getter method for {@link #referencedByImageMd5}. */
    @com.facebook.swift.codec.ThriftField(15)
    public ImageBean getReferencedByImageMd5() {
        return this.referencedByImageMd5;
    }
    /** Setter method for {@link #referencedByImageMd5}. */
    @com.facebook.swift.codec.ThriftField
    public void setReferencedByImageMd5(ImageBean reference) {
        this.referencedByImageMd5 = reference;
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
        case FL_PERSON_ID_ID:
            return checkIdModified();
        case FL_PERSON_ID_GROUP_ID:
            return checkGroupIdModified();
        case FL_PERSON_ID_NAME:
            return checkNameModified();
        case FL_PERSON_ID_SEX:
            return checkSexModified();
        case FL_PERSON_ID_BIRTHDATE:
            return checkBirthdateModified();
        case FL_PERSON_ID_PAPERS_TYPE:
            return checkPapersTypeModified();
        case FL_PERSON_ID_PAPERS_NUM:
            return checkPapersNumModified();
        case FL_PERSON_ID_IMAGE_MD5:
            return checkImageMd5Modified();
        case FL_PERSON_ID_EXPIRY_DATE:
            return checkExpiryDateModified();
        case FL_PERSON_ID_CREATE_TIME:
            return checkCreateTimeModified();
        case FL_PERSON_ID_UPDATE_TIME:
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
        case FL_PERSON_ID_ID:
            return checkIdInitialized();
        case FL_PERSON_ID_GROUP_ID:
            return checkGroupIdInitialized();
        case FL_PERSON_ID_NAME:
            return checkNameInitialized();
        case FL_PERSON_ID_SEX:
            return checkSexInitialized();
        case FL_PERSON_ID_BIRTHDATE:
            return checkBirthdateInitialized();
        case FL_PERSON_ID_PAPERS_TYPE:
            return checkPapersTypeInitialized();
        case FL_PERSON_ID_PAPERS_NUM:
            return checkPapersNumInitialized();
        case FL_PERSON_ID_IMAGE_MD5:
            return checkImageMd5Initialized();
        case FL_PERSON_ID_EXPIRY_DATE:
            return checkExpiryDateInitialized();
        case FL_PERSON_ID_CREATE_TIME:
            return checkCreateTimeInitialized();
        case FL_PERSON_ID_UPDATE_TIME:
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
     * Resets the object initialization status to 'not initialized'.
     */
    private void resetInitialized()
    {
        initialized = 0L;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof PersonBean)) {
            return false;
        }

        PersonBean obj = (PersonBean) object;
        return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getGroupId(), obj.getGroupId())
            .append(getName(), obj.getName())
            .append(getSex(), obj.getSex())
            .append(getBirthdate(), obj.getBirthdate())
            .append(getPapersType(), obj.getPapersType())
            .append(getPapersNum(), obj.getPapersNum())
            .append(getImageMd5(), obj.getImageMd5())
            .append(getExpiryDate(), obj.getExpiryDate())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getUpdateTime(), obj.getUpdateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .append(getGroupId())
            .append(getName())
            .append(getSex())
            .append(getBirthdate())
            .append(getPapersType())
            .append(getPapersNum())
            .append(getImageMd5())
            .append(getExpiryDate())
            .append(getCreateTime())
            .append(getUpdateTime())
            .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tid=").append(getId()).append("\n")
            .append("\tgroup_id=").append(getGroupId()).append("\n")
            .append("\tname=").append(getName()).append("\n")
            .append("\tsex=").append(getSex()).append("\n")
            .append("\tbirthdate=").append(getBirthdate()).append("\n")
            .append("\tpapers_type=").append(getPapersType()).append("\n")
            .append("\tpapers_num=").append(getPapersNum()).append("\n")
            .append("\timage_md5=").append(getImageMd5()).append("\n")
            .append("\texpiry_date=").append(getExpiryDate()).append("\n")
            .append("\tcreate_time=").append(getCreateTime()).append("\n")
            .append("\tupdate_time=").append(getUpdateTime()).append("\n")
            .append("]\n")
            .toString();
    }

    @Override
    public int compareTo(PersonBean object){
        return new CompareToBuilder()
            .append(getId(), object.getId())
            .toComparison();
    }
    @Override
    public PersonBean clone(){
        try {
            return (PersonBean) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    /**
    * set all field to null
    *
    * @author guyadong
    */
    public PersonBean clean()
    {
        setId(null);
        setGroupId(null);
        setName(null);
        setSex(null);
        setBirthdate(null);
        setPapersType(null);
        setPapersNum(null);
        setImageMd5(null);
        setExpiryDate(null);
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
     * @param fieldList the column id list to copy into the current bean
     */
    public void copy(PersonBean bean, int... fieldList)
    {
        if (null == fieldList || 0 == fieldList.length)
            for (int i = 0; i < 11; ++i) {
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
    public void copy(PersonBean bean, String... fieldList)
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
        case FL_PERSON_ID_ID: 
            return (T)getId();        
        case FL_PERSON_ID_GROUP_ID: 
            return (T)getGroupId();        
        case FL_PERSON_ID_NAME: 
            return (T)getName();        
        case FL_PERSON_ID_SEX: 
            return (T)getSex();        
        case FL_PERSON_ID_BIRTHDATE: 
            return (T)getBirthdate();        
        case FL_PERSON_ID_PAPERS_TYPE: 
            return (T)getPapersType();        
        case FL_PERSON_ID_PAPERS_NUM: 
            return (T)getPapersNum();        
        case FL_PERSON_ID_IMAGE_MD5: 
            return (T)getImageMd5();        
        case FL_PERSON_ID_EXPIRY_DATE: 
            return (T)getExpiryDate();        
        case FL_PERSON_ID_CREATE_TIME: 
            return (T)getCreateTime();        
        case FL_PERSON_ID_UPDATE_TIME: 
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
        case FL_PERSON_ID_ID:        
            setId((Integer)value);
        case FL_PERSON_ID_GROUP_ID:        
            setGroupId((Integer)value);
        case FL_PERSON_ID_NAME:        
            setName((String)value);
        case FL_PERSON_ID_SEX:        
            setSex((Integer)value);
        case FL_PERSON_ID_BIRTHDATE:        
            setBirthdate((java.util.Date)value);
        case FL_PERSON_ID_PAPERS_TYPE:        
            setPapersType((Integer)value);
        case FL_PERSON_ID_PAPERS_NUM:        
            setPapersNum((String)value);
        case FL_PERSON_ID_IMAGE_MD5:        
            setImageMd5((String)value);
        case FL_PERSON_ID_EXPIRY_DATE:        
            setExpiryDate((java.util.Date)value);
        case FL_PERSON_ID_CREATE_TIME:        
            setCreateTime((java.util.Date)value);
        case FL_PERSON_ID_UPDATE_TIME:        
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
        int index = FL_PERSON_FIELDS_LIST.indexOf(column);
        if( 0 > index ) 
            index = FL_PERSON_JAVA_FIELDS_LIST.indexOf(column);
        return index;    
    }
}
