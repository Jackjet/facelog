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

package net.gdface.facelog.dborm.device;
import net.gdface.facelog.dborm.BaseBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import net.gdface.facelog.dborm.CompareToBuilder;
import net.gdface.facelog.dborm.EqualsBuilder;
import net.gdface.facelog.dborm.HashCodeBuilder;

/**
 * FlDeviceBean is a mapping of fl_device Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 前端设备基本信息 </li>
 * </ul>
 * @author guyadong
*/
public class FlDeviceBeanBase
    implements Serializable,BaseBean<FlDeviceBeanBase>
{
	private static final long serialVersionUID = -7373963352301050910L;
	
    protected java.util.Date updateTime;

    protected java.util.Date createTime;

    protected String version;

    protected Integer groupId;

    protected Boolean online;

    protected String name;

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
     * Prefered methods to create a FlDeviceBeanBase is via the createFlDeviceBean method in FlDeviceManager or
     * via the factory class FlDeviceFactory create method
     */
    public FlDeviceBeanBase(){
    }
    /**
     * create a FlDeviceBeanBase from a instance
     */
    public FlDeviceBeanBase(FlDeviceBeanBase bean){
        this.copy(bean);
    }
    /**
     * Getter method for updateTime.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.update_time</li>
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
     * <li>full name: fl_device.create_time</li>
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
     * Getter method for version.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.version</li>
     * <li>comments: 设备版本号</li>
     * <li>column size: 32</li>
     * <li>jdbc type returned by the driver: Types.VARCHAR</li>
     * </ul>
     *
     * @return the value of version
     */
    public String getVersion(){
        return version;
    }
    /**
     * Setter method for version.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to version
     */
    public void setVersion(String newVal){    
        version = newVal;
    }



    /**
     * Getter method for groupId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.group_id</li>
     * <li>comments: 设备所属组id</li>
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
     * Getter method for online.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.online</li>
     * <li>comments: 设备是否在线标记</li>
     * <li>column size: 1</li>
     * <li>jdbc type returned by the driver: Types.BIT</li>
     * </ul>
     *
     * @return the value of online
     */
    public Boolean getOnline(){
        return online;
    }
    /**
     * Setter method for online.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to online
     */
    public void setOnline(Boolean newVal){    
        online = newVal;
    }

    /**
     * Setter method for online.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to online
     */
    public void setOnline(boolean newVal){
        setOnline(new Boolean(newVal));
    }


    /**
     * Getter method for name.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.name</li>
     * <li>comments: 设备名称</li>
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
     * Getter method for id.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.id</li>
     * <li> imported key: fl_image.device_id</li>
     * <li> imported key: fl_log.device_id</li>
     * <li>comments: 设备id</li>
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
        if (!(object instanceof FlDeviceBean)) {
            return false;
        }

        FlDeviceBean obj = (FlDeviceBean) object;
        return new EqualsBuilder()
            .append(getUpdateTime(), obj.getUpdateTime())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getVersion(), obj.getVersion())
            .append(getGroupId(), obj.getGroupId())
            .append(getOnline(), obj.getOnline())
            .append(getName(), obj.getName())
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
            .append(getVersion())
            .append(getGroupId())
            .append(getOnline())
            .append(getName())
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
            .append("\tversion=").append(getVersion()).append("\n")
            .append("\tgroup_id=").append(getGroupId()).append("\n")
            .append("\tonline=").append(getOnline()).append("\n")
            .append("\tname=").append(getName()).append("\n")
            .append("\tid=").append(getId()).append("\n")
            .append("]\n")
            .toString();
    }


    public int compareTo(Object object){
        FlDeviceBean obj = (FlDeviceBean) object;
        return new CompareToBuilder()
            .append(getUpdateTime(), obj.getUpdateTime())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getVersion(), obj.getVersion())
            .append(getGroupId(), obj.getGroupId())
            .append(getOnline(), obj.getOnline())
            .append(getName(), obj.getName())
            .append(getId(), obj.getId())
            .toComparison();
    }
    /**
    * Copies proterty of the passed bean into the current bean.<br>
    * if bean.isNew() is true, call {@link #copyIfNotNull(GfCodeBeanBase)}
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copy(FlDeviceBeanBase bean)
    {
        if(bean.isNew()){
            copyIfNotNull(bean);
        }else{        
            isNew(bean.isNew());
            setUpdateTime(bean.getUpdateTime());
            setCreateTime(bean.getCreateTime());
            setVersion(bean.getVersion());
            setGroupId(bean.getGroupId());
            setOnline(bean.getOnline());
            setName(bean.getName());
            setId(bean.getId());
        }
    }
    /**
    * Copies proterty of the passed bean into the current bean if property not null.
    *
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copyIfNotNull(FlDeviceBeanBase bean)
    {
        isNew(bean.isNew());
        if(bean.getUpdateTime()!=null)
            setUpdateTime(bean.getUpdateTime());
        if(bean.getCreateTime()!=null)
            setCreateTime(bean.getCreateTime());
        if(bean.getVersion()!=null)
            setVersion(bean.getVersion());
        if(bean.getGroupId()!=null)
            setGroupId(bean.getGroupId());
        if(bean.getOnline()!=null)
            setOnline(bean.getOnline());
        if(bean.getName()!=null)
            setName(bean.getName());
        if(bean.getId()!=null)
            setId(bean.getId());
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public FlDeviceBeanBase clean()
    {
        isNew(true);
        setUpdateTime(null);
        setCreateTime(null);
        setVersion(null);
        setGroupId(null);
        setOnline(null);
        setName(null);
        setId(null);
        return this;
    }
    
    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     * @param fieldList the column name list to copy into the current bean
     */
    public void copy(FlDeviceBeanBase bean, String[] fieldList)
    {
        if (null == fieldList)
            copy(bean);
        else
            for (int i = 0; i < fieldList.length; i++) {
                setObject(fieldList[i].trim(), bean.getObject(fieldList[i].trim()));
            }
    }
    /**
     * create new FlDeviceBean form {@code bean} if not instanceof FlDeviceBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @see #toFullBean()
    * @author guyadong
    */
    public final static FlDeviceBean toFullBean(FlDeviceBeanBase bean)
    {
        return null==bean?null:(bean.toFullBean());
    }
    /**
    * @param bases
    * @return
    * @see #toFullBean(FlDeviceBeanBase)
    * @author guyadong
    */
    public static FlDeviceBean[] toFullBean(FlDeviceBeanBase[] bases){
        FlDeviceBean[] b = new FlDeviceBean[bases.length];
        for(int i=0;i<b.length;i++){
            b[i]=toFullBean(bases[i]);
        }
        return b;
    }
    /**
     * create new FlDeviceBean form {@code bean} if not instanceof FlDeviceBean<br>
     * 
    * @param bean
    * @return null if bean is null
    * @author guyadong
    */
    @SuppressWarnings("unchecked")
    public FlDeviceBean toFullBean()
    {
        return this instanceof FlDeviceBean?(FlDeviceBean)this:new FlDeviceBean(this);
    }

    /**
     * return a dictionnary of the object
     */
    public Map<String,String> readDictionnary()
    {
        Map<String,String> dictionnary = new HashMap<String,String>();
        dictionnary.put("update_time", getUpdateTime() == null ? "" : getUpdateTime().toString());
        dictionnary.put("create_time", getCreateTime() == null ? "" : getCreateTime().toString());
        dictionnary.put("version", getVersion() == null ? "" : getVersion().toString());
        dictionnary.put("group_id", getGroupId() == null ? "" : getGroupId().toString());
        dictionnary.put("online", getOnline() == null ? "" : getOnline().toString());
        dictionnary.put("name", getName() == null ? "" : getName().toString());
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
        } else if ("version".equalsIgnoreCase(column) || "version".equalsIgnoreCase(column)) {
            return getVersion() == null ? "" : getVersion().toString();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return getGroupId() == null ? "" : getGroupId().toString();
        } else if ("online".equalsIgnoreCase(column) || "online".equalsIgnoreCase(column)) {
            return getOnline() == null ? "" : getOnline().toString();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? "" : getName().toString();
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
        } else if ("version".equalsIgnoreCase(column) || "version".equalsIgnoreCase(column)) {
            return getVersion() == null ? null : (T)getVersion();
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            return getGroupId() == null ? null : (T)getGroupId();
        } else if ("online".equalsIgnoreCase(column) || "online".equalsIgnoreCase(column)) {
            return getOnline() == null ? null : (T)getOnline();
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            return getName() == null ? null : (T)getName();
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
        } else if ("version".equalsIgnoreCase(column) || "version".equalsIgnoreCase(column)) {
            setVersion((String)object);
        } else if ("group_id".equalsIgnoreCase(column) || "groupId".equalsIgnoreCase(column)) {
            setGroupId((Integer)object);
        } else if ("online".equalsIgnoreCase(column) || "online".equalsIgnoreCase(column)) {
            setOnline((Boolean)object);
        } else if ("name".equalsIgnoreCase(column) || "name".equalsIgnoreCase(column)) {
            setName((String)object);
        } else if ("id".equalsIgnoreCase(column) || "id".equalsIgnoreCase(column)) {
            setId((Integer)object);
        }
    }
}
