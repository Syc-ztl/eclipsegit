package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.UserPromise;
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
}
