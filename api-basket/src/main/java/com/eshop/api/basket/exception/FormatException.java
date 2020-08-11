package com.eshop.api.basket.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormatException extends RuntimeException {

    private String message;

    public FormatException(String message) {
        super(message);
    }
}
