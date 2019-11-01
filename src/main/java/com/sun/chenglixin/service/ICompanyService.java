package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.Company;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.CompanyNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;

/**
 * 企业信息业务层接口接口
 * @author lenveo
 *
 */
public interface ICompanyService {
	
		/**
		 * 添加企业信息
		 * @param company  企业实体类
		 * @throws InsertException
		 * @throws UsernameDuplicateException
		 * @throws CodeCheckOutException
		 */
		void   saveCompany(Company company,String code)throws CodeCheckOutException,InsertException,UsernameDuplicateException;
		
		
		
		/**
		 * 短信验证方法
		 * @param phone  电话
		 */
		void sendCode(String phone);
		
		
		
		/**
		 * 根据电话和密码登录
		 * @param phone  企业电话电话
		 * @param password  密码
		 * @return
		 * @throws PhoneNotFoundException
		 * @throws PasswordNotMatchException
		 */
		Company   login(String phone,String password)throws PhoneNotFoundException,PasswordNotMatchException;
		
		
		
		/**
		 * 根据电话修改企业密码
		 * @param phone
		 * @param password
		 * @param code
		 * @throws PhoneNotFoundException
		 * @throws CodeCheckOutException
		 * @throws UpdateException
		 */
		void   changePassword(String phone,String password,String code)throws 
																		PhoneNotFoundException,CodeCheckOutException,UpdateException;
		
		
		
		/**
		 * 根据电话修改电话
		 * @param pldphone
		 * @param newPhone
		 * @param code
		 * @throws PhoneNotFoundException
		 * @throws CodeCheckOutException
		 * @throws UpdateException
		 */
		void   changePhone(String oldphone,String newPhone,String code)throws PhoneNotFoundException,CodeCheckOutException,UpdateException;
		
		
		
		/**
		 * 公司修改头像
		 * @param cid
		 * @param modifedUser
		 * @param avatar
		 * @throws UpdateException
		 * @throws CompanyNotFoundException
		 */
		void   changeAvatar(Integer cid,String modifedUser,String avatar)throws UpdateException,CompanyNotFoundException;
		
		
		
		
		
}
