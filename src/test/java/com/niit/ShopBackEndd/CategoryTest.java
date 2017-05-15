package com.niit.ShopBackEndd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShopBackEndd.Dao.CartDAO;
import com.niit.ShopBackEndd.Dao.CartItemDAO;
import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Cart;
import com.niit.ShopBackEndd.Domain.CartItem;
import com.niit.ShopBackEndd.Domain.Category;
import com.niit.ShopBackEndd.Domain.Product;
import com.niit.ShopBackEndd.Domain.User;

public class CategoryTest {
	@Autowired
	static AnnotationConfigApplicationContext context;
	@Autowired
	static CartDAO cartDAO;
	@Autowired
	static UserDAO userDAO;
	@Autowired
	static CartItemDAO cartItemDAO;
	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static CategoryDAO categoryDAO;

	static Category category;
	static Cart cart;
	static CartItem cartItem;
	static User user;
	static Product product;

	@BeforeClass
	public static void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShopBackEndd");
		context.refresh();
		// get the categoryDAO from context
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		cartDAO = (CartDAO) context.getBean("cartDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test
	public void cartTest() {
		user = new User();
		user.setContact("998965455");
		user.setEmail("steven@gmail.com");
		user.setEnabled(true);
		user.setName("steven");
		user.setPassword("steven");
		user.setRole("BUYER");
		
		assertEquals("Saved", true, userDAO.save(user));
	}
	
	//@Test
	public void cartItemTest()
	{
		user = userDAO.getUserById(25);
		cart = user.getCart();
		cartItem=new CartItem();
		product=productDAO.get(17);
		
		cartItem.setSell_quantity(4);
		cartItem.setTotal_price(80000);
		cartItem.setProduct(product);
		cartItem.setTotal_price((int) (product.getPrice()*cartItem.getSell_quantity()));
		cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
		cart.setCartItemCount(cart.getCartItemCount() + 1);
		cartItem.setCart(cart);

		boolean flag=cartItemDAO.addCartItem(cartItem);
		assertEquals("Saved", true, flag);

	}
	
	//@Test 
	public void testUpdateCartItem() 
	{ 
		cartItem =cartItemDAO.getCartItemByCartItem_Id((long) 22);
		cart = cartItem.getCart();
		product = cartItem.getProduct(); 
		int oldQuantity = cartItem.getSell_quantity();
		cartItem.setSell_quantity(cartItem.getSell_quantity()+1);
		cartItem.setTotal_price((int) (product.getPrice()*cartItem.getSell_quantity()));
		cart.setGrandTotal((int) (cart.getGrandTotal()+(cartItem.getSell_quantity()-oldQuantity)*product.getPrice())); 
		
		assertEquals("Successfully Update the cartItem!", true, cartItemDAO.updateCartItem(cartItem));
	
	}
	//decrease quantity in cartitem
	//@Test
	public void removeQuantityTest()
	{
		cartItem =cartItemDAO.getCartItemByCartItem_Id((long) 22);
		cart = cartItem.getCart();
		product = cartItem.getProduct(); 
		int oldQuantity = cartItem.getSell_quantity();
		cartItem.setSell_quantity(cartItem.getSell_quantity()-1);
		cartItem.setTotal_price((int) (product.getPrice()*cartItem.getSell_quantity()));
		cart.setGrandTotal((int) (cart.getGrandTotal()-(oldQuantity-cartItem.getSell_quantity())*product.getPrice()));		
		assertEquals("Successfully Update the cartItem!", true, cartItemDAO.updateCartItem(cartItem));
	
	}
	
	
	
	/*
	 * @Test public void createCategoryTest() { category = new Category();
	 * //category.setCategory_id(1104);
	 * category.setCategory_name("Smartphones"); boolean flag =
	 * categoryDAO.save(category);
	 * 
	 * assertEquals(true, flag); }
	 * 
	 * // @Test public void updateCategoryTest() { //
	 * product.setProduct_Id("105"); String id = "cat101"; category =
	 * categoryDAO.getCategoryByID(id);
	 * category.setCategory_name("Home Appliances"); boolean flag =
	 * categoryDAO.update(category); assertEquals(true, flag); }
	 * 
	 * //@Test public void getAllCategoriesTest() { List<Category> categories =
	 * categoryDAO.list(); assertEquals(4, categories.size()); }
	 * 
	 * @Test public void deleteCategoryTestCase() {
	 * category=categoryDAO.getCategoryByID(104); boolean flag =
	 * categoryDAO.delete(category); assertEquals(true, flag); }
	 */
}
