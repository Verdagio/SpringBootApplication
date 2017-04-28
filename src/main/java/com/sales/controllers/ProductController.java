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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService pServe;
	
	@RequestMapping(value = "/addProducts", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute ("product1") Product p){
		return "addProductPage";
	}//get prods
	
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public String postProduct(@ModelAttribute("product1") Product p, BindingResult res, HttpServletRequest req, Model m){
		LinkedList <Product> products;
		
		if(!res.hasErrors()){
			try{
				pServe.save(p);
				
				products = pServe.getList();
				
				for(Product tmp : products){
					System.out.println(tmp.getpId());
				}//for
				
				m.addAttribute("products", products);
				
				return "listProducts";
			}catch(Exception e){
				e.printStackTrace();
				return "listProducts";
			}// try catch

		} else {	return "addProducts";	}//if else if
	}//post products
	
	@RequestMapping(value = "/listProducts")
	public void listProducts(Model m){
		LinkedList<Product> products = pServe.getList();
		//for each product in the list print it out
		for(Product tmp : products){
			System.out.println(tmp.getpId());
		}//for
		
		m.addAttribute("products", products);
	}//list products
	
	
}
