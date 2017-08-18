// ______________________________________________________
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Please help us improve this tool by reporting:
// - problems and suggestions to
//   http://sourceforge.net/tracker/?group_id=54687
// - feedbacks and ideas on
//   http://sourceforge.net/forum/forum.php?forum_id=182208
// ______________________________________________________

package net.gdface.facelog.dborm.log;
import net.gdface.facelog.dborm.BaseBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;

/**
 * FlLogLightBean is a mapping of fl_log_light Table.
 * @author guyadong
*/
public class FlLogLightBeanBase
    implements Serializable,BaseBean<FlLogLightBeanBase>
{
	private static final long serialVersionUID = 6673501298917582232L;
	
    protected java.util.Date verifyTime;

    protected String papersNum;

    protected Boolean papersType;

    protected String name;

    protected Integer personId;

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
     * Prefered methods to create a FlLogLightBeanBase is via the createFlLogLightBean method in FlLogLightManager or
     * via the factory class FlLogLightFactory create method
     */
    public FlLogLightBeanBase(){
    }
    /**
     * create a FlLogLightBeanBase from a instance
     */
    public FlLogLightBeanBase(FlLogLightBeanBase bean){
        this.copy(bean);
    }
    /**
     * Getter method for verifyTime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log_light.verify_time</li>
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
     * Setter method for verifyTime.
     * <br>
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
     * Setter method for verifyTime.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to verifyTime
     */
    public void setVerifyTime(long newVal){
        setVerifyTime(new java.util.Date(newVal));
    }


    /**
     * Getter method for papersNum.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log_light.papers_num</li>
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
     * <li>full name: fl_log_light.papers_type</li>
     * <li>comments: 证件类型,0:未知,1:身份证,2:护照,3:台胞证,4:港澳通行证,5:军官证,6:外国人居留证,7:员工卡,8:其他</li>
     * <li>column size: 0</li>
     * <li>jdbc type returned by the driver: Types.BIT</li>
     * </ul>
     *
     * @return the value of papersType
     */
    public Boolean getPapersType(){
        return papersType;
    }
    /**
     * Setter method for papersType.
     * <br>
     * Attention, there will be no comparison with current value which
     * means calling this method will mark the field as 'modified' in all cases.
     *
     * @param newVal the new value to be assigned to papersType
     */
    public void setPapersType(Boolean newVal){    
        papersType = newVal;
    }

    /**
     * Setter method for papersType.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to papersType
     */
    public void setPapersType(boolean newVal){
        setPapersType(new Boolean(newVal));
    }


    /**
     * Getter method for name.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log_light.name</li>
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
     * Getter method for personId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log_light.person_id</li>
     * <li>comments: 用户识别码</li>
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
     * Setter method for personId.
     * <br>
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
     * Setter method for personId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to personId
     */
    public void setPersonId(int newVal){
        setPersonId(new Integer(newVal));
    }


    /**
     * Getter method for id.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_log_light.id</li>
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


    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object)
    {
        if (!(object instanceof FlLogLightBean)) {
            return false;
        }

        FlLogLightBean obj = (FlLogLightBean) object;
        return new EqualsBuilder()
            .append(getVerifyTime(), obj.getVerifyTime())
            .append(getPapersNum(), obj.getPapersNum())
            .append(getPapersType(), obj.getPapersType())
            .append(getName(), obj.getName())
            .append(getPersonId(), obj.getPersonId())
            .append(getId(), obj.getId())
            .isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getVerifyTime())
            .append(getPapersNum())
            .append(getPapersType())
            .append(getName())
            .append(getPersonId())
            .append(getId())
            .toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tverify_time=").append(getVerifyTime()).append("\n")
            .append("\tpapers_num=").append(getPapersNum()).append("\n")
            .append("\tpapers_type=").append(getPapersType()).append("\n")
            .append("\tname=").append(getName()).append("\n")
            .append("\tperson_id=").append(getPersonId()).append("\n")
            .append("\tid=").append(getId()).append("\n")
            .append("]\n")
            .toString();
    }


    public int compareTo(Object object){
        FlLogLightBean obj = (FlLogLightBean) object;
        return new CompareToBuilder()
            .append(getVerifyTime(), obj.getVerifyTime())
            .append(getPapersNum(), obj.getPapersNum())
            .append(getPapersType(), obj.getPapersType())
            .append(getName(), obj.getName())
            .append(getPersonId(), obj.getPersonId())
            .append(getId(), obj.getId())
            .toComparison();
    }
    /**
    * Copies proterty of the passed bean into the current bean.<br>
    * if bean.isNew() is true, call {@link #copyIfNotNull(GfCodeBeanBase)}
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copy(FlLogLightBeanBase bean)
    {
        if(bean.isNew()){
            copyIfNotNull(bean);
        }else{        
            isNew(bean.isNew());
            setVerifyTime(bean.getVerifyTime());
            setPapersNum(bean.getPapersNum());
            setPapersType(bean.getPapersType());
            setName(bean.getName());
            setPersonId(bean.getPersonId());
            setId(bean.getId());
        }
    }
    /**
    * Copies proterty of the passed bean into the current bean if property not null.
    *
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copyIfNotNull(FlLogLightBeanBase bean)
    {
        isNew(bean.isNew());
        if(bean.getVerifyTime()!=null)
            setVerifyTime(bean.getVerifyTime());
        if(bean.getPapersNum()!=null)
            setPapersNum(bean.getPapersNum());
        if(bean.getPapersType()!=null)
            setPapersType(bean.getPapersType());
        if(bean.getName()!=null)
            setName(bean.getName());
        if(bean.getPersonId()!=null)
            setPersonId(bean.getPersonId());
        if(bean.getId()!=null)
            setId(bean.getId());
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlLogLightBeanBase clean()
    {
        isNew(true);
        setVerifyTime(null);
        setPapersNum(null);
        setPapersType(null);
        setName(null);
        setPersonId(null);
        setId(null);
        return this;
    }
    
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     */
    public void copy(FlLogLightBeanBase bean, String[] fieldList)
    {
        if (null == fieldList)
            copy(bean);
        else
            for (int i = 0; i < fieldList.length; i++) {
                setObject(fieldList[i].trim(), bean.getObject(fieldList[i].trim()));
            }
    }
    /**
     * create new FlLogLightBean form {@code bean} if not instanceof FlLogLightBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @see #toFullBean()
    * @author guyadong
    */
    public final static FlLogLightBean toFullBean(FlLogLightBeanBase bean)
    {
        return null==bean?null:(bean.toFullBean());
    }
    /**
    * @param bases
    * @return
    * @see #toFullBean(FlLogLightBeanBase)
    * @author guyadong
    */
    public static FlLogLightBean[] toFullBean(FlLogLightBeanBase[] bases){
        FlLogLightBean[] b = new FlLogLightBean[bases.length];
        for(int i=0;i<b.length;i++){
            b[i]=toFullBean(bases[i]);
        }
        return b;
    }
    /**
     * create new FlLogLightBean form {@code bean} if not instanceof FlLogLightBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @author guyadong
    */
    @SuppressWarnings("unchecked")
    public FlLogLightBean toFullBean()
    {
        return this instanceof FlLogLightBean?(FlLogLightBean)this:new FlLogLightBean(this);
    }

    /**
     * return a dictionnary of the object
     */
    public Map<String,String> readDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("verify_time", getVerifyTime() == null ? "" : getVerifyTime().toString());
        dictionnary.put("papers_num", getPapersNum() == null ? "" : getPapersNum().toString());
        dictionnary.put("papers_type", getPapersType() == null ? "" : getPapersType().toString());
        dictionnary.put("name", getName() == null ? "" : getName().toString());
        dictionnary.put("person_id", getPersonId() == null ? "" : getPersonId().toString());
        dictionnary.put("id", getId() == null ? "" : getId().toString());
        return dictionnary;
    }

    /**
     * return a dictionnary of the pk columns
     * no primary key, the regular dictionnary is returned
     */
    public Map<String,String> readPkDictionnary()
    {
        return readDictionnary();
    }

    /**
     * return a the value string representation of the given field
     */
    public String getValue(String column)
    {
        if (null == column || "".equals(column)) {
            return "";
        } else if ("verify_time".equalsIgnoreCase(column) || "verifyTime".equalsIgnoreCase(column)) {
            return getVerifyTime() == null ? "" : getVerifyTime().toString();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return getPapersNum() == null ? "" : getPapersNum().toString();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return getPapersType() == null ? "" : getPapersType().toString();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? "" : getName().toString();
        } else if ("person_id".equalsIgnoreCase(column) || "personId".equalsIgnoreCase(column)) {
            return getPersonId() == null ? "" : getPersonId().toString();
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
        } else if ("verify_time".equalsIgnoreCase(column) || "verifyTime".equalsIgnoreCase(column)) {
            return getVerifyTime() == null ? null : (T)getVerifyTime();
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            return getPapersNum() == null ? null : (T)getPapersNum();
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            return getPapersType() == null ? null : (T)getPapersType();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? null : (T)getName();
        } else if ("person_id".equalsIgnoreCase(column) || "personId".equalsIgnoreCase(column)) {
            return getPersonId() == null ? null : (T)getPersonId();
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
        } else if ("verify_time".equalsIgnoreCase(column) || "verifyTime".equalsIgnoreCase(column)) {
            setVerifyTime((java.util.Date)object);
        } else if ("papers_num".equalsIgnoreCase(column) || "papersNum".equalsIgnoreCase(column)) {
            setPapersNum((String)object);
        } else if ("papers_type".equalsIgnoreCase(column) || "papersType".equalsIgnoreCase(column)) {
            setPapersType((Boolean)object);
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            setName((String)object);
        } else if ("person_id".equalsIgnoreCase(column) || "personId".equalsIgnoreCase(column)) {
            setPersonId((Integer)object);
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            setId((Integer)object);
        }
    }
}
