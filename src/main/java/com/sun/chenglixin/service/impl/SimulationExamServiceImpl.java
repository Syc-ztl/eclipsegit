package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.entity.Score;
import com.sun.chenglixin.entity.SimulationExam;
import com.sun.chenglixin.mapper.ScoreMapper;
import com.sun.chenglixin.mapper.SimulationExamMapper;
import com.sun.chenglixin.service.ISimulationExamService;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;
import com.sun.chenglixin.service.ex.exception.SimulationExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;
/**
 * 模拟考试实现类
 * @author lenveo
 *
 */
@Service
public class SimulationExamServiceImpl implements ISimulationExamService {

	@Autowired
	SimulationExamMapper mapper;
	@Autowired
	ScoreMapper socreMapper;
	
	
	@Override
	public void saveSimulationExam(SimulationExam simulationExam) throws InsertException {
		Integer row=addSimulationExam(simulationExam);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常，请联系管理员");
		}

	}

	@Override
	public List<SimulationExam> seekSimulationExam() throws SimulationExamNotFoundException {
		Integer sum=findCount();
		Integer end=null;
		Integer start=(int) (Math.random()*1000);
		while(sum-start<=50) {
			 start=(int) (Math.random()*1000);
		}
		end=start+50;
		List<SimulationExam> list=findSimulationExam(start, end);
		return list;
	}
	
	@Override
	public Integer returnScore(Integer sId,Integer cid,Integer uid,String answer,String username)throws ExamNotFoundException,WrongAnswerException {
		SimulationExam simulationExam=findAnswerBysId(sId);
		if(simulationExam==null) {
			throw new ExamNotFoundException("考试题未找到，请联系管理员");
		}
		Integer grade=simulationExam.getGrade();
		String rAnswer=simulationExam.getrAnswer();
		if(!rAnswer.contentEquals(answer)) {
			throw new WrongAnswerException("答案错误");
		}
		grade+=grade;
		Score score=new Score(username,  new Date(), username, new Date());
		if(cid==null) {
			score.setUid(uid);
		}
		if(uid==null) {
			score.setCid(cid);
		}
		score.setInformationScore(grade);
		score.setTime(new Date());
		addScore(score);
		return grade;
	}
	
	
	
	
	/**
	 * 添加模拟考试试题
	 * @param simulationExa
	 * @return
	 */
	private Integer  addSimulationExam(SimulationExam simulationExam) {
		if(simulationExam==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return  mapper.addSimulationExam(simulationExam);
	}
	
	
	/**
	 * 根据start和end进行截取
	 * @param start
	 * @param end
	 * @return
	 */
	private List<SimulationExam> findSimulationExam(Integer start,Integer end){
		if(start==null || end==null) {
			throw new IrregularParameterException("参数不规范异常");
		}
		return  mapper.findSimulationExam(start, end);
	}
	
	
	/**
	 * 查询总题数量
	 * @param tId
	 * @return
	 */
	private	Integer  findCount() {
			return  mapper.findCount();
	}
	
	
	/**
	 * 根据sid查询考试答案
	 * @param sId
	 * @return
	 */
	private SimulationExam   findAnswerBysId(Integer sId) {
		if(sId==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return mapper.findAnswerBysId(sId);
	}
	
	
	/**
	 * 添加分数
	 * @param score
	 * @return
	 */
	private Integer addScore(Score score) {
		if(score==null) {
			throw new IrregularParameterException("不规范的参数");
		}
		return socreMapper.addScore(score);
	}
}
