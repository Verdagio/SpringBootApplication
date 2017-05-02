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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProducts(Model m){
		ArrayList<Product> products = productService.getList();
		//for each product in the list print it out		
		m.addAttribute("products", products);
		
		return "showProducts";
	}//list products
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute ("newProduct") Product p){
		return "addProduct";
	}//get prods
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("newProduct") Product p, BindingResult res, HttpServletRequest req, Model m){
		ArrayList <Product> products;
		
		if(!(res.hasErrors())){
				productService.save(p);
				products = productService.getList();
				m.addAttribute("products", products);
				return "showProducts";
		} else {	return "addProduct";	}//if else if
	}//post products
}
