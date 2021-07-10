package com.kanakadurga.com.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanakadurga.com.entity.Product;



@Service 
public class ProductService {

	@Autowired
	ProductRepository rep;
	
	
	public void saveProduct(Product product){
		System.out.println("product saved");
		rep.save(product);
	}
	public void getProduct(int productId){
		Optional<com.kanakadurga.com.entity.Product> prod=rep.findById(productId);
		Product product=prod.get();
		//System.out.println(product.getName());
	}
	
	
	
}
