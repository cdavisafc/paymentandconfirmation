package com.corneliadavis.temporal.orderSubmission.app;

import java.io.Serializable;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;

public class SendEmailInput implements Serializable {


    private OrderProcessingInput order;
    private String emailMesage;

    // default constructor
    public SendEmailInput() {
    }

    // constructor taking all arguments
    public SendEmailInput(OrderProcessingInput order, String emailMesage) {
        this.order = order;
        this.emailMesage = emailMesage;
    }
    // Getters and setters
    public OrderProcessingInput getOrder() {
        return order;
    }
    public void setOrder(OrderProcessingInput order) {
        this.order = order;
    }
    public String getEmailMesage() {
        return emailMesage;
    }
    public void setEmailMesage(String emailMesage) {
        this.emailMesage = emailMesage;
    }
}
