package com.eshop.api.basket.model;

import lombok.Data;

import java.time.Instant;

@Data
public class BasketCheckout {

    public String city;

    public String street;

    public String state;

    public String country;

    public String zipCode;

    public String cardNumber;

    public String cardHolderName;

    public Instant cardExpiration;

    public String cardSecurityNumber;

    public int cardTypeId;

    public String buyer;

    public String requestId;
}
