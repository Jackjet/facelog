// ______________________________________________________
// Generated by sql2java - https://github.com/10km/sql2java-2-6-7 (custom branch) 
// modified by guyadong from
// sql2java original version https://sourceforge.net/projects/sql2java/ 
// JDBC driver used at code generation time: com.mysql.jdbc.Driver
// template: cmd.manager.java.vm
// ______________________________________________________
package net.gdface.facelog.client;

import net.gdface.facelog.client.thrift.MQParam;
import net.gdface.facelog.client.thrift.Token;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

import gu.simplemq.Channel;
import gu.simplemq.redis.JedisPoolLazy;
import gu.simplemq.redis.RedisFactory;

import gu.simplemq.redis.RedisPublisher;
import gu.simplemq.redis.RedisSubscriber;

/**
 * 
 * client 端 redis管理模块<br>
 * 发送设备命令示例:
 * <pre>
 *    String ackChannel = iFaceLogClient.applyAckChannel(myToken); // 向facelog服务申请命令响应通道
 *    long cmdSn = iFaceLogClient.applyCmdSn(myToken); // 向facelog服务申请命令序列号
 *    targetBuilder()
 *        .setCmdSn(cmdSn) // 设置命令序列号
 *        .setDeviceTarget(deviceId) // 指定目标设备ID
 *        .setAckChannel(ackChannel) // 设置命令响应通道
 *        .build()
 *        .reset(null); // 执行reset命令,立即执行
 *    // 如果同时设置命令响应处理对象,请调用 reset(Long ,IAckAdapter&lt;Void&gt; )
 * </pre>
 * @author guyadong
 *
 */
public class CmdManager {    
    private final Channel<DeviceInstruction> cmdChannel;
    private final RedisPublisher redisPublisher ;
    private final Map<MQParam, String> redisParameters;
    private final RedisSubscriber subscriber;
    /**
     * 构造方法
     * @param poolLazy 
     * @param cmdDispatcher 
     * @param redisParameters redis 服务器参数,参见 {@link IFaceLogClient#getRedisParameters(Token)}
     */
    protected CmdManager(JedisPoolLazy poolLazy,
            CmdDispatcher cmdDispatcher,
            Map<MQParam, String> redisParameters) {
        this.redisPublisher = RedisFactory.getPublisher(checkNotNull(poolLazy));
        this.subscriber = RedisFactory.getSubscriber(checkNotNull(poolLazy));
        this.redisParameters = checkNotNull(redisParameters);
        this.cmdChannel = new Channel<DeviceInstruction>(
                this.redisParameters.get(MQParam.CMD_CHANNEL),
                cmdDispatcher){};
        this.subscriber.register(cmdChannel);
    }
    /**
     * 构造方法
     * @param poolLazy redis 连接池对象
     * @param adapter 应用程序执行设备命令的对象
     * @param redisParameters redis 服务器参数,参见 {@link IFaceLogClient#getRedisParameters(Token)}
     * @param deviceId 当前设备ID
     * @param groupIdSupplier 参见 {@link CmdDispatcher#CmdDispatcher(int, Supplier)}
     */
    public CmdManager(JedisPoolLazy poolLazy,
            CommandAdapter adapter,
            Map<MQParam, String> redisParameters,
            int deviceId, 
            Supplier<Integer> groupIdSupplier) {
        this(poolLazy,
                new CmdDispatcher(deviceId, groupIdSupplier).setCmdAdapter(adapter),
                redisParameters);
    }
    /**
     * 构造方法<br>
     * 使用默认{@link JedisPoolLazy}对象,参见 {@link JedisPoolLazy#getDefaultInstance()}
     * @param adapter
     * @param redisParameters
     * @param groupIdSupplier 
     * @param deviceId
     * @see #CmdManager(JedisPoolLazy, CommandAdapter, Map, int, List)
     */
    public CmdManager(CommandAdapter adapter,
            Map<MQParam, String> redisParameters,
            int deviceId, 
            Supplier<Integer> groupIdSupplier) {
        this(JedisPoolLazy.getDefaultInstance(),
        		adapter,
                redisParameters,
                deviceId,
                groupIdSupplier);
    }
    /**
     * 发送设备命令
     * @param cmd
     * @return 收到命令的客户端数目
     */
    private long sendCmd(DeviceInstruction cmd){
        checkArgument(null != cmd,"cmd is null");
        checkArgument(null != cmd.getCmd(),"DeviceInstruction.cmd field must not be null");
        checkArgument(null != cmd.getTarget() && !cmd.getTarget().isEmpty(),"DeviceInstruction.target field must not be null");
        if(null == cmd.getParameters()){
            cmd.setParameters(ImmutableMap.<String,Object>of());
        }
        return redisPublisher.publish(this.cmdChannel, cmd);
    }
    /** 
     * 设备命令构建类,用于设置除{@link DeviceInstruction#parameters}字段之的其他字段
     */
    public class CmdBuilder{       
        private List<Integer> target;
        private boolean group;
        private Long cmdSn;
        private String ackChannel;
        private final CmdManager parent;
        private boolean autoRemove = true;
        private CmdBuilder(CmdManager parent){
            this.parent = parent;
        }
        /** 参见 {@link DeviceInstruction#setTarget(List, boolean)} */
        public CmdBuilder setTarget(List<Integer> target,boolean group){
            this.target = target;
            this.group = group;
            return this;
        }
        /** 指定设备目标为设备ID列表,参见 {@link DeviceInstruction#setTarget(List, boolean)} */
        public CmdBuilder setDeviceTarget(List<Integer> target){
            return setTarget(target,false);
        }
        /** 指定设备目标为设备ID列表,参见 {@link DeviceInstruction#setTarget(List, boolean)} */
        public CmdBuilder setDeviceTarget(int... target){
            return setDeviceTarget(Ints.asList(target));
        }
        /** 指定设备目标为设备组ID列表,参见 {@link DeviceInstruction#setTarget(List, boolean)} */
        public CmdBuilder setDeviceGroupTarget(List<Integer> target){
            return setTarget(target,true);
        }
        /** 指定设备目标为设备组ID列表,参见 {@link DeviceInstruction#setTarget(List, boolean)} */
        public CmdBuilder setDeviceGroupTarget(int... target){
            return setDeviceGroupTarget(Ints.asList(target));
        }
        /** 指定命令序列号,参见 {@link DeviceInstruction#setCmdSn(long)} */
        public CmdBuilder setCmdSn(long cmdSn) {
            this.cmdSn = cmdSn;
            return this;
        }
        /** 
         * 指定提供命令序列号的{@code Supplier}实例
         * @see {@link IFaceLogClient#getAckChannelSupplier(Token)}
         */
        public CmdBuilder setCmdSn(Supplier<Long> cmdSnSupplier) {
            this.cmdSn = cmdSnSupplier.get().longValue();
            return this;
        }
        /** 
         * 指定命令响应通道,参见 {@link DeviceInstruction#setAckChannel(String)} */
        public CmdBuilder setAckChannel(String ackChannel){
            this.ackChannel = ackChannel;
            return this;
        }
        /** 
         * 指定提供命令响应通道的{@code Supplier}实例,
         * @see {@link IFaceLogClient#getAckChannelSupplier(Token)}
         */
        public CmdBuilder setAckChannel(Supplier<String> ackChannelSupplier){
            this.ackChannel = ackChannelSupplier.get();
            return this;
        }
        /** 数据有效性验证 */
        private void validate(){
            checkState(null != cmdSn,"cmdSn is uninitialized");
        }
        /**
         * 完成build,返回 {@link CmdManager}对象<br> 
         * @param autoRemove 为{@code true}时,完成设备命令发送后自动清除Thread Local Storage变量{@link CmdManager#TLS_BUILDER},
         *                                    默认值为{@code true}
         * @return
         */
        public CmdManager build(boolean autoRemove){
            validate();
            this.autoRemove = autoRemove;
            return this.parent;
        }
        /** 完成build,返回 {@link CmdManager}对象 */
        public CmdManager build(){
            validate();
            return this.parent;
        }
    } 
    /** 
     * 用于保存当前线程使用的 {@link CmdBuilder}对象<br>,
     * TLS变量,在多线程高并发环境如果不显式执行{@link ThreadLocal#remove()}有资源泄漏风险,
     * 如果{@link CmdBuilder#autoRemove}为{@code true},则调用设备命令方法发送完命令后会自动清除TLS变量,
     * 否则需要调用 {@link CmdManager#removeTlsTarget()}方法手动清除。
      */
    private static final ThreadLocal<CmdBuilder> TLS_BUILDER= new ThreadLocal<CmdBuilder>();
    public CmdBuilder targetBuilder(){
        if(null == TLS_BUILDER.get()){
            TLS_BUILDER.set(new CmdBuilder(this));
        }
        return TLS_BUILDER.get();
    }
    /** 
     * 清除TLS变量 {@link #TLS_BUILDER}
     * @see {@link ThreadLocal#remove()}
     */
    public CmdManager removeTlsTarget(){
        TLS_BUILDER.remove();
        return this;
    }
    /** 检查是否创建了{@CmdBuilder}对象没有则抛出异常 */
    protected static final CmdBuilder checkTlsAvailable(){
        return checkNotNull(TLS_BUILDER.get(),
                "not defined target,please call method targetBuilder(),and set target info");
    }

    /**
     * 设备命令 <br>
     * 设置参数,可用于运行时修改参数<br>
     * @param key 参数名
     * @param value 参数值
     * @return 收到命令的客户端数目
     *
     */
    public long parameter(String key,String value){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("key", key);
            params.put("value", value);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.parameter)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设置参数,可用于运行时修改参数<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param key 参数名
     * @param value 参数值
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void parameter(String key,String value,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(parameter(key,value));
    }
    /**
     * 设备命令 <br>
     * 设置一组参数,可用于需要重启有效的参数<br>
     * @param properties 参数配置对象, {@code 参数名(key)->参数值(value)映射}
     * @return 收到命令的客户端数目
     *
     */
    public long config(Map<String,String> properties){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("properties", properties);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.config)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设置一组参数,可用于需要重启有效的参数<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param properties 参数配置对象, {@code 参数名(key)->参数值(value)映射}
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void config(Map<String,String> properties,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(config(properties));
    }
    /**
     * 设备命令 <br>
     * 读取设备状态参数<br>
     * @param name 需要报告状态的参数名
     * @return 收到命令的客户端数目
     *
     */
    public long status(String name){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("name", name);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.status)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 读取设备状态参数<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param name 需要报告状态的参数名
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void status(String name,IAckAdapter<Object> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Object>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(status(name));
    }
    /**
     * 设备命令 <br>
     * 设备状态报告,返回一组状态参数<br>
     * @param names 需要报告状态的参数名列表
     * @return 收到命令的客户端数目
     *
     */
    public long report(List<String> names){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("names", names);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.report)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设备状态报告,返回一组状态参数<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param names 需要报告状态的参数名列表
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void report(List<String> names,IAckAdapter<Map<String,Object>> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Map<String,Object>>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(report(names));
    }
    /**
     * 设备命令 <br>
     * 获取设备版本号<br>
     * @return 收到命令的客户端数目
     *
     */
    public long version(){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.version)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 获取设备版本号<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void version(IAckAdapter<String> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<String>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(version());
    }
    /**
     * 设备命令 <br>
     * 设置设备工作状态<br>
     * @param enable {@code true}:工作状态,否则为非工作状态
     * @return 收到命令的客户端数目
     *
     */
    public long enable(Boolean enable){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("enable", enable);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.enable)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设置设备工作状态<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param enable {@code true}:工作状态,否则为非工作状态
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void enable(Boolean enable,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(enable(enable));
    }
    /**
     * 设备命令 <br>
     * 返回设备工作状态<br>
     * @param message 工作状态附加消息,比如"设备维修,禁止通行"
     * @return 收到命令的客户端数目
     *
     */
    public long isEnable(String message){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("message", message);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.isEnable)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 返回设备工作状态<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param message 工作状态附加消息,比如"设备维修,禁止通行"
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void isEnable(String message,IAckAdapter<Boolean> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Boolean>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(isEnable(message));
    }
    /**
     * 设备命令 <br>
     * 设备重启<br>
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     * @return 收到命令的客户端数目
     *
     */
    public long reset(Long schedule){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("schedule", schedule);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.reset)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设备重启<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void reset(Long schedule,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(reset(schedule));
    }
    /**
     * 设备命令 <br>
     * 设备与服务器时间同步<br>
     * @param unixTimestamp 服务器 unix 时间[秒],参见<a href = "https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
     * @return 收到命令的客户端数目
     *
     */
    public long time(Long unixTimestamp){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("unixTimestamp", unixTimestamp);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.time)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设备与服务器时间同步<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param unixTimestamp 服务器 unix 时间[秒],参见<a href = "https://en.wikipedia.org/wiki/Unix_time">Unix time</a>
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void time(Long unixTimestamp,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(time(unixTimestamp));
    }
    /**
     * 设备命令 <br>
     * 更新版本<br>
     * @param url 更新版本的位置
     * @param version 版本号
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     * @return 收到命令的客户端数目
     *
     */
    public long update(URL url,String version,Long schedule){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("url", url);
            params.put("version", version);
            params.put("schedule", schedule);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.update)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 更新版本<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param url 更新版本的位置
     * @param version 版本号
     * @param schedule 指定执行时间(unix time[秒]),为{@code null}立即执行
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void update(URL url,String version,Long schedule,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(update(url,version,schedule));
    }
    /**
     * 设备命令 <br>
     * 设置空闲时显示的消息<br>
     * @param message 发送到设备的消息
     * @param duration 持续时间[分钟],为{@code null}一直显示
     * @return 收到命令的客户端数目
     *
     */
    public long idleMessage(String message,Long duration){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("message", message);
            params.put("duration", duration);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.idleMessage)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 设置空闲时显示的消息<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param message 发送到设备的消息
     * @param duration 持续时间[分钟],为{@code null}一直显示
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void idleMessage(String message,Long duration,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(idleMessage(message,duration));
    }
    /**
     * 设备命令 <br>
     * 为指定人员通过时显示的临时消息<br>
     * @param message 发送到设备的消息
     * @param id 人员/人员组ID
     * @param group 为{@code true}时{@code id}参数为人员组ID
     * @param onceOnly 为{@code true}时只显示一次
     * @param duration 持续时间[分钟],为{@code null}一直显示
     * @return 收到命令的客户端数目
     *
     */
    public long personMessage(String message,Integer id,Boolean group,Boolean onceOnly,Long duration){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("message", message);
            params.put("id", id);
            params.put("group", group);
            params.put("onceOnly", onceOnly);
            params.put("duration", duration);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.personMessage)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 为指定人员通过时显示的临时消息<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param message 发送到设备的消息
     * @param id 人员/人员组ID
     * @param group 为{@code true}时{@code id}参数为人员组ID
     * @param onceOnly 为{@code true}时只显示一次
     * @param duration 持续时间[分钟],为{@code null}一直显示
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void personMessage(String message,Integer id,Boolean group,Boolean onceOnly,Long duration,IAckAdapter<Void> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Void>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(personMessage(message,id,group,onceOnly,duration));
    }
    /**
     * 设备命令 <br>
     * 自定义命令,命令名及命令参数类型由项目自定义,因为Map中没有定义每一个自定义命令参数的类型,设备端需要自行将命令参数转为与发送方协议约定的参数类型,参见{@link Cmd#cast(Object,Type)}<br>
     * @param cmdName 自定义命令名称
     * @param parameters 自定义参数表
     * @return 收到命令的客户端数目
     *
     */
    public long custom(String cmdName,Map<String,Object> parameters){
        CmdBuilder builder = checkTlsAvailable();
        try{
            // 所有的命令参数封装到 Map
            Map<String, Object> params = Maps.newHashMap();
            params.put("cmdName", cmdName);
            params.put("parameters", parameters);
            DeviceInstruction deviceInstruction = new DeviceInstruction()
                    .setCmd(Cmd.custom)
                    .setCmdSn(builder.cmdSn)
                    .setTarget(builder.target, builder.group)
                    .setAckChannel(builder.ackChannel)
                    .setParameters(params);
            return sendCmd(deviceInstruction);
        }finally{
            if(builder.autoRemove){
                removeTlsTarget(); 
            }
        }
    }
    /**
     * 设备命令 <br>
     * 自定义命令,命令名及命令参数类型由项目自定义,因为Map中没有定义每一个自定义命令参数的类型,设备端需要自行将命令参数转为与发送方协议约定的参数类型,参见{@link Cmd#cast(Object,Type)}<br>
     * 该方法会自动将命令响应通道名({@link CmdBuilder#setAckChannel(String)})
     * 关联命令处理对象({@code adapter})注册到REDIS订阅频道,当有收到设备命令响应时自动交由{@code adapter}处理<br>
     * 该方法要求必须指定命令响应通道,参见{@link CmdBuilder#setAckChannel(String)},{@link CmdBuilder#setAckChannel(Supplier)}
     * 
     * @param cmdName 自定义命令名称
     * @param parameters 自定义参数表
     * @param adapter 命令响应处理对象,不可为{@code null}
     */
    public void custom(String cmdName,Map<String,Object> parameters,IAckAdapter<Object> adapter){
        CmdBuilder builder = checkTlsAvailable();
        checkArgument(!Strings.isNullOrEmpty(builder.ackChannel),"INVALID ackChannel");
        subscriber.register(new Channel<Ack<Object>>(builder.ackChannel){}
        						.setAdapter(checkNotNull(adapter,"adapter is null")));
        adapter.setClientNum(custom(cmdName,parameters));
    }
}
