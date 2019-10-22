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
	 * 根据id名查找用户
	 * @param username
	 * @return  返回用户信息
	 */
	User  findByUid(Integer uid);
	
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
	
	/**
	 * 修改头像
	 * @param uid
	 * @param avatar
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer updateAvatar(
			@Param("uid") Integer uid,
			@Param("avatar") String avatar,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
}
