package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeletePrepare {
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id to be deleted");
		int id=sc.nextInt();
		 
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String password="root";
		String querry=" DELETE FROM STUDENT WHERE ID=?";
		
		Class.forName(className);
		
		Connection connection =DriverManager.getConnection(url, user, password);
		
		PreparedStatement prepare=connection.prepareStatement( querry);
		prepare.setInt(1, id);
		 
		 
		
		prepare.execute();
		System.out.println("deleted");
	}
}
