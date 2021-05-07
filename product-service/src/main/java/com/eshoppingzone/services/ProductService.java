package com.eshoppingzone.services;

import com.eshoppingzone.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Add a Product Function
    void addProduct(Product product);

    // Fetch all the Products Function
    List<Product> getAllProducts();

    // Fetch a Product Based on Product ID Function
    Optional<Product> getProductById(int id);

    // Fetch a Product Based on Product Name Function
    Optional<Product> getProductByName(String productName);

    // Update a Product Function
    Product updateProduct(Product product);

    // Delete a Product Function
    void deleteProductById(int id);

    // Fetch all Products Based on Product Category Function
    List<Product> getProductByCategory(String category);

    // Fetch all Products Based on Product Type Function
    List<Product> getProductByType(String type);
}
