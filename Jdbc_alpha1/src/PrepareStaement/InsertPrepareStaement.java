package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPrepareStaement {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the id");
	int id=sc.nextInt();
	System.out.println("enter the name");
	String name=sc.next();
	System.out.println("enter the MARKS");
	int marks=sc.nextInt();
	System.out.println("enter the address");
	String address=sc.next();
	System.out.println("enter the father name");
	String fname=sc.next();
	
	String className="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/studentdb";
	String user="root";
	String password="root";
	String querry="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
	
	Class.forName(className);
	
	Connection connection =DriverManager.getConnection(url, user, password);
	
	PreparedStatement prepare=connection.prepareStatement( querry);
	prepare.setInt(1, id);
	prepare.setString(2, name);
	prepare.setInt(3, marks);
	prepare.setString(4, address);
	prepare.setString(5, fname);
	
	prepare.execute();
	System.out.println("inserted");
}
}
