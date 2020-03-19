package com.nagarro.EmployeeManagementRest;
/*
* Class name - MyResource
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
* Description -  main rest api class
*/
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.models.Employee;
import com.nagarro.service.EmployeeService;

@Path("/")
public class MyResource {
	
	private EmployeeService employeeService = new EmployeeService();

	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployee() {
		List<Employee> employees = employeeService.getAllEmployees();
		return employees;
	}
	
	@GET
	@Path("/employee/{employeeCode}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployee(@PathParam("employeeCode") long employeeCode) {
		Employee employee = employeeService.getEmployee(employeeCode);
		return employee;
	}
	
	@POST
	@Path("/employee")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
	public void addEmployee(Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PUT
	@Path("/employee")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON})
	public void updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
	}
}
