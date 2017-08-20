// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.dborm.person;

import net.gdface.facelog.dborm.FullBean;

/**
 * FlPersonBean is a mapping of fl_person Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 人员基本描述信息 </li>
 * </ul>
 * @author sql2java
*/
public class FlPersonBean
    extends FlPersonBeanBase
    implements FullBean<FlPersonBeanBase>
{
	private static final long serialVersionUID = 1596716341842607074L;
	
    private boolean updateTimeIsModified = false;
    private boolean updateTimeIsInitialized = false;

    private boolean createTimeIsModified = false;
    private boolean createTimeIsInitialized = false;

    private boolean expiryDateIsModified = false;
    private boolean expiryDateIsInitialized = false;

    private boolean faceMd5IsModified = false;
    private boolean faceMd5IsInitialized = false;

    private boolean photoIdIsModified = false;
    private boolean photoIdIsInitialized = false;

    private boolean papersNumIsModified = false;
    private boolean papersNumIsInitialized = false;

    private boolean papersTypeIsModified = false;
    private boolean papersTypeIsInitialized = false;

    private boolean birthdateIsModified = false;
    private boolean birthdateIsInitialized = false;

    private boolean sexIsModified = false;
    private boolean sexIsInitialized = false;

    private boolean nameIsModified = false;
    private boolean nameIsInitialized = false;

    private boolean groupIdIsModified = false;
    private boolean groupIdIsInitialized = false;

    private boolean idIsModified = false;
    private boolean idIsInitialized = false;



    /**
     * Prefered methods to create a FlPersonBean is via the createFlPersonBean method in FlPersonManager or
     * via the factory class FlPersonFactory create method
     * 为了能在webservice中传递对象，此处从protected改为public
     */
    public FlPersonBean(){
        super();
    }
    /**
     * create a FlPersonBean from a instance
     */
    FlPersonBean(FlPersonBeanBase bean){
        super();
        copy(bean);
    }
    /**
     * Getter method for updateTime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.update_time</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of updateTime
     */
    public java.util.Date getUpdateTime(){
        return updateTime;
    }
    /**
     * Setter method for updateTime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to updateTime
     */
    public void setUpdateTime(java.util.Date newVal)
    {
        if ((newVal != null && updateTime != null && (newVal.compareTo(updateTime) == 0)) ||
            (newVal == null && updateTime == null && updateTimeIsInitialized)) {
            return;
        }
        super.setUpdateTime(newVal);
        updateTimeIsModified = true;
        updateTimeIsInitialized = true;
    }

    /**
     * Setter method for updateTime.
     * <br>
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
    public boolean isUpdateTimeModified()
    {
        return updateTimeIsModified;
    }

    /**
     * Determines if the updateTime has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isUpdateTimeInitialized()
    {
        return updateTimeIsInitialized;
    }

    /**
     * Getter method for createTime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.create_time</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of createTime
     */
    public java.util.Date getCreateTime(){
        return createTime;
    }
    /**
     * Setter method for createTime.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to createTime
     */
    public void setCreateTime(java.util.Date newVal)
    {
        if ((newVal != null && createTime != null && (newVal.compareTo(createTime) == 0)) ||
            (newVal == null && createTime == null && createTimeIsInitialized)) {
            return;
        }
        super.setCreateTime(newVal);
        createTimeIsModified = true;
        createTimeIsInitialized = true;
    }

    /**
     * Setter method for createTime.
     * <br>
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
    public boolean isCreateTimeModified()
    {
        return createTimeIsModified;
    }

    /**
     * Determines if the createTime has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCreateTimeInitialized()
    {
        return createTimeIsInitialized;
    }

    /**
     * Getter method for expiryDate.
     * <br>
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
    public java.util.Date getExpiryDate(){
        return expiryDate;
    }
    /**
     * Setter method for expiryDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to expiryDate
     */
    public void setExpiryDate(java.util.Date newVal)
    {
        if ((newVal != null && expiryDate != null && (newVal.compareTo(expiryDate) == 0)) ||
            (newVal == null && expiryDate == null && expiryDateIsInitialized)) {
            return;
        }
        super.setExpiryDate(newVal);
        expiryDateIsModified = true;
        expiryDateIsInitialized = true;
    }

    /**
     * Setter method for expiryDate.
     * <br>
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
    public boolean isExpiryDateModified()
    {
        return expiryDateIsModified;
    }

    /**
     * Determines if the expiryDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isExpiryDateInitialized()
    {
        return expiryDateIsInitialized;
    }

    /**
     * Getter method for faceMd5.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.face_md5</li>
     * <li>comments: 从用户默认照片(photo_id)提取的人脸特征md5校验码,引用fl_face(md5),非存储字段,应用程序负责更新</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.CHAR</li>
     * </ul>
     *
     * @return the value of faceMd5
     */
    public String getFaceMd5(){
        return faceMd5;
    }
    /**
     * Setter method for faceMd5.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to faceMd5
     */
    public void setFaceMd5(String newVal)
    {
        if ((newVal != null && faceMd5 != null && (newVal.compareTo(faceMd5) == 0)) ||
            (newVal == null && faceMd5 == null && faceMd5IsInitialized)) {
            return;
        }
        super.setFaceMd5(newVal);
        faceMd5IsModified = true;
        faceMd5IsInitialized = true;
    }

    /**
     * Determines if the faceMd5 has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isFaceMd5Modified()
    {
        return faceMd5IsModified;
    }

    /**
     * Determines if the faceMd5 has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isFaceMd5Initialized()
    {
        return faceMd5IsInitialized;
    }

    /**
     * Getter method for photoId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.photo_id</li>
     * <li> foreign key: fl_image.md5</li>
     * <li>comments: 用户默认照片(证件照,标准照)的md5校验码,外键</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.CHAR</li>
     * </ul>
     *
     * @return the value of photoId
     */
    public String getPhotoId(){
        return photoId;
    }
    /**
     * Setter method for photoId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to photoId
     */
    public void setPhotoId(String newVal)
    {
        if ((newVal != null && photoId != null && (newVal.compareTo(photoId) == 0)) ||
            (newVal == null && photoId == null && photoIdIsInitialized)) {
            return;
        }
        super.setPhotoId(newVal);
        photoIdIsModified = true;
        photoIdIsInitialized = true;
    }

    /**
     * Determines if the photoId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPhotoIdModified()
    {
        return photoIdIsModified;
    }

    /**
     * Determines if the photoId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPhotoIdInitialized()
    {
        return photoIdIsInitialized;
    }

    /**
     * Getter method for papersNum.
     * <br>
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
    public String getPapersNum(){
        return papersNum;
    }
    /**
     * Setter method for papersNum.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to papersNum
     */
    public void setPapersNum(String newVal)
    {
        if ((newVal != null && papersNum != null && (newVal.compareTo(papersNum) == 0)) ||
            (newVal == null && papersNum == null && papersNumIsInitialized)) {
            return;
        }
        super.setPapersNum(newVal);
        papersNumIsModified = true;
        papersNumIsInitialized = true;
    }

    /**
     * Determines if the papersNum has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPapersNumModified()
    {
        return papersNumIsModified;
    }

    /**
     * Determines if the papersNum has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPapersNumInitialized()
    {
        return papersNumIsInitialized;
    }

    /**
     * Getter method for papersType.
     * <br>
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
    public Integer getPapersType(){
        return papersType;
    }
    /**
     * Setter method for papersType.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to papersType
     */
    public void setPapersType(Integer newVal)
    {
        if ((newVal != null && papersType != null && (newVal.compareTo(papersType) == 0)) ||
            (newVal == null && papersType == null && papersTypeIsInitialized)) {
            return;
        }
        super.setPapersType(newVal);
        papersTypeIsModified = true;
        papersTypeIsInitialized = true;
    }

    /**
     * Setter method for papersType.
     * <br>
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
    public boolean isPapersTypeModified()
    {
        return papersTypeIsModified;
    }

    /**
     * Determines if the papersType has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPapersTypeInitialized()
    {
        return papersTypeIsInitialized;
    }

    /**
     * Getter method for birthdate.
     * <br>
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
    public java.util.Date getBirthdate(){
        return birthdate;
    }
    /**
     * Setter method for birthdate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to birthdate
     */
    public void setBirthdate(java.util.Date newVal)
    {
        if ((newVal != null && birthdate != null && (newVal.compareTo(birthdate) == 0)) ||
            (newVal == null && birthdate == null && birthdateIsInitialized)) {
            return;
        }
        super.setBirthdate(newVal);
        birthdateIsModified = true;
        birthdateIsInitialized = true;
    }

    /**
     * Setter method for birthdate.
     * <br>
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
    public boolean isBirthdateModified()
    {
        return birthdateIsModified;
    }

    /**
     * Determines if the birthdate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isBirthdateInitialized()
    {
        return birthdateIsInitialized;
    }

    /**
     * Getter method for sex.
     * <br>
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
    public Integer getSex(){
        return sex;
    }
    /**
     * Setter method for sex.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to sex
     */
    public void setSex(Integer newVal)
    {
        if ((newVal != null && sex != null && (newVal.compareTo(sex) == 0)) ||
            (newVal == null && sex == null && sexIsInitialized)) {
            return;
        }
        super.setSex(newVal);
        sexIsModified = true;
        sexIsInitialized = true;
    }

    /**
     * Setter method for sex.
     * <br>
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
    public boolean isSexModified()
    {
        return sexIsModified;
    }

    /**
     * Determines if the sex has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isSexInitialized()
    {
        return sexIsInitialized;
    }

    /**
     * Getter method for name.
     * <br>
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
    public String getName(){
        return name;
    }
    /**
     * Setter method for name.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to name
     */
    public void setName(String newVal)
    {
        if ((newVal != null && name != null && (newVal.compareTo(name) == 0)) ||
            (newVal == null && name == null && nameIsInitialized)) {
            return;
        }
        super.setName(newVal);
        nameIsModified = true;
        nameIsInitialized = true;
    }

    /**
     * Determines if the name has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isNameModified()
    {
        return nameIsModified;
    }

    /**
     * Determines if the name has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isNameInitialized()
    {
        return nameIsInitialized;
    }

    /**
     * Getter method for groupId.
     * <br>
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
    public Integer getGroupId(){
        return groupId;
    }
    /**
     * Setter method for groupId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to groupId
     */
    public void setGroupId(Integer newVal)
    {
        if ((newVal != null && groupId != null && (newVal.compareTo(groupId) == 0)) ||
            (newVal == null && groupId == null && groupIdIsInitialized)) {
            return;
        }
        super.setGroupId(newVal);
        groupIdIsModified = true;
        groupIdIsInitialized = true;
    }

    /**
     * Setter method for groupId.
     * <br>
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
    public boolean isGroupIdModified()
    {
        return groupIdIsModified;
    }

    /**
     * Determines if the groupId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isGroupIdInitialized()
    {
        return groupIdIsInitialized;
    }

    /**
     * Getter method for id.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_person.id</li>
     * <li> imported key: fl_face.person_id</li>
     * <li> imported key: fl_log.person_id</li>
     * <li>comments: 用户识别码</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of id
     */
    public Integer getId(){
        return id;
    }
    /**
     * Setter method for id.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to id
     */
    public void setId(Integer newVal)
    {
        if ((newVal != null && id != null && (newVal.compareTo(id) == 0)) ||
            (newVal == null && id == null && idIsInitialized)) {
            return;
        }
        super.setId(newVal);
        idIsModified = true;
        idIsInitialized = true;
    }

    /**
     * Setter method for id.
     * <br>
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
    public boolean isIdModified()
    {
        return idIsModified;
    }

    /**
     * Determines if the id has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isIdInitialized()
    {
        return idIsInitialized;
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
        return updateTimeIsModified 		|| createTimeIsModified  		|| expiryDateIsModified  		|| faceMd5IsModified  		|| photoIdIsModified  		|| papersNumIsModified  		|| papersTypeIsModified  		|| birthdateIsModified  		|| sexIsModified  		|| nameIsModified  		|| groupIdIsModified  		|| idIsModified  ;
    }
    
    /**
     * Determines if the {@code column} has been modified.
     * @param column
     * @return true if the field has been modified, false if the field has not been modified
     * @author guyadong
     */
    public boolean isModified(String column){
        if (null == column || "".equals(column)) {
            return false;
        } else if ("update_time".equalsIgnoreCase(column) || "updateTime".equalsIgnoreCase(column)) {
            return isUpdateTimeModified();
        } else if ("create_time".equalsIgnoreCase(column) || "createTime".equalsIgnoreCase(column)) {
            return isCreateTimeModified();
        } else if ("expiry_date".equalsIgnoreCase(column) || "expiryDate".equalsIgnoreCase(column)) {
            return isExpiryDateModified();
        } else if ("face_md5".equalsIgnoreCase(column) || "faceMd5".equalsIgnoreCase(column)) {
            return isFaceMd5Modified();
        } else if ("photo_id".equalsIgnoreCase(column) || "photoId".equalsIgnoreCase(column)) {
            return isPhotoIdModified();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return isPapersNumModified();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return isPapersTypeModified();
        } else if ("birthdate".equalsIgnoreCase(column) || "birthdate".equalsIgnoreCase(column)) {
            return isBirthdateModified();
        } else if ("sex".equalsIgnoreCase(column) || "sex".equalsIgnoreCase(column)) {
            return isSexModified();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return isNameModified();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return isGroupIdModified();
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return isIdModified();
        }
        return false;		
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
        if (null == column || "".equals(column)) {
            return false;
        } else if ("update_time".equalsIgnoreCase(column) || "updateTime".equalsIgnoreCase(column)) {
            return isUpdateTimeInitialized();
        } else if ("create_time".equalsIgnoreCase(column) || "createTime".equalsIgnoreCase(column)) {
            return isCreateTimeInitialized();
        } else if ("expiry_date".equalsIgnoreCase(column) || "expiryDate".equalsIgnoreCase(column)) {
            return isExpiryDateInitialized();
        } else if ("face_md5".equalsIgnoreCase(column) || "faceMd5".equalsIgnoreCase(column)) {
            return isFaceMd5Initialized();
        } else if ("photo_id".equalsIgnoreCase(column) || "photoId".equalsIgnoreCase(column)) {
            return isPhotoIdInitialized();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return isPapersNumInitialized();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return isPapersTypeInitialized();
        } else if ("birthdate".equalsIgnoreCase(column) || "birthdate".equalsIgnoreCase(column)) {
            return isBirthdateInitialized();
        } else if ("sex".equalsIgnoreCase(column) || "sex".equalsIgnoreCase(column)) {
            return isSexInitialized();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return isNameInitialized();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return isGroupIdInitialized();
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return isIdInitialized();
        }
        return false;		
    }
    
    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified()
    {
        updateTimeIsModified = false;
        createTimeIsModified = false;
        expiryDateIsModified = false;
        faceMd5IsModified = false;
        photoIdIsModified = false;
        papersNumIsModified = false;
        papersTypeIsModified = false;
        birthdateIsModified = false;
        sexIsModified = false;
        nameIsModified = false;
        groupIdIsModified = false;
        idIsModified = false;
    }

    /**
     * set all field to null and reset all modification status
     * @see #resetIsModified() 
     */
    public FlPersonBean clean()
    {
        super.clean();
        resetIsModified();
        return this;
    }

}
