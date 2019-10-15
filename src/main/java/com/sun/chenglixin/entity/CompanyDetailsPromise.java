package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 企业详情承诺书实体类
 * @author lenveo
 *
 */
public class CompanyDetailsPromise extends BaseEntity {
	
		
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private Integer cdpid;
			private String title;
			private String companyName;
			private String companyIdCard ;
			private String punishId ;
			private String body ;
			private Date time;
			private String username;
			private String type;
			
			public CompanyDetailsPromise(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
				super(createdUser, createdTime, modifiedUser, modifiedTime);
				// TODO Auto-generated constructor stub
			}
			
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public Integer getCdpid() {
				return cdpid;
			}
			public void setCdpid(Integer cdpid) {
				this.cdpid = cdpid;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getCompanyName() {
				return companyName;
			}
			public void setCompanyName(String companyName) {
				this.companyName = companyName;
			}
			public String getCompanyIdCard() {
				return companyIdCard;
			}
			public void setCompanyIdCard(String companyIdCard) {
				this.companyIdCard = companyIdCard;
			}
			public String getPunishId() {
				return punishId;
			}
			public void setPunishId(String punishId) {
				this.punishId = punishId;
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
			public String getUsername() {
				return username;
			}
			public void setUsername(String username) {
				this.username = username;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((cdpid == null) ? 0 : cdpid.hashCode());
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
				CompanyDetailsPromise other = (CompanyDetailsPromise) obj;
				if (cdpid == null) {
					if (other.cdpid != null)
						return false;
				} else if (!cdpid.equals(other.cdpid))
					return false;
				return true;
			}
			@Override
			public String toString() {
				return "CompanyDetailsPromise [cdpid=" + cdpid + ", title=" + title + ", companyName=" + companyName
						+ ", companyIdCard=" + companyIdCard + ", punishId=" + punishId + ", body=" + body + ", time="
						+ time + ", username=" + username + ", type=" + type + ", getCreatedUser()=" + getCreatedUser()
						+ ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()=" + getModifiedUser()
						+ ", getModifiedTime()=" + getModifiedTime() + "]";
			}
		
			

}
