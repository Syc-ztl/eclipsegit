package com.sun.chenglixin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.entity.Course;
import com.sun.chenglixin.entity.DetailsCourse;
import com.sun.chenglixin.service.ICourseService;
import com.sun.chenglixin.util.JsonResult;

/**
 * 课程控制层
 * @author lenveo
 *
 */
@RestController
@RequestMapping("course")
public class CourseController extends BaseController {
		
	@Autowired
	ICourseService  service;

	@RequestMapping("save_course")
	public JsonResult<Void>   saveCourseAndDetailsCourse(DetailsCourse detailsCourse,String sumHours,String type,HttpSession session){
		String username=(String) session.getAttribute("username");
		String companyName=(String)session.getAttribute("companyName");
		if(username==null) {
			service.saveCourseAndDetailsCourse(detailsCourse, sumHours, type, companyName);
		}
		if(companyName==null) {
			service.saveCourseAndDetailsCourse(detailsCourse, sumHours, type, username);
		}
		JsonResult<Void>  json=new JsonResult<Void>();	
		json.setState(20);
		return json;
	}
	
	
	@RequestMapping("find_course")
	public  JsonResult<List<Course>>  findCourse(){
		Integer start=0;
		Integer end=start+20;
		start=end;
		List<Course> list=service.findCourse(start, end);
		JsonResult<List<Course>>  json=new JsonResult<List<Course>>();
		json.setState(20);
		json.setDate(list);
		return  json;
	}
	
	
	@RequestMapping("find_detailsCourse")
	public  JsonResult<DetailsCourse>  findDetailsCourseByDoid(Integer doid){
		service.findDetailsCourseByDoid(doid);
		JsonResult<DetailsCourse>  json=new JsonResult<DetailsCourse>();	
		json.setState(20);
		return json;
	}
	
}
