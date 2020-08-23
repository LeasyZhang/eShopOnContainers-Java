package com.eshop.api.basket.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasketItemDTO {

    public String id;
    public int productId;
    public String productName;
    public Double unitPrice;
    public Double oldUnitPrice;
    public int quantity;
    public String pictureUrl;
}
