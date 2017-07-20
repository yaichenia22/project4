package entity;

public class Lead  extends Entity {

	private Long specializationId;
	private String fullName;
	private String phoneNumber;
	
	public Lead() {
		
	}
	
	public Lead(Long specializationId, String fullName, String phoneNumber) {
		this.specializationId = specializationId;
		this.fullName = fullName;
		this.phoneNumber = fullName;
	}
	
	public Lead(Long id, Long specializationId, String fullName, String phoneNumber) {
		this.id = id;
		this.specializationId = specializationId;
		this.fullName = fullName;
		this.phoneNumber = fullName;
	}
	
	public Long getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(Long specializationId) {
		this.specializationId = specializationId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((specializationId == null) ? 0 : specializationId.hashCode());
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
		Lead other = (Lead) obj;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (specializationId == null) {
			if (other.specializationId != null)
				return false;
		} else if (!specializationId.equals(other.specializationId))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Lead [specializationId=" + specializationId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
				+ ", id=" + id + "]";
	}
}
