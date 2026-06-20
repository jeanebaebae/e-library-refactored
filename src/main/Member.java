package main;

public class Member extends Person {
	private String id;
	private String name;
	
	public Member(String id, String name) {
		super(id, name);
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getRole() {
		return "Member";
	}
	
}
