package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 课程详情表实体类
 * @author lenveo
 *
 */
public class DetailsCourse extends BaseEntity {
	private int doid;
	private String name;
	private String avatar;
	private String title;
	private String promiseAvatar;
	public int getDoid() {
		return doid;
	}
	public void setDoid(int doid) {
		this.doid = doid;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPromiseAvatar() {
		return promiseAvatar;
	}
	public void setPromiseAvatar(String promiseAvatar) {
		this.promiseAvatar = promiseAvatar;
	}
	public DetailsCourse(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime,
			int doid, String name, String avatar, String title, String promiseAvatar) {
		super(createdUser, createdTime, modifiedUser, modifiedTime);
		this.doid = doid;
		this.name = name;
		this.avatar = avatar;
		this.title = title;
		this.promiseAvatar = promiseAvatar;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + doid;
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
		DetailsCourse other = (DetailsCourse) obj;
		if (doid != other.doid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DetailsCourse [doid=" + doid + ", name=" + name + ", avatar=" + avatar + ", title=" + title
				+ ", promiseAvatar=" + promiseAvatar + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
				+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
				+ getModifiedTime() + "]";
	}
	
	
	
	
}
