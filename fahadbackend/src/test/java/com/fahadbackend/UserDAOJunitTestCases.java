package com.fahadbackend;


import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.List;



import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fahadbackend.dao.UserDAO;
import com.fahadbackend.model.UserDetail;



public class UserDAOJunitTestCases {
	static UserDAO userDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.fahadbackend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	//@Ignore
	@Test
	public  void registerUser() 
	{
		UserDetail user=new UserDetail();
		
		user.setMobileNo("9004076870");
		user.setPassword("fahad996");
		user.setUserName("fahad");
		user.setAddr("mumbai");
		user.setRole("user");
		user.setEnabled(true);
		user.setCustomerName("fahad khan");
		
		assertTrue("Problem in User Insertion",userDAO.registerUser(user));
	
	}
	
	@Ignore
	@Test
	public  void deleteUser() 
	{
		UserDetail user=userDAO.getUserId(8);
		assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public  void updateUser() 
	{

		UserDetail user=userDAO.getUserId(7);
	    user.setAddr("delhi");
	    user.setMobileNo("989407897");
		user.setPassword("kking112");
		user.setUserName("king");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	
	@Test
	public void listUserTest()
	{
		List<UserDetail> listUserDetails=userDAO.listUserDetails();
		assertNotNull("No Categories",listUserDetails);
		
		for(UserDetail user: listUserDetails)
		{
			System.out.print(user.getUserId()+":::");
			System.out.print(user.getUserName()+":::");
			System.out.println(user.getMobileNo());
		}
	}
	
	

}






