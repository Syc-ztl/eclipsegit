package com.sun.chenglixin.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.sun.chenglixin.entity.Company;

import io.lettuce.core.dynamic.annotation.Param;

/**
 * 企业信息持久层的接口
 * @author lenveo
 *
 */

public interface CompanyMapper {
	
	
	/**
	 * 添加一个企业信息
	 * @param company  企业信息实体类
	 * @return  返回受影响的行数
	 */
	Integer  addCompany(Company company);
	
	/**
	 * 根据企业名查询公司信息
	 * @param companyName
	 * @return
	 */
	Company   findByCompany(String companyName);
	
	/**
	 * 根据电话查找公司信息
	 * @param phone
	 * @return  
	 */
	Company  findByPhone(String phone);
	
	/**
	 * 根据电话修改密码
	 * @param phone
	 * @param password
	 * @return
	 */
	Integer  updatePassword(@Param("phone")String phone,
							@Param("password")String password,
							@Param("modifiedUser")String modifiedUser,
							@Param("modifiedTime")Date modifiedTime);
	
	
	/**
	 * 跟据电话修改电话
	 * @param oldphone 老电话
	 * @param newphone 新电话
	 * @return
	 * modified_user=#{modifiedUser},
			modified_time=#{modifiedTime}
	 */
	Integer  updatePhone(@Param("oldphone")String oldphone,
								@Param("newphone")String newphone,
								@Param("modifiedUser")String modifiedUser,
								@Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 修改头像
	 * @param cid
	 * @param avatar
	 * @param modifiedUser
	 * @param modifiedTime
	 * @return
	 */
	Integer  updateAvatar(@Param("cid")Integer cid,@Param("avatar")String avatar,@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 根据cid进行查找企业信息
	 * @param cid
	 * @return
	 */
	Company  findByCid(Integer cid);
}
