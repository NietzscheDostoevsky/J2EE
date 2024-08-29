package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCExecuteUpdate {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:postgresql://localhost:5432/qsp";
        String username = "postgres";
        String password = "m";
        
        try {
        	Class.forName("org.postgresql.Driver");
        	System.out.println("Driver class loaded");
        	
        	Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
        	System.out.println("Connection created");
        	
        	Statement stm = conn.createStatement();
        	//int n = stm.executeUpdate("INSERT INTO student VALUES (33, 'xyz'), (44, 'abc')");
        	//int n = stm.executeUpdate("UPDATE student SET NAME='ganesh' WHERE id=33");
        	//int n = stm.executeUpdate("DELETE FROM student WHERE id=33");
        	//System.out.println(n);
        	
        	stm.execute("SELECT * FROM student");
        	ResultSet rs = stm.getResultSet();
        	rs.next();
        	System.out.println(rs.getInt("id"));
        	System.out.println(rs.getString("name"));
        	
        	rs.next();
        	System.out.println(rs.getInt("id"));
        	System.out.println(rs.getString("name"));
        	
        	
        	conn.close();
        	System.out.println("connection is closed");
        	
        	while(rs.next()) {
        		System.out.println(rs.getInt("id"));
            	System.out.println(rs.getString("name"));
        	}
        	
        	
        	
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
	}
}
