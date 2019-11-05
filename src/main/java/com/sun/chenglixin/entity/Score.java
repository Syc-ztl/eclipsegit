package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 考试成绩实体类
 * @author lenveo
 *
 */
public class Score extends BaseEntity {
	private Integer sid;
	private Integer uid;
	private Integer cid;
	private Date time;
	private Integer informationScore ;
	private Integer examScore;
	public Score(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getInformationScore() {
		return informationScore;
	}
	public void setInformationScore(Integer informationScore) {
		this.informationScore = informationScore;
	}
	public Integer getExamScore() {
		return examScore;
	}
	public void setExamScore(Integer examScore) {
		this.examScore = examScore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
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
		Score other = (Score) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Score [sid=" + sid + ", uid=" + uid + ", cid=" + cid + ", time=" + time + ", informationScore="
				+ informationScore + ", examScore=" + examScore + ", getCreatedUser()=" + getCreatedUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + "]";
	}

}
