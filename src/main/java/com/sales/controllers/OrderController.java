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

import com.sales.exceptions.*;
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
	public String getOrder(@ModelAttribute("newOrder") Order o, HttpServletRequest req){
		return "addOrder";
	}//get orders
	
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST) 
	public String postOrders(@ModelAttribute("newOrder") Order o, BindingResult res, HttpServletRequest req, Model m)  {
		ArrayList<Order> orders;

				if(!(res.hasErrors())){
					try{
						oServe.save(o);
						orders = oServe.getList();
						m.addAttribute("orders", orders);				
						return "showOrders";
					}catch(NullCIdException | NullPIdException | StockQtyException | InvalidIdException e){
						
						m.addAttribute("message", e.getMessage());
						m.addAttribute("cId", o.getCust().getcId());
						m.addAttribute("pId", o.getProd().getpId());
						m.addAttribute("qty", o.getQty());
						return "oops";
					}
				}else{
					return "addOrder";
				}
				
	}//post orders



}
