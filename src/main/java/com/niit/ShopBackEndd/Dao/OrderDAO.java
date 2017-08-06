package com.niit.ShopBackEndd.Dao;

import com.niit.ShopBackEndd.Domain.OrderDetails;

public interface OrderDAO {
	
	public boolean createOrder(OrderDetails orderDetails);
	
	public boolean updateOrder(OrderDetails orderDetails);

	public boolean cancelOrder(OrderDetails orderDetails);
	
	
	

}
