package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.chenglixin.entity.Course;
import com.sun.chenglixin.entity.DetailsCourse;
import com.sun.chenglixin.mapper.CourseMapper;
import com.sun.chenglixin.service.ICourseService;
import com.sun.chenglixin.service.ex.exception.CourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.DetailsCourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;


/**
 * 课程业务层
 * @author lenveo
 *
 */
@Service
public class CourseServiceImpl implements ICourseService{

	@Autowired
	CourseMapper mapper;
	
	@Override
	public void saveCourseAndDetailsCourse(DetailsCourse detailsCourse, String sumHours,String type,String name) throws InsertException {
		
		Integer doid=detailsCourse.getDoid();
		String title=detailsCourse.getTitle();
		
		
	
		
			Course course=new Course(name, new Date(), name, new Date(), doid, title, type, sumHours, null);
			Integer row=addCourse(course);
			if(!row.equals(1)) {
				throw new InsertException("数据插入异常");
			}
			
			detailsCourse.setModifiedTime(new Date());
			detailsCourse.setCreatedTime(new Date());
			detailsCourse.setCreatedUser(name);
			detailsCourse.setModifiedUser(name);
		
		Integer row1=addDetailsCourse(detailsCourse);
		if(!row1.equals(1)) {
			throw new InsertException("数据插入异常");
		}
	}
	
	
	@Override
	public List<Course> findCourse(Integer start,Integer end) throws CourseNotFoundException {
		List<Course> list=findAll(start, end);
		if(list.isEmpty()) {
			throw new CourseNotFoundException("已经到底了");
		}
		return list;
	}
	
	
	@Override
	public DetailsCourse findDetailsCourseByDoid(Integer doid) throws DetailsCourseNotFoundException {
		DetailsCourse deta=findDetailsCourseByDoid(doid);
		if(deta==null) {
			throw new DetailsCourseNotFoundException("详情课程表未找到，请联系管理员");
		}
		return deta;
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
	private List<Course>  findAll(Integer start,Integer end) {
		if(start==null || end==null) {
			throw new IrregularParameterException("参数不规范异常");
		}
		return mapper.findAll(start, end);
	}
	/**
	 * 根据doid进行查询课程详情
	 * @param doid
	 * @return
	 */
	private DetailsCourse    findDetailsCourseByoid(Integer doid) {
		if(doid==null) {
			throw new IrregularParameterException("不规范参数异常");
		}
		return mapper.findDetailsCourseByoid(doid);
	}

}
