package jdbc_maven_eb9;

import java.util.Scanner;

public class PersonDriver {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Person person=new Person();
		PersonCRUD personCrud=new PersonCRUD();
		System.out.println("enter the id");
		int id=scanner.nextInt();
		//System.out.println("enter the name");
		//String name=scanner.next();
		/*System.out.println("enter the number");
		long phone =scanner.nextLong();
		person.setId(id);
		person.setName(name)
		person.setPhone(phone);
		 
		try {
			personCrud.savePerson(person);
		} catch (Exception e) {
			 System.out.println("error");
		}*/
		person.setId(id);
		//person.setName(name);
		try {
			personCrud.selectPerson();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}
	}
}
