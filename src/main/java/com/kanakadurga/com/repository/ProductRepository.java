package com.kanakadurga.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanakadurga.com.entity.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> 
{
   
   
}
