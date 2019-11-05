package com.sun.chenglixin.service;

import java.util.List;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;

/**
 * 考试题业务层接口
 * @author lenveo
 *
 */
public interface IExamService {
	
	/**
	 * 添加考试题
	 * @param exam
	 */
	void  saveExam(Exam exam)throws InsertException;
	
	
	/**
	 * 随机查询50道题
	 * @return
	 * @throws ExamNotFoundException
	 */
	List<Exam>  seekExams()throws  ExamNotFoundException;
 	
	/**
	 * 根据eId查询分数，返回成绩
	 * @param eId
	 * @param cid
	 * @param uid
	 * @param answer
	 * @param username
	 * @return
	 * @throws ExamNotFoundException
	 * @throws WrongAnswerException
	 */
	Integer   returnScore(Integer eId,Integer cid,Integer uid,String answer,String username)throws ExamNotFoundException,WrongAnswerException;
	
	
}
