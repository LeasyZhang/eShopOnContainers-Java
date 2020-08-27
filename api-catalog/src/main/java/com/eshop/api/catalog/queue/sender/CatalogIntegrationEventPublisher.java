package com.eshop.api.catalog.queue.sender;

import com.eshop.api.catalog.queue.event.IntegrationEvent;
import com.google.gson.Gson;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CatalogIntegrationEventPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchangeCatalog;


    public void publish(IntegrationEvent event) {
        rabbitTemplate.convertAndSend(exchangeCatalog.getName(), event.getKey(), new Gson().toJson(event));
    }

    public void saveEvent(IntegrationEvent event) {
        //persist event in database
    }
}
