package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.sun.chenglixin.entity.CompanyDetailsPromise;
import com.sun.chenglixin.entity.CompanyPromise;
/**
 * 企业承诺书持久层接口
 * @author lenveo
 *
 */

public interface CompanyPromiseMapper {
	
	/**
	 * 添加一个企业承诺书简版
	 * @param companyPromise
	 * @return
	 */
	Integer  addCompanyPromise(CompanyPromise companyPromise);
	
	/**
	 * 添加一个企业承诺书数据
	 * @param companyDetailsProise
	 * @return
	 */
	Integer addCompanyDetailsPromise(CompanyDetailsPromise companyDetailsPromise);
	
	
	/**
	 * 根据start和end进行分页查询企业承诺书
	 * @param start
	 * @param end
	 * @return
	 */
	List<CompanyPromise> findCompanyPromise(@Param("start")Integer start,@Param("end")Integer end);
	
	
	
	
	
}
