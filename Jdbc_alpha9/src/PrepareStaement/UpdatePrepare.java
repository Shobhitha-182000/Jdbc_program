package PrepareStaement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdatePrepare {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the id need to be Updated");
		int id = scanner.nextInt();
		System.out.println("Enter the address ");
		String address = scanner.next();
		String className = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/empd";
		String userName = "root";
		String password = "root";
		String query = "UPDATE EMPLOYEE SET address=? WHERE ID=?";

		Class.forName(className);

		Connection connection = DriverManager.getConnection(url, userName, password);

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, address);

		preparedStatement.setInt(2, id);

		preparedStatement.execute();

		connection.close();

		System.out.println("Updated");

	}
}
