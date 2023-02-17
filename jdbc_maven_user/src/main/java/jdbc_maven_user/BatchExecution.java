package jdbc_maven_user;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class BatchExecution {
	public static void main(String[] args) throws Exception {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("dbconfigure.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		
		User user=new User();
		user.setId(6);
		user.setUsername("Radya");
		user.setEmailid("r@gmail.com");
		user.setPassword("123");
		user.setContact(9278375);
		
		User user1=new User();
		user1.setId(7);
		user1.setUsername("Aadya");
		user1.setEmailid("A@gmail.com");
		user1.setPassword("823");
		user1.setContact(87278375);
		
		User user2=new User();
		user2.setId(10);
		user2.setUsername("Dhanya");
		user2.setEmailid("d@gmail.com");
		user2.setPassword("83475");
		user2.setContact(73428278375l);
		
		List<User> list=new ArrayList<User>();
		list.add(user);
		list.add(user1);
		list.add(user2);
		
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user values(?,?,?,?,?)");
		for(User u:list) {
			preparedStatement.setInt(1, u.getId());
			preparedStatement.setString(2, u.getUsername());
			preparedStatement.setString(3, u.getEmailid());
			preparedStatement.setString(4, u.getPassword());
			preparedStatement.setLong(5, u.getContact());
			//all items are store in 1 batch i.e
			
			preparedStatement.addBatch();
			System.out.println("added batch is "+u.getUsername());
			
		}
		preparedStatement.executeBatch();
		System.out.println("saved to database");
		
		
		connection.close();
		

	}
}
