package com.sales.controllers;

import java.util.LinkedList;

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

	@RequestMapping(value = "/addOrders", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("order1") Order o, HttpServletRequest req){
		return "addOrders";
	}//get orders
	
	@RequestMapping(value = "/addOrders", method = RequestMethod.POST)
	public String postOrders(@ModelAttribute("order1") Order o, BindingResult res, HttpServletRequest req, Model m){
		
		LinkedList<Order> orders;
		
		if(!res.hasErrors()){
			try{
				oServe.save(o);
				
				orders = oServe.getList();
				
				for(Order tmp : orders){
					System.out.println(tmp.getoId());
				}
				
				m.addAttribute("orders", orders);
				
				return "listOrders";
			}catch(Exception e){
				e.printStackTrace();
				return "listOrders";
			}//try / catch

			
		}else{	return "addOrders";	}//if else
	}//post orders
	
	@RequestMapping(value = "listOrders")
	public void listOrders(Model m){
		LinkedList<Order> orders = oServe.getList();
		
		for(Order o : orders){
			System.out.println(o.getoId());
		}//for
		
		m.addAttribute("orders", orders);
	}//list orders
}
