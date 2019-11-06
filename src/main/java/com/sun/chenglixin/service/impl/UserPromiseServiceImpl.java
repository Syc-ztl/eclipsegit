package com.sun.chenglixin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.chenglixin.entity.UserDetailsPromise;
import com.sun.chenglixin.entity.UserPromise;
import com.sun.chenglixin.mapper.UserPromiseMapper;
import com.sun.chenglixin.service.IUserPromiseService;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;
import com.sun.chenglixin.service.ex.exception.UserPromiseNotFoundException;
/**
 * 用户承诺书实现类
 * @author lenveo
 *
 */
@Service
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
	
	@Override
	public void saveUserPromise(UserDetailsPromise userDetailsPromise) throws InsertException {
		
		Integer udpid=userDetailsPromise.getUdpid();
		String title=userDetailsPromise.getTitle();
		String type=userDetailsPromise.getType();
		Date time=userDetailsPromise.getTime();
		String userName=userDetailsPromise.getUserName();
		UserPromise userPromise=new UserPromise(userName, new Date(),
													userName, new Date(), 
												udpid, title, type, 1, time);
		Integer row=addUserPromise(userPromise);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
		
		Integer line=addUserDetailsPromise(userDetailsPromise);
		if(!line.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
	}
	
	
	
	/**
	 * 根据start和end进行分页查询用户承诺书
	 * @param start
	 * @param end	
	 * @return
	 */
	private UserPromise  findUserPromise(Integer start,Integer end) {
		if(start==null || end==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.findUserPromise(start, end);
	}

	/**
	 * 添加一个用户承诺书简版数据
	 * @param userPromise
	 * @return
	 */
	private Integer addUserPromise(UserPromise userPromise) {
		if(userPromise==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.addUserPromise(userPromise);
	}
	
	
	/**
	 * 添加一个用户承诺书数据
	 * @param userDetailsPromise
	 * @return
	 */
	private Integer addUserDetailsPromise(UserDetailsPromise userDetailsPromise) {
		if(userDetailsPromise==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.addUserDetailsPromise(userDetailsPromise);
	}



}
