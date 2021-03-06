package com.eshop.api.basket.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BasketItem {

    public String id;
    public int productId;
    public String productName;
    public Double unitPrice;
    public Double oldUnitPrice;
    public int quantity;
    public String pictureUrl;
}
