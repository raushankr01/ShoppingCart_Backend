package com.eshoppingzone.orders;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {

    private int customerId;
    private String fullName;
    private String mobileNumber;
    private int flatNumber;
    private String city;
    private int pinCode;
    private String state;

    public Address() {
        super();
    }

    public Address(int customerId, String fullName, String mobileNumber, int flatNumber, String city, int pinCode, String state) {
        super();
        this.customerId = customerId;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.pinCode = pinCode;
        this.state = state;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", flatNumber=" + flatNumber +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                '}';
    }
}
