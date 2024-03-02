package com.berkayarslan.UserEngage.erroremessage;

import com.berkayarslan.UserEngage.general.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {
    USER_NOT_FOUND("User not found");

    private final String message;

    UserErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
