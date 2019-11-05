package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 真实考试实体类
 * @author lenveo
 *
 */
public class Exam extends BaseEntity {
	private Integer eid;		
	private String body;
	private String type;
	private String answer;
	private Integer  grade;
	private String rAnswer;
	public Exam(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
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
	
	
	
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eid == null) ? 0 : eid.hashCode());
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
		Exam other = (Exam) obj;
		if (eid == null) {
			if (other.eid != null)
				return false;
		} else if (!eid.equals(other.eid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", body=" + body + ", type=" + type + ", answer=" + answer + ", grade=" + grade
				+ ", rAnswer=" + rAnswer + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
				+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
				+ getModifiedTime() + "]";
	}
}
