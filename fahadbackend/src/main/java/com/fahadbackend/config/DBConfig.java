package com.fahadbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fahadbackend.dao.CategoryDAOimpl;
import com.fahadbackend.dao.CategoryDAO;
import com.fahadbackend.dao.ProductDAO;
import com.fahadbackend.dao.ProductDAOimpl;
import com.fahadbackend.dao.SupplierDAO;
import com.fahadbackend.dao.SupplierDAOimpl;
import com.fahadbackend.dao.UserDAO;
import com.fahadbackend.dao.UserDAOimpl;
import com.fahadbackend.model.Category;
import com.fahadbackend.model.Product;
import com.fahadbackend.model.Supplier;
import com.fahadbackend.model.UserDetail;

@Configuration
@EnableTransactionManagement
public class DBConfig 
{
    @Autowired
	@Bean(name="dataSource")
public DataSource getH2DataSource()
{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUsername("abcd");
	dataSource.setPassword("abcd");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	System.out.println("THIS IS datasource object");
	return dataSource;
}

  @Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
	Properties hibernateProperties=new Properties();
	hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
	hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

	LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
	factory1.addProperties(hibernateProperties);
	factory1.addAnnotatedClass(Category.class);
	factory1.addAnnotatedClass(Product.class);
	factory1.addAnnotatedClass(UserDetail.class);
	factory1.addAnnotatedClass(Supplier.class);
	SessionFactory sessionFactory=factory1.buildSessionFactory();
	System.out.println("THIS IS sessionFactory object");
	return sessionFactory;
	}

	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println(">.....Category DAO Implementation.......<");
		return new CategoryDAOimpl();
	}

	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println(">........Product DAO Implementation.......<");
		return new ProductDAOimpl();
	}
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println(">......User DAO Implementation......<");
		return new UserDAOimpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAOimpl getSupplierDAO()
	{
		System.out.println(">........supplier  DAO Implementation---");
		return new SupplierDAOimpl();
	}

	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("THIS IS transcationmanager object");
		return new HibernateTransactionManager(getSessionFactory());
	}
}