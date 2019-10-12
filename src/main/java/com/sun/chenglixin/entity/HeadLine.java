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
			private Date headline_time;
			private String avatar;
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
			public Date getHeadline_time() {
				return headline_time;
			}
			public void setHeadline_time(Date headline_time) {
				this.headline_time = headline_time;
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
				return "Headline [hid=" + hid + ", dhid=" + dhid + ", title=" + title + ", headline_time="
						+ headline_time + ", avatar=" + avatar + ", getCreatedUser()=" + getCreatedUser()
						+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
						+ ", getModifiedTime()=" + getModifiedTime() + "]";
			}
			
			
}
