package com.sun.chenglixin.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.sun.chenglixin.controller.Exception.ControllerException;
import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.service.ex.exception.CodeCheckOutException;
import com.sun.chenglixin.service.ex.exception.CodeNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.PasswordNotMatchException;
import com.sun.chenglixin.service.ex.exception.PhoneNotFoundException;
import com.sun.chenglixin.service.ex.exception.ServiceException;
import com.sun.chenglixin.service.ex.exception.UpdateException;
import com.sun.chenglixin.service.ex.exception.UserNotFoundException;
import com.sun.chenglixin.service.ex.exception.UsernameDuplicateException;
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
		}
		
		return json;
	}
}
