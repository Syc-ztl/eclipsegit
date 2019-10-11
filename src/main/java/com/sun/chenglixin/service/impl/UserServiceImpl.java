package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.mapper.UserMapper;
import com.sun.chenglixin.service.ICompanyService;
import com.sun.chenglixin.service.IUserService;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.CodeNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UserNotFoundException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;
import com.sun.chenglixin.util.Msg;
import com.sun.chenglixin.util.Smutil;
/**
 * 个人业务层实现类
 * @author lenveo
 *
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper mapper;

	@Autowired
	RedisTemplate<String, String> redistemplate;

	@Autowired
	ICompanyService companyService;

	/**
	 * 添加一个用户信息
	 */
	@Override
	public void saveUser(User user, String code)
			throws InsertException, UsernameDuplicateException, CodeCheckOutException, CodeNotFoundException {
		String oldCode = (String) redistemplate.opsForValue().get(user.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		String salt = UUID.randomUUID().toString();
		user.setSalt(salt);
		// 获取用户输入的密码
		String password = user.getPassword();
		// 基于盐值对密码进行加密
		String md5password = getMd5Password(password, salt);
		// 将加密后的密码添加user中
		user.setPassword(md5password);

		user.setAuthority(1);
		user.setCreditScore("0");
		// 补全4项日志数据
		user.setCreatedTime(new Date());
		user.setCreatedUser(user.getUsername());
		user.setModifiedTime(new Date());
		user.setModifiedUser(user.getUsername());
		// 调用mapper的addnew()，将用户数据添加到数据库
		Integer row = addUser(user);
		// 查看返回的行数是否不为1
		if (!row.equals(1)) {
			// 是： 抛出InsertException
			throw new InsertException("数据插入异常，请联系管理员");
		}

	}

	/**
	 * 登录按电话登录
	 */
	@Override
	public User login(String username, String password) throws PhoneNotFoundException, PasswordNotMatchException {
		User user = findByPhone(username);
		if (user == null) {
			throw new UserNotFoundException("用户电话或密码错误");
		}
		String oldpassword = user.getPassword();
		String salt = user.getSalt();
		String newpassword = getMd5Password(password, salt);
		if (!oldpassword.equals(newpassword)) {
			throw new PasswordNotMatchException("用户电话或密码错误");
		}
		user.setSalt(null);
		user.setPassword(null);
		return user;
	}

	/**
	 * 链接短信验证码方法
	 * 
	 * @param phone
	 */
	public void sendCode(String phone) {
		long ran = Math.round(Math.random() * 10000);
		System.err.println(phone);
		Smutil sms = new Smutil() {
			@Override
			public void success() {
				
			}
		};
		Msg msg = sms.sendMsg(phone, ran);
		redistemplate.opsForValue().set(phone, String.valueOf(ran), 15, TimeUnit.MINUTES);
	}

	/**
	 * 根据电话修改密码
	 * 
	 * @param phone
	 * @param password
	 * @param code
	 */
	public void updatePassword(String phone, String password, String code)
			throws UserNotFoundException, UpdateException, PhoneNotFoundException {
		User user = findByPhone(phone);
		if (user == null) {
			companyService.changePassword(phone, password, code);
		}
		String oldCode = (String) redistemplate.opsForValue().get(user.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		String salt = user.getSalt();
		String newPassword = getMd5Password(password, salt);
		String modifiedUser=user.getUsername();
		Integer row = updatePasswordByPhone(phone, newPassword,modifiedUser,new Date());
		if (!row.equals(1)) {
			throw new UpdateException("数据更新异常");
		}

	}

	/**
	 * 根据电话修改电话
	 */
	public void updatePhone(String oldphone, String newphone, String code)
			throws PhoneNotFoundException, UpdateException, UserNotFoundException {
		User user = findByPhone(oldphone);
		if (user == null) {
			throw new UserNotFoundException("用户未找到请联系管理员");
		}
		String oldCode = (String) redistemplate.opsForValue().get(user.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		String modifiedUser=user.getUsername();
		Integer row = updatePhone(oldphone, newphone, modifiedUser, new Date());
		if (!row.equals(1)) {
			throw new UpdateException("用户数据修改异常，请联系管理员");
		}

	}

	/**
	 * 对密码进行加密
	 * 
	 * @param password 原始密码
	 * @param salt     盐值
	 * @return 加密后的密码
	 */
	private String getMd5Password(String password, String salt) {
		// salt+password+salt 进行3次加密
		String msg = salt + password + salt;
		for (int i = 0; i < 3; i++) {
			msg = DigestUtils.md5DigestAsHex(msg.getBytes());
		}
		return msg;
	}

	/**
	 * 根据电话修改电话
	 * 
	 * @param oldphone
	 * @param newphone
	 * @return
	 */
	private Integer updatePhone(String oldphone, String newphone,String modifiedUser,Date modifiedTime) {
		return mapper.updatePhone(oldphone, newphone, modifiedUser, modifiedTime);
	}

	/**
	 * 根据电话修改密码
	 * 
	 * @param phone
	 * @return
	 */
	private Integer updatePasswordByPhone(String phone, String password,String modifiedUser,Date modifiedTime) {
		return mapper.updatePasswordByPhone(phone, password, modifiedUser, modifiedTime);
	}

	/**
	 * 添加个人用户信息
	 * 
	 * @param user 用户
	 * @return 返回添加成功或者失败
	 */
	private Integer addUser(User user) {
		return mapper.addUser(user);
	}

	/**
	 * 根据昵称名查找用户
	 * 
	 * @param username
	 * @return 返回用户信息
	 */
	private User findByUsername(String username) {
		return mapper.findByUsername(username);
	}

	/**
	 * 根据电话查找
	 * 
	 * @param phone
	 * @return
	 */
	private User findByPhone(String phone) {
		return mapper.findByPhone(phone);
	}

}
