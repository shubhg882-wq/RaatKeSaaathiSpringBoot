package com.raatkesaaathi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raatkesaaathi.service.ProductService;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/category/{category}")
    public String getProductsByCategory(@PathVariable String category, Model model) {

        model.addAttribute("products",
                productService.getProductsByCategory(category));

        return "products";
    }
}