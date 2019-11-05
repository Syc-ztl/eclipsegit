package com.sun.chenglixin.service;

import java.util.List;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.entity.SimulationExam;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.SimulationExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;

/**
 * 模拟考试业务层接口
 * @author lenveo
 *
 */
public interface ISimulationExamService {
	
	/**
	 * 添加一个模拟考试题目
	 * @param simulationExam
	 * @throws InsertException
	 */
	void   saveSimulationExam(SimulationExam simulationExam)throws InsertException;
	
	
	/**
	 * 随机查询50道题
	 * @return
	 * @throws ExamNotFoundException
	 */
	List<SimulationExam>  seekSimulationExam()throws  SimulationExamNotFoundException;
 	
	/**
	 * 根据sId查询分数，返回成绩
	 * @param sId
	 * @param cid
	 * @param uid
	 * @param answer
	 * @param username
	 * @return
	 * @throws ExamNotFoundException
	 * @throws WrongAnswerException
	 */
	Integer   returnScore(Integer sId,Integer cid,Integer uid,String answer,String username)throws ExamNotFoundException,WrongAnswerException;
	
	
}
