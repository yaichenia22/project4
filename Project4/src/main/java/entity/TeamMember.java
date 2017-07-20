package entity;

public class TeamMember extends Entity{
	
	private Long teamId;
	private Long employeeId;
	
	public TeamMember() {
	
	}
	
	public TeamMember(Long teamId, Long employeeId) {
		
		this.teamId = teamId;
		this.employeeId = employeeId;
	}
	
	public TeamMember(Long id, Long teamId, Long employeeId) {
		
		this.id = id;
		this.teamId = teamId;
		this.employeeId = employeeId;
	}
	
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
		TeamMember other = (TeamMember) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (teamId == null) {
			if (other.teamId != null)
				return false;
		} else if (!teamId.equals(other.teamId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeamMember [teamId=" + teamId + ", employeeId=" + employeeId + ", id=" + id + "]";
	}
}
