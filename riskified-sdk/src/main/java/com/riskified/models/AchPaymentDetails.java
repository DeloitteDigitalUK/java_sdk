package com.riskified.models;

import com.riskified.validations.*;

public class AchPaymentDetails implements IPaymentDetails {

    private String routingNumber;

    public AchPaymentDetails(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public void validate(Validation validationType)
    throws FieldBadFormatException {
        if (validationType == validationType.ALL) {
            Validate.notNullOrEmpty(this, this.routingNumber, "Routing Number");
        }

    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

}
