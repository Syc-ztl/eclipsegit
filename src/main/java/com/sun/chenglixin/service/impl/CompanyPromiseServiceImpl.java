package com.sun.chenglixin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.mapper.CompanyPromiseMapper;
import com.sun.chenglixin.service.ICompanyPromiseService;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;

public class CompanyPromiseServiceImpl implements ICompanyPromiseService {

	@Autowired
	CompanyPromiseMapper mapper;
	
	@Override
	public CompanyPromise seekCompanyPromise(Integer start, Integer end) throws CompanyPromiseNotFoundException {
		CompanyPromise companyPromise=findCompanyPromise(start, end);
		if(companyPromise==null) {
			throw new CompanyPromiseNotFoundException("已经到底了！");
		}
		return companyPromise;
	}

	
	
	/**
	 * 根据start和end进行分页查询企业承诺书
	 * @param start
	 * @param end
	 * @return
	 */
	private CompanyPromise findCompanyPromise(Integer start,Integer end) {
		return mapper.findCompanyPromise(start, end);
	}
}
