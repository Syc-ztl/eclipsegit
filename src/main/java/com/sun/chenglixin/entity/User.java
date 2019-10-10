package com.sun.chenglixin.entity;
/**
 * 个人的相关信息
 * @author lenveo
 *
 */
public class User extends BaseEntity{
	private Integer uid;
	private String username;
	private String idCard;
	private String phone;
	private String email;
	private String avatar;
	private String password;
	private String salt;
	private int authority;
	public int getUid() {
		return uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uid;
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
		User other = (User) obj;
		if (uid != other.uid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username +", idCard=" + idCard
				+ ", phone=" + phone + ", email=" + email + ", avatar=" + avatar + ", password=" + password + ", salt=" + salt + ", authority=" + authority + ", getCreatedUser()="
				+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
				+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}
	

	
	
	
}
