package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 个人承诺书详情实体类
 * 
 * @author lenveo
 *
 */
public class UserDetailsPromise extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer udpid;
	private String title;
	private String body;
	private String userName;
	private Date time;
	private String type;
	private String idCard;
	private String phone;
	
	
	
	
	public UserDetailsPromise(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}

	
	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((udpid == null) ? 0 : udpid.hashCode());
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
		UserDetailsPromise other = (UserDetailsPromise) obj;
		if (udpid == null) {
			if (other.udpid != null)
				return false;
		} else if (!udpid.equals(other.udpid))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserDetailsPromise [udpid=" + udpid + ", title=" + title + ", body=" + body + ", userName=" + userName
				+ ", time=" + time + ", type=" + type + ", idCard=" + idCard + ", phone=" + phone
				+ ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}

	
	

}
