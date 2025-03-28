package com.corneliadavis.temporal.orderSubmission.app;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.corneliadavis.temporal.orderSubmission.shared.MyWorkflow;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingOutput;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

public class MyWorkflowImpl implements MyWorkflow {

    private static final Logger logger = LoggerFactory.getLogger(MyWorkflowImpl.class);

    // ActivityOptions specify the limits on how long an Activity can execute before
    // being interrupted by the Orchestration service. At least one of StartToClose or 
    // ScheduleToClose must be set
    private final ActivityOptions defaultActivityOptions = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofSeconds(2)) // Max execution time for single Activity
            .build();

    // ActivityStubs enable calls to methods as if the Activity object is local but
    // actually perform an RPC invocation
    private final MyActivities activityStub = Workflow
            .newActivityStub(MyActivities.class, defaultActivityOptions, null);

    public OrderProcessingOutput processOrder(OrderProcessingInput orderProcessingInput) {

        logger.info("processing order #" + orderProcessingInput.getOrderNumber());

        // Process payment
        String confirmationNumber = activityStub.processPayment(orderProcessingInput);

        // record payment confirmation number
        logger.info("Payment processed for order " + orderProcessingInput.getOrderNumber() + " with confirmation number "
                + confirmationNumber);

        // send order placed email

        // process order
        String trackingNumber = "1234";

        // send order shipped email

        return new OrderProcessingOutput("ORDER SHIPPED", orderProcessingInput.getOrderNumber(), "tracking number " + trackingNumber);
    }

}