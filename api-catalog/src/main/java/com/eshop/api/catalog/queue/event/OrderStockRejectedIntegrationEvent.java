package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class OrderStockRejectedIntegrationEvent extends IntegrationEvent{

    public int orderId;

    public List<ConfirmedOrderStockItem> orderStockItems;

    @RequiredArgsConstructor
    @Getter
    class ConfirmedOrderStockItem {
        public int productId;
        public boolean hasStock;
    }
}
