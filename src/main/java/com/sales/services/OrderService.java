package com.sales.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.InvalidIdException;
import com.sales.exceptions.StockQtyException;
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
		

		if(customer == null ){											// null id passed
			throw new InvalidIdException("Customer id may not be empty");
		} else if (product == null){									// null id passed
			throw new InvalidIdException("Product id may not be empty");
		} else if (order.getCust().getcId() != customer.getcId()){		// wrong cust id
			throw new InvalidIdException("Invalid customer Id");
		} else if( order.getProd().getpId() != product.getpId()){		//wrong prod id
			throw new InvalidIdException("Invalid product Id");
		} else {
			
			if(product.getQtyInStock() > order.getQty()){
				product.setQtyInStock(product.getQtyInStock() - order.getQty());
				
			} else { //if there isn't enough stock throw an error
				throw new StockQtyException("Insufficient stock!! stock available = " + product.getQtyInStock()); 
			}
			order.setOrderDate(df.format(date));
			order.getCust().setcName(customer.getcName());
			order.getProd().setpDesc(product.getpDesc());
			orderRepository.save(order);
			return orderRepository.save(order);
		}//if else i
		
		
	}//save
	
}//class
