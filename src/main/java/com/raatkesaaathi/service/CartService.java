package com.raatkesaaathi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raatkesaaathi.entity.CartItem;
import com.raatkesaaathi.entity.Product;

@Service
public class CartService {

    private List<CartItem> cart = new ArrayList<>();

    // Add Product
    public void addToCart(Product product) {

        for (CartItem item : cart) {

            if (item.getId().equals(product.getId())) {

                item.setQuantity(item.getQuantity() + 1);
                return;

            }

        }

        CartItem item = new CartItem(
                product.getId(),
                product.getName(),
                product.getImage(),
                product.getPrice(),
                1
        );

        cart.add(item);
    }

    // Increase Quantity
    public void increaseQuantity(Long id) {

        for (CartItem item : cart) {

            if (item.getId().equals(id)) {

                item.setQuantity(item.getQuantity() + 1);
                return;

            }

        }

    }

    // Decrease Quantity
    public void decreaseQuantity(Long id) {

        for (CartItem item : cart) {

            if (item.getId().equals(id)) {

                if (item.getQuantity() > 1) {

                    item.setQuantity(item.getQuantity() - 1);

                } else {

                    cart.remove(item);

                }

                return;
            }

        }

    }

    // Get Cart
    public List<CartItem> getCartItems() {
        return cart;
    }

    // Total Amount
    public Double getTotalAmount() {

        double total = 0;

        for (CartItem item : cart) {

            total += item.getTotalPrice();

        }

        return total;
    }

    // Remove Item
    public void removeItem(Long id) {

        cart.removeIf(item -> item.getId().equals(id));

    }

    // Clear Cart
    public void clearCart() {

        cart.clear();

    }

}