package com.corneliadavis.temporal.orderSubmission.app;

import java.time.Duration;
import java.util.concurrent.Flow.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corneliadavis.temporal.orderSubmission.shared.MyWorkflow;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingOutput;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class MyWorkflowImpl implements MyWorkflow {

    private static final Logger logger = LoggerFactory.getLogger(MyWorkflowImpl.class);

    private final ActivityOptions defaultActivityOptions = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(2)) // Max execution time for single Activity
            .build();
    private final MyActivities activityStub = Workflow
            .newActivityStub(MyActivities.class, defaultActivityOptions, null);

    public OrderProcessingOutput processOrder(OrderProcessingInput orderProcessingInput) {

        logger.info("processing order #" + orderProcessingInput.getOrderNumber());

        // Process payment
        String confirmationNumber = activityStub.processPayment(orderProcessingInput);

        // record payment confirmation number
        activityStub.recordPayment(new RecordPaymentInput(
                orderProcessingInput.getOrderNumber(),
                confirmationNumber,
                orderProcessingInput.getTotalPrice()));

        // send order placed email
        String emailMessage = "Order #" + orderProcessingInput.getOrderNumber() + " has been placed. ";
        activityStub.sendEmail(new SendEmailInput(orderProcessingInput, emailMessage));

        // process order
        ProcessOrderOutput processOrderOutput = activityStub.processOrder(orderProcessingInput);

        // send order shipped email
        String emailMessage2 = "Order #" + orderProcessingInput.getOrderNumber() + " has been shipped. "
                + "Tracking number: " + processOrderOutput.getTrackingNumber();
        activityStub.sendEmail(new SendEmailInput(orderProcessingInput, emailMessage2));

        return new OrderProcessingOutput("ORDER SHIPPED", 
                          orderProcessingInput.getOrderNumber(), 
                          "tracking number " + processOrderOutput.getTrackingNumber());
    }

}