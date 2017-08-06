package com.niit.ShopBackEndd.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Cart")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cart_Id;

	private int cartItemCount;

	private int grandTotal;

	@OneToOne()
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "user_id")
	private User user;

	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
	//@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) 

	//private List<CartItem> cartList = new ArrayList<CartItem>(0);

	public long getCart_Id() {
		return cart_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCart_Id(long cart_Id) {
		this.cart_Id = cart_Id;
	}

	public int getCartItemCount() {
		return cartItemCount;
	}

	public void setCartItemCount(int cartItemCount) {
		this.cartItemCount = cartItemCount;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Cart [cart_Id=" + cart_Id + ", cartItemCount=" + cartItemCount + ", grandTotal=" + grandTotal
				+ ", user=" + user + "]";
	}
}
