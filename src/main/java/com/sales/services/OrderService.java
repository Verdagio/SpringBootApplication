package com.sales.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.*;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.OrderRepository;
import com.sales.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired 
	private ProductRepository productRepository;
		
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();
	private Customer customer;
	private Product product;
	
	public ArrayList<Order> getList(){
		
		return (ArrayList<Order>) orderRepository.findAll();					//get order data from the database...
	}// get list
	
	public void save(Order order) throws NullCIdException, NullPIdException, InvalidIdException, StockQtyException{
		
		customer = order.getCust();
		product = order.getProd();
		
		if(customer.getcId() == null ){						//no id entered
			throw new NullCIdException("No customer entered");
		}else if (product.getpId() == null){				//no id entered
			throw new NullPIdException( "No product entered");
		} 
		
		customer = customerRepository.findOne(order.getCust().getcId());
		product = productRepository.findOne(order.getProd().getpId());
		
		if (product == null) {							// invalid product id
			throw new InvalidIdException("Invalid Product: "+ order.getProd().getpId());
		} else if (customer == null) {							// invalid customer id
			throw new InvalidIdException("Invalid Customer: " + order.getCust().getcId());
		} else if (product.getQtyInStock() < order.getQty()){			// not enough stock
			throw new StockQtyException("Insufficient stock!! stock available = " + product.getQtyInStock() ); 
		} else {
			
			product.setQtyInStock(product.getQtyInStock() - order.getQty());	//update stock 
			order.setOrderDate(df.format(date));								//set the order date
			order.getCust().setcName(customer.getcName());						//set the orders buyer name
			order.getProd().setpDesc(product.getpDesc());						//set the orders product
			orderRepository.save(order);	
		}//if else if
	}//save
	
}//class
