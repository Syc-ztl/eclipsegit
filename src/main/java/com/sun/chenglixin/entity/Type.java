package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 题库类型表 实体类
 * @author lenveo
 *
 */
public class Type extends BaseEntity{

	private static final long serialVersionUID = 1L;
	private Integer tId;//题库类型id
	private String title;//题库类型标题

	public Type(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tId == null) ? 0 : tId.hashCode());
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
		Type other = (Type) obj;
		if (tId == null) {
			if (other.tId != null)
				return false;
		} else if (!tId.equals(other.tId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Type [tId=" + tId + ", title=" + title + ", getCreatedUser()=" + getCreatedUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	
}