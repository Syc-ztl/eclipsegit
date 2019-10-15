package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.DetailsHeadline;
import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.entity.Photo;

/**
 * 信用头条持久层接口
 * @author lenveo
 *
 */
public interface HeadLineMapper {
	
	/**
	 * 根据信用头条添加一个简版信用头条
	 * @param headLine
	 * @return
	 */
	Integer addHeadLine(HeadLine headLine);
	
	
	/**
	 * 根据信用头条添加一个详情版信用头条
	 * @param detailsHeadLine
	 * @return
	 */
	Integer  addDetailsHeadLine(DetailsHeadline detailsHeadLine);
	
	/**
	 * 添加图片
	 * @param photo
	 * @return
	 */
	Integer addPhoto(Photo photo);
	
	/**
	 * 根据分页查询进行查询信用头条的简版信息
	 * @param start
	 * @param end
	 * @return
	 */
	HeadLine	findHeadLineByLimit(@Param("start")Integer start,@Param("end")Integer end);
}
