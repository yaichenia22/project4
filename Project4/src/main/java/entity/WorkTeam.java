package entity;

public class WorkTeam extends Entity {

	private Long leadId;
	private String name;
	
	public WorkTeam() {
	
	}

	public WorkTeam(Long leadId, String name) {
		
		this.leadId = leadId;
		this.name = name;
	}
	
	public WorkTeam(Long id, Long leadId, String name) {
		
		this.id = id;
		this.leadId = leadId;
		this.name = name;
	}
	
	public Long getLeadId() {
		return leadId;
	}
	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((leadId == null) ? 0 : leadId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		WorkTeam other = (WorkTeam) obj;
		if (leadId == null) {
			if (other.leadId != null)
				return false;
		} else if (!leadId.equals(other.leadId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "WorkTeam [leadId=" + leadId + ", name=" + name + ", id=" + id + "]";
	}
}
