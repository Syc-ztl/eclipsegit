package com.sun.chenglixin.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.DetailsHeadline;
import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.entity.Photo;
import com.sun.chenglixin.mapper.HeadLineMapper;
import com.sun.chenglixin.service.IHeadLineService;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;

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
	
	
	@Override
	public void saveHeadLine(DetailsHeadline detailsHeadline, String avatar) throws InsertException {
		
		
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

	/**
	 * 根据信用头条添加一个简版信用头条
	 * @param headLine
	 * @return
	 */
	private Integer addHeadLine(HeadLine headLine) {
		return mapper.addHeadLine(headLine);
	}
	
	
	/**
	 * 根据信用头条添加一个详情版信用头条
	 * @param detailsHeadLine
	 * @return
	 */
	private Integer  addDetailsHeadLine(DetailsHeadline detailsHeadLine) {
		return mapper.addDetailsHeadLine(detailsHeadLine);
	}
	
	/**
	 * 添加图片
	 * @param photo
	 * @return
	 */
	private Integer addPhoto(Photo photo) {
		return mapper.addPhoto(photo);
	}
	
	
}
