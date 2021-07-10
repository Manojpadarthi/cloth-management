package com.kanakadurga.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanakadurga.com.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
