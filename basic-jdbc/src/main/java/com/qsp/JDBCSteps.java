package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSteps {

	public static void main(String[] args) throws ClassNotFoundException {
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver class is loaded");
			
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection created");
			
			Statement stm = conn.createStatement(); 
			System.out.println("statement is created");
			stm.execute("DELETE FROM student WHERE id=101");
			stm.execute("INSERT INTO student VALUES (101, 'anuradha')");
			System.out.println("data inserted");
			
			conn.close();
			System.out.println("Connection close");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}

