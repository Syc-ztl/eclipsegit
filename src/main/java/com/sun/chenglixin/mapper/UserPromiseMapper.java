package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.sun.chenglixin.entity.UserDetailsPromise;
import com.sun.chenglixin.entity.UserPromise;

/**
 * 用户个人持久层承诺书接口
 * @author lenveo
 *
 */

public interface UserPromiseMapper {
	
	/**
	 * 添加一个用户承诺书简版数据
	 * @param userPromise
	 * @return
	 */
	Integer addUserPromise(UserPromise userPromise);
	
	
	/**
	 * 添加一个用户承诺书数据
	 * @param userDetailsPromise
	 * @return
	 */
	Integer addUserDetailsPromise(UserDetailsPromise userDetailsPromise); 
	
	
	/**
	 * 根据start和end进行分页查询用户承诺书
	 * @param start
	 * @param end	
	 * @return
	 */
	List<UserPromise>  findUserPromise(@Param("start")Integer start,@Param("end")Integer end);
	
	
}
