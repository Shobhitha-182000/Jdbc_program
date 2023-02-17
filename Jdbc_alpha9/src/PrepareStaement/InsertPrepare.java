package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertPrepare {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id ");
		int id = scanner.nextInt();
		System.out.println("enter the name");
		String name = scanner.next();
		System.out.println("enter the phone");
		long phone = scanner.nextLong();
		System.out.println("enter the company");
		String company = scanner.next();
		System.out.println("enter the address");
		String address = scanner.next();
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empd";
		String userName = "root";
		String password = "root";
		String query = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?)";
		// Load /register the Driver

		Class.forName(className);

		// establish connection

		Connection connection = DriverManager.getConnection(url, userName, password);

		// create statement

		// PreparedStatement is a interface which inherits Statement interface

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);

		preparedStatement.setString(2, name);

		preparedStatement.setLong(3, phone);

		preparedStatement.setString(4, address);

		preparedStatement.setString(5, company);

		preparedStatement.execute();

		connection.close();

		System.out.println("Inserted");

	}

}
