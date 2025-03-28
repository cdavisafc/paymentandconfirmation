package com.corneliadavis.temporal.orderSubmission.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corneliadavis.temporal.orderSubmission.shared.MyWorkflow;
import com.corneliadavis.temporal.orderSubmission.shared.Shared;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;
import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingOutput;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class RESTController {

    private static final Logger logger = LoggerFactory.getLogger(RESTController.class);

    @RequestMapping(method = RequestMethod.POST, value = "/submitOrder")
    public String submitOrderWorkflow(@RequestBody OrderPayload payload, HttpServletResponse response) {

        // First thing we will do is generate an order number. This will be used to track the order
        // and to correlate the order with the payment processing and subsequent steps.
        Long orderNumber = (long) (Math.random() * 100000);
        logger.info("Generated order number: " + orderNumber);

        // A WorkflowServiceStubs communicates with the Temporal front-end service.
        WorkflowServiceStubs serviceStub = WorkflowServiceStubs.newLocalServiceStubs();

        // A WorkflowClient wraps the stub.
        // It can be used to start, signal, query, cancel, and terminate Workflows.
        WorkflowClient client = WorkflowClient.newInstance(serviceStub);

        // Workflow options configure Workflow stubs.
        // A WorkflowId prevents duplicate instances, which are removed.
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.TASK_QUEUE)
                .setWorkflowId("order-" + orderNumber)
                .build();

        // WorkflowStubs enable calls to methods as if the Workflow object is local
        // but actually perform a gRPC call to the Temporal Service.
        MyWorkflow workflow = client.newWorkflowStub(MyWorkflow.class, options);


        logger.info("submitting order #" + orderNumber + " for processing");
        // Call the Workflow method. This is a blocking call.
        // The Workflow method will return when the Workflow completes.
        OrderProcessingInput orderInput = new OrderProcessingInput(payload.getName(),
                payload.getAddress(),
                payload.getEmail(),
                payload.getCardNumber(),
                payload.getExpiry(),
                orderNumber);
        // iterate over the order items and add them to the order input
        for (OrderPayload.OrderItem item : payload.getOrderItems()) {
            orderInput.addOrderItem(item.getName(), item.getQuantity(), item.getPrice());
        }
       OrderProcessingOutput orderResult = workflow.processOrder(orderInput);

        return orderResult.getOrderStatus();

    }

}
