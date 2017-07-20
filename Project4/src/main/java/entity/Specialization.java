package entity;

public class Specialization extends Entity {

	private String specializationName;
	
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	
	public Specialization() {
		
	}
	
	public Specialization(String specializationName){
		this.specializationName = specializationName;
	}
	
	public Specialization(Long id, String specializationName){
		this.id = id;
		this.specializationName = specializationName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((specializationName == null) ? 0 : specializationName.hashCode());
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
		Specialization other = (Specialization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (specializationName == null) {
			if (other.specializationName != null)
				return false;
		} else if (!specializationName.equals(other.specializationName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Specialization [id=" + id + ", specializationName=" + specializationName + "]";
	}
}
