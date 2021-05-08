package com.shoppingzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingzone.model.Product;
import com.shoppingzone.service.PublicApiService;

//•	User can search for a product without login and access the website

@RestController
@RequestMapping("/public")
public class PublicApiController {
	/**
	 * Get all products
	 * get product By id
	 * get Product By Name
	 */
	@Autowired
	PublicApiService publicService;
	
	@GetMapping("getProductById/{id}")
	public Product getProductById(@PathVariable String id) {
		return publicService.getProductById(id);
	}
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return publicService.getAllProducts();
	}
	@GetMapping("/getProductByName/{name}")
	public Product getAllProductsByName(@PathVariable String name){
		return publicService.getProductByName(name);
	}
}
