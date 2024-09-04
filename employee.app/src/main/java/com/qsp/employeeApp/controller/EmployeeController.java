package com.qsp.employeeApp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.employeeApp.model.Employee;

public class EmployeeController {
	// contains all the methods for Database. 
	
	static Connection conn; 
	static {
		//
		try {
			String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
	        String username = "postgres";
	        String password = "m";
	        
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addEmployee(Employee emp) throws SQLException {
		// Insert employee data into the database. 
		//3rd
		PreparedStatement ps = conn.prepareStatement("INSERT INTO employee VALUES(?,?,?)");
		ps.setInt(1, emp.getId());
		ps.setString(2, emp.getName());
		ps.setLong(3, emp.getPhone());
		ps.setDouble(4, emp.getSal());
		
		//4th
		ps.execute();
	}
	
//	public Employee getEmployeeById(int id) {
//		Employee emp = new Employee();
//		
//		//3rd 
//		PreparedStatement ps = conn.prepareStatement("SELECT * FROM employee WHERE id=?");
//		ps.setInt(1, id);
//		ResultSet rs = ps.executeQuery();
//		while (rs.next()) {
//			emp.setId(rs.getInt(id));
//			emp.setName(rs.getString(id));
//		}
//			
//		
//	}
	
	public boolean deleteEmployeeById(int id) {
		Employee emp = getEmployeeById(id);
		if (emp.getId() != 0) {
			PreparedStatement ps;
			try {
				//3rd 
				ps = conn.prepareStatement("delete from employee where id = ?");
				ps.setInt(1, id);
				
				//4th 
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false; 
	}
	
	public boolean updateEmployeeSal(int id, double newSal) {
		Employee emp = getEmployeeById(id);
		if (emp.getId() != 0) {
			try {
				//3rd 
				PreparedStatement ps = conn.prepareStatement("update employee set sal = ? where id = ?");
				ps.setInt(2, id);
				ps.setDouble(1, newSal);
				
				//4th 
				ps.execute();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public List<Employee> getAll() {
		List<Employee> list = new ArrayList<>(); 
		try {
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(); 
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPhone(rs.getLong("phone"));
				emp.setSal(rs.getDouble("sal"));
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list; 
		
	}
	
	
}
