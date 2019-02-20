package com.fahadbackend;


import static org.junit.Assert.*;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fahadbackend.dao.CategoryDAO;
import com.fahadbackend.model.Category;

public class CategoryDAOUnitTestCases 
{
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.fahadbackend");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	//@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("One plus");
		category.setCategoryDesc("Best battery backup");
	
		assertTrue("Problem in adding the Category ",categoryDAO.addCategory(category));
	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
	}
	
	@Ignore 
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
    
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(3);
		category.setCategoryName("Samsung");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
	}
    
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.listCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
	}
	
}

