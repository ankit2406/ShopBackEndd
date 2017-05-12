package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.User;

public interface UserDAO 
{	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean validate(String email, String password);
	
	public List<User> list();
	
	public User getUserById(long user_id);
	
	public User getUserByEmail(String email);
	
	public boolean deactivate(User user);
}
