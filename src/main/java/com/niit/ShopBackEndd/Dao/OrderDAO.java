package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.OrderDetails;
import com.niit.ShopBackEndd.Domain.User;

public interface OrderDAO {
	
	public boolean createOrder(OrderDetails orderDetails);
	
	public boolean updateOrder(OrderDetails orderDetails);

	public boolean cancelOrder(OrderDetails orderDetails);
	
	public List<OrderDetails> getOrderDetailsByUser(User user);
	

}
