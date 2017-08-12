package com.niit.ShopBackEndd.Domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;


@Component
@Entity
public class OrderedItems implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderedItemId;
	
	private int sell_quantity;

	private int total_price;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "order_id")

	
	private OrderDetails orderDetails;
	
	public int getSell_quantity() {
		return sell_quantity;
	}

	public void setSell_quantity(int sell_quantity) {
		this.sell_quantity = sell_quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getOrderedItemId() {
		return orderedItemId;
	}

	
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	

	
}
