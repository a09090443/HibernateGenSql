package com.localhost.config;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import com.localhost.VO.OptionsVO;
import com.localhost.utils.OptionsUtil;

public class HibernateConfig {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory configureSessionFactory() throws HibernateException, IOException {
		OptionsVO optionsVO = OptionsUtil.getOptionsVO();
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
				.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
				.setProperty("hibernate.connection.url", "jdbc:mysql://" + optionsVO.getDatabaseIp() + ":" + optionsVO.getDatabasePort() + "/" + optionsVO.getDatabase() + "")
				.setProperty("hibernate.connection.username", "" + optionsVO.getDbUser() + "")
				.setProperty("hibernate.connection.password", "" + optionsVO.getDbPassword() + "")
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.hbm2ddl.auto", "false");

		EntityScanner.scanPackages("com.localhost.model").addTo(configuration);
		serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}
