package net.gdface.facelog.client;

import java.util.List;

import com.google.common.base.Strings;
import com.google.common.base.Supplier;

import gu.simplemq.Channel;
import gu.simplemq.IMessageAdapter;
import gu.simplemq.exceptions.SmqUnsubscribeException;
import gu.simplemq.redis.RedisPublisher;
import gu.simplemq.redis.JedisPoolLazy;

/**
 * 设备命令分发器,实现{@link IMessageAdapter}接口,将redis操作与业务逻辑隔离<br>
 * 从订阅频道得到设备指令{@link DeviceInstruction},并将交给{@link CommandAdapter}执行<br>
 * 如果是与当前设备无关的命令则跳过
 * @author guyadong
 *
 */
public class CmdDispatcher implements IMessageAdapter<DeviceInstruction>{
	private CommandAdapter cmdAdapter;
	private final int deviceId;
	private Supplier<Integer> groupIdSupplier;
	private RedisPublisher redisPublisher = new RedisPublisher(JedisPoolLazy.getDefaultInstance());
	/**
	 * 构造方法<br>
	 *  设备所属的组可能是可以变化的,所以这里需要用{@code Supplier} 接口来动态获取当前设备的设备组
	 * @param deviceId 当前设备ID,应用项目应确保ID是有效的
	 * @param groupIdSupplier 用于提供{@code deviceId}所属的设备组,
	 * 参见默认实现: {@link IFaceLogClient#getDeviceGroupIdSupplier(int)},为{@code null}不响应设备组命令
	 */
	public CmdDispatcher(int deviceId, Supplier<Integer> groupIdSupplier) {
		this.deviceId= deviceId;
		this.groupIdSupplier = groupIdSupplier;
	}
	/** 判断target列表是否包括当前设备 */
	private boolean selfIncluded(boolean group,List<Integer> target){
		if(group){
			if(null == groupIdSupplier){
				return false;
			}
			Integer groupId = groupIdSupplier.get();
			return null == groupId ? false : target.contains(groupId); 
		}
		else {
			return target.contains(this.deviceId);
		}
	}
	/**
	 * 执行指定的设备命令并向命令响应频道返回命令结果
	 */
	@Override
	public void onSubscribe(DeviceInstruction t) throws SmqUnsubscribeException {
		if(null != cmdAdapter && null != t.getTarget() && selfIncluded(t.isGroup(),t.getTarget())){
			// 将设备命令交给命令类型对应的方法执行设备命令
			Ack<?> ack = t.getCmd().run(cmdAdapter, t.getParameters()).setCmdSn(t.getCmdSn());
			// 如果指定了响应频道则向指定的频道发送响应消息
			if(!Strings.isNullOrEmpty(t.getAckChannel())){
				Channel<Ack<?>> ackChannel = new Channel<Ack<?>>(t.getAckChannel()){};
				redisPublisher.publish(ackChannel, ack);
			}
		}
	}
	/**
	 * 设置应用程序执行设备命令的对象<br>
	 * 创建{@link CmdDispatcher}对象时如果不调用本方法,设备不会响应任何设备命令
	 * @param cmdAdapter
	 * @return
	 */
	public CmdDispatcher setCmdAdapter(CommandAdapter cmdAdapter) {
		this.cmdAdapter = cmdAdapter;
		return this;
	}

}