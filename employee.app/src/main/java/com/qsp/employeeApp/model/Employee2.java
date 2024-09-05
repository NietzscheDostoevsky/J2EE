package com.qsp.employeeApp.model;

public record Employee2(
		int id,
		String name,
		long phone,
		double sal
		) {
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", sal=" + sal + "]";
	}
}
