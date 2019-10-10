package com.sun.chenglixin.Redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties.Jedis;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
	@Autowired
	RedisTemplate<String,String> tem;
	
	@Test
	public void  add() {
		
		tem.opsForValue().set("demo", "helloworld");
		System.err.println(tem.opsForValue().get("demo"));
		
	}
}
