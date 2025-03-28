package com.corneliadavis.temporal.orderSubmission.app;

import java.io.Serializable;

public class RecordPaymentInput implements Serializable {
    private Long orderNumber;
    private String paymentConfirmationNumber;
    private double amount;
    

    // default constructor
    public RecordPaymentInput() {
    }

    // constructor talking all arguments
    public RecordPaymentInput(Long orderNumber, String paymentConfirmationNumber, double amount) {
        this.orderNumber = orderNumber;
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.amount = amount;
    }

    // Getters and setters
    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPaymentConfirmationNumber() {
        return paymentConfirmationNumber;
    }  

    public void setPaymentConfirmationNumber(String paymentConfirmationNumber) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
