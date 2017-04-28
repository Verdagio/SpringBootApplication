package com.sales.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public LinkedList<Product> getList(){
		return (LinkedList<Product>) productRepository.findAll();
	}//get list
	
	public Product save(Product p){
		return productRepository.save(p);
	}
}
