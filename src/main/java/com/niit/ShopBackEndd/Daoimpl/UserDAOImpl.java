package com.niit.ShopBackEndd.Daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Cart;
import com.niit.ShopBackEndd.Domain.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO

{

	@Autowired SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean save(User user) 
	{
		try
		{
			if(user.getRole().equals("BUYER"))
			{
				Cart cart = new Cart();
				cart.setUser(user);
				user.setCart(cart);
			}
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean validate(String email, String password) 
	{
		try{
			@SuppressWarnings({ "deprecation", "rawtypes" })
			Query query=sessionFactory.getCurrentSession().createQuery("from User where email=? and password=?");
			query.setString(0, email);
			query.setString(1, password);
			if(query.uniqueResult()== null)
				return false;
			else
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<User> list()
	{
		return sessionFactory.getCurrentSession().createQuery("from User").list();

	}

	public User getUserById(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class,id);

	}

	public boolean deactivate(User user) {
		user.setEnabled(false);
		try
		{
			sessionFactory.getCurrentSession().update(user);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public User getUserByEmail(String email) 
	{
		return (User) sessionFactory.getCurrentSession().createQuery("from User where email= ? ")
		.setString(0, email).uniqueResult();
	}
}