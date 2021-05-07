package com.eshoppingzone.Testings;

import com.eshoppingzone.entity.Product;
import com.eshoppingzone.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceTestCases {

    @Autowired
    private ProductService productService;

    private Product product;
    private Object NoSuchElementException;

    @BeforeEach
    public void setUp() {

        List<String> images = new ArrayList<>();
        images.add("image.png");

        product = new Product(
                1,
                "mobile",
                "iPhone10",
                "gadgets",
                59000.0,
                "Good Phone",
                images
        );

        productService.addProduct(product);
    }

    // JUnit5 Test Case for getAllProducts service Method
    @Test
    public void getAllProductsTest() throws Exception {
        List<Product> products = productService.getAllProducts();
        assertEquals(1 , products.size());
    }

    // JUnit5 Test Case for getProductByID service Method
    @Test
    public void getProductByIdTest() throws Exception {
        Optional<Product> found = productService.getProductById(1);
        assertEquals(product , found.get());
    }

    // JUnit5 Test Case for getProductById when given productId is not available
    @Test
    public void getProductByIdWhenProductNotAvailable() {
        Optional<Product> found = productService.getProductById(100);
        assertThrows(NoSuchElementException.class , () -> {
            found.get().getProductId();
        });
    }

    // JUnit5 Test Case for getProductByName service Method
    @Test
    public void getProductByNameTest() throws Exception {
        Optional<Product> found = productService.getProductByName("iPhone10");
        assertEquals(product , found.get());
    }

    // JUnit5 Test Case for getProductByName when given productName is not available
    @Test
    public void getProductByNameWhenProductNotAvailable() {
        Optional<Product> found = productService.getProductByName("iPhone12");
        assertThrows(NoSuchElementException.class , () -> {
            found.get().getProductName();
        });
    }

    // JUnit5 Test Case for updateProduct Service Method
    @Test
    public void updateProductTest() throws Exception {
        Product found = productService.getProductById(1).get();
        found.setPrice(40000.0);
        Product updateProduct = productService.updateProduct(found);
        assertEquals(found , updateProduct);
    }

    // JUnit5 Test Case for deleteProduct Service Method
    @Test
    public void deleteProductTest() throws Exception {
        productService.deleteProductById(1);
        Optional<Product> found = productService.getProductById(1);
        assertFalse(found.isPresent());
    }
}
