package com.nagarro.services;
/*
* Class name - EmployeeServiceImpl
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
* Description -  implements employeeservice
*/
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.ICsvBeanWriter;

import com.nagarro.constant.Constant;
import com.nagarro.dao.EmployeeDao;
import com.nagarro.models.Employee;
import com.nagarro.utils.CsvUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeDao employeeDao;

	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	public void addAllEmployees(MultipartFile file) {
		List<Employee> employees = CsvUtil.getParsedData(file);
        if (employees != null) {
            employeeDao.addAllEmployees(employees);
        }	
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}

	public void addEmployeeDetailsToFile(ICsvBeanWriter csvBeanWriter) throws IOException {
		List<Employee> employees = this.getAllEmployees();
        csvBeanWriter.writeHeader(Constant.DISPLAY_HEADER);
        for (Employee employee : employees) {
            csvBeanWriter.write(employee, Constant.BEAN_HEADER);
        }
	}
}
