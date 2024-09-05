package com.qsp.employee_app.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qsp.employee_app.model.Employee;

public class EmployeeController {

	static Connection con;

	static {
		try {
			// 1st
			Class.forName("org.postgresql.Driver");
			// 2nd
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/qsp", "postgres", "root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addEmployee(Employee emp) {
		try {
			// 3rd
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setLong(3, emp.getPhone());
			ps.setDouble(4, emp.getSal());
			// 4th
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Employee getEmployeeById(int id) {
		Employee emp = new Employee();
		try {
			// 3rd
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			// 4th
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPhone(rs.getLong("phone"));
				emp.setSal(rs.getDouble("sal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	public boolean deleteEmployeeById(int id) {
		Employee emp = getEmployeeById(id);
		if (emp.getId() != 0) {

			PreparedStatement ps;
			try {
				// 3rd
				ps = con.prepareStatement("delete from employee where id=?");
				ps.setInt(1, id);
				// 4th
				ps.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updateEmployeeSal(int id, double newSal) {
		Employee emp = getEmployeeById(id);
		if (emp.getId() != 0) {
			try {
				// 3rd
				PreparedStatement ps = con.prepareStatement("update employee set sal=? where id=?");
				ps.setInt(2, id);
				ps.setDouble(1, newSal);
				// 4th
				ps.execute();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<Employee> getAll(){
		List<Employee> list=new ArrayList();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
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
	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
