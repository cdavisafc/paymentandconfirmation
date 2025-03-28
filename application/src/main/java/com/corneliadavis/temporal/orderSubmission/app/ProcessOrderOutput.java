package com.corneliadavis.temporal.orderSubmission.app;

import java.io.Serializable;

public class ProcessOrderOutput implements Serializable {

    private String trackingNumber;

    // default constructor
    public ProcessOrderOutput() {
    }

    // constructor taking all arguments
    public ProcessOrderOutput(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    // Getters and setters
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
