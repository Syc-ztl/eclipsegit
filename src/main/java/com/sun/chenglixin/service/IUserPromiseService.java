package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.UserDetailsPromise;
import com.sun.chenglixin.entity.UserPromise;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.UserPromiseNotFoundException;

/**
 * 个人承诺书业务层接口
 * @author lenveo
 *
 */
public interface IUserPromiseService {  
	
	/**
	 * 根据start和end查询用户承诺书
	 * @param start
	 * @param end
	 * @return
	 * @throws UserPromiseNotFoundException
	 */
	UserPromise seekUserPromise(Integer start,Integer end)throws UserPromiseNotFoundException;
	
	/**
	 * 根据用户承诺书添加详情表和简版
	 * @param userDetailsPromise
	 * @throws InsertException
	 */
	void  saveUserPromise(UserDetailsPromise userDetailsPromise)throws InsertException;
	
}
