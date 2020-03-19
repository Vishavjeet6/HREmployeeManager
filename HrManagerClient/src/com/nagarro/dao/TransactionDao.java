package com.nagarro.dao;
/*
* Class name - TransactionDao
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
* Description -  contains transaction functions
*/
import org.hibernate.Session;

public interface TransactionDao {
	void begin();
	void commit();
	void close();
	void rollback();
	Session getSession();
}
