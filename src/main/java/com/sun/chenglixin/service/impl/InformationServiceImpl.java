package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.chenglixin.entity.Information;
import com.sun.chenglixin.entity.InformationAnswer;
import com.sun.chenglixin.entity.Type;
import com.sun.chenglixin.mapper.InformationMapper;
import com.sun.chenglixin.service.IInformationService;
import com.sun.chenglixin.service.ex.exception.InformationNotFoundException;
import com.sun.chenglixin.service.ex.exception.InformationSumIsEmptyException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;
import com.sun.chenglixin.service.ex.exception.TitleNotFoundException;
import com.sun.chenglixin.service.ex.exception.TypeNotFoundException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;

public class InformationServiceImpl implements IInformationService{

	@Autowired
	InformationMapper mapper;
	
	
	@Override
	public void saveInformation(Information information,String title,String username,String answer,String rAnswer) {
		
		Integer aId=information.getaId();
		Type type=new Type(username, new Date(), username, new Date());
		type.setTitle(title);
		Integer row=addType(type);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常");
		}
		
		information.setCreatedTime(new Date());
		information.setCreatedUser(username);
		information.setModifiedTime(new Date());
		information.setModifiedUser(username);
		Integer row1=addInformation(information);
		if(!row1.equals(1)) {
			throw new InsertException("数据插入异常");
		}
		
		Integer iId=information.getiId();
		InformationAnswer iAnswer=new InformationAnswer(username, new Date(), username, new Date());
		iAnswer.setiId(iId);
		iAnswer.setAnswer(answer);
		iAnswer.setrAnswer(rAnswer);
		Integer row2=addAnswer(iAnswer);
		if(!row2.equals(1)) {
			throw new InsertException("数据插入异常");
		}
		
	}

	
		@Override
		public Map<String, Integer> seekSumAndTitle() throws InformationSumIsEmptyException, TitleNotFoundException {
			List<Type>  list=findAll();
			Map<String,Integer> map=new HashMap<>();
			for (Type type : list) {
				Integer tId=type.gettId();
				String title=type.getTitle();
				Integer sum=findSumBytId(tId);
				map.put(title, sum);
			}
			return map;
		}
	
	
	
	@Override
	public List<Information> seekInformation(Integer tId) throws InformationNotFoundException {
		List<Information>   list=findInformationBytId(tId);
		if(list==null) {
			throw new InformationNotFoundException("题目未找到，请联系管理员");
		}
		return list;
	}
	
	
	
	@Override
	public void returnAnswer(Integer iId, String answer) throws WrongAnswerException {
		InformationAnswer informationAnswer=findAnswerByiId(iId);
		String rAnswer=informationAnswer.getrAnswer();
		if(!answer.equals(rAnswer)) {
			throw new WrongAnswerException("答案错误，正确答案是"+rAnswer);
		}
	}
	
	
	
	/**
	 * 添加题库类型
	 * @param type
	 * @return
	 */
	private Integer addType(Type type) {
		if(type==null) {
			throw new IrregularParameterException("不规范得参数");
		}
		return  mapper.addType(type);
	}
	
	/**
	 * 添加题库题
	 * @param information
	 * @return
	 */
	private Integer  addInformation(Information information) {
		if(information==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return  mapper.addInformation(information);
	}
	
	
	/**
	 * 添加答案
	 * @param informationAnswer 
	 * @return
	 */
	private Integer  addAnswer(InformationAnswer informationAnswer) {
		if(informationAnswer==null) {
			throw new IrregularParameterException("不规范得参数");
		}
		return   mapper.addAnswer(informationAnswer);
	}


	/**
	 * 查询所有题库类型
	 * @return
	 */
	private List<Type>  findAll() {
		return  mapper.findAll();
	}
	
	/**
	 * 根据tid查询相同题库类型的题
	 * @param tId
	 * @return
	 */
	private List<Information>   findInformationBytId(Integer tId){
		if(tId==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return mapper.findInformationBytId(tId);
	}
	
	
	/**
	 * 根据tid查询总题数
	 * @param tId
	 * @return
	 */
	 private   Integer findSumBytId(Integer tId) {
		 if(tId==null) {
			 throw new IrregularParameterException("不规范参数");
		 }
		 return  mapper.findSumBytId(tId);
	 }
	
	
	 /**
		 * 根据iId查询题库答案
		 * @param iId
		 * @return
		 */
		private InformationAnswer   findAnswerByiId(Integer iId) {
			if(iId==null) {
				throw new IrregularParameterException("不规范参数");
			}
			return mapper.findAnswerByiId(iId);
		}
	
}
