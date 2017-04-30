package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Order;
import com.sales.services.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService oServe;

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showOrders(Model m){
		ArrayList<Order> orders = oServe.getList();
		m.addAttribute("orders", orders);		
		return "showOrders";
	}//list orders

	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("order1") Order o, HttpServletRequest req){
		return "addOrder";
	}//get orders
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postOrders(@ModelAttribute("order1") Order o, BindingResult res, HttpServletRequest req, Model m) throws Exception{
		
		ArrayList<Order> orders;
		
		if(!res.hasErrors()){

				oServe.save(o);			
				orders = oServe.getList();
				m.addAttribute("orders", orders);				
				return "showOrders";
			
		}else{	return "addOrder";	}//if else
	}//post orders

}
