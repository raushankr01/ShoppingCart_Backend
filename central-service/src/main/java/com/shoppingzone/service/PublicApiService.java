package com.shoppingzone.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shoppingzone.model.Product;

@Service
public class PublicApiService {
	/**
	 * Get all products
	 * get product By id
	 * get Product By Name
	 */
	
	@Autowired
	RestTemplate restTemplate;
	
	public static String _url = "http://product-service/products/";
	
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
	
	public Product getProductByName(String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = _url+"productName/{name}";
		
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);
		return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Product.class, name).getBody();
	}
}
