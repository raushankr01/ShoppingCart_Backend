package com.eshoppingzone.service;

import com.eshoppingzone.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    // Get a single Cart by CartId
    Cart getCartById(int cartId);

    // Update a particular Cart
    Cart updateCart(Cart cart);

    // Get all Carts available in Database
    List<Cart> getAllCarts();

    // calculate total price in the cart
    double cartTotal(Cart cart);

    // Add a new Cart
    Cart addCart(Cart cart);
}
