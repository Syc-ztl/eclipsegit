package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 模拟考试实体类
 * @author lenveo
 *
 */
public class SimulationExam extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sId;
	private String body;
	private String type;
	private String answer;
	private  Integer grade;
	private String rAnswer;

	public SimulationExam(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		
	}
	

	public Integer getsId() {
		return sId;
	}



	public void setsId(Integer sId) {
		this.sId = sId;
	}



	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
	}


	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getrAnswer() {
		return rAnswer;
	}

	public void setrAnswer(String rAnswer) {
		this.rAnswer = rAnswer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sId == null) ? 0 : sId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulationExam other = (SimulationExam) obj;
		if (sId == null) {
			if (other.sId != null)
				return false;
		} else if (!sId.equals(other.sId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "SimulationExam [sId=" + sId + ", body=" + body + ", type=" + type + ", answer=" + answer + ", grade="
				+ grade + ", rAnswer=" + rAnswer + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
				+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
				+ getModifiedTime() + "]";
	}

	
	
	
	
	

	}
