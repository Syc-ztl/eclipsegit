package com.sun.chenglixin.service;

import java.util.List;
import java.util.Map;

import com.sun.chenglixin.entity.Information;
import com.sun.chenglixin.entity.Type;
import com.sun.chenglixin.service.ex.exception.InformationNotFoundException;
import com.sun.chenglixin.service.ex.exception.InformationSumIsEmptyException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.TitleNotFoundException;
import com.sun.chenglixin.service.ex.exception.TypeNotFoundException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;

/**
 * 题库业务层接口
 * @author lenveo
 *
 */
public interface IInformationService {
	
	/**
	 * 添加题库
	 * @param information
	 * @param title
	 * @param username
	 * @exception InsertException
	 */
	void   saveInformation(Information information,String title,
							String username,String answer,String rAanswer)throws InsertException;
	
	
	
	
	
	/**
	 * 查询具有相同类型的题库题
	 * @return
	 * @throws InformationNotFoundException
	 */
	List<Information>   seekInformation(Integer tId)throws InformationNotFoundException;
	
	
	
	/**
	 * 查询题库类型标题和题库题总和
	 * @return
	 * @throws InformationSumIsEmptyException
	 * @throws TitleNotFoundException
	 */
	Map<String,Integer>   seekSumAndTitle()throws InformationSumIsEmptyException,TitleNotFoundException;
	
	/**
	 * 根据iId查询真实答案进行对比提交答案
	 * @param iId
	 * @return
	 * @throws WrongAnswerException
	 */
	void   returnAnswer(Integer iId,String answer)throws WrongAnswerException;
	
	
}
