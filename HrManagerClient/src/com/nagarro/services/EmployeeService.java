package com.nagarro.services;
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
* Description -  contains functions done on employee data
*/
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.models.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void addAllEmployees(MultipartFile file);
	void updateEmployee(Employee employee);
	void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException;

}
