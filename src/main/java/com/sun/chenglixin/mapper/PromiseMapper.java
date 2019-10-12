package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.UserPromise;

/**
 * 持久层承诺书接口
 * @author lenveo
 *
 */
public interface PromiseMapper {
	/**
	 * 根据start和end进行分页查询
	 * @param start
	 * @param end	
	 * @return
	 */
	UserPromise  findUserPromise(@Param("start")Integer start,@Param("end")Integer end);
	
	
}
