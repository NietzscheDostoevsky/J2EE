package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetStudentData {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM student");
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println("---------");
			}
			conn.close();
			sc.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
