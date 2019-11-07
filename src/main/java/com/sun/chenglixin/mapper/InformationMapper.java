package com.sun.chenglixin.mapper;

import java.util.List;
import java.util.Map;

import com.sun.chenglixin.entity.Information;
import com.sun.chenglixin.entity.InformationAnswer;
import com.sun.chenglixin.entity.Type;


/**
 * 题库持久层接口
 * @author lenveo
 *
 */
public interface InformationMapper {
	
	/**
	 * 添加题库类型
	 * @param type
	 * @return
	 */
	Integer addType(Type type);
	
	/**
	 * 添加题库题
	 * @param information
	 * @return
	 */
	Integer  addInformation(Information information);
	
	
	/**
	 * 添加答案
	 * @param informationAnswer 
	 * @return
	 */
	Integer  addAnswer(InformationAnswer informationAnswer);


	/**
	 * 查询所有题库类型
	 * @return
	 */
	List<Type>  findAll();
	
	
	/**
	 * 根据tid查询相同题库类型的题
	 * @param tId
	 * @return
	 */
	List<Information>   findInformationBytId(Integer tId);
	
	
	
	
	/**
	 * 根据tid查询总题数
	 * @param tId
	 * @return
	 */
	  Integer findSumBytId(Integer tId);
	
	/**
	 * 查询title
	 * @return
	 */
	List<Type> findAllType();
	
	/**
	 * 根据iId查询题库答案
	 * @param iId
	 * @return
	 */
	InformationAnswer   findAnswerByiId(Integer iId);

	/**
	 * 根据title查tid
	 * @return java.lang.Integer
	 */
	Integer findTidByTitle(String title);

	/**
	 * 根据body查iid
	 * @return java.lang.Integer
	 */
	Integer findIidByBody(String body);
}
