package com.sun.chenglixin.mapper;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.Course;
import com.sun.chenglixin.entity.DetailsCourse;

public interface CourseMapper {
	
	/**
	 * 添加一个课程简版表数据
	 * @param course
	 * @return
	 */
	Integer  addCourse(Course course);
	
	/**
	 * 添加一个课程表详情
	 * @param detailsCourse
	 * @return
	 */
	Integer addDetailsCourse(DetailsCourse detailsCourse);
	
	/**
	 * 查询课程简表
	 * @param start
	 * @param end
	 * @return
	 */
	Course  findAll(@Param("start")Integer start,@Param("end")Integer end);
	
}
