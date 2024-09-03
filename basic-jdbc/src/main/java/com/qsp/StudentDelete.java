package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDelete {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver class is loaded");
			
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection created");
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE id=?");
			System.out.print("Enter id: ");
			ps.setInt(1, sc.nextInt());
			
			ps.execute();
			System.out.println("Deleted");
			
			conn.close();
			System.out.println("Connection close");
			sc.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
