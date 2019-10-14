package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.CompanyPromise;
/**
 * 企业承诺书持久层接口
 * @author lenveo
 *
 */
public interface CompanyPromiseMapper {
	/**
	 * 根据start和end进行分页查询企业承诺书
	 * @param start
	 * @param end
	 * @return
	 */
	CompanyPromise findCompanyPromise(@Param("start")Integer start,@Param("end")Integer end);
}
