// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
// ______________________________________________________

package net.gdface.facelog.dborm.log;
import java.io.Serializable;
import net.gdface.facelog.dborm.Constant;
import net.gdface.facelog.dborm.BaseBean;
import net.gdface.facelog.dborm.device.FlDeviceBean;
import net.gdface.facelog.dborm.face.FlFaceBean;
import net.gdface.facelog.dborm.person.FlPersonBean;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;
/**
 * FlLogBean is a mapping of fl_log Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 人脸验证日志,记录所有通过验证的人员 </li>
 * </ul>
 * @author guyadong
*/
public class FlLogBean
    implements Serializable,BaseBean<FlLogBean>,Comparable<FlLogBean>,Constant
{
    private static final long serialVersionUID = 7869683986300606649L;
    
    /** comments:日志id */
    private Integer id;

    /** comments:外键,用户id */
    private Integer personId;

    /** comments:外键,图像来源设备id */
    private Integer deviceId;

    /** comments:外键,验证人脸信息id */
    private String verifyFace;

    /** comments:外键,数据库中最相似的对比人脸id */
    private String compareFace;

    /** comments:验证相似度 */
    private Double similarty;

    /** comments:验证时间(可能由前端设备提供时间) */
    private java.util.Date verifyTime;

    private java.util.Date createTime;

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
    public FlLogBean(){
        super();
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
    public void setId(Integer newVal)
    {
        if ((newVal != null && id != null && (newVal.compareTo(id) == 0)) ||
            (newVal == null && id == null && checkIdInitialized())) {
            return;
        }
        id = newVal;

        modified |= FL_LOG_ID_ID_MASK;
        initialized |= FL_LOG_ID_ID_MASK;
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
        return 0L !=  (modified & FL_LOG_ID_ID_MASK);
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
        return 0L !=  (initialized & FL_LOG_ID_ID_MASK);
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
    public void setPersonId(Integer newVal)
    {
        if ((newVal != null && personId != null && (newVal.compareTo(personId) == 0)) ||
            (newVal == null && personId == null && checkPersonIdInitialized())) {
            return;
        }
        personId = newVal;

        modified |= FL_LOG_ID_PERSON_ID_MASK;
        initialized |= FL_LOG_ID_PERSON_ID_MASK;
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
        return 0L !=  (modified & FL_LOG_ID_PERSON_ID_MASK);
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
        return 0L !=  (initialized & FL_LOG_ID_PERSON_ID_MASK);
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
    public void setDeviceId(Integer newVal)
    {
        if ((newVal != null && deviceId != null && (newVal.compareTo(deviceId) == 0)) ||
            (newVal == null && deviceId == null && checkDeviceIdInitialized())) {
            return;
        }
        deviceId = newVal;

        modified |= FL_LOG_ID_DEVICE_ID_MASK;
        initialized |= FL_LOG_ID_DEVICE_ID_MASK;
    }

    /**
     * Setter method for {@link #deviceId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to deviceId
     */
    public void setDeviceId(int newVal)
    {
        setDeviceId(new Integer(newVal));
    }
    /**
     * Determines if the deviceId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkDeviceIdModified()
    {
        return 0L !=  (modified & FL_LOG_ID_DEVICE_ID_MASK);
    }

    /**
     * Determines if the deviceId has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkDeviceIdInitialized()
    {
        return 0L !=  (initialized & FL_LOG_ID_DEVICE_ID_MASK);
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
    public void setVerifyFace(String newVal)
    {
        if ((newVal != null && verifyFace != null && (newVal.compareTo(verifyFace) == 0)) ||
            (newVal == null && verifyFace == null && checkVerifyFaceInitialized())) {
            return;
        }
        verifyFace = newVal;

        modified |= FL_LOG_ID_VERIFY_FACE_MASK;
        initialized |= FL_LOG_ID_VERIFY_FACE_MASK;
    }

    /**
     * Determines if the verifyFace has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkVerifyFaceModified()
    {
        return 0L !=  (modified & FL_LOG_ID_VERIFY_FACE_MASK);
    }

    /**
     * Determines if the verifyFace has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkVerifyFaceInitialized()
    {
        return 0L !=  (initialized & FL_LOG_ID_VERIFY_FACE_MASK);
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
    public void setCompareFace(String newVal)
    {
        if ((newVal != null && compareFace != null && (newVal.compareTo(compareFace) == 0)) ||
            (newVal == null && compareFace == null && checkCompareFaceInitialized())) {
            return;
        }
        compareFace = newVal;

        modified |= FL_LOG_ID_COMPARE_FACE_MASK;
        initialized |= FL_LOG_ID_COMPARE_FACE_MASK;
    }

    /**
     * Determines if the compareFace has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkCompareFaceModified()
    {
        return 0L !=  (modified & FL_LOG_ID_COMPARE_FACE_MASK);
    }

    /**
     * Determines if the compareFace has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkCompareFaceInitialized()
    {
        return 0L !=  (initialized & FL_LOG_ID_COMPARE_FACE_MASK);
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
    public void setSimilarty(Double newVal)
    {
        if ((newVal != null && similarty != null && (newVal.compareTo(similarty) == 0)) ||
            (newVal == null && similarty == null && checkSimilartyInitialized())) {
            return;
        }
        similarty = newVal;

        modified |= FL_LOG_ID_SIMILARTY_MASK;
        initialized |= FL_LOG_ID_SIMILARTY_MASK;
    }

    /**
     * Setter method for {@link #similarty}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to similarty
     */
    public void setSimilarty(double newVal)
    {
        setSimilarty(new Double(newVal));
    }
    /**
     * Determines if the similarty has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkSimilartyModified()
    {
        return 0L !=  (modified & FL_LOG_ID_SIMILARTY_MASK);
    }

    /**
     * Determines if the similarty has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkSimilartyInitialized()
    {
        return 0L !=  (initialized & FL_LOG_ID_SIMILARTY_MASK);
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
    public void setVerifyTime(java.util.Date newVal)
    {
        if ((newVal != null && verifyTime != null && (newVal.compareTo(verifyTime) == 0)) ||
            (newVal == null && verifyTime == null && checkVerifyTimeInitialized())) {
            return;
        }
        verifyTime = newVal;

        modified |= FL_LOG_ID_VERIFY_TIME_MASK;
        initialized |= FL_LOG_ID_VERIFY_TIME_MASK;
    }

    /**
     * Setter method for {@link #verifyTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to verifyTime
     */
    public void setVerifyTime(long newVal)
    {
        setVerifyTime(new java.util.Date(newVal));
    }
    /**
     * Determines if the verifyTime has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean checkVerifyTimeModified()
    {
        return 0L !=  (modified & FL_LOG_ID_VERIFY_TIME_MASK);
    }

    /**
     * Determines if the verifyTime has been initialized.<br>
     *
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean checkVerifyTimeInitialized()
    {
        return 0L !=  (initialized & FL_LOG_ID_VERIFY_TIME_MASK);
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
    public void setCreateTime(java.util.Date newVal)
    {
        if ((newVal != null && createTime != null && (newVal.compareTo(createTime) == 0)) ||
            (newVal == null && createTime == null && checkCreateTimeInitialized())) {
            return;
        }
        createTime = newVal;

        modified |= FL_LOG_ID_CREATE_TIME_MASK;
        initialized |= FL_LOG_ID_CREATE_TIME_MASK;
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
        return 0L !=  (modified & FL_LOG_ID_CREATE_TIME_MASK);
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
        return 0L !=  (initialized & FL_LOG_ID_CREATE_TIME_MASK);
    }
    //////////////////////////////////////
    // referenced bean for FOREIGN KEYS
    //////////////////////////////////////
    /** 
     * The referenced {@link FlDeviceBean} by {@link #deviceId} . <br>
     * FOREIGN KEY (device_id) REFERENCES fl_device(id)
     */
    private FlDeviceBean referencedByDeviceId;
    /** Getter method for {@link #referencedByDeviceId}. */
    public FlDeviceBean getReferencedByDeviceId() {
        return this.referencedByDeviceId;
    }
    /** Setter method for {@link #referencedByDeviceId}. */
    public void setReferencedByDeviceId(FlDeviceBean reference) {
        this.referencedByDeviceId = reference;
    }
    /** 
     * The referenced {@link FlFaceBean} by {@link #verifyFace} . <br>
     * FOREIGN KEY (verify_face) REFERENCES fl_face(md5)
     */
    private FlFaceBean referencedByVerifyFace;
    /** Getter method for {@link #referencedByVerifyFace}. */
    public FlFaceBean getReferencedByVerifyFace() {
        return this.referencedByVerifyFace;
    }
    /** Setter method for {@link #referencedByVerifyFace}. */
    public void setReferencedByVerifyFace(FlFaceBean reference) {
        this.referencedByVerifyFace = reference;
    }
    /** 
     * The referenced {@link FlFaceBean} by {@link #compareFace} . <br>
     * FOREIGN KEY (compare_face) REFERENCES fl_face(md5)
     */
    private FlFaceBean referencedByCompareFace;
    /** Getter method for {@link #referencedByCompareFace}. */
    public FlFaceBean getReferencedByCompareFace() {
        return this.referencedByCompareFace;
    }
    /** Setter method for {@link #referencedByCompareFace}. */
    public void setReferencedByCompareFace(FlFaceBean reference) {
        this.referencedByCompareFace = reference;
    }
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
        case FL_LOG_ID_ID:
            return checkIdModified();
        case FL_LOG_ID_PERSON_ID:
            return checkPersonIdModified();
        case FL_LOG_ID_DEVICE_ID:
            return checkDeviceIdModified();
        case FL_LOG_ID_VERIFY_FACE:
            return checkVerifyFaceModified();
        case FL_LOG_ID_COMPARE_FACE:
            return checkCompareFaceModified();
        case FL_LOG_ID_SIMILARTY:
            return checkSimilartyModified();
        case FL_LOG_ID_VERIFY_TIME:
            return checkVerifyTimeModified();
        case FL_LOG_ID_CREATE_TIME:
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
        case FL_LOG_ID_ID:
            return checkIdInitialized();
        case FL_LOG_ID_PERSON_ID:
            return checkPersonIdInitialized();
        case FL_LOG_ID_DEVICE_ID:
            return checkDeviceIdInitialized();
        case FL_LOG_ID_VERIFY_FACE:
            return checkVerifyFaceInitialized();
        case FL_LOG_ID_COMPARE_FACE:
            return checkCompareFaceInitialized();
        case FL_LOG_ID_SIMILARTY:
            return checkSimilartyInitialized();
        case FL_LOG_ID_VERIFY_TIME:
            return checkVerifyTimeInitialized();
        case FL_LOG_ID_CREATE_TIME:
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
     * Resets the object initialization status to 'not initialized'.
     */
    private void resetInitialized()
    {
        initialized = 0L;
    }
    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof FlLogBean)) {
            return false;
        }

        FlLogBean obj = (FlLogBean) object;
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
    public int compareTo(FlLogBean object){
        return new CompareToBuilder()
            .append(getId(), object.getId())
            .toComparison();
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlLogBean clean()
    {
        setId(null);
        setPersonId(null);
        setDeviceId(null);
        setVerifyFace(null);
        setCompareFace(null);
        setSimilarty(null);
        setVerifyTime(null);
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
    public void copy(FlLogBean bean, int... fieldList)
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
    }
        
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     */
    public void copy(FlLogBean bean, String... fieldList)
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
        case FL_LOG_ID_ID: 
            return (T)getId();        
        case FL_LOG_ID_PERSON_ID: 
            return (T)getPersonId();        
        case FL_LOG_ID_DEVICE_ID: 
            return (T)getDeviceId();        
        case FL_LOG_ID_VERIFY_FACE: 
            return (T)getVerifyFace();        
        case FL_LOG_ID_COMPARE_FACE: 
            return (T)getCompareFace();        
        case FL_LOG_ID_SIMILARTY: 
            return (T)getSimilarty();        
        case FL_LOG_ID_VERIFY_TIME: 
            return (T)getVerifyTime();        
        case FL_LOG_ID_CREATE_TIME: 
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
        case FL_LOG_ID_ID:        
            setId((Integer)value);
        case FL_LOG_ID_PERSON_ID:        
            setPersonId((Integer)value);
        case FL_LOG_ID_DEVICE_ID:        
            setDeviceId((Integer)value);
        case FL_LOG_ID_VERIFY_FACE:        
            setVerifyFace((String)value);
        case FL_LOG_ID_COMPARE_FACE:        
            setCompareFace((String)value);
        case FL_LOG_ID_SIMILARTY:        
            setSimilarty((Double)value);
        case FL_LOG_ID_VERIFY_TIME:        
            setVerifyTime((java.util.Date)value);
        case FL_LOG_ID_CREATE_TIME:        
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
        int index = FL_LOG_FIELDS_LIST.indexOf(column);
        if( 0 > index ) 
            index = FL_LOG_JAVA_FIELDS_LIST.indexOf(column);
        return index;    
    }
}
