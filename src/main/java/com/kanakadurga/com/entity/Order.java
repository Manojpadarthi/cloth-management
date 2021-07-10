package com.kanakadurga.com.entity;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ordertbl")
public class Order 
{   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="fk_orderid")
	private List<Item> items = new ArrayList();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	

	
	

}
