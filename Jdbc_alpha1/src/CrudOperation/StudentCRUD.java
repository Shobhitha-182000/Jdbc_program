package CrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb");
		return connection;
	}
//insert
	public void insertStudent(int id,String name,double marks,String address,String fatherName) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, marks);
		preparedStatement.setString(4, fatherName);
		preparedStatement.setString(5, fatherName);
		
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
		System.out.println("inserted");
	}
	//update
	public void updateStudent(double marks , int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE STUDENT SET MARKS=? WHERE ID =?");
		preparedStatement.setInt(2, id);
		preparedStatement.setDouble(1,marks);
		
		preparedStatement.execute();
		connection.close();
		System.out.println("updated");
	}
	
	//delete
	public void deleteStudent(int id) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM STUDENT WHERE ID =?");
		preparedStatement.setInt(1, id);
		int count=preparedStatement.executeUpdate();
		if(count==1)
			System.out.println("Deleted");
		else 
			System.out.println("id not found");
		
		preparedStatement.close();
		connection.close();
	}
	//select
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
			System.out.println("===================");
		}
		preparedStatement.close();
		connection.close();
	}
}
