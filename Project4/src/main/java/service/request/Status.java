package service.request;

public enum Status {

	UNCONSIDERED("Unconsidered"),
	IN_PROCESS("In process"),
	DONE("Done");
	
	private String name;
	
	Status(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
