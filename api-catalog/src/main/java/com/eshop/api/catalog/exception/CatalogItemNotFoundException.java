package com.eshop.api.catalog.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatalogItemNotFoundException extends RuntimeException {

    private String message;

    public CatalogItemNotFoundException() {

    }

    public CatalogItemNotFoundException(String message) {
        super(message);
    }

}
