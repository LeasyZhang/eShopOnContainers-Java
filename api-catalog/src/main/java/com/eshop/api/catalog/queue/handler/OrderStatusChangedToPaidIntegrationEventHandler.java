package com.eshop.api.catalog.queue.handler;


import com.eshop.api.catalog.queue.event.OrderStatusChangedToPaidIntegrationEvent;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class OrderStatusChangedToPaidIntegrationEventHandler {

    @RabbitListener(queues = "#{orderStatusChangedToPaidQueue.name}")
    public void handleOrderStatusEvent(String event) {
        log.info(event);

        OrderStatusChangedToPaidIntegrationEvent parsedEvent = new Gson()
                .fromJson(event, OrderStatusChangedToPaidIntegrationEvent.class);
        log.info(parsedEvent.toString());
    }

}
