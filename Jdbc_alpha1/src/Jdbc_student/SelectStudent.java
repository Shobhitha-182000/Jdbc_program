package Jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectStudent {
public static void main(String[] args) throws Exception {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/studentdb";
	String user="root";
	String password="root";
	String query="select * from student ";
	
	
	Class.forName(path);
	Connection con=DriverManager.getConnection(url,user,password);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getLong(3));
	}
	con.close();
	//
	System.out.println("Successfully deleted");

}
}
