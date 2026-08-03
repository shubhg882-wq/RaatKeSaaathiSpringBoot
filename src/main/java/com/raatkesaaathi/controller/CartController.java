package com.raatkesaaathi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.raatkesaaathi.entity.Product;
import com.raatkesaaathi.service.CartService;
import com.raatkesaaathi.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    // Add Product To Cart
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id) {

        Product product = productService.getProductById(id);

        if (product != null) {
            cartService.addToCart(product);
        }

        return "redirect:/";
    }

    // View Cart
    @GetMapping
    public String viewCart(Model model) {

        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());

        return "cart";
    }

    // Remove Product
    @GetMapping("/remove/{id}")
    public String removeItem(@PathVariable Long id) {

        cartService.removeItem(id);

        return "redirect:/cart";
    }

    // Clear Cart
    @GetMapping("/clear")
    public String clearCart() {

        cartService.clearCart();

        return "redirect:/cart";
    }
 // Increase Quantity
    @GetMapping("/increase/{id}")
    public String increaseQuantity(@PathVariable Long id) {

        cartService.increaseQuantity(id);

        return "redirect:/cart";
    }

    // Decrease Quantity
    @GetMapping("/decrease/{id}")
    public String decreaseQuantity(@PathVariable Long id) {

        cartService.decreaseQuantity(id);

        return "redirect:/cart";
    }

}