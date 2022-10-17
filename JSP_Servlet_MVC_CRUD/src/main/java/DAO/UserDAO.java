package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDAO {

	public static Connection getConnection() {

		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registering DB driver
			con = DriverManager.getConnection("jdbc:mysql://localhost/simplilearn","root","root");

		}
		catch(Exception e) {
			System.out.println(e);
		}

		return con;		

	}

	public static int insertUser(User user) {
		String INSERT_USER_SQL = "INSERT INTO users (name, email, country) values(?,?,?)";


		int result = 0;
		try(Connection connection = UserDAO.getConnection();
				PreparedStatement stmt = connection.prepareStatement(INSERT_USER_SQL)) {		
			//create a Statement using connection object


			stmt.setString(1,user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getCountry());

			//Execute the query

			result = stmt.executeUpdate();		
			//connection.close();			
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return result;

	}
	
	public static List<User> selectAllUsers(){
		
		String SELECT_USER_SQL = "select * from users";
		
		List<User> users = new ArrayList<User>();
		
		try(Connection connection = UserDAO.getConnection();
		PreparedStatement stmt = connection.prepareStatement(SELECT_USER_SQL)){
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString("email"));
				user.setCountry(rs.getString("country"));				
				users.add(user);			
				
			}			
		}
		catch(SQLException e) {			
		}
		
		return users;
	}


}
