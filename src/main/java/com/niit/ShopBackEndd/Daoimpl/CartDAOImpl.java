package com.niit.ShopBackEndd.Daoimpl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShopBackEndd.Dao.CartDAO;
import com.niit.ShopBackEndd.Domain.Cart;


@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SessionFactory sessionFactory;


	public boolean updateCart(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
			System.out.println(ex);
			return false;
		}
	}

	public Cart getCartBycart_Id(long cart_Id) 
	{
		String selectCartId = "FROM Cart where cart_Id=:parameter";
		Query<Cart> query = sessionFactory.getCurrentSession().createQuery(selectCartId, Cart.class);
		query.setParameter("parameter", cart_Id);
		try {
			return query.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}

	public boolean deleteAllCartItems(Cart cart) 
	{
		try 
		{
			String selectCartId = "DELETE FROM CartItem WHERE cart=:parameter";
			Query query = sessionFactory.getCurrentSession().createQuery(selectCartId);
			query.setParameter("parameter", cart);
			System.out.println(query.executeUpdate());
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
			return false;
		}

	}

	
	

}
