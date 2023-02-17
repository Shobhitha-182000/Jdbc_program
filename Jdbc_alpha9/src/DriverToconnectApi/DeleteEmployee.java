package DriverToconnectApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteEmployee {
public static void main(String[] args) throws Exception {
	String path="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/empd";
	String user="root";
	String password="root";
	String query="delete from employee where id=5 ";
	
	
	Class.forName(path);
	Connection con=DriverManager.getConnection(url,user,password);
	Statement st=con.createStatement();
	 st.execute(query);
	 con.close();
	 System.out.println("deleted");
}
}
