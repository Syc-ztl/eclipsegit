package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 题库题实体类
 * @author lenveo
 *
 */
public class Information extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iId;
	private Integer tId;
	private Integer aId;
	private String type;
	private String body;
	public Information(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		
	}
	public Integer getiId() {
		return iId;
	}
	public void setiId(Integer iId) {
		this.iId = iId;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public Integer getaId() {
		return aId;
	}
	public void setaId(Integer aId) {
		this.aId = aId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iId == null) ? 0 : iId.hashCode());
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
		Information other = (Information) obj;
		if (iId == null) {
			if (other.iId != null)
				return false;
		} else if (!iId.equals(other.iId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Information [iId=" + iId + ", tId=" + tId + ", aId=" + aId + ", type=" + type + ", body=" + body
				+ ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	
}
