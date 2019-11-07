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
import com.sun.chenglixin.entity.CompanyPromise;
import com.sun.chenglixin.entity.DetailsHeadline;
import com.sun.chenglixin.entity.DetalitsHeadLineAndPhotoVO;
import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.service.IHeadLineService;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.util.JsonResult;
/**
 * 行用头条控制层
 * @author lenveo
 *
 */
@RestController
@RequestMapping("headLine")
public class HeadLineController extends BaseController {

	@Autowired
	IHeadLineService service;
	
	private static final long AVATAR_MAX_SIZE = 600 * 1024;
	private static final List<String> AVATAR_TYPES = new ArrayList<String>();
	// 静态初始化器：用于初始化本类的静态成员
	static {
		AVATAR_TYPES.add("image/jpeg");
		AVATAR_TYPES.add("image/png");
	}
	@RequestMapping("save_headLine")
	public JsonResult<Void>   saveHeadLine(DetailsHeadline detailsHeadline,
			@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpSession session){
		String modifiedUser = (String) session.getAttribute("username");
		// 空文件验证
		if (file.isEmpty()) {
			throw new FileEmptyException("文件上传异常！文件不能为空"); 
		}
		// 文件大小验证
		long fileSize = file.getSize();
		if (fileSize > AVATAR_MAX_SIZE) {
			throw new FileSizeException("文件上传异常！文件大小超过上限:" + (AVATAR_MAX_SIZE / 1024) + "kb");
		}
		// 文件类型验证
		if (!AVATAR_TYPES.contains(file.getContentType())) {
			throw new FileTypeException("文件上传异常！文件类型不正确，允许的类型有：" + AVATAR_TYPES);
		}
		String oldFileName = file.getOriginalFilename();
		Integer index = oldFileName.lastIndexOf(".");
		String suffix = "";
		if (index != -1) {
			suffix = oldFileName.substring(index);
		}
		String fileName = UUID.randomUUID().toString() + suffix;
		String filePath = request.getServletContext().getRealPath("upload");
		File parent = new File(filePath);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		File dest = new File(parent, fileName);

		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			throw new FileStateException("文件上传异常" + e.getMessage());
		} catch (IOException e) {
			throw new FileIOException("文件上传异常" + e.getMessage());
		}

		String avatar = "/upload" + fileName;
		service.saveHeadLine(detailsHeadline, avatar, modifiedUser);
		JsonResult<Void>  json=new JsonResult<Void>();	
		json.setState(20);
		return json;
	}
	
	
	@RequestMapping("seek_headLine")
	public JsonResult<List<HeadLine>>  seekHeadLine(){
		Integer start=0;
		Integer end=start+20;
		start=end;
		List<HeadLine> list=service.seekHeadLine(start, end);
		JsonResult<List<HeadLine>>  json=new JsonResult<List<HeadLine>>();
		json.setState(20);
		json.setDate(list);
		return  json;

	}
	
	
	
	@RequestMapping("save_photo")
	public JsonResult<Void> savePhotoAvatar(String title,
			@RequestParam("file") MultipartFile file,
			HttpServletRequest request,HttpSession session){
		String modifiedUser = (String) session.getAttribute("username");
		// 空文件验证
				if (file.isEmpty()) {
					throw new FileEmptyException("文件上传异常！文件不能为空"); 
				}
				// 文件大小验证
				long fileSize = file.getSize();
				if (fileSize > AVATAR_MAX_SIZE) {
					throw new FileSizeException("文件上传异常！文件大小超过上限:" + (AVATAR_MAX_SIZE / 1024) + "kb");
				}
				// 文件类型验证
				if (!AVATAR_TYPES.contains(file.getContentType())) {
					throw new FileTypeException("文件上传异常！文件类型不正确，允许的类型有：" + AVATAR_TYPES);
				}
				String oldFileName = file.getOriginalFilename();
				Integer index = oldFileName.lastIndexOf(".");
				String suffix = "";
				if (index != -1) {
					suffix = oldFileName.substring(index);
				}
				String fileName = UUID.randomUUID().toString() + suffix;
				String filePath = request.getServletContext().getRealPath("upload");
				File parent = new File(filePath);
				if (!parent.exists()) {
					parent.mkdirs();
				}
				File dest = new File(parent, fileName);

				try {
					file.transferTo(dest);
				} catch (IllegalStateException e) {
					throw new FileStateException("文件上传异常" + e.getMessage());
				} catch (IOException e) {
					throw new FileIOException("文件上传异常" + e.getMessage());
				}

				String avatar = "/upload" + fileName;
		service.savePhotoAvatar(title, avatar, modifiedUser);
		JsonResult<Void>  json=new JsonResult<Void>();	
		json.setState(20);
		return json;
	}
	
	
	
	@RequestMapping("seek_detailsHeadline")
	public  JsonResult<DetalitsHeadLineAndPhotoVO>  seekDetailsHeadline(Integer dhid){
		
		DetalitsHeadLineAndPhotoVO hpVO=service.seekDetailsHeadline(dhid);
		JsonResult<DetalitsHeadLineAndPhotoVO>  json=new JsonResult<DetalitsHeadLineAndPhotoVO>();	
		json.setState(20);
		json.setDate(hpVO);
		return json;
	}
	
}
