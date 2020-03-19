package com.nagarro.daoImpl;
/*
* Class name - UserDaoImpl
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
* Description -  Implements user dao
*/
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dao.TransactionDao;
import com.nagarro.dao.UserDao;
import com.nagarro.models.UserModel;

public class UserDaoImpl implements UserDao{
	
	@Autowired
	private TransactionDao transactionDao;

	@Override
	public void addUser(UserModel userModel) {
		transactionDao.begin();
		transactionDao.getSession().save(userModel);
		transactionDao.commit();
		transactionDao.close();
	}

	@Override
	public UserModel getUser(String userName) {
		transactionDao.begin();
		UserModel userModel = (UserModel)transactionDao.getSession().get(UserModel.class, userName);
		transactionDao.commit();
		transactionDao.close();
		return userModel;
	}
}
