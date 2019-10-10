package com.sun.chenglixin.service;




import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.CodeNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UserNotFoundException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;

/**
 * 用户相关信息的接口
 * @author root
 *
 */
public interface IUserService {
	
	
	
	/**
	 * 添加一个用户信息
	 * @param user
	 * @param code
	 * @throws InsertException
	 * @throws UsernameDuplicateException
	 * @throws CodeCheckOutException
	 * @throws CodeNotFoundException
	 */
	void saveUser(User user, String code) throws InsertException, UsernameDuplicateException
												,CodeCheckOutException,CodeNotFoundException;
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 */
	User login(String username,String password) throws PhoneNotFoundException, PasswordNotMatchException;
	
	/**
	 * 用户短信验证码
	 * @param phone 用户电话
	 */
	void sendCode(String phone);
	
	/**
	 * 根据用户电话修改密码
	 * @param password 新密码
	 * @param phone  电话
	 * @param code  验证码
	 * @throws PhoneNotFoundException
	 */
	void   updatePassword(String password,String phone,String code)throws UserNotFoundException,UpdateException,PhoneNotFoundException ;
	
	/**
	 * 根据用户电话修改电话
	 * @param oldphone
	 * @param newphone
	 * @param code
	 * @throws PhoneNotFoundException
	 * @throws UpdateException
	 * @throws UserNotFoundException
	 */
	void   updatePhone(String oldphone,String newphone,String code)throws PhoneNotFoundException,UpdateException,UserNotFoundException;
	
}
