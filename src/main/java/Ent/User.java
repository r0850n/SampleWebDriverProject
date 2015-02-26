package Ent;

import java.util.ArrayList;
import java.util.List;

public class User {
	String email;
	String password;
	String firstName;
	String LastName;
	String localization;

	List<User> users = new ArrayList<User>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLocalization() {
		return localization;
	}

	public User(String email, String password, String firstName,
			String lastName, String localization) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		LastName = lastName;
		this.localization = localization;
	
		
	}

	public User() {
		User p= new User("robert+15@gociety.com", "tajne123", "ccc", "ddd", "katowice");
		/*User p1= new User("083rt.goldyn"+48+"@gmail.com", "bbb12345", "jan", "dupa", "katowice");
		User p2= new User("083rt.goldyn"+49+"@gmail.com", "bbb12345", "jan3", "dupa", "katowice");
		User p3= new User("083rt.goldyn"+50+"@gmail.com", "bbb12345", "jan4", "dupa", "katowice");
		User p4= new User("083rt.goldyn"+51+"@gmail.com", "bbb12345", "jan5", "dupa", "katowice");
		User p5= new User("083rt.goldyn"+52+"@gmail.com", "bbb12345", "jan6", "Niezbdny", "katowice");
		User p6= new User("083rt.goldyn"+53+"@gmail.com", "bbb12345", "jan7", "dupa", "katowice");*/
		
		users.add(p);
		/*users.add(p1);
		users.add(p2);
		users.add(p3);
		users.add(p4);
		users.add(p5);
		users.add(p6);*/
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> persons) {
		this.users = persons;
	}

	
}
