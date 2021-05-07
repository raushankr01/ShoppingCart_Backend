package com.eshoppingzone.Testings;

import static org.junit.Assert.assertEquals;

import com.eshoppingzone.entity.Product;
import com.eshoppingzone.resource.ProductResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTestCases {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // JUnit TestCase for addProduct Rest Controller
    @Test
    public void testPostAPIMethods() throws Exception {
        List<String> images = new ArrayList<>();
        images.add("image.png");

        List<Product> productList = new ArrayList<>();

        Product product = new Product(
                1,
                "mobile",
                "iPhone10",
                "gadgets",
                59000.0,
                "Good Phone",
                images
        );

        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/products/addProduct" , product , String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    // JUnit TestCase for getAllProducts RestController
    @Test
    public void testForGetAllProducts() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products/allProduct", String.class);
        assertEquals(HttpStatus.OK , responseEntity.getStatusCode());
    }

    // JUnit TestCase for getProductById RestController
    @Test
    public void testForGetProductById() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products/id/1" , String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.FOUND);
    }

    // JUnit TestCase for getProductById RestController when productId does not exists
    @Test
    public void testForGetProductWhichDoesNotExists() throws Exception {
        ResponseEntity<ProductResource> responseEntity = testRestTemplate.getForEntity("/products/id/1001" , ProductResource.class);
        assertEquals(HttpStatus.NOT_FOUND , responseEntity.getStatusCode());
    }

    // JUnit TestCase for incorrect URL Request
    @Test
    public void testForIncorrectURL() throws Exception {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/products/hello" , String.class);
        assertEquals(HttpStatus.NOT_FOUND , responseEntity.getStatusCode());
    }
}
