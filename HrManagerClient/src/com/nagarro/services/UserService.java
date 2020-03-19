package com.nagarro.services;
/*
* Class name - UserService
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
* Description -  validates user and add user
*/
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.UserDao;
import com.nagarro.models.UserModel;

public class UserService {
	
	@Autowired
	private UserDao userDao;

	public boolean validateUser(String userName, String password) {	
		UserModel userModel = userDao.getUser(userName);
		if(userModel == null) return false;
		if(userModel.getPassword().equals(password)) return true;
		return false;
	}

	public void addUser(String userName, String password) {
		UserModel userModel = new UserModel();
		userModel.setUserName(userName);
		userModel.setPassword(password);
		userDao.addUser(userModel);
	}	
}
