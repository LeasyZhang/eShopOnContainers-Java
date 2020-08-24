package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
public class OrderStatusChangedToPaidIntegrationEvent extends IntegrationEvent{

    private int orderId;
    private Collection<OrderStockItem> orderStockItems;

}
