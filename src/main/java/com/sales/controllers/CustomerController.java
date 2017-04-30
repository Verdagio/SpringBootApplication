package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/showCustomers")
	public String showCustomers(Model m){
		
		//list customers in the list
		ArrayList<Customer> customers = customerService.getAll();

		
		m.addAttribute("customers", customers);
		
		return "showCustomers";
	}//list customers
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getCustomers(@ModelAttribute("customer1") Customer c, HttpServletRequest req){
		
		return "addCustomer";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomers(@Valid @ModelAttribute("customer1") Customer c, BindingResult res, HttpServletRequest req, Model m){
		
		ArrayList<Customer> customers;
		
		if(!(res.hasErrors())){								
				customerService.save(c);											
				customers = customerService.getAll();						
				m.addAttribute("customers", customers);
				
				return "showCustomers";


			
		}else{	return "addCustomer";	}//if else if
		
	}//add customer
}//cust ctrl
