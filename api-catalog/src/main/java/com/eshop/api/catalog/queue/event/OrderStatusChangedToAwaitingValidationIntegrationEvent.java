package com.eshop.api.catalog.queue.event;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Data
@RequiredArgsConstructor
public class OrderStatusChangedToAwaitingValidationIntegrationEvent {

    private int orderId;
    private Collection<OrderStockItem> orderStockItems;

    @Getter
    @Setter
    @RequiredArgsConstructor
    public class OrderStockItem {
        public int productId;
        public int units;
    }
}
