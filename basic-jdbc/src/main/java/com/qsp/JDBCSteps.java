package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSteps {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver class is loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection created");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}

