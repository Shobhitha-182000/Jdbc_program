package Jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {
public static void main(String[] args) throws Exception {
	//load or register
	Class.forName("com.mysql.cj.jdbc.Driver");
	//establish connection
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
	//create the statement "jdbc:mysql://localhost:3306/persondb"
	Statement st=con.createStatement();
	//execute the statementt
	st.execute("insert into student values(2,'Arjunaa',90,'Banglore','R"
			+ "aju'),(3,'Anaa',90,'manglore','Prasanna Kumar')");
	//close
	con.close();
	System.out.println("inserted");
}
}
