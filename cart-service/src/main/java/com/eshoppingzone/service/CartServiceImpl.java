package com.eshoppingzone.service;

import com.eshoppingzone.entity.Cart;
import com.eshoppingzone.entity.Items;
import com.eshoppingzone.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartById(int cartId) {
        return cartRepository.findByCartId(cartId);
    }

    @Override
    public Cart updateCart(Cart cart) {
        cart.setTotalPrice(cartTotal(cart));
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public double cartTotal(Cart cart) {
        double totalPrice = 0.0;
        double cartPrice = 0.0;
        int count = 0;
        for (Items items: cart.getItems()) {
            totalPrice += items.getPrice() * items.getQuantity();
        }
        cartPrice += totalPrice;
        return cartPrice;
    }

    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }
}
