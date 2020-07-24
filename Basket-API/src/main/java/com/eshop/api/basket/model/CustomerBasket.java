package com.eshop.api.basket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CustomerBasket {

    public String buyerId;

    public List<BasketItem> items;

    public CustomerBasket(String customerId) {
        this.buyerId = customerId;
    }
}
