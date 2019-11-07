package com.sun.chenglixin.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.chenglixin.controller.Exception.ControllerException;
import com.sun.chenglixin.controller.Exception.FileEmptyException;
import com.sun.chenglixin.controller.Exception.FileIOException;
import com.sun.chenglixin.controller.Exception.FileSizeException;
import com.sun.chenglixin.controller.Exception.FileStateException;
import com.sun.chenglixin.controller.Exception.FileTypeException;
import com.sun.chenglixin.controller.Exception.FileUploadException;
import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.CodeNotFoundException;
import com.sun.chenglixin.service.ex.exception.CompanyPromiseNotFoundException;
import com.sun.chenglixin.service.ex.exception.CourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.DetailsCourseNotFoundException;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.ServiceException;
import com.sun.chenglixin.service.ex.exception.SimulationExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UserNotFoundException;
import com.sun.chenglixin.service.ex.exception.UserPromiseNotFoundException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;
import com.sun.chenglixin.util.JsonResult;

public class BaseController {
	
	@ExceptionHandler({ServiceException.class,ControllerException.class})
	@ResponseBody
	public JsonResult<Void>  handlerException(Throwable  e) {
		JsonResult<Void>  json=new JsonResult<Void>();
		
		if(e instanceof  UsernameDuplicateException) {
			json.setState(30);
			json.setMessage(e.getMessage());
		}else if(e instanceof  InsertException) {
			json.setState(31);
			json.setMessage(e.getMessage());
		}else if(e instanceof  UserNotFoundException) {
			json.setState(32);
			json.setMessage(e.getMessage());
		}else if(e instanceof PasswordNotMatchException) {
			json.setState(33);
			json.setMessage(e.getMessage());
		}else if(e  instanceof  CodeNotFoundException) {
			json.setState(50);
			json.setMessage(e.getMessage());
		}else if(e instanceof CodeCheckOutException) {
			json.setState(51);
			json.setMessage(e.getMessage());
		}else if(e instanceof  PhoneNotFoundException) {
			json.setState(60);
			json.setMessage(e.getMessage());
		}else if(e instanceof UpdateException) {
			json.setState(70);
			json.setMessage(e.getMessage());
		}else if(e instanceof FileEmptyException) {
			json.setState(80);
			json.setMessage(e.getMessage());
		}else if(e instanceof FileIOException) {
			json.setState(81);
			json.setMessage(e.getMessage());
		}else if(e instanceof FileSizeException) {
			json.setState(82);
			json.setMessage(e.getMessage());
		}else if(e instanceof FileStateException) {
			json.setState(83);
			json.setMessage(e.getMessage());
		}else if(e instanceof FileTypeException) {
			json.setState(84);
			json.setMessage(e.getMessage());
		}else if(e instanceof UserPromiseNotFoundException) {
			json.setState(91);
			json.setMessage(e.getMessage());
		}else if(e instanceof CompanyPromiseNotFoundException) {
			json.setState(90);
			json.setMessage(e.getMessage());
		}else if(e instanceof  CourseNotFoundException) {
			json.setState(100);
			json.setMessage(e.getMessage());
		}else  if(e instanceof  DetailsCourseNotFoundException) {
			json.setState(101);
			json.setMessage(e.getMessage());
		}else if(e instanceof   ExamNotFoundException) {
			json.setState(120);
			json.setMessage(e.getMessage());
		}else if(e instanceof WrongAnswerException) {
			json.setState(121);
			json.setMessage(e.getMessage());
		}else if(e instanceof HeadLineNotFoundException) {
			json.setState(130);
			json.setMessage(e.getMessage());
		}else if(e instanceof SimulationExamNotFoundException) {
			json.setState(122);
			json.setMessage(e.getMessage());
		}
		
		return json;
	}
}
