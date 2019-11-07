package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
	 * 根据标题查询信用头条详情
	 * @param title
	 * @return
	 */
	DetailsHeadline  findBytitle(String title);
	
	/**
	 * 根据dhid查找对应的信用头条详情
	 * @param dhid
	 * @return
	 */
	DetailsHeadline  findDetailsHeadline(Integer dhid);
	
	
	/**
	 * 根据dhid查询当前行用头条的所有照片路径
	 * @param dhid
	 * @return
	 */
	List<Photo>  findAvatar(Integer dhid);	
	
	
	/**
	 * 根据分页查询进行查询信用头条的简版信息
	 * @param start
	 * @param end
	 * @return
	 */
	List<HeadLine>	findHeadLineByLimit(@Param("start")Integer start,@Param("end")Integer end);
}
