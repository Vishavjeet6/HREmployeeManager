package com.nagarro.dao;
/*
* Class name - EmployeeDao
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
* Description -  Contains add, update, get employee functions
*/
import java.util.List;

import com.nagarro.models.Employee;

public interface EmployeeDao {
	List<Employee> getAllEmployees();
	void addAllEmployees(List<Employee> employees);
	void updateEmployee(Employee employee);
	void addEmployee(Employee employee);
}
