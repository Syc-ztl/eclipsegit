package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 课程简表表实体类
 * @author lenveo
 *
 */
public class Course extends BaseEntity {
	
	private int oid;
	private int doid;
	private String title;
	private String type;
	private String sumHours;
	private String avatar;
	
	
	
	public Course(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime, int doid, String title,
			String type, String sumHours, String avatar) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		this.doid = doid;
		this.title = title;
		this.type = type;
		this.sumHours = sumHours;
		this.avatar = avatar;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getDoid() {
		return doid;
	}
	public void setDoid(int doid) {
		this.doid = doid;
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
	public String getSumHours() {
		return sumHours;
	}
	public void setSumHours(String sumHours) {
		this.sumHours = sumHours;
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
		result = prime * result + oid;
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
		Course other = (Course) obj;
		if (oid != other.oid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [oid=" + oid + ", doid=" + doid + ", title=" + title + ", type=" + type + ", sumHours="
				+ sumHours + ", avatar=" + avatar + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
				+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
				+ getModifiedTime() + "]";
	}
	
	
	

}
