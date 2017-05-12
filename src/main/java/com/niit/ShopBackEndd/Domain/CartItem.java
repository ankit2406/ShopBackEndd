package com.niit.ShopBackEndd.Domain;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "CartItem")
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartItem_Id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Product product;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cart cart;

	private int sell_quantity;

	private int total_price;

	public long getCartItem_Id() {
		return cartItem_Id;
	}

	public void setCartItem_Id(long cartItem_Id) {
		this.cartItem_Id = cartItem_Id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

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

	@Override
	public String toString() {
		return "CartItem [cartItem_Id=" + cartItem_Id + ", product=" + product + ", cart=" + cart + ", sell_quantity="
				+ sell_quantity + ", total_price=" + total_price + "]";
	}
}