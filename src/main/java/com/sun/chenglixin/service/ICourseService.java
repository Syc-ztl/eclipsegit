package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.Course;
import com.sun.chenglixin.entity.DetailsCourse;
import com.sun.chenglixin.service.ex.exception.CourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;

public interface ICourseService {
	
	/**
	 * 添加一个课程表数据以及课程表简版，和总课时
	 * @param detailsCourse
	 * @param sumHours
	 * @throws InsertException
	 */
	void  saveCourseAndDetailsCourse(DetailsCourse detailsCourse,String sumHours,String type)throws InsertException;

	
	/**
	 * 根据start和end查询课程简表
	 * @param start
	 * @param end
	 * @return
	 * @throws CourseNotFoundException
	 */
	Course  findCourse(Integer start,Integer end)throws CourseNotFoundException;

}
