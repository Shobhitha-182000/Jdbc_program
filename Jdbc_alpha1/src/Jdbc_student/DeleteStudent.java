package Jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudent {
public static void main(String[] args) throws Exception {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/studentdb";
	String user="root";
	String password="root";
	String query="delete from student where name='anaa' ";
	
	
	Class.forName(path);
	Connection con=DriverManager.getConnection(url,user,password);
	Statement st=con.createStatement();
	st.execute(query);
	con.close();
	System.out.println("Successfully deleted");
}
}
