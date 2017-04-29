package com.sales.controllers;

import java.util.LinkedList;

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
import com.sales.models.Order;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cServe;
	
	@RequestMapping(value = "/addCustomers", method = RequestMethod.GET)
	public String getCustomers(@ModelAttribute("customer1") Customer c, HttpServletRequest req){
		
		return "addCustomers";
	}
	
	@RequestMapping(value = "/addCustomers", method = RequestMethod.POST)
	public String postCustomers(@Valid @ModelAttribute("customer1") Customer c, BindingResult res, HttpServletRequest req, Model m){
		
		LinkedList<Customer> customers;
		
		if(!res.hasErrors()){								// test for & retrieve validation errors.
			
			try{
				cServe.save(c);									//save the customer to the list
				
				customers = cServe.getAll();					// put the list into the list...
				
				for(Customer tmp : customers){					//for each customer in the list
					System.out.println(tmp.getcId());			//print stuff
					
					for(Order o: tmp.getOrders()){				// for each order in the customers list
						System.out.println(o.getoId());			//print order stuff
					}//inner for
				}//outer for
				
				m.addAttribute("customers", customers);
				
				return "listCustomers";
			}catch(Exception e){
				e.printStackTrace();
				return "listCustomers";
			}// try catch

			
		}else{	return "addCustomers";	}//if else if
		
	}//add customer
	
	@RequestMapping(value = "/listCustomers")
	public void listCustomers(Model m){
		
		//list customers in the list
		LinkedList<Customer> customers = cServe.getAll();
		
		for(Customer c : customers){
			
			for(Order o : c.getOrders()){
				System.out.println(o.getoId());				
			}//innner for
		}//for
		
		m.addAttribute("customers", customers);
	}//list customers
	
	
}//cust ctrl
