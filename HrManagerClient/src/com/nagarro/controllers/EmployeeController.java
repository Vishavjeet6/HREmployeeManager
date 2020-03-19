package com.nagarro.controllers;
/*
* Class name - EmployeeController
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
* Description -  Contains all the operations to get update upload download employee date
*/
import java.io.IOException;
import java.util.List;

//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.constant.Constant;
import com.nagarro.models.Employee;
import com.nagarro.services.EmployeeService;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller 
@RequestMapping(value="employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEmployeeList() {
		ModelAndView modelView = new ModelAndView();	
		List<Employee> employees = employeeService.getAllEmployees();
		modelView.addObject("employees", employees);
		modelView.setViewName("home");
		return modelView;
	}
		
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editEmployee(
			@RequestParam(value="id") long id,
			@RequestParam(value="employeeCode") long employeeCode,
			@RequestParam(value="employeeName") String employeeName,
			@RequestParam(value="location") String location,
			@RequestParam(value="email") String email,
			@RequestParam(value="dateOfBirth") String dateOfBirth)
			{	
		ModelAndView modelView = new ModelAndView();
		Employee employee = new Employee(id, 
								employeeCode, 
								employeeName, 
								location, 
								email, 
								dateOfBirth);
		modelView.addObject("employee", employee);
		modelView.setViewName("/editEmployeePage");
		return modelView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam(value="file") MultipartFile file) {
		System.out.println("********************");
		System.out.println("********************");
		System.out.println("********************");
		System.out.println("********************");
		System.out.println(file.getName());
		System.out.println("********************");
		System.out.println("********************");
		System.out.println("********************");
		System.out.println("********************");
		ModelAndView modelView = new ModelAndView();	
		employeeService.addAllEmployees(file);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(
						@RequestParam(value="id") long id,
						@RequestParam(value="employeeCode") long employeeCode,
						@RequestParam(value="employeeName") String employeeName,
						@RequestParam(value="location") String location,
						@RequestParam(value="email") String email,
						@RequestParam(value="dateOfBirth") String dateOfBirth) {
		ModelAndView modelView = new ModelAndView();	
		Employee employee = new Employee(id, 
				employeeCode, 
				employeeName, 
				location, 
				email, 
				dateOfBirth);
		employeeService.updateEmployee(employee);
		modelView.setViewName("redirect:/employee");
		return modelView;
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void downloadFile(HttpServletResponse response) {
        response.setContentType("text/csv");
        response.addHeader("Content-Disposition", "attachment; filename=" + Constant.CSV_FILE_NAME);
        try (ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE)) {
            employeeService.addEmployeeDetailsToFile(csvBeanWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
