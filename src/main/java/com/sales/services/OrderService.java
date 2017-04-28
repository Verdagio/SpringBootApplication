package com.sales.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public LinkedList<Order> getList(){
		
		return (LinkedList<Order>) orderRepository.findAll();
	}// get list
	
	public Order save(Order o){
		return orderRepository.save(o);
	}//save
	
}//class
