package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 信用修复申请书实体类
 * @author lenveo
 *
 */
public class RepairApplicat extends BaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer raid;
	private String userName;
	private String idCard;
	private String type;
	private String companyName;
	private String province;
	private String county;
	private String applicatAvatar;
	private String promiseAvatar;
	private String phone;
	
	public RepairApplicat(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		// TODO Auto-generated constructor stub
	}

	public Integer getRaid() {
		return raid;
	}

	public void setRaid(Integer raid) {
		this.raid = raid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getApplicatAvatar() {
		return applicatAvatar;
	}

	public void setApplicatAvatar(String applicatAvatar) {
		this.applicatAvatar = applicatAvatar;
	}

	public String getPromiseAvatar() {
		return promiseAvatar;
	}

	public void setPromiseAvatar(String promiseAvatar) {
		this.promiseAvatar = promiseAvatar;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((raid == null) ? 0 : raid.hashCode());
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
		RepairApplicat other = (RepairApplicat) obj;
		if (raid == null) {
			if (other.raid != null)
				return false;
		} else if (!raid.equals(other.raid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RepairApplicat [raid=" + raid + ", userName=" + userName + ", idCard=" + idCard + ", type=" + type
				+ ", companyName=" + companyName + ", province=" + province + ", county=" + county + ", applicatAvatar="
				+ applicatAvatar + ", promiseAvatar=" + promiseAvatar + ", phone=" + phone + ", getCreatedUser()="
				+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
				+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
	}

}
