package com.shoppingzone.model;

import java.time.LocalDate;

public class Orders {

    private int orderId;
    private LocalDate orderDate;
    private Integer customerId;
    private double ammountPaid;
    private String modeOfPayment;
    private String orderStatus;
    private int quantity;
    private Address address;
    private Product product;
    public Orders() {
        super();
    }

    public Orders(int orderId, LocalDate orderDate, Integer customerId, double ammountPaid, String modeOfPayment,
                  String orderStatus, int quantity, Address address, Product product) {
        super();
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.ammountPaid = ammountPaid;
        this.modeOfPayment = modeOfPayment;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
        this.address = address;
        this.product = product;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public double getAmmountPaid() {
        return ammountPaid;
    }

    public void setAmmountPaid(double ammountPaid) {
        this.ammountPaid = ammountPaid;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ", ammountPaid=" + ammountPaid +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", quantity=" + quantity +
                ", address=" + address +
                ", product=" + product +
                '}';
    }
}
