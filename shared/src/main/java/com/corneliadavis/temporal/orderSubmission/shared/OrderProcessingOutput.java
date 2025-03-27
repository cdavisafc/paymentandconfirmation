package com.corneliadavis.temporal.orderSubmission.shared;

import java.io.Serializable;

public class OrderProcessingOutput implements Serializable {
    private String orderStatus;
    private Long orderNumber;
    private String message;

    // default constructor
    public OrderProcessingOutput() {
    }

    // constructor talking all arguments
    public OrderProcessingOutput(String orderStatus, Long orderNumber, String message) {
        this.orderStatus = orderStatus;
        this.orderNumber = orderNumber;
        this.message = message;
    }

    // Getters and setters
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
