package com.corneliadavis.temporal.orderSubmission.controller;

public class OrderPayload {


    public static class OrderItem {
        private String name;
        private int quantity;
        private double price;

        // default constructor
        public OrderItem() {
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String itemName) {
            this.name = itemName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

    }
    private String name;
    private String address;
    private String email;
    private String cardNumber;
    private String expiry;
    private String cvv;
    private OrderItem[] orderItems;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public OrderItem[] getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

}