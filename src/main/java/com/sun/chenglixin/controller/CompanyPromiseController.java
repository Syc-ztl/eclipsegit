package com.sun.chenglixin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.chenglixin.entity.CompanyDetailsPromise;
import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.service.ICompanyPromiseService;
import com.sun.chenglixin.util.JsonResult;

@RestController
@RequestMapping("companyPromise")
public class CompanyPromiseController extends BaseController {

	@Autowired
	ICompanyPromiseService service;
	
	@RequestMapping("save_companyPromise")
	public   JsonResult<Void>   saveCompanyPromise(CompanyDetailsPromise companyDetailsPromise){
		service.saveCompanyPromise(companyDetailsPromise);
		JsonResult<Void>  json=new JsonResult<Void>();
		json.setState(20);
		return json;
	}
	
	
	@RequestMapping("find_companyPromise")
	public  JsonResult<List<CompanyPromise>>  seekCompanyPromise(){
		Integer start=0;
		Integer end=start+20;
		start=end;
		List<CompanyPromise> list=service.seekCompanyPromise(start, end);
		JsonResult<List<CompanyPromise>>  json=new JsonResult<List<CompanyPromise>>();
		json.setState(20);
		json.setDate(list);
		return  json;
	}
	
	
	
}
