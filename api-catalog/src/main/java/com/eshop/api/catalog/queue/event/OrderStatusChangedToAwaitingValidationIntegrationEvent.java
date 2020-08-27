package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Getter
@RequiredArgsConstructor
@ToString
public class OrderStatusChangedToAwaitingValidationIntegrationEvent extends IntegrationEvent{

    private int orderId;
    private Collection<OrderStockItem> orderStockItems;

}
