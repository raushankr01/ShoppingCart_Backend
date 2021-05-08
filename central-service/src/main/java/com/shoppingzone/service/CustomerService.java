package com.shoppingzone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	/**
	 * add product to cart
	 * remove product from cart
	 * order product
	 */
	@Autowired
	RestTemplate restTemplate;
	
	public static String _url = "";
}
