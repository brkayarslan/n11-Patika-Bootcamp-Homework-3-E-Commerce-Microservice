package com.berkayarslan.UserEngage.erroremessage;

import com.berkayarslan.UserEngage.general.BaseErrorMessage;

public enum ReviewErrorMessage implements BaseErrorMessage {

    REVIEW_NOT_FOUND("No comments found for this user");

    private final String message;


    ReviewErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return message;
    }
}
