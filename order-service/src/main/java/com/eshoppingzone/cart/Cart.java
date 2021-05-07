package com.eshoppingzone.cart;

import java.util.List;

public class Cart {

    private int cartId;
    private double totalPrice;
    private List<Items> items;

    public Cart() {

    }

    public Cart(int cartId , List<Items> items) {
        super();
        this.cartId = cartId;
        this.items = items;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
