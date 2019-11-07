package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 题库答案表 实体类
 * @author lenveo
 *
 */
public class InformationAnswer extends BaseEntity {

	private Integer aId;//答案id
	private Integer iId ; //试题id
	private String answer;//答案
	private String rAnswer;//正确答案

	public InformationAnswer(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public Integer getiId() {
		return iId;
	}
	public void setiId(Integer iId) {
		this.iId = iId;
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
		result = prime * result + ((aId == null) ? 0 : aId.hashCode());
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
		InformationAnswer other = (InformationAnswer) obj;
		if (aId == null) {
			if (other.aId != null)
				return false;
		} else if (!aId.equals(other.aId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InformationAnswer [aId=" + aId + ", iId=" + iId + ", answer=" + answer + ", rAnswer=" + rAnswer
				+ ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	
}
