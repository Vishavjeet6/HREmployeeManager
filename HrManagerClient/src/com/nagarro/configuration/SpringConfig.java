package com.nagarro.configuration;

/*
* Class name - SpringConfig
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 10-01-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description - Spring Configuration File
*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.nagarro.dao.EmployeeDao;
import com.nagarro.dao.TransactionDao;
import com.nagarro.dao.UserDao;
import com.nagarro.daoImpl.EmployeeDaoImpl;
import com.nagarro.daoImpl.TransactionDaoImpl;
import com.nagarro.daoImpl.UserDaoImpl;
import com.nagarro.services.EmployeeService;
import com.nagarro.services.EmployeeServiceImpl;
import com.nagarro.services.UserService;

@Configuration
@EnableScheduling
public class SpringConfig {
	
	@Bean
	public TransactionDao getTransactionDao() {
		return new TransactionDaoImpl();
	}

	@Bean
	public UserDao getUserDao() {
		return new UserDaoImpl();
	}
	
	@Bean EmployeeDao getEmployeeDao() {
		return new EmployeeDaoImpl();
	}
	
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	
	@Bean
	public RestTemplate  getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}
	
}
