package com.kanakadurga.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="product")
public class Product
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="prd_name")
	private String name;
	@Column(name="prd_num_items")
	private int numberOfItems;
	@Column(name="prd_price")
	private double price;
	
	public int getId() {
		return id;
	}

	

	public Product(String name, int numberOfItems, double price) {
		super();
		this.name = name;
		this.numberOfItems = numberOfItems;
		this.price = price;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
