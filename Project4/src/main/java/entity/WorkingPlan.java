package entity;

import java.sql.Timestamp;

public class WorkingPlan extends Entity {

	private Long workTeamId;
	private Long dispatcherId;
	private Long requestId;
	private String comment;
	private Timestamp estimatedExecutionDate;
	private Timestamp estimatedStartDate;
	
	public WorkingPlan(){
		
	}
	
	public WorkingPlan(Long workTeamId, Long dispatcherId, Long requestId,
			Timestamp estimatedExecutionDate, Timestamp estimatedStartDate, String comment) {
		
		this.workTeamId = workTeamId;
		this.dispatcherId = dispatcherId;
		this.requestId = requestId;
		this.comment = comment;
		this.estimatedExecutionDate = estimatedExecutionDate;
		this.estimatedStartDate = estimatedStartDate;
	}
	
	public WorkingPlan(Long id, Long requestId, Long dispatcherId, Long workTeamId,
			Timestamp estimatedExecutionDate, Timestamp estimatedStartDate, String comment) {
		
		this.id = id;
		this.workTeamId = workTeamId;
		this.dispatcherId = dispatcherId;
		this.requestId = requestId;
		this.comment = comment;
		this.estimatedExecutionDate = estimatedExecutionDate;
		this.estimatedStartDate = estimatedStartDate;
	}
	
	public Long getWorkTeamId() {
		return workTeamId;
	}
	public void setWorkTeamId(Long workTeamId) {
		this.workTeamId = workTeamId;
	}
	public Long getDispatcherId() {
		return dispatcherId;
	}
	public void setDispatcherId(Long dispatcherId) {
		this.dispatcherId = dispatcherId;
	}
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getEstimatedExecutionDate() {
		return estimatedExecutionDate;
	}
	public void setEstimatedExecutionDate(Timestamp estimatedExecutionDate) {
		this.estimatedExecutionDate = estimatedExecutionDate;
	}
	public Timestamp getEstimatedStartDate() {
		return estimatedStartDate;
	}
	public void setEstimatedStartDate(Timestamp estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((dispatcherId == null) ? 0 : dispatcherId.hashCode());
		result = prime * result + ((estimatedExecutionDate == null) ? 0 : estimatedExecutionDate.hashCode());
		result = prime * result + ((estimatedStartDate == null) ? 0 : estimatedStartDate.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((workTeamId == null) ? 0 : workTeamId.hashCode());
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
		WorkingPlan other = (WorkingPlan) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (dispatcherId == null) {
			if (other.dispatcherId != null)
				return false;
		} else if (!dispatcherId.equals(other.dispatcherId))
			return false;
		if (estimatedExecutionDate == null) {
			if (other.estimatedExecutionDate != null)
				return false;
		} else if (!estimatedExecutionDate.equals(other.estimatedExecutionDate))
			return false;
		if (estimatedStartDate == null) {
			if (other.estimatedStartDate != null)
				return false;
		} else if (!estimatedStartDate.equals(other.estimatedStartDate))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (workTeamId == null) {
			if (other.workTeamId != null)
				return false;
		} else if (!workTeamId.equals(other.workTeamId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "WorkingPlan [workTeamId=" + workTeamId + ", dispatcherId=" + dispatcherId + ", requestId=" + requestId
				+ ", comment=" + comment + ", estimatedExecutionDate=" + estimatedExecutionDate
				+ ", estimatedStartDate=" + estimatedStartDate + ", id=" + id + "]";
	}
}
