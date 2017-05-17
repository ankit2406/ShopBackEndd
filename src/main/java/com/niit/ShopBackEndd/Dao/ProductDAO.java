package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.Category;
import com.niit.ShopBackEndd.Domain.Product;

public interface ProductDAO 
{
	public boolean createProduct(Product product);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(Product product);
	
	public List<Product> list();
	
	public Product get(long product_Id);
	
	public Product getProductByName(String name);
	
	public List<Product> getProductsByCategory(Category category);

	public List<Product> getSimilarProducts(String search_string);
	
}
