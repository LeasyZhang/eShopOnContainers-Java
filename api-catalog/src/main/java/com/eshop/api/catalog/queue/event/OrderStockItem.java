package com.eshop.api.catalog.queue.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class OrderStockItem {

    public int productId;
    public int units;
}
