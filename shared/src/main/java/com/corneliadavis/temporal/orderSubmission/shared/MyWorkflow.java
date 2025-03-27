package com.corneliadavis.temporal.orderSubmission.shared;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MyWorkflow {

    // This workflow will be invoked via the RESTController which has an endpoint for 
    // order processing.
    @WorkflowMethod
    OrderProcessingOutput processOrder(OrderProcessingInput orderProcessingInput);
}