package com.eshop.api.catalog.queue.service;

import com.eshop.api.catalog.queue.event.IntegrationEvent;

public class CatalogIntegrationEventService implements ICatalogIntegrationEventService {
    @Override
    public void saveEventAndCatalogContextChangesAsync(IntegrationEvent evt) {

    }

    @Override
    public void publishThroughEventBusAsync(IntegrationEvent evt) {

    }
}
