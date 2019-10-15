package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.CompanyDetailsPromise;
import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;

/**
 * 企业承诺书业务层接口
 * @author lenveo
 *
 */
public interface ICompanyPromiseService {
	
	/**
	 * 根据信用承诺书添加企业承诺书
	 * @param companyDetailsPromise
	 * @throws InsertException
	 */
	void  saveCompanyPromise(CompanyDetailsPromise companyDetailsPromise)throws InsertException;
	
	
	
	/**
	 * 根据start和end查询企业承诺书
	 * @param start
	 * @param end
	 * @return
	 */
	CompanyPromise seekCompanyPromise(Integer start,Integer end)throws CompanyPromiseNotFoundException;
}
