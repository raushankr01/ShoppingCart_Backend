package com.eshoppingzone.service;


import com.eshoppingzone.cart.Cart;
import com.eshoppingzone.cart.Items;
import com.eshoppingzone.orders.Address;
import com.eshoppingzone.orders.Orders;
import com.eshoppingzone.repository.AddressRepository;
import com.eshoppingzone.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static int orderId = 1;
    int customerId;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void placeOrder(Cart cart) {
        int totalQuantity = 0;
        customerId = cart.getCartId();
        Orders orders = new Orders();
        orders.setAddress(orders.getAddress());
        orders.setAmountPaid(cart.getTotalPrice());
        orders.setCustomerId(cart.getCartId());
        orders.setModeOfPayment("COD");
        orders.setOrderStatus("Delivered");
        List<Items> itemsList = cart.getItems();
        for (Items item : itemsList) {
            totalQuantity += item.getQuantity();
        }
        orders.setQuantity(totalQuantity);
        orders.setOrderDate(LocalDate.now());
        orders.setOrderId(orderId++);
        orderRepository.save(orders);
    }

    @Override
    public String changeStatus(String orderStatus, int orderId) {
        Orders order = orderRepository.findById(orderId).get();
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return orderStatus;
    }

    @Override
    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<Orders> getOrderByCustomerId(int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public void storeAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public List<Address> getAddressByCustomerId(int customerId) {
        return addressRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Orders getOrderById() {
        return orderRepository.findFirstByOrderByOrderIdDesc();
    }

    @Override
    public Optional<Orders> getOrderById(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void onlinePayment(Cart cart) {
        int totalQuantity = 0;
        customerId = cart.getCartId();
        Orders orders = new Orders();
        orders.setAddress(orders.getAddress());
        orders.setAmountPaid(cart.getTotalPrice());
        orders.setCustomerId(cart.getCartId());
        orders.setModeOfPayment("Online");
        orders.setOrderStatus("Delivered");
        List<Items> itemsList = cart.getItems();
        for (Items item : itemsList) {
            totalQuantity += item.getQuantity();
        }
        orders.setQuantity(totalQuantity);
        orders.setOrderDate(LocalDate.now());
        orders.setOrderId(orderId++);
        orderRepository.save(orders);
    }
}
