package com.corneliadavis.temporal.orderSubmission.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderProcessingInput implements Serializable {

    public static class OrderItem {
        private String itemName;
        private int quantity;
        private double price;

        // default constructor
        public OrderItem() {
        }
        // constructor taking all arguments
        public OrderItem(String itemName, int quantity, double price) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and setters
        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
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
    private Long orderNumber;
    private ArrayList<OrderItem> orderItems; 

    // default constructor
    public OrderProcessingInput() {
    }

    // constructor talking all arguments
    public OrderProcessingInput(String name, String address, String email, String cardNumber, String expiry, 
                                String cvv, Long orderNumber) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.cardNumber = cardNumber;
        this.expiry = expiry;
        this.cvv = cvv;
        this.orderNumber = orderNumber;
        this.orderItems = new ArrayList<>();
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

    public Long getOrderNumber() {
        return orderNumber;
    }   

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItem(String itemName, int quantity, double price) {
        this.orderItems.add(new OrderItem(itemName, quantity, price));
    }

}
