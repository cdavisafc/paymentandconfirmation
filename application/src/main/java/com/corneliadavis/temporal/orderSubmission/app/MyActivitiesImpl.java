package com.corneliadavis.temporal.orderSubmission.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;


@Component
public class MyActivitiesImpl implements MyActivities {

    private static final Logger logger = LoggerFactory.getLogger(MyActivitiesImpl.class);

    @Autowired
    public MyActivitiesImpl() {
    }

    @Override
    public String processPayment(OrderProcessingInput orderProcessingInput) {
        logger.info("Processing payment for order " + orderProcessingInput.getOrderNumber());


        String confirmationNumber = "ab1234";

        return confirmationNumber;
    }

}
