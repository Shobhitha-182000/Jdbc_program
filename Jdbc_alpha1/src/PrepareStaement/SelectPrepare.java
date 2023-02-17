package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectPrepare {
 
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id to be updated");
		int id=sc.nextInt();
		 
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String user="root";
		String password="root";
		String querry=" SELECT * FROM STUDENT WHERE ID=?";
		
		Class.forName(className);
		
		Connection connection =DriverManager.getConnection(url, user, password);
		
		PreparedStatement prepare=connection.prepareStatement( querry);
		prepare.setInt(1, id);
		ResultSet res=prepare.executeQuery();
		while(res.next()) {
			System.out.println(res.getInt(1));
			System.out.println(res.getString(2));
			System.out.println(res.getInt(3));
			System.out.println(res.getString(4));
			System.out.println(res.getString(5));
		}
		
		 
		connection.close();
		 
		System.out.println("Selected");
	}

}
