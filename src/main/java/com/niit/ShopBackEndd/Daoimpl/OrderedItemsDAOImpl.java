package com.niit.ShopBackEndd.Daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.ShopBackEndd.Dao.OrderDAO;
import com.niit.ShopBackEndd.Dao.OrderedItemsDAO;
import com.niit.ShopBackEndd.Domain.OrderDetails;
import com.niit.ShopBackEndd.Domain.OrderedItems;


@Transactional(dontRollbackOn = Exception.class)
@Repository("orderedItemsDAO")
public class OrderedItemsDAOImpl implements OrderedItemsDAO 
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addOrderItem(OrderedItems orderItem) {
		try
		{
			// add ordered item to database
			sessionFactory.getCurrentSession().save(orderItem);
			return true;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<OrderedItems> getItemsByOrderID(long orderID) 
	{
		String selectOrderID="FROM OrderedItems where order_id=?";
		Query<OrderedItems> query= sessionFactory.getCurrentSession().createQuery(selectOrderID);
		query.setParameter(0, orderID);
		System.out.println("order id is"+orderID);
		try
		{
			return query.getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
}
