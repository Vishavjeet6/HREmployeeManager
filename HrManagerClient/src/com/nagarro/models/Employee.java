package com.nagarro.models;
/*
* Class name - Employee
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
* Description -  employee pojo
*/
public class Employee {
	
	private long id;
    private long employeeCode;
    private String employeeName;
    private String location;
    private String email;
    private String dateOfBirth;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Employee() {
		super();
	}
	public Employee(long id, long employeeCode, String employeeName, String location, String email,
			String dateOfBirth) {
		super();
		this.id = id;
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.location = location;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", location=" + location + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
}
