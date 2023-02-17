package jdbc_maven_user;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		User user=new User();
		UserCRUD crud=new UserCRUD(); 
		
		System.out.println("enter the id");
		int id=scanner.nextInt();
		
		System.out.println("enter the username");
		String username=scanner.next();
		
		System.out.println("enter the email id");
		String emailid=scanner.next();
		
		System.out.println("enter the password");
		String password=scanner.next();
		
		System.out.println("enter the phone number");
		long contact=scanner.nextLong();
		
		user.setId(id);
		user.setUsername(username);
		user.setEmailid(emailid);
		user.setPassword(password);
		user.setContact(contact);
		crud.signInUser(user);
		
		/*boolean result=crud.login(user);
		if(result==true) {
			System.out.println("login succcesfully");
		}
		else
			System.out.println("incorrect user and password");*/
		
		
	}
}
