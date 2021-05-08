package com.shoppingzone.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingzone.model.Product;
import com.shoppingzone.model.RequestResult;

@Service
public class MerchantService {

	/**
	 * Add product
	 * update product
	 * delete product
	 * get all products
	 * get product by id
	 */
	
	@Autowired
	RestTemplate restTemplate;
	
	public static String _url = "http://product-service/products/";
	
	// http://product-service/products
	public RequestResult addNewProduct(Product product) {
		restTemplate.postForObject(_url+"addProduct", product, void.class);
		return new RequestResult("OK", "Success");
	}
	
	public RequestResult updateProduct(Product product) {
		RequestEntity<Product> entity = RequestEntity
				.put(_url+"updateProduct")
				.accept(MediaType.APPLICATION_JSON)
				.body(product);
		ResponseEntity<Product> myExchangeRes = restTemplate.exchange(entity, Product.class);
		return new RequestResult("OK", "Success");
	}
	
	public RequestResult deletProductById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = _url+"delete/{id}";
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		
		ResponseEntity<?> myRes = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, void.class, id);
		
		return new RequestResult("OK", "Success");
	}
	
	
	
	public List<Product> getAllProducts() {
		ResponseEntity<Object[]> myList = restTemplate.getForEntity(_url+"allProduct", Object[].class);
		/**
		 * 
		 */
		ObjectMapper mapper = new ObjectMapper();
		List<Product> finalList = Arrays.stream(myList.getBody())
				.map(obj->mapper.convertValue(obj, Product.class)).collect(Collectors.toList());
		return finalList;
	}
	
	public Product getProductById(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = _url+"id/{id}";
		
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product.class, id).getBody();
	}
}
