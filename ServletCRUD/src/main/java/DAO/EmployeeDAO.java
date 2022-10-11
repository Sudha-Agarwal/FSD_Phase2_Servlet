package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import bean.Employee;

public class EmployeeDAO {
	
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
	
	public static int registerEmployee(Employee employee) {
		
		String INSERT_EMP_SQL = "INSERT INTO employee (first_name,last_name,username,password,address,contact) values(?,?,?,?,?,?)";
		
		int result = 0;
		try {
			Connection connection = EmployeeDAO.getConnection();
			//create a Statement using connection object
			
			PreparedStatement stmt = connection.prepareStatement(INSERT_EMP_SQL);
			stmt.setString(1,employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setString(3, employee.getUserName());
			stmt.setString(4, employee.getPassword());
			stmt.setString(5, employee.getAddress());
			stmt.setString(6, employee.getContact());
			
			//Execute the query
			
			result = stmt.executeUpdate();		
			connection.close();			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
		
	}

}
