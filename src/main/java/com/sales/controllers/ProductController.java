package com.sales.controllers;

import java.util.LinkedList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Product;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/addProducts")
	public String addProduct(@ModelAttribute ("product") Product p){
		//add a product to a list
		LinkedList<Product> products = new LinkedList<>();	
		
		products.add(p);
		
		System.out.println("product: " + p.toString());
		return "addProductPage";
	}//add
	
	@RequestMapping(value = "/listProducts")
	public void listProducts(){
		LinkedList<Product> products = new LinkedList<>();
		//for each product in the list print it out
		for(Product p : products){
			p.toString();
		}//for
	}//list products
	
	
}
