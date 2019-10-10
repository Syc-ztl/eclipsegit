package com.sun.chenglixin.mapper;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.chenglixin.entity.Company;
import com.sun.chenglixin.entity.User;
	
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanymapperTest {
	@Autowired
	CompanyMapper mapper;
	
	@Test
	public void addUser() {
		Company c=new Company();
		c.setCompanyName("呈祥农业开发有限公司");
		Integer row=mapper.addCompany(c);
		System.out.println(row);
	}
	
	
//	@Test
//	public  void   findByUsername() {
//		User user=mapper.findByUsername("tom");
//		System.err.println(user);
//	}
}
