package jdbc_maven_eb9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/persondb", "root", "root");
		return connection;
	}
	
	//insert
	public void savePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
		
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	//update
	public void updatePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PERSON SET NAME=? WHERE ID=?");
		
		preparedStatement.setInt(2,person.getId());
		preparedStatement.setString(1, person.getName());
		
		preparedStatement.execute();
		System.out.println("updated");
		connection.close();
		
	}
	//delete
	public void deletePerson(Person person) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		
		preparedStatement.setInt(1,person.getId());
		preparedStatement.execute();
		connection.close();
		System.out.println("deleted");
	}
	
	//select
	public void selectPerson() throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println( resultSet.getInt(1));
			System.out.println(resultSet.getString(2) );
			System.out.println((resultSet.getLong(3)));
			System.out.println("=========================");
			
		}
		connection.close();
	}
}
