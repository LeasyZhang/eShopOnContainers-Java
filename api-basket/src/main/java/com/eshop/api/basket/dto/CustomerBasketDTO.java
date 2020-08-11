package com.eshop.api.basket.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerBasketDTO {

    private String buyerId;

    private List<BasketItemDTO> basketItems;
}
