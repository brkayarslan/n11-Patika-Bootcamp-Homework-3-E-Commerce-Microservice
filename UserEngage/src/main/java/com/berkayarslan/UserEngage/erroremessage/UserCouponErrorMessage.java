package com.berkayarslan.UserEngage.erroremessage;

import com.berkayarslan.UserEngage.general.BaseErrorMessage;

public enum UserCouponErrorMessage implements BaseErrorMessage {
    USERS_COUPON_NOT_FOUND("No coupons found for the user!");

    private final String message;

    UserCouponErrorMessage(String message) {
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
