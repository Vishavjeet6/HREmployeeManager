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
* Description -  employee model for database
*/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_details")
public class Employee {
	
	 @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name = "employee_code", nullable = false, unique = true)
	private long employeeCode;
	 
	@Column(name = "employee_name", nullable = false, length = 100)
	private String employeeName;
	
	@Column(name = "location", length = 500)
	private String location;
	
	@Column(name = "email", length = 100)
	private String email;
	
	@Column(name = "dob")
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

	public String getlocation() {
		return location;
	}

	public void setlocation(String location) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", location=" + location + ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}	
}
