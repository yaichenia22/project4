package entity;

public class Tenant extends Entity {

	private Long addressId;
	private String fullName;
	private String login;
	private String password;
	
	public Tenant() {
	
	}
	
	public Tenant(Long addressId, String fullName, String login, String password) {
		
		this.addressId = addressId;
		this.fullName = fullName;
		this.login = login;
		this.password = password;
	}
	
	public Tenant(Long id, Long addressId, String fullName, String login, String password) {
		
		this.id = id;
		this.addressId = addressId;
		this.fullName = fullName;
		this.login = login;
		this.password = password;
	}
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Tenant other = (Tenant) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tenant [addressId=" + addressId + ", fullName=" + fullName + ", login=" + login + ", password="
				+ password + ", id=" + id + "]";
	}
}
