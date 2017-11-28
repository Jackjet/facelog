// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: command.adapter.java.vm
// ______________________________________________________

package net.gdface.facelog.client;

import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 设备命令执行基类,应用项目根据需要继承此类,实现命令方法<br>
 * 没有override的方法会抛出{@link UnsupportCmdExeption}异常,
 * 命令响应端收到的对应命令执行状态是{@link Ack.Status#UNSUPPORTED}
 * @author guyadong
 *
 */
public class CommandAdapter {
    /** 
     * 发送给命令响应接收端的异常,
     * 如果希望命令响应端收到设备命令执行的异常信息,
     * 就将异常信息封装到此类中抛出.
     */
    @SuppressWarnings("serial")
    protected class DeviceCmdException extends Exception {
        protected DeviceCmdException() {}

        protected DeviceCmdException(String message, Throwable cause) {
            super(message, cause);
        }

        protected DeviceCmdException(String message) {
            super(message);
        }

        protected DeviceCmdException(Throwable cause) {
            super(cause);
        }
    }
    /** 当前命令设备端未实现时抛出此异常 */
    @SuppressWarnings("serial")
    protected class UnsupportCmdExeption extends RuntimeException {
        private UnsupportCmdExeption() {}
    }
    /**
     * 设备命令 <br>
     * 设置参数,可用于运行时修改参数<br>
     * @param key 参数名
     * @param value 参数值
     *
     */
    public void parameter(String key,String value)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设置一组参数,可用于需要重启有效的参数<br>
     * @param properties 参数配置对象, {@code 参数名(key)->参数值(value)映射}
     *
     */
    public void config(Map<String,String> properties)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 读取设备状态参数<br>
     * @param name 需要报告状态的参数名
     * @return {@code name}指定设备状态参数值
     *
     */
    public Object status(String name)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设备状态报告,返回一组状态参数<br>
     * @param names 需要报告状态的参数名列表
     * @return 设备状态参数对象,{@code 参数名(key)->参数值(value)映射},key与{@code names}对应
     *
     */
    public Map<String,Object> report(List<String> names)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 获取设备版本号<br>
     * @return 返回设备版本描述
     *
     */
    public String version()throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设置设备工作状态<br>
     * @param enable {@code true}:工作状态,否则为非工作状态
     *
     */
    public void enable(Boolean enable)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 返回设备工作状态<br>
     * @param message 工作状态附加消息,比如"设备维修,禁止通行"
     * @return 为{@code true}:工作状态,{@code false}:非工作状态
     *
     */
    public Boolean isEnable(String message)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设备重启<br>
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     *
     */
    public void reset(Long schedule)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设备与服务器时间同步<br>
     * @param unixTimestamp 服务器 unix 时间[秒],参见<a href = "https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
     *
     */
    public void time(Long unixTimestamp)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 更新版本<br>
     * @param url 更新版本的位置
     * @param version 版本号
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     *
     */
    public void update(URL url,String version,Long schedule)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 设置空闲时显示的消息<br>
     * @param message 发送到设备的消息
     * @param duration 持续时间[分钟],为{@code null}一直显示
     *
     */
    public void idleMessage(String message,Long duration)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 为指定人员通过时显示的临时消息<br>
     * @param message 发送到设备的消息
     * @param id 人员/人员组ID
     * @param group 为{@code true}时{@code id}参数为人员组ID
     * @param onceOnly 为{@code true}时只显示一次
     * @param duration 持续时间[分钟],为{@code null}一直显示
     *
     */
    public void personMessage(String message,Integer id,Boolean group,Boolean onceOnly,Long duration)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
    /**
     * 设备命令 <br>
     * 自定义命令,命令名及命令参数由项目自定义<br>
     * @param cmdName 自定义命令名称
     * @param parameters 自定义参数表
     * @return 返回自定义结果对象
     *
     */
    public Object custom(String cmdName,Map<String,Object> parameters)throws DeviceCmdException{
        throw new UnsupportCmdExeption();
    }
}