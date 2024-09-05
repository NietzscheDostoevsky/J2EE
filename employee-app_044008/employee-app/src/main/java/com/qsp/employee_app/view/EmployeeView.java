package com.qsp.employee_app.view;

import java.util.List;
import java.util.Scanner;

import com.qsp.employee_app.controller.EmployeeController;
import com.qsp.employee_app.model.Employee;

public class EmployeeView {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeeController controller = new EmployeeController();
		do {
			System.out.println("1> add Employee");
			System.out.println("2> delete Employee by id");
			System.out.println("3> find employee by id");
			System.out.println("4> update employee sal by id");
			System.out.println("5> fin all employee");
			System.out.println("6> exit");
			switch (sc.nextInt()) {
			case 1: {
				Employee emp = new Employee();
				System.out.println("enter id");
				emp.setId(sc.nextInt());
				System.out.println("enter name");
				emp.setName(sc.next());
				System.out.println("enter phone");
				emp.setPhone(sc.nextLong());
				System.out.println("enter sal");
				emp.setSal(sc.nextDouble());
				controller.addEmployee(emp);
				System.out.println("inserted-------------!");
			}
				break;
			case 2: {
				System.out.println("enter id");
				boolean res = controller.deleteEmployeeById(sc.nextInt());
				if (res) {
					System.out.println("deleted-------------!");
				} else {
					System.out.println("id is not present");
				}
			}
				break;
			case 3: {
				System.out.println("enter id");
				Employee emp = controller.getEmployeeById(sc.nextInt());
				if (emp.getId() != 0) {
					System.out.println(emp);
				}else {
					System.out.println("id is not present");
				}
			}
				break;
			case 4: {
				System.out.println("enter id");
				int id = sc.nextInt();
				System.out.println("enter new sal");
				double newSal = sc.nextDouble();
				boolean res = controller.updateEmployeeSal(id, newSal);
				if (res) {
					System.out.println("updated-------------!");
				} else {
					System.out.println("id is not present");
				}
			}
				break;
			case 5: {
				List<Employee> list=controller.getAll();
				for (Employee employee : list) {
					System.out.println(employee);
					System.out.println("-----------------------------");
				}
			}
				break;
			case 6: {
				controller.closeConnection();
				System.out.println("tata bye bye");
				System.exit(0);
			}
				break;
			default:{
				System.out.println("invalid choice");
			}
				break;
			}
			System.out.println("enter y to continue");
		} while (sc.next().equalsIgnoreCase("y"));
	}
}
