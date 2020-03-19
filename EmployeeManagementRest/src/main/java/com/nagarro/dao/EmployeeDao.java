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
* Description -  get and add employees
*/
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.models.Employee;
import com.nagarro.utils.SessionUtil;

public class EmployeeDao {
	
	public List<Employee> getEmployees(){
		Session session = SessionUtil.getSession();
		List<Employee> employees=null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> employeeRoot = criteria.from(Employee.class);
			criteria.select(employeeRoot);
			employees = session.createQuery(criteria).getResultList();
		} catch (Exception e) {
			System.out.println("Hibernate Exception Found");
		}
        session.close();
        return employees;
	}
	
	public Employee getEmployee(long employeeCode) {
		Session session = SessionUtil.getSession();
		Employee employee=null;
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> employeeRoot = criteria.from(Employee.class);
			criteria.select(employeeRoot);
			criteria.where(builder.equal(employeeRoot.get("employeeCode"), employeeCode));
			employee = session.createQuery(criteria).getSingleResult();
		} catch (Exception e) {
			System.out.println("Hibernate Exception Found");
		}
        session.close();
        return employee;
	}
	
	public void addEmployee(Employee employee) {
		Session session = SessionUtil.getSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hibernate Exception Found");
		}
		session.close();
	}
	
	public void updateEmployee(Employee employee) {
		Session session = SessionUtil.getSession();
	
		try {		
			Transaction transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
			Root<Employee> employeeRoot = criteria.from(Employee.class);
			criteria.select(employeeRoot);
			criteria.where(builder.equal(employeeRoot.get("employeeCode"), employee.getEmployeeCode()));
			Employee employee1 = session.createQuery(criteria).uniqueResult();
			transaction.commit();
			employee.setId(employee1.getId());
			session.clear();
			session.beginTransaction();
			session.update(employee);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("Hibernate Exception Found");
		}
		session.close();
	}
}
