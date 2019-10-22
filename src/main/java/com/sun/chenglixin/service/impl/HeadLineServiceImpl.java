package com.sun.chenglixin.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.DetailsHeadline;
import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.entity.Photo;
import com.sun.chenglixin.mapper.HeadLineMapper;
import com.sun.chenglixin.service.IHeadLineService;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;

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
	public void saveHeadLine(DetailsHeadline detailsHeadline, String avatar,String username) throws InsertException {
		
		Integer dhid=detailsHeadline.getDhid();
		String title=detailsHeadline.getTitle();
		Date headlineTime=detailsHeadline.getIssueTime();
		HeadLine  headLine=new HeadLine(username, new Date(), username, new Date());
		headLine.setDhid(dhid);
		headLine.setTitle(title);
		headLine.setHeadlinTime(headlineTime);
		Integer row=addHeadLine(headLine);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
		
		
		
		Photo photo=new Photo(username, new Date(), username, new Date());
		photo.setAvatar(avatar);
		photo.setDhid(dhid);
		Integer row1=addPhoto(photo);
		if(!row1.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
		
		
		detailsHeadline.setCreatedTime(new Date());
		detailsHeadline.setCreatedUser(username);
		detailsHeadline.setModifiedTime(new Date());
		detailsHeadline.setModifiedUser(username);
		Integer row2=addDetailsHeadLine(detailsHeadline);
		if(!row2.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}
		
	}

	/**
	 * 根据分页查询进行查询信用头条的简版信息
	 * @param start
	 * @param end
	 * @return
	 */
	private HeadLine	findHeadLineByLimit(Integer start,Integer end){
		if(start==null || end==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.findHeadLineByLimit(start, end);
	}

	/**
	 * 根据信用头条添加一个简版信用头条
	 * @param headLine
	 * @return
	 */
	private Integer addHeadLine(HeadLine headLine) {
		if(headLine==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.addHeadLine(headLine);
	}
	
	
	/**
	 * 根据信用头条添加一个详情版信用头条
	 * @param detailsHeadLine
	 * @return
	 */
	private Integer  addDetailsHeadLine(DetailsHeadline detailsHeadLine) {
		if(detailsHeadLine==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.addDetailsHeadLine(detailsHeadLine);
	}
	
	/**
	 * 添加图片
	 * @param photo
	 * @return
	 */
	private Integer addPhoto(Photo photo) {
		if(photo==null) {
			throw new IrregularParameterException("参数不规范");
		}
		return mapper.addPhoto(photo);
	}
	
	
}
