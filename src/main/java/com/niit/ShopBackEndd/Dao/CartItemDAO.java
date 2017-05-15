package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.Cart;
import com.niit.ShopBackEndd.Domain.CartItem;

public interface CartItemDAO {
	public boolean addCartItem(CartItem cartItem);

	public List<CartItem> cartItemGetByCart(Cart cart);

	public boolean updateCartItem(CartItem cartItem);

	public boolean deleteCartItem(CartItem cartItem);

	public CartItem getCartItemByCartItem_Id(Long cartItem_Id);

	//public CartItem getCartItemByUserIdAndProductId(Cart cart, Product product);

	//public boolean searchCartItemByUserIdAndProductId(Cart cart, Product product);
}