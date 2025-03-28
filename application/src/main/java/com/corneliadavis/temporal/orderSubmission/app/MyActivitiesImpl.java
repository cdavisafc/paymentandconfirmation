package com.corneliadavis.temporal.orderSubmission.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.corneliadavis.temporal.orderSubmission.shared.OrderProcessingInput;

import com.corneliadavis.temporal.thirdparties.shared.PaymentProcessingInput;
import com.corneliadavis.temporal.thirdparties.shared.PaymentProcessingResult;

@Component
public class MyActivitiesImpl implements MyActivities {

    private static final Logger logger = LoggerFactory.getLogger(MyActivitiesImpl.class);

    @Autowired
    public MyActivitiesImpl() {
    }

    @Override
    public String processPayment(OrderProcessingInput orderProcessingInput) {
        logger.info("Processing payment for order " + orderProcessingInput.getOrderNumber());

        PaymentProcessingInput paymentProcessingInput = new PaymentProcessingInput(
                orderProcessingInput.getName(),
                orderProcessingInput.getTotalPrice(),
                "USD",
                "CREDIT_CARD",
                orderProcessingInput.getCardNumber(),
                orderProcessingInput.getExpiry());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PaymentProcessingResult> respConns = restTemplate.postForEntity(
            "http://localhost:8081/processpayment", 
            paymentProcessingInput, 
            PaymentProcessingResult.class);


        if (respConns.getStatusCode().is2xxSuccessful() && respConns.getBody() != null) {
            String confirmationNumber = respConns.getBody().getConfirmationNumber();
            return confirmationNumber;
        } else {
            throw new RuntimeException("Payment processing failed with status: " + respConns.getStatusCode());
        }

    }

    @Override
    public void recordPayment(RecordPaymentInput recordPaymentInput) {
        logger.info("Recording payment for order " + recordPaymentInput.getOrderNumber());
        logger.info("Payment confirmation number = " + recordPaymentInput.getPaymentConfirmationNumber());
        logger.info("Payment amount = " + recordPaymentInput.getAmount());
        
        return;
    }

    @Override
    public void sendEmail(SendEmailInput sendEmailInput) {
        logger.info("Sending email for order " + sendEmailInput.getOrder().getOrderNumber() );
        logger.info("email body = " + sendEmailInput.getEmailMesage());

    }

    @Override
    public ProcessOrderOutput processOrder(OrderProcessingInput orderProcessingInput) {
        logger.info("Processing order " + orderProcessingInput.getOrderNumber());
        // Logic to process order
        return new ProcessOrderOutput(java.util.UUID.randomUUID().toString());
    }

}
