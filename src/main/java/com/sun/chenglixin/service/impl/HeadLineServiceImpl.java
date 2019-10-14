package com.sun.chenglixin.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.mapper.HeadLineMapper;
import com.sun.chenglixin.service.IHeadLineService;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;

public class HeadLineServiceImpl implements IHeadLineService{

	@Autowired
	HeadLineMapper mapper;
	
	@Override
	public HeadLine seekHeadLine(Integer start, Integer end)throws HeadLineNotFoundException {
		HeadLine headLine=findHeadLineByLimit(start, end);
		if(headLine==null) {
			throw new HeadLineNotFoundException("已经到底了！");
		}
		return headLine;
	}

	/**
	 * 根据分页查询进行查询信用头条的简版信息
	 * @param start
	 * @param end
	 * @return
	 */
	private HeadLine	findHeadLineByLimit(Integer start,Integer end){
		return mapper.findHeadLineByLimit(start, end);
	}
	
	
}
