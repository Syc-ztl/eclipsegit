package com.sun.chenglixin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.entity.SimulationExam;

/**
 *模拟考试持久层接口
 * @author lenveo
 *
 */
public interface SimulationExamMapper {
	
	/**
	 * 添加模拟考试试题
	 * @param simulationExa
	 * @return
	 */
	Integer  addSimulationExam(SimulationExam simulationExam);
	
	
	/**
	 * 根据start和end进行截取
	 * @param start
	 * @param end
	 * @return
	 */
	List<SimulationExam> findSimulationExam(@Param("start")Integer start,@Param("end")Integer end);
	
	
	/**
	 * 查询总题数量
	 * @param tId
	 * @return
	 */
	Integer  findCount();
	
	
	/**
	 * 根据sid查询考试答案
	 * @param sId
	 * @return
	 */
	SimulationExam   findAnswerBysId(Integer sId);
	
	
}
