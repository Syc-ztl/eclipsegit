package com.sun.chenglixin.MD5;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMD5 {
	@Test
	public void  testMD5() {

		/**
		 * 对密码进行加密
		 * @param password 原始密码
		 * @param salt 盐值
		 * @return 加密后的密码
		 */
		String salt="ac111346-7f99-4948-8f89-c5cabcb9a77c";
			// salt+password+salt 进行3次加密
			String msg=salt+"123456"+salt;
			for(int i=0;i<3;i++) {
				msg=DigestUtils.md5DigestAsHex(msg.getBytes());
			}
			System.out.println(msg);
		
		
	}
}
