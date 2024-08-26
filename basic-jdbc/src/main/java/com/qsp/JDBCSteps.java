package com.qsp;

public class JDBCSteps {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("driver class is loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
