package entity;

import java.sql.Timestamp;

public class Request extends Entity {

	private Long tenantId;
	private Long kindOfWorkId;
	private String scopeOfWork;
	private Timestamp desiredExecutionDate;
	private Timestamp applicationDate;
	private String comment;
	
	public Request() {
	
	}
	
	public Request(Long tenantId, Long kindOfWorkId, String scopeOfWork,
			Timestamp desiredExecutionDate, Timestamp applicationDate, String comment) {
		
		this.tenantId = tenantId;
		this.kindOfWorkId = kindOfWorkId;
		this.scopeOfWork = scopeOfWork;
		this.desiredExecutionDate = desiredExecutionDate;
		this.applicationDate = applicationDate;
		this.comment = comment;
	}
	
	public Request(Long id, Long tenantId, Long kindOfWorkId, String scopeOfWork,
			Timestamp desiredExecutionDate, Timestamp applicationDate, String comment) {
		
		this.id = id;
		this.tenantId = tenantId;
		this.kindOfWorkId = kindOfWorkId;
		this.scopeOfWork = scopeOfWork;
		this.desiredExecutionDate = desiredExecutionDate;
		this.applicationDate = applicationDate;
		this.comment = comment;
	}
	
	public Long getTenantId() {
		return tenantId;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public Long getKindOfWorkId() {
		return kindOfWorkId;
	}
	public void setKindOfWorkId(Long kindOfWorkId) {
		this.kindOfWorkId = kindOfWorkId;
	}
	public String getScopeOfWork() {
		return scopeOfWork;
	}
	public void setScopeOfWork(String scopeOfWork) {
		this.scopeOfWork = scopeOfWork;
	}
	public Timestamp getDesiredExecutionDate() {
		return desiredExecutionDate;
	}
	public void setDesiredExecutionDate(Timestamp desiredExecutionDate) {
		this.desiredExecutionDate = desiredExecutionDate;
	}
	public Timestamp getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Timestamp applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((applicationDate == null) ? 0 : applicationDate.hashCode());
		result = prime * result + ((desiredExecutionDate == null) ? 0 : desiredExecutionDate.hashCode());
		result = prime * result + ((kindOfWorkId == null) ? 0 : kindOfWorkId.hashCode());
		result = prime * result + ((scopeOfWork == null) ? 0 : scopeOfWork.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (applicationDate == null) {
			if (other.applicationDate != null)
				return false;
		} else if (!applicationDate.equals(other.applicationDate))
			return false;
		if (desiredExecutionDate == null) {
			if (other.desiredExecutionDate != null)
				return false;
		} else if (!desiredExecutionDate.equals(other.desiredExecutionDate))
			return false;
		if (kindOfWorkId == null) {
			if (other.kindOfWorkId != null)
				return false;
		} else if (!kindOfWorkId.equals(other.kindOfWorkId))
			return false;
		if (scopeOfWork == null) {
			if (other.scopeOfWork != null)
				return false;
		} else if (!scopeOfWork.equals(other.scopeOfWork))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Request [tenantId=" + tenantId + ", kindOfWorkId=" + kindOfWorkId + ", scopeOfWork=" + scopeOfWork
				+ ", desiredExecutionDate=" + desiredExecutionDate + ", applicationDate=" + applicationDate
				+ ", Comment=" + comment + ", id=" + id + "]";
	}
}
