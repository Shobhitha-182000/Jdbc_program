package jdbc_maven_user;

public class User {
	private int id;
	private String username;
	private String emailid;
	private String password;
	private long contact;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	 
}
