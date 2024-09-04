package com.qsp.employeeApp.view;

import java.util.Scanner;

import com.qsp.employeeApp.controller.EmployeeController;
import com.qsp.employeeApp.model.Employee;

public class EmployeeView {

	public static void main(String[] args) {
		
		do {
			System.out.println("1> Add Employee");
			System.out.println("2> delete employee by id");
			System.out.println("3> find employee by id");
			System.out.println("4> update employee sal by id");
			System.out.println("5> find all employee");
			Scanner sc = new Scanner(System.in);
			
			switch (sc.nextInt()) {
			case 1 : {
				Employee emp = new Employee(); 
				System.out.println("Enter id");
				emp.setId(sc.nextInt());
				System.out.println("Enter name");
				emp.setName(sc.next());
				System.out.println("Enter phone");
				emp.setPhone(sc.nextLong());
				System.out.println("Enter sal");
				emp.setSal(sc.nextDouble());
				
				Controller.addEmployee(emp);
			} break; 
			
			case 2: {
				System.out.println("Enter id: ");
				in
			} break; 
			
			case 3: {
				System.out.println("Enter id");
			}
			
			}
		} while(true);

	}

}
