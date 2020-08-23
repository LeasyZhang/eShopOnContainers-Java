package com.eshop.api.gateway.dto;

import lombok.Data;

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
