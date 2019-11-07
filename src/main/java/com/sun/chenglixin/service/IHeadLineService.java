package com.sun.chenglixin.service;

import java.util.List;

import com.sun.chenglixin.entity.DetailsHeadline;
import com.sun.chenglixin.entity.DetalitsHeadLineAndPhotoVO;
import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;

/**
 * 信用头条
 * @author lenveo
 *
 */
public interface IHeadLineService {

	/**
	 * 添加一个信用头条新闻，和照片
	 * @param detailsHeadline
	 * @param avatar
	 * @throws InsertException
	 */
	void   saveHeadLine(DetailsHeadline detailsHeadline,String avatar,String username)throws InsertException;
	
	/**
	 * 根据start和end查询信用头条信息
	 * @param start
	 * @param end
	 * @return
	 */
	List<HeadLine> seekHeadLine(Integer start,Integer end)throws HeadLineNotFoundException;
	
	/**
	 * 根据标题查询信用头条，在添加图片
	 * @param title
	 * @param avatar
	 */
	void   savePhotoAvatar(String title,String avatar,String username)throws InsertException;
	
	/**
	 * 查询详情信用头条以及它所有照片
	 * @param dhid
	 * @return
	 */
	DetalitsHeadLineAndPhotoVO   seekDetailsHeadline(Integer dhid);
	
	
	
	
}
