package com.sun.chenglixin.entity;

import java.util.Date;

/**
 * 行用头条简版实体类
 * @author lenveo
 *
 */
public class HeadLine extends BaseEntity {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private  Integer hid;
			private Integer dhid ;
			private String title ;
			private Date headlinTime;
			private String avatar;
			
			public HeadLine(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
				super(createdUser, createdTime, modifiedUser, modifiedTime);
				// TODO Auto-generated constructor stub
			}
			
			public Integer getHid() {
				return hid;
			}
			
			public Integer getDhid() {
				return dhid;
			}

			public void setDhid(Integer dhid) {
				this.dhid = dhid;
			}

			public void setHid(Integer hid) {
				this.hid = hid;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			
			public Date getHeadlinTime() {
				return headlinTime;
			}

			public void setHeadlinTime(Date headlinTime) {
				this.headlinTime = headlinTime;
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
				result = prime * result + ((hid == null) ? 0 : hid.hashCode());
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
				HeadLine other = (HeadLine) obj;
				if (hid == null) {
					if (other.hid != null)
						return false;
				} else if (!hid.equals(other.hid))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "HeadLine [hid=" + hid + ", dhid=" + dhid + ", title=" + title + ", headlinTime=" + headlinTime
						+ ", avatar=" + avatar + ", getCreatedUser()=" + getCreatedUser() + ", getCreatedTime()="
						+ getCreatedTime() + ", getModifiedUser()=" + getModifiedUser() + ", getModifiedTime()="
						+ getModifiedTime() + "]";
			}

			
			
			
}
