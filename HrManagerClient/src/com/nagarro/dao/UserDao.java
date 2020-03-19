package com.nagarro.dao;
/*
* Class name - UserDao
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
* Description -  contains add and get user
*/
import com.nagarro.models.UserModel;

public interface UserDao {
	void addUser(UserModel userModel);
	UserModel getUser(String userName);
}
