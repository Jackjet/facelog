package net.gdface.facelog.db;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * FlDeviceBeanBase is a mapping of fl_device Table.
 * <br>Meta Data Information (in progress):
 * <ul>
 *    <li>comments: 前端设备基本信息 </li>
 * </ul>
 * @author guyadong
*/
public class DeviceBean
    implements Serializable,Comparable<DeviceBean>
{
	private static final long serialVersionUID = -5263172151311428153L;

	/**
     * comments:设备id
     */
    protected Integer id;

    /**
     * comments:设备名称
     */
    protected String name;

    /**
     * comments:设备是否在线标记
     */
    protected Boolean online;

    /**
     * comments:设备所属组id
     */
    protected Integer groupId;

    /**
     * comments:设备版本号
     */
    protected String version;

    protected java.util.Date createTime;

    protected java.util.Date updateTime;

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
     * Prefered methods to create a FlDeviceBeanBaseBase is via the createFlDeviceBeanBase method in FlDeviceManager or
     * via the factory class FlDeviceFactory create method
     */
    public DeviceBean(){
    }
    
    /**
     * create a FlDeviceBeanBase from a instance
     */
    public DeviceBean(DeviceBean bean){
        this.copy(bean);
    }
    
    /**
     * Getter method for {@link #id}.<br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: fl_device.id</li>
     * <li> imported key: fl_log.device_id</li>
     * <li> imported key: fl_image.device_id</li>
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
     * Getter method for {@link #name}.<br>
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
     * Setter method for {@link #name}.<br>
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
     * Getter method for {@link #online}.<br>
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
     * Setter method for {@link #online}.<br>
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
     * Setter method for {@link #online}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to online
     */
    public void setOnline(boolean newVal){
        setOnline(new Boolean(newVal));
    }

    /**
     * Getter method for {@link #groupId}.<br>
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
     * Setter method for {@link #groupId}.<br>
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
     * Setter method for {@link #groupId}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to groupId
     */
    public void setGroupId(int newVal){
        setGroupId(new Integer(newVal));
    }

    /**
     * Getter method for {@link #version}.<br>
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
     * Setter method for {@link #version}.<br>
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
     * Getter method for {@link #createTime}.<br>
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

    /**
     * Getter method for {@link #updateTime}.<br>
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
     * Setter method for {@link #updateTime}.<br>
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
     * Setter method for {@link #updateTime}.<br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to updateTime
     */
    public void setUpdateTime(long newVal){
        setUpdateTime(new java.util.Date(newVal));
    }



    @Override
    public boolean equals(Object object)
    {
        if (!(object instanceof DeviceBean)) {
            return false;
        }

        DeviceBean obj = (DeviceBean) object;
        return new EqualsBuilder()
            .append(getId(), obj.getId())
            .append(getName(), obj.getName())
            .append(getOnline(), obj.getOnline())
            .append(getGroupId(), obj.getGroupId())
            .append(getVersion(), obj.getVersion())
            .append(getCreateTime(), obj.getCreateTime())
            .append(getUpdateTime(), obj.getUpdateTime())
            .isEquals();
    }

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(-82280557, -700257973)
            .append(getId())
            .append(getName())
            .append(getOnline())
            .append(getGroupId())
            .append(getVersion())
            .append(getCreateTime())
            .append(getUpdateTime())
            .toHashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getName()).append("@").append(Integer.toHexString(this.hashCode())).append("[\n")
            .append("\tid=").append(getId()).append("\n")
            .append("\tname=").append(getName()).append("\n")
            .append("\tonline=").append(getOnline()).append("\n")
            .append("\tgroup_id=").append(getGroupId()).append("\n")
            .append("\tversion=").append(getVersion()).append("\n")
            .append("\tcreate_time=").append(getCreateTime()).append("\n")
            .append("\tupdate_time=").append(getUpdateTime()).append("\n")
            .append("]\n")
            .toString();
    }

    @Override
    public int compareTo(DeviceBean object){
    	return getId().compareTo(object.getId());
    }
    /**
    * Copies property of the passed bean into the current bean.<br>
    * if bean.isNew() is true, call {@link #copyIfNotNull(GfCodeBeanBase)}
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copy(DeviceBean bean)
    {
        if(bean.isNew()){
            copyIfNotNull(bean);
        }else{        
            isNew(bean.isNew());
            setId(bean.getId());
            setName(bean.getName());
            setOnline(bean.getOnline());
            setGroupId(bean.getGroupId());
            setVersion(bean.getVersion());
            setCreateTime(bean.getCreateTime());
            setUpdateTime(bean.getUpdateTime());
        }
    }
    /**
    * Copies property of the passed bean into the current bean if property not null.
    *
    * @param bean the bean to copy into the current bean
    * @author guyadong
    */
    public void copyIfNotNull(DeviceBean bean)
    {
        isNew(bean.isNew());
        if(bean.getId()!=null)
            setId(bean.getId());
        if(bean.getName()!=null)
            setName(bean.getName());
        if(bean.getOnline()!=null)
            setOnline(bean.getOnline());
        if(bean.getGroupId()!=null)
            setGroupId(bean.getGroupId());
        if(bean.getVersion()!=null)
            setVersion(bean.getVersion());
        if(bean.getCreateTime()!=null)
            setCreateTime(bean.getCreateTime());
        if(bean.getUpdateTime()!=null)
            setUpdateTime(bean.getUpdateTime());
    }

    /**
    * set all field to null
    *
    * @author guyadong
    */
    public DeviceBean clean()
    {
        isNew(true);
        setId(null);
        setName(null);
        setOnline(null);
        setGroupId(null);
        setVersion(null);
        setCreateTime(null);
        setUpdateTime(null);
        return this;
    }
}
