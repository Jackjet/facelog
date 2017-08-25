// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.db;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * FlLogBeanBase is a mapping of fl_log Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 人脸验证日志,记录所有通过验证的人员 </li>
 * </ul>
 * @author guyadong
*/
public class LogBean
    implements Serializable,Comparable<LogBean>
{
	private static final long serialVersionUID = -4612112589792507945L;
	
    /**
     * comments:日志id
     */
    protected Integer id;

    /**
     * comments:外键,用户id
     */
    protected Integer personId;

    /**
     * comments:外键,图像来源设备id
     */
    protected Integer deviceId;

    /**
     * comments:外键,验证人脸信息id
     */
    protected String verifyFace;

    /**
     * comments:外键,数据库中最相似的对比人脸id
     */
    protected String compareFace;

    /**
     * comments:验证相似度
     */
    protected Double similarty;

    /**
     * comments:验证时间(可能由前端设备提供时间)
     */
    protected java.util.Date verifyTime;

    protected java.util.Date createTime;

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
     * Prefered methods to create a FlLogBeanBase is via the createFlLogBean method in FlLogManager or
     * via the factory class FlLogFactory create method
     */
    public LogBean(){
    }
    /**
     * create a FlLogBeanBase from a instance
     */
    public LogBean(LogBean bean){
        this.copy(bean);
    }
    /**
     * Getter method for {@link #id}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.id</li>
     * <li>comments: 日志id</li>
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
     * Setter method for {@link #id}.<br>
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
     * Setter method for {@link #id}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to id
     */
    public void setId(int newVal){
        setId(new Integer(newVal));
    }

    /**
     * Getter method for {@link #personId}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.person_id</li>
     * <li> foreign key: fl_person.id</li>
     * <li>comments: 外键,用户id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
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
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(Integer newVal){    
        personId = newVal;
    }

    /**
     * Setter method for {@link #personId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(int newVal){
        setPersonId(new Integer(newVal));
    }

    /**
     * Getter method for {@link #deviceId}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.device_id</li>
     * <li> foreign key: fl_device.id</li>
     * <li>comments: 外键,图像来源设备id</li>
     * <li>column size: 10</li>
     * <li>jdbc type returned by the driver: Types.INTEGER</li>
     * </ul>
     *
     * @return the value of deviceId
     */
    public Integer getDeviceId(){
        return deviceId;
    }
    /**
     * Setter method for {@link #deviceId}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to deviceId
     */
    public void setDeviceId(Integer newVal){    
        deviceId = newVal;
    }

    /**
     * Setter method for {@link #deviceId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to deviceId
     */
    public void setDeviceId(int newVal){
        setDeviceId(new Integer(newVal));
    }

    /**
     * Getter method for {@link #verifyFace}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.verify_face</li>
     * <li> foreign key: fl_face.md5</li>
     * <li>comments: 外键,验证人脸信息id</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of verifyFace
     */
    public String getVerifyFace(){
        return verifyFace;
    }
    /**
     * Setter method for {@link #verifyFace}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to verifyFace
     */
    public void setVerifyFace(String newVal){    
        verifyFace = newVal;
    }


    /**
     * Getter method for {@link #compareFace}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.compare_face</li>
     * <li> foreign key: fl_face.md5</li>
     * <li>comments: 外键,数据库中最相似的对比人脸id</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of compareFace
     */
    public String getCompareFace(){
        return compareFace;
    }
    /**
     * Setter method for {@link #compareFace}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to compareFace
     */
    public void setCompareFace(String newVal){    
        compareFace = newVal;
    }


    /**
     * Getter method for {@link #similarty}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.similarty</li>
     * <li>comments: 验证相似度</li>
     * <li>column size: 22</li>
     * <li>jdbc type returned by the driver: Types.DOUBLE</li>
     * </ul>
     *
     * @return the value of similarty
     */
    public Double getSimilarty(){
        return similarty;
    }
    /**
     * Setter method for {@link #similarty}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to similarty
     */
    public void setSimilarty(Double newVal){    
        similarty = newVal;
    }

    /**
     * Setter method for {@link #similarty}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to similarty
     */
    public void setSimilarty(double newVal){
        setSimilarty(new Double(newVal));
    }

    /**
     * Getter method for {@link #verifyTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.verify_time</li>
     * <li>comments: 验证时间(可能由前端设备提供时间)</li>
     * <li>column size: 19</li>
     * <li>jdbc type returned by the driver: Types.TIMESTAMP</li>
     * </ul>
     *
     * @return the value of verifyTime
     */
    public java.util.Date getVerifyTime(){
        return verifyTime;
    }
    /**
     * Setter method for {@link #verifyTime}.<br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to verifyTime
     */
    public void setVerifyTime(java.util.Date newVal){    
        verifyTime = newVal;
    }

    /**
     * Setter method for {@link #verifyTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to verifyTime
     */
    public void setVerifyTime(long newVal){
        setVerifyTime(new java.util.Date(newVal));
    }

    /**
     * Getter method for {@link #createTime}.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log.create_time</li>
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
     * Setter method for {@link #createTime}.<br>
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
     * Setter method for {@link #createTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to createTime
     */
    public void setCreateTime(long newVal){
        setCreateTime(new java.util.Date(newVal));
    }


    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link DeviceBean} by {@link #deviceId} . <br>
     * FOREIGN KEY (device_id) REFERENCES fl_device(id)
     */
    private DeviceBean referencedByDeviceId;
    /** Getter method for {@link #referencedByDeviceId}. */
    public DeviceBean getReferencedByDeviceId() {
        return this.referencedByDeviceId;
    }
    /** Setter method for {@link #referencedByDeviceId}. */
    public void setReferencedByDeviceId(DeviceBean reference) {
        this.referencedByDeviceId = reference;
    }
    /** 
     * The referenced {@link FaceBean} by {@link #verifyFace} . <br>
     * FOREIGN KEY (verify_face) REFERENCES fl_face(md5)
     */
    private FaceBean referencedByVerifyFace;
    /** Getter method for {@link #referencedByVerifyFace}. */
    public FaceBean getReferencedByVerifyFace() {
        return this.referencedByVerifyFace;
    }
    /** Setter method for {@link #referencedByVerifyFace}. */
    public void setReferencedByVerifyFace(FaceBean reference) {
        this.referencedByVerifyFace = reference;
    }
    /** 
     * The referenced {@link FaceBean} by {@link #compareFace} . <br>
     * FOREIGN KEY (compare_face) REFERENCES fl_face(md5)
     */
    private FaceBean referencedByCompareFace;
    /** Getter method for {@link #referencedByCompareFace}. */
    public FaceBean getReferencedByCompareFace() {
        return this.referencedByCompareFace;
    }
    /** Setter method for {@link #referencedByCompareFace}. */
    public void setReferencedByCompareFace(FaceBean reference) {
        this.referencedByCompareFace = reference;
    }
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

    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof LogBean)) {
            return false;
        }

        LogBean obj = (LogBean) object;
        return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getPersonId(), obj.getPersonId())
            .append(getDeviceId(), obj.getDeviceId())
            .append(getVerifyFace(), obj.getVerifyFace())
            .append(getCompareFace(), obj.getCompareFace())
            .append(getSimilarty(), obj.getSimilarty())
            .append(getVerifyTime(), obj.getVerifyTime())
            .append(getCreateTime(), obj.getCreateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .append(getPersonId())
            .append(getDeviceId())
            .append(getVerifyFace())
            .append(getCompareFace())
            .append(getSimilarty())
            .append(getVerifyTime())
            .append(getCreateTime())
            .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tid=").append(getId()).append("\n")
            .append("\tperson_id=").append(getPersonId()).append("\n")
            .append("\tdevice_id=").append(getDeviceId()).append("\n")
            .append("\tverify_face=").append(getVerifyFace()).append("\n")
            .append("\tcompare_face=").append(getCompareFace()).append("\n")
            .append("\tsimilarty=").append(getSimilarty()).append("\n")
            .append("\tverify_time=").append(getVerifyTime()).append("\n")
            .append("\tcreate_time=").append(getCreateTime()).append("\n")
            .append("]\n")
            .toString();
    }

    @Override
    public int compareTo(LogBean object){
    	return getId().compareTo(object.getId());
    }
    /**
    * Copies property of the passed bean into the current bean.<br>
    * if bean.isNew() is true, call {@link #copyIfNotNull(GfCodeBeanBase)}
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copy(LogBean bean)
    {
        if(bean.isNew()){
            copyIfNotNull(bean);
        }else{        
            isNew(bean.isNew());
            setId(bean.getId());
            setPersonId(bean.getPersonId());
            setDeviceId(bean.getDeviceId());
            setVerifyFace(bean.getVerifyFace());
            setCompareFace(bean.getCompareFace());
            setSimilarty(bean.getSimilarty());
            setVerifyTime(bean.getVerifyTime());
            setCreateTime(bean.getCreateTime());
        }
    }
    /**
    * Copies property of the passed bean into the current bean if property not null.
    *
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copyIfNotNull(LogBean bean)
    {
        isNew(bean.isNew());
        if(bean.getId()!=null)
            setId(bean.getId());
        if(bean.getPersonId()!=null)
            setPersonId(bean.getPersonId());
        if(bean.getDeviceId()!=null)
            setDeviceId(bean.getDeviceId());
        if(bean.getVerifyFace()!=null)
            setVerifyFace(bean.getVerifyFace());
        if(bean.getCompareFace()!=null)
            setCompareFace(bean.getCompareFace());
        if(bean.getSimilarty()!=null)
            setSimilarty(bean.getSimilarty());
        if(bean.getVerifyTime()!=null)
            setVerifyTime(bean.getVerifyTime());
        if(bean.getCreateTime()!=null)
            setCreateTime(bean.getCreateTime());
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public LogBean clean()
    {
        isNew(true);
        setId(null);
        setPersonId(null);
        setDeviceId(null);
        setVerifyFace(null);
        setCompareFace(null);
        setSimilarty(null);
        setVerifyTime(null);
        setCreateTime(null);
        return this;
    }
}
