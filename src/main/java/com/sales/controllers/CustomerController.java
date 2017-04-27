package com.sales.controllers;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Customer;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "/addCustomers")
	public void addCustomer(Customer c){
		//add a new customer to a list of customers
		LinkedList<Customer> customers = new LinkedList<>();
		
		customers.add(c);
	}//add customer
	
	@RequestMapping(value = "/listCustomers")
	public void listCustomers(){
		
		//list customers in the list
		LinkedList<Customer> customers = new LinkedList<>();
		
		for(Customer c : customers){
			c.toString();
		}//for
	}//list customers
}//cust ctrl
