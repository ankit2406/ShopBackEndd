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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class OrderDetails implements Serializable
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long order_id;
	private String fname;
	private String lname;
	private String contact;
	private String address;
	private String city;
	private String state;
	private String pin;
	private String orderDate;
	private int qty;
	private int shipping;
	private int orderTotal;
	






	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getShipping() {
		return shipping;
	}


	public void setShipping(int shipping) {
		this.shipping = shipping;
	}


	public int getOrderTotal() {
		return orderTotal;
	}


	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}


	@ManyToOne(fetch=FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "user_id")
	
	private User user;

	public long getOrder_id() {
		return order_id;
	}


	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public String getLname() {
		return lname;
	}



	public void setLname(String lname) {
		this.lname = lname;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPin() {
		return pin;
	}



	public void setPin(String pin) {
		this.pin = pin;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	

	@Override
	public String toString() {
		return "OrderDetails [order_id=" + order_id + ", fname=" + fname + ", lname=" + lname + ", contact=" + contact
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", pin=" + pin + ", orderDate="
				+ orderDate + ", qty=" + qty + ", shipping=" + shipping + ", orderTotal=" + orderTotal + ", user="
				+ user + "]";
	}

}
