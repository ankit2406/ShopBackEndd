package com.niit.ShopBackEndd.Dao;

import com.niit.ShopBackEndd.Domain.Cart;

public interface CartDAO 
{
	public boolean updateCart(Cart cart);
	public Cart getCartBycart_Id(long cart_Id);
	public boolean deleteAllCartItems(Cart cart);
}