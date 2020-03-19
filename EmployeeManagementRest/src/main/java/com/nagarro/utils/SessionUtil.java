package com.nagarro.utils;
/*
* Class name - SessionUtil
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
* Description -  creates session and configure hibernate
*/
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {
	
	private static SessionUtil instance = new SessionUtil();
	private SessionFactory sessionFactory;

	public static SessionUtil getInstance() {
		return instance;
	}
	
	private SessionUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}
}
