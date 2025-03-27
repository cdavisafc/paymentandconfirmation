package com.corneliadavis.temporal.orderSubmission.shared;

import java.io.Serializable;

public class OrderProcessingInput implements Serializable {
    private String name;
    private String address;
    private String cardNumber;
    private String expiry;
    private String cvv;
    private Long orderNumber;   

    // default constructor
    public OrderProcessingInput() {
    }
    
    // constructor talking all arguments
    public OrderProcessingInput(String name, String address, String cardNumber, String expiry, String cvv, Long orderNumber) {
        this.name = name;
        this.address = address;
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
        this.orderNumber = orderNumber;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }   

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

}
