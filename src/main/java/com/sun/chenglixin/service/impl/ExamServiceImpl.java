package com.sun.chenglixin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.chenglixin.entity.Exam;
import com.sun.chenglixin.entity.Score;
import com.sun.chenglixin.mapper.ExamMapper;
import com.sun.chenglixin.mapper.ScoreMapper;
import com.sun.chenglixin.service.IExamService;
import com.sun.chenglixin.service.ex.exception.ExamNotFoundException;
import com.sun.chenglixin.service.ex.exception.InsertException;
import com.sun.chenglixin.service.ex.exception.IrregularParameterException;
import com.sun.chenglixin.service.ex.exception.WrongAnswerException;
/**
 * 考试业务层实现类
 * @author lenveo
 *
 */
@Service
public class ExamServiceImpl implements IExamService {
	
	@Autowired
	ExamMapper mapper;
	@Autowired
	ScoreMapper socreMapper;
	
	@Override
	public void saveExam(Exam exam)throws InsertException {
		Integer row=addExam(exam);
		if(!row.equals(1)) {
			throw new InsertException("数据插入异常");
		}
	}

	
	@Override
	public List<Exam> seekExams() throws ExamNotFoundException {
		Integer sum=findCount();
		Integer end=null;
		Integer start=(int) (Math.random()*1000);
		while(sum-start<=50) {
			 start=(int) (Math.random()*1000);
		}
		end=start+50;
		List<Exam> list=findExam(start, end);
		return list;
	}
	
	
	
	@Override
	public Integer returnScore(Integer eId,Integer cid,Integer uid,String answer,String username)throws ExamNotFoundException,WrongAnswerException {
		Exam exam=findAnswerByeId(eId);
		if(exam==null) {
			throw new ExamNotFoundException("考试题未找到，请联系管理员");
		}
		Integer grade=exam.getGrade();
		String rAnswer=exam.getrAnswer();
		if(!rAnswer.equals(answer)) {
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
		score.setExamScore(grade);
		score.setTime(new Date());
		addScore(score);
		return grade;
	}
	
	
	/**
	 * 添加考试题目
	 * @param exam
	 * @return
	 */
	private Integer  addExam(Exam exam) {
		if(exam==null) {
			throw new IrregularParameterException("不规范参数");
		}
		return  mapper.addExam(exam);
	}


	/**
	 * 根据start和end进行截取
	 * @param start
	 * @param end
	 * @return
	 */
	private List<Exam> findExam(Integer start,Integer end){
		if(start==null ||  end==null) {
			throw new IrregularParameterException("参数不规范异常");
		}
		return mapper.findExam(start, end);
	}
	
	/**
	 * 查询总题数量
	 * @param tId
	 * @return
	 */
	private Integer  findCount() {
		return mapper.findCount();
	}
	
	/**
	 * 根据eid查询考试答案
	 * @param eId
	 * @return
	 */
	private Exam   findAnswerByeId(Integer eId) {
		return mapper.findAnswerByeId(eId);
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
