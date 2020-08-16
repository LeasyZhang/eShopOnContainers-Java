package com.eshop.api.catalog.exception;

public class CatalogDomainException extends RuntimeException {

    private String message;

    public CatalogDomainException(String message) {
        this.message = message;
    }

    public CatalogDomainException(String message, Exception e) {
        super(message, e);
    }
}
