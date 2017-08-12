package com.niit.ShopBackEndd.Dao;

import java.util.List;

import com.niit.ShopBackEndd.Domain.OrderDetails;
import com.niit.ShopBackEndd.Domain.OrderedItems;

public interface OrderedItemsDAO {
	
	public boolean addOrderItem(OrderedItems orderItem);
	
	public List<OrderedItems> getItemsByOrderID(long orderID);
	

}
