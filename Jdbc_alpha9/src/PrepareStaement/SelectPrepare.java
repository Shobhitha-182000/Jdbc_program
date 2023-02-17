package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectPrepare {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id to be printed");
		int id = scanner.nextInt();
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empd";
		String userName = "root";
		String password = "root";
		String query = "SELECT * FROM EMPLOYEE WHERE ID=?";

		// load/register driver
		Class.forName(className);
		// establish connection

		Connection connection = DriverManager.getConnection(url, userName, password);

		// create statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		// execute query
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next())

		{
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getString(5));
			System.out.println("=================");
		}

		// close connection

		connection.close();

	}

}
