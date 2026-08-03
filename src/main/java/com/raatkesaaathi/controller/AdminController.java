package com.raatkesaaathi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.raatkesaaathi.entity.Product;
import com.raatkesaaathi.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    // Admin Dashboard
    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin";
    }

    // Open Add Product Form
    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add-product";
    }

    // Save Product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin";
    }

    // Delete Product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin";
    }
 // View All Products
    @GetMapping("/products")
    public String viewProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return "admin-products";
    }
}