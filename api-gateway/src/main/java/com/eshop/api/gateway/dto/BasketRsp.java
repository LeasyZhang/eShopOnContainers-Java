package com.eshop.api.gateway.dto;

import lombok.Data;

import java.util.List;

@Data
public class BasketRsp {

    private String buyerId;
    private List<BasketItemDTO> basketItems;
}
