package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public ArrayList<Product> getList(){
		return (ArrayList<Product>) productRepository.findAll();
	}//get list
	
	public Product save(Product p){
		return productRepository.save(p);
	}
}
