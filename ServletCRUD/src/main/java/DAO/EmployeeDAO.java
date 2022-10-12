package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import java.sql.CallableStatement;

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
	
	public static List<Employee> getAllEmployeesCallable(){
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			Connection connection = EmployeeDAO.getConnection();
			
			CallableStatement stmt = connection.prepareCall("{call GetEmployeeDetails}");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setUserName(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setAddress(rs.getString(6));
				emp.setContact(rs.getString(7));
				
				list.add(emp);		
				
			}
			connection.close();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public static Employee getEmployeeById(int id) {
		
		Employee emp = new Employee();		
		try {
			Connection connection = EmployeeDAO.getConnection();
			
			CallableStatement stmt = connection.prepareCall("{call getEmployeeDetailsById(?)}");
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				emp.setId(rs.getInt(1));
				emp.setFirstName(rs.getString(2));
				emp.setLastName(rs.getString(3));
				emp.setUserName(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setAddress(rs.getString(6));
				emp.setContact(rs.getString(7));					
			}
			connection.close();		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return emp;
		
		
	}

}
