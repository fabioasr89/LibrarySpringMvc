package com.fabio.dao;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDAO<E> {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Properties properties;
	public AbstractDAO() {
		
	}
	
	public boolean insert(E entity) {
		boolean inserito=true;
		Session session=null;
		Transaction tx=null;
		try {
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			session.persist(entity);
			tx.commit();
		}catch(Exception e) {
			inserito=false;
			e.printStackTrace();
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return inserito;
	}
	
	
	
	
	public boolean delete(E entity) {
		Session session=null;
		Transaction tx=null;
		boolean eliminato=true;
		try {
			session=sessionFactory.getCurrentSession();
			tx=session.beginTransaction();
			session.delete(entity);
			tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			eliminato=false;
			if(tx!=null) {
				tx.rollback();
			}
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return eliminato;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
}
