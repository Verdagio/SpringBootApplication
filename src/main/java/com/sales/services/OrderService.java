package com.sales.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.InvalidIdException;
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
		
		return (ArrayList<Order>) orderRepository.findAll();
	}// get list
	
	public Order save(Order order) throws Exception{
		
		customer = customerRepository.findOne(order.getCust().getcId());
		product = productRepository.findOne(order.getProd().getpId());
		
		if(customer == null || product == null){
			throw new InvalidIdException("May not be empty");
		} else if (order.getCust().getcId() != customer.getcId() || order.getProd().getpId() != product.getpId()){
			throw new InvalidIdException("Invalid Id");
		} else {
			product.setQtyInStock(product.getQtyInStock() - order.getQty());
			order.setOrderDate(df.format(date));
			order.getCust().setcName(customer.getcName());
			order.getProd().setpDesc(product.getpDesc());
			orderRepository.save(order);
			return orderRepository.save(order);
		}//if else i
		
		
	}//save
	
}//class
