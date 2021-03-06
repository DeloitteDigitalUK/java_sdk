package com.riskified.models;

import com.riskified.validations.*;

public class DecisionOrder implements IValidated {

    private String id;
    private DecisionDetails decision;

    public DecisionOrder(String id, DecisionDetails decision) {
        this.id = id;
        this.decision = decision;
    }

    public void validate(Validation validationType)
    throws FieldBadFormatException {
        if (validationType == Validation.ALL) {
            Validate.notNullOrEmpty(this, this.id, "Id");
            Validate.notNull(this, this.decision, "Decision");
        }
        if (this.decision != null) {
            this.decision.validate(validationType);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public DecisionDetails getDecision() {
        return decision;
    }


    public void setDecision(DecisionDetails decision) {
        this.decision = decision;
    }


}
