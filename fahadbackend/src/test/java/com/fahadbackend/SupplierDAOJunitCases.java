package com.fahadbackend;

import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fahadbackend.dao.CategoryDAO;
import com.fahadbackend.model.Category;
import com.fahadbackend.model.Supplier;
import com.fahadbackend.dao.SupplierDAO;

public class SupplierDAOJunitCases 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.fahadbackend");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	//@Ignore
	@Test
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("Honor");
		supplier.setSupplierDesc("latest android phone ");
		assertTrue("Problem in adding the Category ",supplierDAO.addSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void getSupplierTest()
	{
		assertNotNull("Problem in get Category",supplierDAO.getSupplier(52));
	}
	
	@Ignore
	@Test
	public void deleteCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(54);
		assertTrue("Problem in Deletion:",supplierDAO.deleteSupplier(supplier));
	}
    
	 @Ignore
     @Test
	public void updateCategoryTest()
	{
		Supplier supplier=supplierDAO.getSupplier(9);
		supplier.setSupplierName("Micromax");
		assertTrue("Problem in Updation",supplierDAO.updateSupplier(supplier));
	}
    
	//@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertNotNull("No Categories",listSuppliers);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.print(supplier.getId()+":::");
			System.out.print(supplier.getSupplierName()+":::");
			System.out.println(supplier.getSupplierDesc());
		}
	}
	
}

