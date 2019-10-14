package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.entity.UserPromise;

/**
 * 用户个人持久层承诺书接口
 * @author lenveo
 *
 */
public interface UserPromiseMapper {
	/**
	 * 根据start和end进行分页查询用户承诺书
	 * @param start
	 * @param end	
	 * @return
	 */
	UserPromise  findUserPromise(@Param("start")Integer start,@Param("end")Integer end);
	
	
}
