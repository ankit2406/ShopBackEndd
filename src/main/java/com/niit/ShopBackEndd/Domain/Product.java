package com.niit.ShopBackEndd.Domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Product")
public class Product implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_Id; 
	private String Brand; 
	private String product_Name, product_Description;
	private double Price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;

	public long getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(long product_Id) {
		this.product_Id = product_Id;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Description() {
		return product_Description;
	}

	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}