package com.sun.chenglixin.mapper;

import java.util.Date;

import com.sun.chenglixin.entity.User;

import io.lettuce.core.dynamic.annotation.Param;

public interface UserMapper {
	
	/**
	 * 添加个人用户信息
	 * @param user  用户
	 * @return  返回添加成功或者失败
	 */
	Integer  addUser(User user);
	
	/**
	 * 根据昵称名查找用户
	 * @param username
	 * @return  返回用户信息
	 */
	User  findByUsername(String username);
	
	/**
	 * 根据电话查找
	 * @param phone
	 * @return
	 */
	User  findByPhone(String phone);
	
	/**
	 * 根据电话修改密码
	 * @param phone
	 * @return
	 */
	Integer  updatePasswordByPhone(@Param("phone")String phone,
									@Param("password")String password,
									@Param("modifiedUser")String modifiedUser,
									@Param("modifiedTime")Date modifiedTime);
	
	
	/**
	 * 跟据电话修改电话
	 * @param oldphone 老电话
	 * @param newphone 新电话
	 * @return
	 */
	Integer  updatePhone(@Param("oldphone")String oldphone,
						@Param("newphone")String newphone,
						@Param("modifiedUser")String modifiedUser,
						@Param("modifiedTime")Date modifiedTime);
	
}
