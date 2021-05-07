package com.eshoppingzone.resource;


import com.eshoppingzone.entity.Product;
import com.eshoppingzone.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductResource {

    @Autowired
    private ProductServiceImpl productService;

    // Adding a new Product
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    // Get all Products available
    @GetMapping("/allProduct")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts() , HttpStatus.OK);
    }

    // Get a single product based on Product ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> product = productService.getProductById(id);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get() , HttpStatus.FOUND);
    }

    // Get all Products based on Product Type
    @GetMapping("type/{productType")
    public ResponseEntity<List<Product>> getAllProductByType(@PathVariable("productType") String type) {
        return new ResponseEntity<>(productService.getProductByType(type) , HttpStatus.OK);
    }

    // Get a single Product based on Product Name
    @GetMapping("productName/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        Optional<Product> product = productService.getProductByName(name);
        if(!product.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get() , HttpStatus.FOUND);
    }

    // Get all Products based on Product Category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
        return new ResponseEntity<>(productService.getProductByCategory(category) , HttpStatus.OK);
    }

    // Updating a Product
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product) , HttpStatus.OK);
    }

    // Deleting a Product based on ProductId
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.deleteProductById(id);
    }

}
