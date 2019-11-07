package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
	List<Course>  findAll(@Param("start")Integer start,@Param("end")Integer end);
	
	/**
	 * 根据doid进行查询课程详情
	 * @param doid
	 * @return
	 */
	DetailsCourse    findDetailsCourseByoid(Integer doid);
	
	
}
