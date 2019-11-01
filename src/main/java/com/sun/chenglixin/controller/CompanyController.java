package com.sun.chenglixin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.chenglixin.controller.Exception.FileEmptyException;
import com.sun.chenglixin.controller.Exception.FileIOException;
import com.sun.chenglixin.controller.Exception.FileSizeException;
import com.sun.chenglixin.controller.Exception.FileStateException;
import com.sun.chenglixin.controller.Exception.FileTypeException;
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

	
	private static final long AVATAR_MAX_SIZE = 600 * 1024;

	private static final List<String> AVATAR_TYPES = new ArrayList<String>();

	// 静态初始化器：用于初始化本类的静态成员
	static {
		AVATAR_TYPES.add("image/jpeg");
		AVATAR_TYPES.add("image/png");
	}

	@RequestMapping("change_avatar")
	public  JsonResult<Void>   changeAvatar(HttpSession session,@RequestParam("file")MultipartFile file,HttpServletRequest request){
		Integer cid=(Integer)session.getAttribute("cid");
		String modifiedUser=(String) session.getAttribute("username");
		if(file.isEmpty()) {
			throw new FileEmptyException("文件上传不能为空");
		}
		// 文件大小验证
		long fileSize = file.getSize();
		if (fileSize > AVATAR_MAX_SIZE) {
			throw new FileSizeException("文件上传异常！文件大小超过上限:" + (AVATAR_MAX_SIZE / 1024) + "kb");
		}
		
		if(!AVATAR_TYPES.contains(file.getContentType())) {
			throw new FileTypeException("文件上传异常！文件类型不正确，允许的类型有：" + AVATAR_TYPES);
		}
		
		String oldFileName=file.getOriginalFilename();
		Integer index=oldFileName.lastIndexOf(".");
		String suffix="";
		if(index!=-1) {
			suffix=oldFileName.substring(index);
		}
		String  fileName=UUID.randomUUID().toString()+suffix;
		String filePath=request.getServletContext().getRealPath("upload");
		File parent=new File(filePath);
		if(!parent.exists()) {
			parent.mkdirs();
		}
		File dest=new File(parent,fileName);
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new FileStateException("文件上传异常 "+ e.getMessage());
		} catch (IOException e) {
			throw new FileIOException("文件上传异常 "+ e.getMessage());
		}
		
		
		String avatar="/upload"+fileName;
		
		service.changeAvatar(cid, modifiedUser, avatar);
		JsonResult<Void> json = new JsonResult<Void>();
		json.setState(20);
		return json;
	}
	
	
	
}
