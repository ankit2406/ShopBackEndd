package com.niit.ShopBackEndd;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Domain.Category;
import com.niit.ShopBackEndd.Domain.Product;

public class ProductTest 
{
	@Autowired	static AnnotationConfigApplicationContext context;
	@Autowired	static ProductDAO productDAO;
	@Autowired	static CategoryDAO categoryDAO;
	static Product product;
	static Category category;

	@BeforeClass
	public static void initialize() 
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShopBackEndd");

		context.refresh();
		
		//get the userDAO from context
		productDAO =  (ProductDAO) context.getBean("productDAO");
	
	}

	//@Test
	public void deleteProduct()
	{
		Product product = productDAO.get(105);
		boolean flag=productDAO.deleteProduct(product);
		
		assertEquals(true, flag);
	}
	//@Test
	public void createProduct() 
	{
		category=new Category();
		category.setCategory_name("Laptop");
		product = new Product();
		//product.setProduct_Id("106");
		product.setProduct_Name("apple macbook air");
		product.setBrand("apple");
		product.setProduct_Description("apple 13 inch laptop");
		product.setPrice(90000.00);
		product.setCategory(category);
		boolean flag =  productDAO.createProduct(product);
		System.out.println("");
			
	

		//error - if there is in runtime errors  -  Red mark
		//success  - if expected and actual is same  - green mark
		//fail  - if expected and actual is different  -  blue mark
		assertEquals("createProduct",true,flag);
		
	}
	
	//@Test
	public void updateProduct()
	{
		//product.setProduct_Id("105");
		
		product=productDAO.get(106);
		product.setProduct_Name("note 5");
		boolean flag=productDAO.updateProduct(product);
		assertEquals(true, flag);
	}
	//@Test
	public void getProducts()
	{
		int products=productDAO.list().size();
		assertEquals(2, products);
	}
	
	
	

}
