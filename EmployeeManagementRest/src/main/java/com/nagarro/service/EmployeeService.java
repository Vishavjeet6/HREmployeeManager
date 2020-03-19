package com.nagarro.service;
/*
* Class name - EmployeeService
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 17-03-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description -  funnction to add, get, update employee
*/
import java.util.List;

import com.nagarro.dao.EmployeeDao;
import com.nagarro.models.Employee;

public class EmployeeService {
	
	private EmployeeDao employeeDao = new EmployeeDao();

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeDao.getEmployees();
		if(employeeList == null) {
			System.err.println("Empty employee List");
		}
		return employeeList;
	}

	public Employee getEmployee(long employeeCode) {
		Employee employee = employeeDao.getEmployee(employeeCode);
		if(employee == null) {
			System.err.println("Employee not found");
		}
		return employee;
	}

	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

}
