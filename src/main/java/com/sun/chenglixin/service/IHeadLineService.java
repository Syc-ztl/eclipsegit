package com.sun.chenglixin.service;

import com.sun.chenglixin.entity.HeadLine;
import com.sun.chenglixin.service.ex.exception.HeadLineNotFoundException;

/**
 * 信用头条
 * @author lenveo
 *
 */
public interface IHeadLineService {

	/**
	 * 根据start和end查询信用头条信息
	 * @param start
	 * @param end
	 * @return
	 */
	HeadLine seekHeadLine(Integer start,Integer end)throws HeadLineNotFoundException;
}
