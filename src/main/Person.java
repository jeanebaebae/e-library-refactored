package main;

public abstract class Person {
	protected String id;
	protected String name;
	
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public abstract String getRole();
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
}
