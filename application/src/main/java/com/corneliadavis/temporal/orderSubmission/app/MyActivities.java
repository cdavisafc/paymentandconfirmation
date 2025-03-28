package com.corneliadavis.temporal.orderSubmission.app;

import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface MyActivities {

    @ActivityMethod
    String processPayment(OrderProcessingInput orderProcessingInput);

    @ActivityMethod
    void recordPayment(RecordPaymentInput recordPaymentInput);

    @ActivityMethod
    void sendEmail(SendEmailInput sendEmailInput);

    @ActivityMethod
    ProcessOrderOutput processOrder(OrderProcessingInput orderProcessingInput);

}
