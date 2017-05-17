package com.niit.ShopBackEndd.Daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Domain.Category;
@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO 
{

	@Autowired 
	SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@SuppressWarnings("unchecked")
	public List<Category> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from Category").list();

	}

	public boolean save(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(category);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Category category) 
	{
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Category getCategoryByID(long id) 
	{
		return (Category) sessionFactory.getCurrentSession().get(Category.class,id);
	}
	
	@Override
	public boolean deleteById(long id) {
		try
		{
			sessionFactory.getCurrentSession().delete(getCategoryByID(id));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
