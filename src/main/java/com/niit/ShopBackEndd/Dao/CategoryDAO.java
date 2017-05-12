package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.Category;

public interface CategoryDAO 
{
	public List<Category> list();
	
	public boolean save(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(Category category);
	
	public boolean deleteById(long id);
	
	public Category getCategoryByID(long category_id);
	
}
