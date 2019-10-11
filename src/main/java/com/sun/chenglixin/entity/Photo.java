package com.sun.chenglixin.entity;

public class Photo extends BaseEntity {
			private Integer pid ;
			private Integer dhid;
			private String avatar ;
			public Integer getPid() {
				return pid;
			}
			public void setPid(Integer pid) {
				this.pid = pid;
			}
			public Integer getDhid() {
				return dhid;
			}
			public void setDhid(Integer dhid) {
				this.dhid = dhid;
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
				Photo other = (Photo) obj;
				if (pid == null) {
					if (other.pid != null)
						return false;
				} else if (!pid.equals(other.pid))
					return false;
				return true;
			}
			@Override
			public String toString() {
				return "Photo [pid=" + pid + ", dhid=" + dhid + ", avatar=" + avatar + ", getCreatedUser()="
						+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
						+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
			}
			
}
