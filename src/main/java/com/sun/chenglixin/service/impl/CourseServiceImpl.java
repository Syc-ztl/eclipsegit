package com.sun.chenglixin.service.impl;

import java.util.Date;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.Course;
import com.sun.chenglixin.entity.DetailsCourse;
import com.sun.chenglixin.mapper.CourseMapper;
import com.sun.chenglixin.service.ICourseService;
import com.sun.chenglixin.service.ex.exception.CourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;

public class CourseServiceImpl implements ICourseService{

	@Autowired
	CourseMapper mapper;
	
	@Override
	public void saveCourseAndDetailsCourse(DetailsCourse detailsCourse, String sumHours,String type) throws InsertException {
		
		Integer doid=detailsCourse.getDoid();
		String title=detailsCourse.getTitle();
		String username=detailsCourse.getUsername();
		String companyUsername=detailsCourse.getCompanyUsername();
		
		if(username==null) {
			Course course=new Course(companyUsername, new Date(), companyUsername, new Date(), doid, title, type, sumHours, null);
			Integer row=addCourse(course);
			if(!row.equals(1)) {
				throw new InsertException("数据插入异常");
			}
		}
		if(companyUsername==null) {
			Course course=new Course(username, new Date(), username, new Date(), doid, title, type, sumHours, null);
			Integer row=addCourse(course);
			if(!row.equals(1)) {
				throw new InsertException("数据插入异常");
			}
		}
		
		detailsCourse.setModifiedTime(new Date());
		detailsCourse.setCreatedTime(new Date());
		if(username==null) {
			detailsCourse.setCreatedUser(companyUsername);
			detailsCourse.setModifiedUser(companyUsername);
		}
		
		if(companyUsername==null) {
			detailsCourse.setCreatedUser(username);
			detailsCourse.setModifiedUser(username);
		}
		Integer row=addDetailsCourse(detailsCourse);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常");
		}
	}
	
	
	@Override
	public Course findCourse(Integer start,Integer end) throws CourseNotFoundException {
		Course course=findAll(start, end);
		if(course==null) {
			throw new CourseNotFoundException("已经到底了");
		}
		return course;
	}
	
	/**
	 * 添加一个课程简版表数据
	 * @param course
	 * @return
	 */
	private Integer  addCourse(Course course) {
		if(course==null) {
			throw new IrregularParameterException("不规定的参数");
		}
		return mapper.addCourse(course);
	}
	
	/**
	 * 添加一个课程表详情
	 * @param detailsCourse
	 * @return
	 */
	private Integer addDetailsCourse(DetailsCourse detailsCourse) {
		if(detailsCourse==null) {
			throw new IrregularParameterException("不规范的参数");
		}
		return mapper.addDetailsCourse(detailsCourse);
	}

	/**
	 * 查询课程简表
	 * @param start
	 * @param end
	 * @return
	 */
	private Course  findAll(Integer start,Integer end) {
		if(start==null || end==null) {
			throw new IrregularParameterException("参数不规范异常");
		}
		return mapper.findAll(start, end);
	}


}
