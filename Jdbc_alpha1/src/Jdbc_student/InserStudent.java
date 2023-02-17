package Jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InserStudent {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/Studentdb";
		String user="root";
		String passward="root";
		String query="insert into Student values(5,'Anaa',90,'manglore','Prasanna Kumar')";
		
		Class.forName(path);
		Connection conn=DriverManager.getConnection(url,user,passward);
		Statement st=conn.createStatement();
		st.execute(query);
		conn.close();
		System.out.println("inserted");
	}
}
