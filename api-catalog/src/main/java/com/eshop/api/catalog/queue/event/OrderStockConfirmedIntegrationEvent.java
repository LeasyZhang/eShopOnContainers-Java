package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderStockConfirmedIntegrationEvent extends IntegrationEvent{

    private int orderId;
}
