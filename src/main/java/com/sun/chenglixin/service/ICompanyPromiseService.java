package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;

/**
 * 企业承诺书业务层接口
 * @author lenveo
 *
 */
public interface ICompanyPromiseService {
	/**
	 * 根据start和end查询企业承诺书
	 * @param start
	 * @param end
	 * @return
	 */
	CompanyPromise seekCompanyPromise(Integer start,Integer end)throws CompanyPromiseNotFoundException;
}
