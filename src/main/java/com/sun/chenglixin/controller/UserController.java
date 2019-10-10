package com.sun.chenglixin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.chenglixin.entity.User;
import com.sun.chenglixin.service.IUserService;
import com.sun.chenglixin.util.JsonResult;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {

	@Autowired
	IUserService service;

	@RequestMapping("add_user")
	public JsonResult<Void> saveUser(User user, String code) {
		JsonResult<Void> json = new JsonResult<Void>();
		service.saveUser(user, code);
		json.setState(20);
		return json;
	}

	@RequestMapping("send")
	public JsonResult<Void> sendIdCard(String phone) {
		service.sendCode(phone);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		return json;
	}

	@RequestMapping("login")
	public JsonResult<User> login(String username, String password, HttpSession session) {
		System.err.println(username);
		System.err.println(password);
		User user = service.login(username, password);
		session.setAttribute("username", username);
		session.setAttribute("uid", user.getUid());
		session.setAttribute("phone", user.getPhone());
		JsonResult<User> json = new JsonResult<User>();
		json.setState(20);
		json.setDate(user);
		return json;
	}

	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(String phone, String password, String code) {
		service.updatePassword(password, phone, code);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		return json;
	}

}
