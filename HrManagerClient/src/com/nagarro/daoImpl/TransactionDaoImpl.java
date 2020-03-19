package com.nagarro.daoImpl;
/*
* Class name - TransactionDaoImpl
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
* Description -  implements transaction dao
*/
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.dao.TransactionDao;

public class TransactionDaoImpl implements TransactionDao {
	private Configuration con = new Configuration().configure();
	private SessionFactory sessionFactory = con.buildSessionFactory();
	private Session session;
	
	@Override
	public void begin() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	@Override
	public void commit() {
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		session.close();
	}

	@Override
	public void rollback() {
		session.getTransaction().rollback();
	}

	@Override
	public Session getSession() {
		return session;
	}
}
