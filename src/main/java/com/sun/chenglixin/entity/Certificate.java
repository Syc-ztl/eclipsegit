package com.sun.chenglixin.entity;

import java.util.Date;
/**
 * 修复证明书实体类
 * @author lenveo
 *
 */
public class Certificate extends BaseEntity{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private Integer cid;
		private String companyName;
		private String type;
		private String promiseId;
		private Integer isSuccess;
		private Date successTime;
		
		
		
		public Certificate() {
			super();
		}
		public Integer getCid() {
			return cid;
		}
		public void setCid(Integer cid) {
			this.cid = cid;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getPromiseId() {
			return promiseId;
		}
		public void setPromiseId(String promiseId) {
			this.promiseId = promiseId;
		}
		public Integer getIsSuccess() {
			return isSuccess;
		}
		public void setIsSuccess(Integer isSuccess) {
			this.isSuccess = isSuccess;
		}
		public Date getSuccessTime() {
			return successTime;
		}
		public void setSuccessTime(Date successTime) {
			this.successTime = successTime;
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
			Certificate other = (Certificate) obj;
			if (cid == null) {
				if (other.cid != null)
					return false;
			} else if (!cid.equals(other.cid))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Certificate [cid=" + cid + ", companyName=" + companyName + ", type=" + type + ", promiseId="
					+ promiseId + ", isSuccess=" + isSuccess + ", successTime=" + successTime + ", getCreatedUser()="
					+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
					+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
		}
		
}
