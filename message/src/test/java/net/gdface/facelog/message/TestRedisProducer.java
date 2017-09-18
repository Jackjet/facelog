package net.gdface.facelog.message;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestRedisProducer {

	@Test
	public void test() throws InterruptedException {
		RedisProducer<Date> producer = new RedisProducer<Date>(Date.class,JedisPoolLazy.getDefaultInstance(),"datelist"){};
		for(int i=0;i<100;++i){
			Date date = new Date();
			producer.produce(date);
			System.out.println(date.getTime() +" : " +date.toString());
			Thread.sleep(2000);
		}
	}

}
