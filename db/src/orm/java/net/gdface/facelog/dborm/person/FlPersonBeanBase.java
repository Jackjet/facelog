// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.dborm.person;
import net.gdface.facelog.dborm.BaseBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.gdface.facelog.dborm.image.FlImageBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;

/**
 * FlPersonBean is a mapping of fl_person Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 人员基本描述信息 </li>
 * </ul>
 * @author guyadong
*/
public class FlPersonBeanBase
    implements Serializable,BaseBean<FlPersonBeanBase>
{
	private static final long serialVersionUID = 5215134106814122962L;
	
    protected java.util.Date updateTime;

    protected java.util.Date createTime;

    protected java.util.Date expiryDate;

    protected String faceMd5;

    protected String photoId;

    protected String papersNum;

    protected Integer papersType;

    protected java.util.Date birthdate;

    protected Integer sex;

    protected String name;

    protected Integer groupId;

    protected Integer id;

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
     * Prefered methods to create a FlPersonBeanBase is via the createFlPersonBean method in FlPersonManager or
     * via the factory class FlPersonFactory create method
     */
    public FlPersonBeanBase(){
    }
    /**
     * create a FlPersonBeanBase from a instance
     */
    public FlPersonBeanBase(FlPersonBeanBase bean){
        this.copy(bean);
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
    public void setUpdateTime(java.util.Date newVal){    
        updateTime = newVal;
    }

    /**
     * Setter method for updateTime.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to updateTime
     */
    public void setUpdateTime(long newVal){
        setUpdateTime(new java.util.Date(newVal));
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
    public void setCreateTime(java.util.Date newVal){    
        createTime = newVal;
    }

    /**
     * Setter method for createTime.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to createTime
     */
    public void setCreateTime(long newVal){
        setCreateTime(new java.util.Date(newVal));
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
    public void setExpiryDate(java.util.Date newVal){    
        expiryDate = newVal;
    }

    /**
     * Setter method for expiryDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to expiryDate
     */
    public void setExpiryDate(long newVal){
        setExpiryDate(new java.util.Date(newVal));
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
    public void setFaceMd5(String newVal){    
        faceMd5 = newVal;
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
    public void setPhotoId(String newVal){    
        photoId = newVal;
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
    public void setPapersNum(String newVal){    
        papersNum = newVal;
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
    public void setPapersType(Integer newVal){    
        papersType = newVal;
    }

    /**
     * Setter method for papersType.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to papersType
     */
    public void setPapersType(int newVal){
        setPapersType(new Integer(newVal));
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
    public void setBirthdate(java.util.Date newVal){    
        birthdate = newVal;
    }

    /**
     * Setter method for birthdate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to birthdate
     */
    public void setBirthdate(long newVal){
        setBirthdate(new java.util.Date(newVal));
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
    public void setSex(Integer newVal){    
        sex = newVal;
    }

    /**
     * Setter method for sex.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to sex
     */
    public void setSex(int newVal){
        setSex(new Integer(newVal));
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
    public void setName(String newVal){    
        name = newVal;
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
    public void setGroupId(Integer newVal){    
        groupId = newVal;
    }

    /**
     * Setter method for groupId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to groupId
     */
    public void setGroupId(int newVal){
        setGroupId(new Integer(newVal));
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
    public void setId(Integer newVal){    
        id = newVal;
    }

    /**
     * Setter method for id.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to id
     */
    public void setId(int newVal){
        setId(new Integer(newVal));
    }


    /** The FlImage referenced by this bean. */
    private FlImageBean referencedFlImage;
    /** Getter method for FlImageBean. */
    public FlImageBean getFlImageBean() {
        return this.referencedFlImage;
    }
    /** Setter method for FlImageBean. */
    public void setFlImageBean(FlImageBean reference) {
        this.referencedFlImage = reference;
    }    
    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object)
    {
        if (!(object instanceof FlPersonBean)) {
            return false;
        }

        FlPersonBean obj = (FlPersonBean) object;
        return new EqualsBuilder()
            .append(getUpdateTime(), obj.getUpdateTime())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getExpiryDate(), obj.getExpiryDate())
            .append(getFaceMd5(), obj.getFaceMd5())
            .append(getPhotoId(), obj.getPhotoId())
            .append(getPapersNum(), obj.getPapersNum())
            .append(getPapersType(), obj.getPapersType())
            .append(getBirthdate(), obj.getBirthdate())
            .append(getSex(), obj.getSex())
            .append(getName(), obj.getName())
            .append(getGroupId(), obj.getGroupId())
            .append(getId(), obj.getId())
            .isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getUpdateTime())
            .append(getCreateTime())
            .append(getExpiryDate())
            .append(getFaceMd5())
            .append(getPhotoId())
            .append(getPapersNum())
            .append(getPapersType())
            .append(getBirthdate())
            .append(getSex())
            .append(getName())
            .append(getGroupId())
            .append(getId())
            .toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tupdate_time=").append(getUpdateTime()).append("\n")
            .append("\tcreate_time=").append(getCreateTime()).append("\n")
            .append("\texpiry_date=").append(getExpiryDate()).append("\n")
            .append("\tface_md5=").append(getFaceMd5()).append("\n")
            .append("\tphoto_id=").append(getPhotoId()).append("\n")
            .append("\tpapers_num=").append(getPapersNum()).append("\n")
            .append("\tpapers_type=").append(getPapersType()).append("\n")
            .append("\tbirthdate=").append(getBirthdate()).append("\n")
            .append("\tsex=").append(getSex()).append("\n")
            .append("\tname=").append(getName()).append("\n")
            .append("\tgroup_id=").append(getGroupId()).append("\n")
            .append("\tid=").append(getId()).append("\n")
            .append("]\n")
            .toString();
    }


    public int compareTo(Object object){
        FlPersonBean obj = (FlPersonBean) object;
        return new CompareToBuilder()
            .append(getUpdateTime(), obj.getUpdateTime())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getExpiryDate(), obj.getExpiryDate())
            .append(getFaceMd5(), obj.getFaceMd5())
            .append(getPhotoId(), obj.getPhotoId())
            .append(getPapersNum(), obj.getPapersNum())
            .append(getPapersType(), obj.getPapersType())
            .append(getBirthdate(), obj.getBirthdate())
            .append(getSex(), obj.getSex())
            .append(getName(), obj.getName())
            .append(getGroupId(), obj.getGroupId())
            .append(getId(), obj.getId())
            .toComparison();
    }
    /**
    * Copies proterty of the passed bean into the current bean.<br>
    * if bean.isNew() is true, call {@link #copyIfNotNull(GfCodeBeanBase)}
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copy(FlPersonBeanBase bean)
    {
        if(bean.isNew()){
            copyIfNotNull(bean);
        }else{        
            isNew(bean.isNew());
            setUpdateTime(bean.getUpdateTime());
            setCreateTime(bean.getCreateTime());
            setExpiryDate(bean.getExpiryDate());
            setFaceMd5(bean.getFaceMd5());
            setPhotoId(bean.getPhotoId());
            setPapersNum(bean.getPapersNum());
            setPapersType(bean.getPapersType());
            setBirthdate(bean.getBirthdate());
            setSex(bean.getSex());
            setName(bean.getName());
            setGroupId(bean.getGroupId());
            setId(bean.getId());
        }
    }
    /**
    * Copies proterty of the passed bean into the current bean if property not null.
    *
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copyIfNotNull(FlPersonBeanBase bean)
    {
        isNew(bean.isNew());
        if(bean.getUpdateTime()!=null)
            setUpdateTime(bean.getUpdateTime());
        if(bean.getCreateTime()!=null)
            setCreateTime(bean.getCreateTime());
        if(bean.getExpiryDate()!=null)
            setExpiryDate(bean.getExpiryDate());
        if(bean.getFaceMd5()!=null)
            setFaceMd5(bean.getFaceMd5());
        if(bean.getPhotoId()!=null)
            setPhotoId(bean.getPhotoId());
        if(bean.getPapersNum()!=null)
            setPapersNum(bean.getPapersNum());
        if(bean.getPapersType()!=null)
            setPapersType(bean.getPapersType());
        if(bean.getBirthdate()!=null)
            setBirthdate(bean.getBirthdate());
        if(bean.getSex()!=null)
            setSex(bean.getSex());
        if(bean.getName()!=null)
            setName(bean.getName());
        if(bean.getGroupId()!=null)
            setGroupId(bean.getGroupId());
        if(bean.getId()!=null)
            setId(bean.getId());
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlPersonBeanBase clean()
    {
        isNew(true);
        setUpdateTime(null);
        setCreateTime(null);
        setExpiryDate(null);
        setFaceMd5(null);
        setPhotoId(null);
        setPapersNum(null);
        setPapersType(null);
        setBirthdate(null);
        setSex(null);
        setName(null);
        setGroupId(null);
        setId(null);
        return this;
    }
    
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     */
    public void copy(FlPersonBeanBase bean, String[] fieldList)
    {
        if (null == fieldList)
            copy(bean);
        else
            for (int i = 0; i < fieldList.length; i++) {
                setObject(fieldList[i].trim(), bean.getObject(fieldList[i].trim()));
            }
    }
    /**
     * create new FlPersonBean form {@code bean} if not instanceof FlPersonBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @see #toFullBean()
    * @author guyadong
    */
    public final static FlPersonBean toFullBean(FlPersonBeanBase bean)
    {
        return null==bean?null:(bean.toFullBean());
    }
    /**
    * @param bases
    * @return
    * @see #toFullBean(FlPersonBeanBase)
    * @author guyadong
    */
    public static FlPersonBean[] toFullBean(FlPersonBeanBase[] bases){
        FlPersonBean[] b = new FlPersonBean[bases.length];
        for(int i=0;i<b.length;i++){
            b[i]=toFullBean(bases[i]);
        }
        return b;
    }
    /**
     * create new FlPersonBean form {@code bean} if not instanceof FlPersonBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @author guyadong
    */
    @SuppressWarnings("unchecked")
    public FlPersonBean toFullBean()
    {
        return this instanceof FlPersonBean?(FlPersonBean)this:new FlPersonBean(this);
    }

    /**
     * return a dictionnary of the object
     */
    public Map<String,String> readDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("update_time", getUpdateTime() == null ? "" : getUpdateTime().toString());
        dictionnary.put("create_time", getCreateTime() == null ? "" : getCreateTime().toString());
        dictionnary.put("expiry_date", getExpiryDate() == null ? "" : getExpiryDate().toString());
        dictionnary.put("face_md5", getFaceMd5() == null ? "" : getFaceMd5().toString());
        dictionnary.put("photo_id", getPhotoId() == null ? "" : getPhotoId().toString());
        dictionnary.put("papers_num", getPapersNum() == null ? "" : getPapersNum().toString());
        dictionnary.put("papers_type", getPapersType() == null ? "" : getPapersType().toString());
        dictionnary.put("birthdate", getBirthdate() == null ? "" : getBirthdate().toString());
        dictionnary.put("sex", getSex() == null ? "" : getSex().toString());
        dictionnary.put("name", getName() == null ? "" : getName().toString());
        dictionnary.put("group_id", getGroupId() == null ? "" : getGroupId().toString());
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        return dictionnary;
    }

    /**
     * return a dictionnary of the pk columns
     */
    public Map<String,String> readPkDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        return dictionnary;
    }

    /**
     * return a the value string representation of the given field
     */
    public String getValue(String column)
    {
        if (null == column || "".equals(column)) {
            return "";
        } else if ("update_time".equalsIgnoreCase(column) || "updateTime".equalsIgnoreCase(column)) {
            return getUpdateTime() == null ? "" : getUpdateTime().toString();
        } else if ("create_time".equalsIgnoreCase(column) || "createTime".equalsIgnoreCase(column)) {
            return getCreateTime() == null ? "" : getCreateTime().toString();
        } else if ("expiry_date".equalsIgnoreCase(column) || "expiryDate".equalsIgnoreCase(column)) {
            return getExpiryDate() == null ? "" : getExpiryDate().toString();
        } else if ("face_md5".equalsIgnoreCase(column) || "faceMd5".equalsIgnoreCase(column)) {
            return getFaceMd5() == null ? "" : getFaceMd5().toString();
        } else if ("photo_id".equalsIgnoreCase(column) || "photoId".equalsIgnoreCase(column)) {
            return getPhotoId() == null ? "" : getPhotoId().toString();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return getPapersNum() == null ? "" : getPapersNum().toString();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return getPapersType() == null ? "" : getPapersType().toString();
        } else if ("birthdate".equalsIgnoreCase(column) || "birthdate".equalsIgnoreCase(column)) {
            return getBirthdate() == null ? "" : getBirthdate().toString();
        } else if ("sex".equalsIgnoreCase(column) || "sex".equalsIgnoreCase(column)) {
            return getSex() == null ? "" : getSex().toString();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? "" : getName().toString();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return getGroupId() == null ? "" : getGroupId().toString();
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return getId() == null ? "" : getId().toString();
        }
        return "";
    }

    /**
     * return a object representation of the given field
     */
    @SuppressWarnings("unchecked")
    public <T>T getObject(String column)
    {
        if (null == column || "".equals(column)) {
            return null;
        } else if ("update_time".equalsIgnoreCase(column) || "updateTime".equalsIgnoreCase(column)) {
            return getUpdateTime() == null ? null : (T)getUpdateTime();
        } else if ("create_time".equalsIgnoreCase(column) || "createTime".equalsIgnoreCase(column)) {
            return getCreateTime() == null ? null : (T)getCreateTime();
        } else if ("expiry_date".equalsIgnoreCase(column) || "expiryDate".equalsIgnoreCase(column)) {
            return getExpiryDate() == null ? null : (T)getExpiryDate();
        } else if ("face_md5".equalsIgnoreCase(column) || "faceMd5".equalsIgnoreCase(column)) {
            return getFaceMd5() == null ? null : (T)getFaceMd5();
        } else if ("photo_id".equalsIgnoreCase(column) || "photoId".equalsIgnoreCase(column)) {
            return getPhotoId() == null ? null : (T)getPhotoId();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return getPapersNum() == null ? null : (T)getPapersNum();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return getPapersType() == null ? null : (T)getPapersType();
        } else if ("birthdate".equalsIgnoreCase(column) || "birthdate".equalsIgnoreCase(column)) {
            return getBirthdate() == null ? null : (T)getBirthdate();
        } else if ("sex".equalsIgnoreCase(column) || "sex".equalsIgnoreCase(column)) {
            return getSex() == null ? null : (T)getSex();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? null : (T)getName();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return getGroupId() == null ? null : (T)getGroupId();
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            return getId() == null ? null : (T)getId();
        }
        return null;
    }

    /**
     * set a value representation of the given field
     */
    public <T>void setObject(String column,T object)
    {
        if (null == column || "".equals(column)) {
            return ;
        } else if ("update_time".equalsIgnoreCase(column) || "updateTime".equalsIgnoreCase(column)) {
            setUpdateTime((java.util.Date)object);
        } else if ("create_time".equalsIgnoreCase(column) || "createTime".equalsIgnoreCase(column)) {
            setCreateTime((java.util.Date)object);
        } else if ("expiry_date".equalsIgnoreCase(column) || "expiryDate".equalsIgnoreCase(column)) {
            setExpiryDate((java.util.Date)object);
        } else if ("face_md5".equalsIgnoreCase(column) || "faceMd5".equalsIgnoreCase(column)) {
            setFaceMd5((String)object);
        } else if ("photo_id".equalsIgnoreCase(column) || "photoId".equalsIgnoreCase(column)) {
            setPhotoId((String)object);
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            setPapersNum((String)object);
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            setPapersType((Integer)object);
        } else if ("birthdate".equalsIgnoreCase(column) || "birthdate".equalsIgnoreCase(column)) {
            setBirthdate((java.util.Date)object);
        } else if ("sex".equalsIgnoreCase(column) || "sex".equalsIgnoreCase(column)) {
            setSex((Integer)object);
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            setName((String)object);
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            setGroupId((Integer)object);
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            setId((Integer)object);
        }
    }
}
