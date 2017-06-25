package com.localhost.base.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.localhost.base.dao.BaseDao;
import com.localhost.config.HibernateConfig;

public abstract class BaseDaoImpl<T extends Object> implements BaseDao<T> {

	private Class<T> clazz;
	private static SessionFactory sessionFactory;
	protected static Session session;

	public void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public List<T> findAll() throws Exception {
		try {
			this.getSession();
			this.openSession();
			return session.createCriteria(clazz).list();
		} catch (Exception e) {
			throw (e);
		} finally {
			this.closeSession();
		}
	}

	@SuppressWarnings("static-access")
	public static void initConnection() throws Exception {
		HibernateConfig config = new HibernateConfig();
		sessionFactory = config.configureSessionFactory();
	}

	public final void openSession() throws Exception {
		session = sessionFactory.openSession();
	}

	public final void closeSession() throws Exception {
		session.close();
	}

	public final void getSession() throws Exception {
		if (null == sessionFactory) {
			initConnection();
		}
	}
}
