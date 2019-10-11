package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 个人简版承诺书实体类
 * 
 * @author lenveo
 *
 */
public class UserPromise extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer pid;
	private Integer udpid;
	private String title;
	private String type;
	private Integer isPromise;
	private Date time;

	public UserPromise() {
		super();
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUdpid() {
		return udpid;
	}

	public void setUdpid(Integer udpid) {
		this.udpid = udpid;
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
		UserPromise other = (UserPromise) obj;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		return true;
	}

	public Integer getIsPromise() {
		return isPromise;
	}

	public void setIsPromise(Integer isPromise) {
		this.isPromise = isPromise;
	}

	@Override
	public String toString() {
		return "userPromise [pid=" + pid + ", udpid=" + udpid + ", title=" + title + ", type=" + type + ", isPromise="
				+ isPromise + ", time=" + time + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
				+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
				+ getModifiedTime() + "]";
	}

}
