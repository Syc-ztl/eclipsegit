package com.sun.chenglixin.entity;

import java.util.Date;

public class DetailsHeadline extends BaseEntity {
			private Integer dhid;
			private Integer pid;
			private String title;
			private String source ;
			private Date issueTime ;
			private Integer reading ;
			private String body;
			public Integer getDhid() {
				return dhid;
			}
			
			public Integer getPid() {
				return pid;
			}

			public void setPid(Integer pid) {
				this.pid = pid;
			}

			public void setDhid(Integer dhid) {
				this.dhid = dhid;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getSource() {
				return source;
			}
			public void setSource(String source) {
				this.source = source;
			}
			
			public Date getIssueTime() {
				return issueTime;
			}

			public void setIssueTime(Date issueTime) {
				this.issueTime = issueTime;
			}

			public Integer getReading() {
				return reading;
			}
			public void setReading(Integer reading) {
				this.reading = reading;
			}
			public String getBody() {
				return body;
			}
			public void setBody(String body) {
				this.body = body;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + ((dhid == null) ? 0 : dhid.hashCode());
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
				DetailsHeadline other = (DetailsHeadline) obj;
				if (dhid == null) {
					if (other.dhid != null)
						return false;
				} else if (!dhid.equals(other.dhid))
					return false;
				return true;
			}

			@Override
			public String toString() {
				return "DetailsHeadline [dhid=" + dhid + ", pid=" + pid + ", title=" + title + ", source=" + source
						+ ", issueTime=" + issueTime + ", reading=" + reading + ", body=" + body + ", getCreatedUser()="
						+ getCreatedUser() + ", getCreatedTime()=" + getCreatedTime() + ", getModifiedUser()="
						+ getModifiedUser() + ", getModifiedTime()=" + getModifiedTime() + "]";
			}

			
			
			
			
}
