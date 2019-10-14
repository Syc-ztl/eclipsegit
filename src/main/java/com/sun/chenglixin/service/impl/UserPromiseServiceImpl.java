package com.sun.chenglixin.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.UserPromise;
import com.sun.chenglixin.mapper.UserPromiseMapper;
import com.sun.chenglixin.service.IUserPromiseService;
import com.sun.chenglixin.service.ex.exception.UserPromiseNotFoundException;

public class UserPromiseServiceImpl implements IUserPromiseService {
	
	@Autowired
	UserPromiseMapper mapper;
	
	@Override
	public UserPromise seekUserPromise(Integer start, Integer end) throws UserPromiseNotFoundException {
		UserPromise userpromise=findUserPromise(start, end);
		if(userpromise==null) {
			throw new UserPromiseNotFoundException("已经到底了！");
		}
		return userpromise;
	}
	
	
	
	
	/**
	 * 根据start和end进行分页查询用户承诺书
	 * @param start
	 * @param end	
	 * @return
	 */
	private UserPromise  findUserPromise(Integer start,Integer end) {
		return mapper.findUserPromise(start, end);
	}

}
