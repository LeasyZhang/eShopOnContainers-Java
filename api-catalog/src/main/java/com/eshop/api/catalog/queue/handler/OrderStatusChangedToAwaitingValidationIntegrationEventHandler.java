package com.eshop.api.catalog.queue.handler;


import com.eshop.api.catalog.queue.event.OrderStatusChangedToAwaitingValidationIntegrationEvent;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Slf4j
public class OrderStatusChangedToAwaitingValidationIntegrationEventHandler {

    @RabbitListener(queues = "#{orderStatusChangedToAwaitingQueue.name}")
    public void handleOrderStatusEvent(String event) {
        log.info(event);
        OrderStatusChangedToAwaitingValidationIntegrationEvent parsedEvent = new Gson()
                .fromJson(event, OrderStatusChangedToAwaitingValidationIntegrationEvent.class);
        log.info(parsedEvent.toString());

    }

}
