package jdbc_maven_eb9;

public class Person {
//class name should be same as table name
	// and attributes also should be same as column name. this all are called as entity or bin folder
	private int id;
	private String name;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
