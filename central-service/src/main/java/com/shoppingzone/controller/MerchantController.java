package com.shoppingzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingzone.model.Product;
import com.shoppingzone.model.RequestResult;
import com.shoppingzone.service.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
	/**
	 * Add product
	 * update product
	 * delete product
	 * get all products
	 * get product by id
	 */
	@Autowired
	MerchantService merchantService;
	
	@PostMapping("/addNewProduct")
	public RequestResult addNewProduct(@RequestBody Product product) {
		return merchantService.addNewProduct(product);
	}
	@GetMapping("getProductById/{id}")
	public Product getProductById(@PathVariable String id) {
		return merchantService.getProductById(id);
	}
	
	@PutMapping("/updateProduct")
	public RequestResult updateProduct(@RequestBody Product product) {
		return merchantService.updateProduct(product);
	}
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts(){
		return merchantService.getAllProducts();
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public RequestResult deleteProductById(@PathVariable String id) {
		return merchantService.deletProductById(id);
	}
}
