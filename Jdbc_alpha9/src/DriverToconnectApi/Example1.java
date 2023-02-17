package DriverToconnectApi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Example1 {
public static void main(String[] args) throws Exception {
	//THERE ARE 5 METHODS TO COMMUNICATE WITH JAVA PROGRAM LANGAUGE TO DATABASE
	/*
	 * we can't communicate directly between the JAVA PROGRAM LANGAUGE TO DATABASE.
	 * jdbc is a like translator it makes the connection between 2 programming language.
	 * --->directly we can't translate so it contatais "DRIVER".
	 * ---->driver follows 5 Steps to communicate
	 * 
	 */
	
	//1.load or register Driver
	/*
	 * Class.forName("com.mysql.cj.jdbc.Driver")------->here Class is a class in that forName methods is there.
	 * in that we have to pass the path
	 * jdbc contains driver. it is used to Specify which database is to be take and perform the some action
	 * ex:com.mysql.cj.jdbc.Driver
	 * forName-----> it is a Static method present in Class class. 
	 * -->when we execute this checked exception is ocured so   we have to handle exception or make it class as throws
	 */
	Class.forName("com.mysql.cj.jdbc.Driver");
	 
	//2.establish connection
	/*
	 *Connection  --------> Connection is a interface. so we can't create object so we go to the helpermethod.
	 * connection----------> ref of Connection interface.
	 * DriverManager-------> it is a helper class
	 * getConnection()------>it is a method present in the DriverManager class.Sql path is passed s args.
	 *  "jdbc:mysql://localhost:3306/persondb"
	 *  jdbc--->Api
	 *  mySql---->database
	 *  localhost:3306---->port no
	 * persondb----->Sql Database (folder) name.
	 * 
	 */
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
	
	
	//3.Create Statement
	/*
	 * Statement----> Statement is a interface. so we can't create object so we go to the helpermethod
	 * statement--------> ref of statement interface.
	 * createStatement()-----it is a method present in Connection interface
	 */
	Statement statement=connection.createStatement();
	
	
	//4.execute Statement
	statement.execute("INSERT INTO PERSON VALUES (1,'ABC',8296279297)");
	
	//5.CLOSE()
	connection.close();
	System.out.println("inserted");
}
}
