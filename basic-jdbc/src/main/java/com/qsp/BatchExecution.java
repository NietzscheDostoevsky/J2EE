package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BatchExecution {
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			Statement stm = conn.createStatement();
			stm.addBatch("INSERT INTO student VALUES(1, 'xyz')");
			stm.addBatch("INSERT INTO student VALUES(2, 'abc')");
			stm.addBatch("UPDATE student SET name='haha123' WHERE id=1");
			stm.addBatch("DELETE FROM student WHERE id = 2");
			
			stm.executeBatch();
			
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
