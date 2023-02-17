package jdbc_maven_eb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
		return connection;
	}
	
	//insert
	public void saveStudent (Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
		
		 preparedStatement.setInt(1,student.getId());
		 preparedStatement.setString(2,student.getName());
		 preparedStatement.setDouble(3, student.getMarks());
		 preparedStatement.setString(4, student.getAddress());
		 preparedStatement.setString(5, student.getFather_name());
		 
		 preparedStatement.execute();
		 connection.close();
		 System.out.println("inserted");
	}
	
	public void updateStudent(Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE STUDENT SET NAME=? WHERE ID=?");
		preparedStatement.setInt(2,student.getId());
		preparedStatement.setString(1,student.getName());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("updated");
	}
	
	public void deleteStudent(Student student) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
		preparedStatement.setInt(1,student.getId());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("deleted");
	}
	
	public void selectStudent() throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getDouble(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("==================");
		}
	}
}
