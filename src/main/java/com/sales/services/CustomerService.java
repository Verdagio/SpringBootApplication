package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public ArrayList<Customer> getAll(){
		
		return (ArrayList <Customer>) customerRepository.findAll();
	}//get list
	
	public Customer save(Customer c){
		return customerRepository.save(c);
	}//save
}//class
