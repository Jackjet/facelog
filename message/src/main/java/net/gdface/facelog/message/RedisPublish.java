package net.gdface.facelog.message;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import redis.clients.jedis.Jedis;

public class RedisPublish implements IPublish,IRedisComponent{
	private JsonEncoder encoder = JsonEncoder.getEncoder();
	private final JedisPoolLazy poolLazy;

	@Override
	public JedisPoolLazy getPoolLazy() {
		return this.poolLazy;
	}

	public RedisPublish() {
		this(JedisPoolLazy.getDefaultInstance());
	}
	
	public RedisPublish(JedisPoolLazy poolLazy) {
		super();
		this.poolLazy = poolLazy;
	}
	
	@Override
	public void publish(Channel channel, Object obj, Type type) {
		if(null == obj)return;
		if(null != channel.type){
			if(channel.type instanceof Class<?> && !((Class<?>)channel.type).isInstance(obj)){
				throw new IllegalArgumentException("invalid type of 'obj'");
			}else if(channel.type instanceof ParameterizedType ){
				if(null == type)
					throw new IllegalArgumentException("type must not be null'");
				if(! (type !=channel.type))
					throw new IllegalArgumentException("invalid type of 'obj'");
			}
		}
		Jedis jedis = this.poolLazy.apply();
		try{
			jedis.publish(channel.name, this.encoder.toJsonString(obj));
		}finally{
			this.poolLazy.free();
		}
	}
}
