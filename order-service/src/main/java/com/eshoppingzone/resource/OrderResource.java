package com.eshoppingzone.resource;

import com.eshoppingzone.cart.Cart;
import com.eshoppingzone.orders.Address;
import com.eshoppingzone.orders.Orders;
import com.eshoppingzone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping("/allOrders")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/allAddress")
    public List<Address> getAllAddress() {
        return orderService.getAllAddress();
    }

    @GetMapping("/orders/{customerId}")
    public List<Orders> getOrderByCustomerId(@PathVariable("customerId") int customerId) {
        return orderService.getOrderByCustomerId(customerId);
    }

    @GetMapping("/address/{customerId}")
    public List<Address> getAddressByCustomerId(@PathVariable("customerId") int customerId) {
        return orderService.getAddressByCustomerId(customerId);
    }

    @GetMapping("/orderId")
    public Orders findMAXByOrderId() {
        return orderService.getOrderById();
    }

    @PostMapping("/cashOnDelivery")
    public void placeOrder(@RequestBody Cart cart) {
        orderService.placeOrder(cart);
    }

    @PostMapping("/walletPayment")
    public void onlinePayment(@RequestBody Cart cart) {
        orderService.onlinePayment(cart);
    }

    @PostMapping("/addAddress")
    public void storeAddress(@RequestBody Address address) {
        orderService.storeAddress(address);
    }

    @PutMapping("/changeStatus/{orderId}")
    public void changeStatus(@RequestParam String orderStatus , @PathVariable("orderId") int orderId) {
        orderService.changeStatus(orderStatus , orderId);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") int orderId) {
        Optional<Orders> order = orderService.getOrderById(orderId);
        if(!order.isPresent()) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
