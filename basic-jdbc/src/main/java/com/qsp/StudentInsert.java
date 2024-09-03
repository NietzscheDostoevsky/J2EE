package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInsert {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO student VALUES(?,?)");
			System.out.print("Enter id: ");
			ps.setInt(1, sc.nextInt());
			System.out.println("Enter name: ");
			ps.setString(2, sc.next());
			
			System.out.println("Inserted");
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
