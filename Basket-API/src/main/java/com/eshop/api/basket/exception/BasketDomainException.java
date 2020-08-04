package com.eshop.api.basket.exception;

public class BasketDomainException extends Exception {

    private String message;

    public BasketDomainException(String message) {
        super(message);
    }

    public BasketDomainException(String message, Exception e) {
        super(message, e);
    }
}
