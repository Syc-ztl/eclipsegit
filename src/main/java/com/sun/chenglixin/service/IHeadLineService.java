package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.DetailsHeadline;
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
	HeadLine seekHeadLine(Integer start,Integer end)throws HeadLineNotFoundException;
}
