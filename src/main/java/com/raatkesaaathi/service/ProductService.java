package com.raatkesaaathi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raatkesaaathi.entity.Product;
import com.raatkesaaathi.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }


    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By Id
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}