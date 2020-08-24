package com.eshop.api.catalog.queue.service;

import com.eshop.api.catalog.queue.event.IntegrationEvent;

import java.util.concurrent.CompletableFuture;

public interface ICatalogIntegrationEventService {

    void saveEventAndCatalogContextChangesAsync(IntegrationEvent evt);
    void publishThroughEventBusAsync(IntegrationEvent evt);
}
