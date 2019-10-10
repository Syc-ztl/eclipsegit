package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.sun.chenglixin.entity.Company;
import com.sun.chenglixin.mapper.CompanyMapper;
import com.sun.chenglixin.service.ICompanyService;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UserNotFoundException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;
import com.sun.chenglixin.util.Msg;
import com.sun.chenglixin.util.Smutil;

/**
 * 企业业务层实现类
 * 
 * @author lenveo
 *
 */
@Service
public class CompanyServiceImpl implements ICompanyService {

	@Autowired
	CompanyMapper mapper;
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	public void saveCompany(Company company, String code)
			throws CodeCheckOutException, InsertException, UsernameDuplicateException {
		String companyName = company.getCompanyName();
		Company result = findByCompany(companyName);
		String oldCode = (String) redisTemplate.opsForValue().get(company.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		if (result != null) {
			throw new UsernameDuplicateException("公司名字重复");
		}
		String salt = UUID.randomUUID().toString();
		company.setSalt(salt);
		String password = company.getPassword();
		String md5password = getMd5Password(password, salt);
		company.setPassword(md5password);
		company.setAuthority(1);
		company.setCreatedTime(new Date());
		company.setCreatedUser(company.getUsername());
		company.setModifiedTime(new Date());
		company.setModifiedUser(company.getUsername());
		Integer row = addCompany(company);
		if (!row.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
	}

	public Company login(String phone, String password) throws PhoneNotFoundException, PasswordNotMatchException {

		Company com = findByphone(phone);
		if (com == null) {
			throw new PhoneNotFoundException("用户电话或密码错误");
		}
		String salt = com.getSalt();
		String oldPassword = com.getPassword();

		String newPassword = getMd5Password(password, salt);
		if (!oldPassword.equals(newPassword)) {
			throw new PasswordNotMatchException("用户电话或密码错误");
		}
		com.setSalt(null);
		com.setPassword(null);
		return com;
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
		redisTemplate.opsForValue().set(phone, String.valueOf(ran), 15, TimeUnit.MINUTES);
	}

	/**
	 * 根据电话修改密码
	 */
	public void changePassword(String phone, String password, String code)
			throws PhoneNotFoundException, CodeCheckOutException, UpdateException {
		Company company = findByphone(phone);
		if (company == null) {
			throw new UserNotFoundException("用户未找到异常");
		}
		String oldCode = (String) redisTemplate.opsForValue().get(company.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		String salt = company.getSalt();
		String newPassword = getMd5Password(password, salt);
		Integer row = updatePassword(phone, newPassword);
		if (!row.equals(1)) {
			throw new UpdateException("数据更新异常");
		}

	}

	/**
	 * 根据电话修改电话
	 */
	public void changePhone(String oldphone, String newPhone, String code)
			throws PhoneNotFoundException, CodeCheckOutException, UpdateException {
		Company company = findByphone(oldphone);
		if (company == null) {
			throw new PhoneNotFoundException("用户未找到");
		}
		String oldCode = (String) redisTemplate.opsForValue().get(company.getPhone());
		if (!code.equals(oldCode)) {
			throw new CodeCheckOutException("验证码输入错误，请重新输入");
		}
		Integer row = updatePhone(oldphone, newPhone);
		if (!row.equals(1)) {
			throw new UpdateException("数据更新异常，请联系管理员");
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
	 * 添加一个企业信息
	 * 
	 * @param company 企业信息实体类
	 * @return 返回受影响的行数
	 */
	private Integer addCompany(Company company) {
		return mapper.addCompany(company);
	}

	/**
	 * 根据企业名查询公司信息
	 * 
	 * @param companyName
	 * @return
	 */
	private Company findByCompany(String companyName) {
		return mapper.findByCompany(companyName);
	}

	/**
	 * 根据电话查询公司信息
	 * 
	 * @param companyName
	 * @return
	 */
	private Company findByphone(String phone) {
		return mapper.findByCompany(phone);
	}

	/**
	 * 根据电话修改密码
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	private Integer updatePassword(String phone, String password) {
		return mapper.updatePassword(phone, password);
	}

	/**
	 * 根据电话修改电话
	 * 
	 * @param oldphone
	 * @param newphone
	 * @return
	 */
	private Integer updatePhone(String oldphone, String newphone) {
		return mapper.updatePhone(oldphone, newphone);
	}

}
