package com.sun.chenglixin.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.service.IUserService;
	
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsermapperTest {
	@Autowired
	UserMapper mapper;
	@Autowired
	IUserService service;
	
	
	
	@Test
	public void addUser() {
		User user=new User();


		user.setUsername("jerry");
		user.setIdCard("500221199702114531");
		user.setUsername("tom");
		user.setPassword("123456");
		user.setEmail("3366@qq.com");
		user.setPhone("1234567");
		Integer row=mapper.addUser(user);
		System.out.println(row);
	}
	
	
	@Test
	public  void   findByUsername() {
		User user=mapper.findByUsername("tom");
		System.err.println(user);
	}
	
	
	
	
	
	
	
	
	@Test
	public void addUsers() {
		User user=new User();


		user.setUsername("tom");
		user.setIdCard("500221199702114531");
		user.setUsername("je");
		user.setPassword("123456");
		user.setEmail("3366@qq.com");
		user.setPhone("1234567");
		service.saveUser(user,"1234");
		
	}
	
	
	@Test 
	public  void   update() {
		//Integer row=mapper.updatePasswordByPhone( "15823181467", "12345");
		//System.err.println(row);
		service.updatePassword("15823181467", "12345", "123");
	}
	
	
	
	
	
	
}
