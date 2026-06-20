package main;

public class Admin extends Person {
	
	public Admin(String id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "Admin";
	}

}
