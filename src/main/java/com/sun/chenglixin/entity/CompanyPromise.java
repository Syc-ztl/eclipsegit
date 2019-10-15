package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 企业简版承诺书实体类
 * 
 * @author lenveo
 *
 */
public class CompanyPromise extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer cdpid;
	private String title;
	private String type;
	private Integer isPromise;
	private Date time;

	

	public CompanyPromise(String createdUser, Date createdTime, String modifiedUser,
											Date modifiedTime,Integer cdpid, 
											String title, String type, 
											Integer isPromise, Date time) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		this.cdpid = cdpid;
		this.title = title;
		this.type = type;
		this.isPromise = isPromise;
		this.time = time;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getCdpid() {
		return cdpid;
	}

	public void setCdpid(Integer cdpid) {
		this.cdpid = cdpid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getIsPromise() {
		return isPromise;
	}

	public void setIsPromise(Integer isPromise) {
		this.isPromise = isPromise;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
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
		CompanyPromise other = (CompanyPromise) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "companyPromise [pid=" + pid + ", cdpid=" + cdpid + ", title=" + title + ", type=" + type
				+ ", isPromise=" + isPromise + ", time=" + time + ", getCreatedUser()=" + getCreatedUser()
				+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
				+ ", getModifiedTime()=" + getModifiedTime() + "]";
	}

}
