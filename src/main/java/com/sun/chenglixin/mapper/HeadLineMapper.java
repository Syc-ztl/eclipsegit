package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.HeadLine;

/**
 * 信用头条持久层接口
 * @author lenveo
 *
 */
public interface HeadLineMapper {
	
	/**
	 * 根据分页查询进行查询信用头条的简版信息
	 * @param start
	 * @param end
	 * @return
	 */
	HeadLine	findHeadLineByLimit(@Param("start")Integer start,@Param("end")Integer end);
}
