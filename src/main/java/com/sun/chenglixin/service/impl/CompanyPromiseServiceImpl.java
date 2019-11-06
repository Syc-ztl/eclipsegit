package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.chenglixin.entity.CompanyDetailsPromise;
import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.mapper.CompanyPromiseMapper;
import com.sun.chenglixin.service.ICompanyPromiseService;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;

/**
 * 企业承诺书业务层
 * @author lenveo
 *
 */

@Service
public class CompanyPromiseServiceImpl implements ICompanyPromiseService {

	@Autowired
	CompanyPromiseMapper mapper;
	
	@Override
	public List<CompanyPromise> seekCompanyPromise(Integer start, Integer end) throws CompanyPromiseNotFoundException {
		List<CompanyPromise> list=findCompanyPromise(start, end);
		if(list.isEmpty()) {
			throw new CompanyPromiseNotFoundException("已经到底了！");
		}
		return list;
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
				
			
			
			
			companyDetailsPromise.setCreatedUser(username);
			companyDetailsPromise.setCreatedTime(new Date());
			companyDetailsPromise.setModifiedTime(new Date());
			companyDetailsPromise.setModifiedUser(username);
			
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
	private List<CompanyPromise> findCompanyPromise(Integer start,Integer end) {
		if(start==null || end==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return mapper.findCompanyPromise(start, end);
	}

	/**
	 * 添加一个企业承诺书简版
	 * @param companyPromise
	 * @return
	 */
	private Integer  addCompanyPromise(CompanyPromise companyPromise) {
		if(companyPromise==null) {
			throw new IrregularParameterException("参数不规范，请填写正确的参数");
		}
		return mapper.addCompanyPromise(companyPromise);
	}
	
	/**
	 * 添加一个企业承诺书数据
	 * @param companyDetailsProise
	 * @return
	 */
	private Integer addCompanyDetailsPromise(CompanyDetailsPromise companyDetailsPromise) {
		if(companyDetailsPromise==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return mapper.addCompanyDetailsPromise(companyDetailsPromise);
	}
	

	
}
