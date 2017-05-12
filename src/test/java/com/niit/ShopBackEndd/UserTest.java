package com.niit.ShopBackEndd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.User;

public class UserTest 
{
	@Autowired static AnnotationConfigApplicationContext context;
	@Autowired static UserDAO userDAO;
	static User user;
	@BeforeClass
	public static void initalize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShopBackEndd");

		context.refresh();
		
		//get the userDAO from context
		userDAO =  (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void createUserTest() {
		user=new User();
		//user.setId("u201");
		user.setName("kai green");
		user.setContact("12457867");
		user.setPassword("12345");
		user.setRole("user");
		user.setEnabled(true);
		
		boolean flag=userDAO.save(user);
		assertEquals(true, flag);
		
	}
	
	//@Test
	public void updateUserTest()
	{
		user=userDAO.getUserById(201);
		user.setName("kevin levron");
		boolean flag=userDAO.update(user);
		assertEquals(true, flag);
	}
	
	//@Test
	public void deactivateUserTest()
	{
		user=userDAO.getUserById(201);
		user.setEnabled(false);
		boolean flag=userDAO.deactivate(user);
		assertEquals(true, flag);
	}
	
	//@Test
	public void validateUserTest()
	{
		boolean flag=userDAO.validate("u201", "12345");
		assertEquals(true, flag);
	}
	
	//@Test
	public void getAllUserTest()
	{
		int size=userDAO.list().size();
		assertEquals(1, size);
	}

}
