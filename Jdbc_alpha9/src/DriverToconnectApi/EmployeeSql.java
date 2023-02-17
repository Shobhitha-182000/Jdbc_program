package DriverToconnectApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EmployeeSql {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish Connectionn
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/empd","root","root");
	//create st
	Statement s=c.createStatement();
	//execute
	s.execute("insert into employee values (113,'Harish',826279298,'Banglore','Ty')");
	 c.close();
	System.out.println("insereted");
}
}
