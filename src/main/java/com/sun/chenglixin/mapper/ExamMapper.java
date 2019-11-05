package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.Exam;

/**
 * 考试持久层接口
 * @author lenveo
 *
 */
public interface ExamMapper {
	
	/**
	 * 添加考试题目
	 * @param exam
	 * @return
	 */
	Integer  addExam(Exam exam);
	
	/**
	 * 根据start和end进行截取
	 * @param start
	 * @param end
	 * @return
	 */
	List<Exam> findExam(@Param("start")Integer start,@Param("end")Integer end);
	
	
	/**
	 * 查询总题数量
	 * @param tId
	 * @return
	 */
	Integer  findCount();
	
	
	/**
	 * 根据eid查询考试答案
	 * @param eId
	 * @return
	 */
	Exam   findAnswerByeId(Integer eId);
	
	
	
	
}
