package com.berkayarslan.ProductEngage.erroremessage;


import com.berkayarslan.ProductEngage.general.BaseErrorMessage;

public enum ProductErrorMessage implements BaseErrorMessage {
    PRODUCT_NOT_FOUND("No products found in this category");

    private final String message;

    ProductErrorMessage(String message) {
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
