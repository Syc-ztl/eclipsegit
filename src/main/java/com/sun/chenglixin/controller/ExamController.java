package com.sun.chenglixin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.service.IExamService;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;
import com.sun.chenglixin.util.JsonResult;

@RestController
@RequestMapping("exam")
public class ExamController extends BaseController {
	
	@Autowired
	IExamService service;
	
	
	@RequestMapping("save_exam")
	public  JsonResult<Void>   saveExam(Exam exam){
		service.saveExam(exam);
		JsonResult<Void>  json=new JsonResult<Void>();	
		json.setState(20);
		return json;
	}

	
	@RequestMapping("seek_exam")
	public  JsonResult<List<Exam>>  seekExams(){
		List<Exam>  list=service.seekExams();
		JsonResult<List<Exam>>  json=new JsonResult<List<Exam>>();	
		json.setState(20);
		json.setDate(list);
		return json;
	}
	
	
	@RequestMapping("return_score")
	public  JsonResult<Integer>  returnScore(Integer eId,String answer,HttpSession session){
		Integer uid=(Integer) session.getAttribute("uid");
		Integer cid=(Integer) session.getAttribute("cid");
		String username=(String)session.getAttribute("username");
		Integer grade=service.returnScore(eId, cid, uid, answer, username);
		JsonResult<Integer>  json=new JsonResult<Integer>();	
		json.setState(20);
		json.setDate(grade);
		return json;
	}
	
	
	
	
 	

}
