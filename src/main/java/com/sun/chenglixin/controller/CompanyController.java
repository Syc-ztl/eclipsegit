package com.sun.chenglixin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.chenglixin.entity.Company;
import com.sun.chenglixin.service.ICompanyService;
import com.sun.chenglixin.util.JsonResult;

@RestController
@RequestMapping("company")
public class CompanyController extends BaseController {

	@Autowired
	ICompanyService service;

	@RequestMapping("add_company")
	public JsonResult<Void> saveCompany(Company company, String code) {
		service.saveCompany(company, code);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		return json;
	}

	@RequestMapping("send_company")
	public JsonResult<Void> sendIdCard(String phone) {
		service.sendCode(phone);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		return json;
	}

	@RequestMapping("login_company")
	public JsonResult<Void> loginCompany(String phone, String password, HttpSession session) {
		Company company = service.login(phone, password);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		session.setAttribute("cid", company.getCid());
		session.setAttribute("username", company.getUsername());
		session.setAttribute("companyName", company.getCompanyName());
		session.setAttribute("phone", company.getPhone());
		return json;
	}

}
