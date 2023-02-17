package DriverToconnectApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertEMployee {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String path="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/empd";
		String user="root";
		String passward="root";
		String query="insert into employee values(112,'Anaa',90901983970,'manglore','Prasanna Kumar')";
		
		Class.forName(path);
		Connection conn=DriverManager.getConnection(url,user,passward);
		Statement st=conn.createStatement();
		st.execute(query);
		conn.close();
		System.out.println("inserted");
	}
}
