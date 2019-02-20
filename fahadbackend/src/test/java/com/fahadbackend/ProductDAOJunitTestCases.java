package com.fahadbackend;



import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.fahadbackend.dao.ProductDAO;
import com.fahadbackend.dao.ProductDAOimpl;
import com.fahadbackend.model.Category;
import com.fahadbackend.model.Product;

public class ProductDAOJunitTestCases {
	static ProductDAO productDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.fahadbackend");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	//@Ignore
	@Test
	public void addProductUnitTest()
	{
		Product product = new Product();
		product.setProductName("lenovo ");
		product.setProductDesc("Pocket friendly");
		product.setPrice(10000);
		product.setStock(12);
		product.setCategoryId(1);
		product.setSupplierId(2);
		assertTrue("Problem in adding the Category ",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(38);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(5);
		product.setProductName("Nokia");
		product.setPrice(20000);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in getting 	Product",productDAO.getProduct(36));
	}
	
	@Ignore
	@Test
	public void listProductTest()
	{
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Categories",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getProductid()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductDesc());
		}
	}
    
	
}
