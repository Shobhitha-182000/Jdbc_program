package jdbc_maven_user;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;
 
public class UserCRUD {
	public Connection getConnection() throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		FileInputStream fileinputstream = new FileInputStream("dbconfigure.properties");
		Properties properties = new Properties();
		properties.load(fileinputstream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));

		return connection;
	}

	//signin
	public void signInUser(User user) throws Exception {
		String query = "INSERT INTO USER VALUES(?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getUsername());
		preparedStatement.setString(4, user.getPassword());
		preparedStatement.setString(3, user.getEmailid());
		preparedStatement.setLong(5, user.getContact());

		int res = preparedStatement.executeUpdate();
		if (res == 1) {
			System.out.println("sign in Successfully");

		}else
			System.out.println("something went wrong");

		connection.close();
	}

	//login
	public boolean login(User user) throws Exception {
		String query="select * from user where username=?";
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUsername());
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		while(resultSet.next()) {
			password=resultSet.getString("password");
		}
		if(user.getPassword().equals(password)) {
			 return true;
		}
		else 
			return false;
	}
	
	
	public void updateUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET USERNAME=? WHERE ID=?");
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getEmailid());

		preparedStatement.execute();
		connection.close();
	}

	public void deleteUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM USER WHERE ID=?");
		preparedStatement.setString(1, user.getUsername());

		preparedStatement.execute();
		connection.close();
	}

	public void getUser() throws Exception {
		Connection connection = getConnection();

		PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println(resultSet.getString(4));
			System.out.println(resultSet.getLong(5));
			System.out.println("============================");
		}
		preparedStatement.close();
		connection.close();
	}

}
