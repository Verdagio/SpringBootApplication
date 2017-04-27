package com.sales.controllers;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Order;

@Controller
public class OrderController {

	@RequestMapping(value = "/addOrders")
	public void addOrderer(Order o){
		LinkedList<Order> orders = new LinkedList<>();
		
		orders.add(o);
	}
	
	@RequestMapping(value = "listOrders")
	public void listOrders(){
		LinkedList<Order> orders = new LinkedList<>();
		
		for(Order o : orders){
			o.toString();
		}
	}
}
