package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 企业相关的信息
 * @author lenveo
 *
 */
public class Company extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Integer cid;
	 private  String userName;
	 private String companyName;
	 private String creditScore ;
	 private String  hours;
	private String idCard;
	private String phone;
	private String email;
	private String password;
	private  Integer authority;
	private String salt;
	private String avatar;
	 public Company(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
			super(createdUser, createdTime, modifiedUser, modifiedTime);
			// TODO Auto-generated constructor stub
		}
	 
	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
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
		Company other = (Company) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Company [cid=" + cid + ", userName=" + userName + ", companyName=" + companyName + ", creditScore="
				+ creditScore + ", hours=" + hours + ", idCard=" + idCard + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", authority=" + authority + ", salt=" + salt + ", avatar=" + avatar
				+ ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()=" + getCreatedTime()
				+ ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	
	
	

	
}
