package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductPriceChangedIntegrationEvent extends IntegrationEvent {

    public int productId;
    public double newPrice;
    public double oldPrice;
}
