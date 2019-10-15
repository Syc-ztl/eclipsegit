package com.sun.chenglixin.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.CompanyDetailsPromise;
import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.mapper.CompanyPromiseMapper;
import com.sun.chenglixin.service.ICompanyPromiseService;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;

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

	@Override
	public void saveCompanyPromise(CompanyDetailsPromise companyDetailsPromise) throws InsertException {
		
		Integer cdpid=companyDetailsPromise.getCdpid();
		String title=companyDetailsPromise.getTitle();
		String type=companyDetailsPromise.getType();
		Date time=companyDetailsPromise.getTime();
		String username=companyDetailsPromise.getUsername();
		CompanyPromise companyPromise=new CompanyPromise(username, new Date(),
														username,new Date(), 
														cdpid, title, type,1, time);
				
			Integer row=addCompanyPromise(companyPromise);
			if(!row.equals(1)) {
				throw new InsertException("数据插入异常，请联系管理员");
			}
				
			Integer line=addCompanyDetailsPromise(companyDetailsPromise);
			if(!line.equals(1)) {
				throw new InsertException("数据插入异常，请联系管理员");
			}
				
				
		
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

	/**
	 * 添加一个企业承诺书简版
	 * @param companyPromise
	 * @return
	 */
	private Integer  addCompanyPromise(CompanyPromise companyPromise) {
		return mapper.addCompanyPromise(companyPromise);
	}
	
	/**
	 * 添加一个企业承诺书数据
	 * @param companyDetailsProise
	 * @return
	 */
	private Integer addCompanyDetailsPromise(CompanyDetailsPromise companyDetailsPromise) {
		return mapper.addCompanyDetailsPromise(companyDetailsPromise);
	}
	

	
}
