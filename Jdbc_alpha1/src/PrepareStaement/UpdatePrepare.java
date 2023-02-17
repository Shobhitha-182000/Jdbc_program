package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatePrepare {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the id to be updated");
	int id=sc.nextInt();
	System.out.println("enter the name to be updated");
	String name=sc.next();
	 
	
	String className="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/studentdb";
	String user="root";
	String password="root";
	String querry=" UPDATE STUDENT SET NAME=? WHERE ID=?";
	
	Class.forName(className);
	
	Connection connection =DriverManager.getConnection(url, user, password);
	
	PreparedStatement prepare=connection.prepareStatement( querry);
	prepare.setString(1, name);
	prepare.setInt(2, id);
	 
	
	prepare.execute();
	System.out.println("UPDETED");
}
}
