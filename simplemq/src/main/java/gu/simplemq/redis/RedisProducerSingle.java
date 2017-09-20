package gu.simplemq.redis;

import java.lang.reflect.Type;

import gu.simplemq.Producer;

/**
 * 基于 {@link RedisQueue} 的生产者模型实现
 * @author guyadong
 *
 * @param <T>
 */
public class RedisProducerSingle<T> extends Producer<T> implements IRedisComponent {
	@Override
	public JedisPoolLazy getPoolLazy() {
		return ((RedisQueue<T>)queue).getPoolLazy();
	}
	
	@Override
	public String getQueueName() {
		return ((RedisQueue<T>)queue).getQueueName();
	}

	public RedisProducerSingle(Type type,JedisPoolLazy poolLazy, String queueName) {
		super(type);
		this.setQueue(new RedisQueue<T>(type,poolLazy).setQueueName(queueName));
	}
	
	public RedisProducerSingle(Type type, JedisPoolLazy poolLazy) {
		this(type,poolLazy,null);
	}
	
	public RedisProducerSingle(Type type) {
		this(type,JedisPoolLazy.getDefaultInstance());
	}

	@Override
	public int produce(@SuppressWarnings("unchecked") T... array) {
		return ((RedisQueue<T>)queue).offer(this.offerLast,array);
	}

	@Override
	public int produce(boolean offerLast, @SuppressWarnings("unchecked") T... array) {
		return ((RedisQueue<T>)queue).offer(offerLast,array);
	}
}
