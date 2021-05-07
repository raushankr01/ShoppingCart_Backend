package com.eshoppingzone.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.eshoppingzone.entity.Cart;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // JUnit5 Test Case for getAllCarts Rest Controller
    @Test
    public void getCartsTest() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/carts/allCarts" , String.class);
        assertEquals(responseEntity.getStatusCode() , HttpStatus.OK);
    }

    // JUnit5 Test Case when try to getAllCarts using Post Method type
    @Test
    public void getCartsWhenMethodTypeIsPost() throws Exception {
        Cart cart = new Cart();
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/carts/allCarts" , cart , String.class);
        assertEquals(responseEntity.getStatusCode() , HttpStatus.METHOD_NOT_ALLOWED);
    }

    // JUnit5 Test Case for getCartById Rest Controller
    @Test
    public void getCartByIdTest() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/carts/getCart/5" , String.class);
        assertEquals(responseEntity.getStatusCode() , HttpStatus.FOUND);
    }

    // JUnit5 Test Case for getCartById when Cart is not available
    @Test
    public void getCartByIdTestWhenCartNotAvailable() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/carts/getCart/100" , String.class);
        assertEquals(responseEntity.getStatusCode() , HttpStatus.NOT_FOUND);
    }

    // JUnit5 Test Case for getCartById when pass Id as a String
    @Test
    public void getCartByIdBadRequest() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/carts/getCart/product" , String.class);
        assertEquals(responseEntity.getStatusCode() , HttpStatus.BAD_REQUEST);
    }
}
