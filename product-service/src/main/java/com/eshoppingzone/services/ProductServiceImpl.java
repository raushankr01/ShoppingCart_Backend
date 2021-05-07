package com.eshoppingzone.services;

import com.eshoppingzone.entity.Product;
import com.eshoppingzone.exception.ResourceNotFoundException;
import com.eshoppingzone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(int id) {
        return Optional.ofNullable(productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + id)));
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        return Optional.ofNullable(productRepository.findByProductName(productName));
    }

    @Override
    public Product updateProduct(Product product) {
        Product update = productRepository.findById(product.getProductId()).get();
        update.setCategory(product.getCategory());
        update.setDescription(product.getDescription());
        update.setImage(product.getImage());
        update.setProductName(product.getProductName());
        update.setProductType(product.getProductType());
        update.setPrice(product.getPrice());
        return productRepository.save(update);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getProductByType(String type) {
        return productRepository.findByProductType(type);
    }
}
