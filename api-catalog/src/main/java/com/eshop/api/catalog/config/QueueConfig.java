package com.eshop.api.catalog.config;

import com.eshop.api.catalog.queue.handler.OrderStatusChangedToAwaitingValidationIntegrationEventHandler;
import com.eshop.api.catalog.queue.handler.OrderStatusChangedToPaidIntegrationEventHandler;
import com.eshop.api.catalog.queue.sender.CatalogIntegrationEventPublisher;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    public static final String TOPIC_CATALOG = "eshop.topic.catalog";
    public static final String QUEUE_ORDER_STATUS_PAID = "eshop.queue.order_status_changed_to_paid";
    public static final String QUEUE_ORDER_STATUS_AWAITING = "eshop.queue.order_status_changed_to_awaiting";

    public static final String ROUTING_ORDER_STATUS_TO_PAID = "routing.key.order_status_changed_to_paid";
    public static final String ROUTING_ORDER_STATUS_TO_AWAITING = "routing.key.order_status_changed_to_awaiting";

    @Bean
    public DirectExchange exchangeCatalog() {
        return new DirectExchange(TOPIC_CATALOG);
    }


    private static class ReceiverConfig {

        @Bean
        public Queue orderStatusChangedToPaidQueue() {
            return new Queue(QUEUE_ORDER_STATUS_PAID);
        }

        @Bean
        public Queue orderStatusChangedToAwaitingQueue() {
            return new Queue(QUEUE_ORDER_STATUS_AWAITING);
        }

        @Bean
        public Binding bindingOrderStatusToPaid(DirectExchange exchangeCatalog,
                                                Queue orderStatusChangedToPaidQueue) {
            return BindingBuilder.bind(orderStatusChangedToPaidQueue)
                    .to(exchangeCatalog)
                    .with(ROUTING_ORDER_STATUS_TO_PAID);
        }

        @Bean
        public Binding bindingOrderStatusToAwaiting(DirectExchange exchangeCatalog,
                                                    Queue orderStatusChangedToAwaitingQueue) {
            return BindingBuilder.bind(orderStatusChangedToAwaitingQueue)
                    .to(exchangeCatalog)
                    .with(ROUTING_ORDER_STATUS_TO_AWAITING);
        }

        @Bean
        public OrderStatusChangedToAwaitingValidationIntegrationEventHandler orderStatusToPaidHandler() {
            return new OrderStatusChangedToAwaitingValidationIntegrationEventHandler();
        }

        @Bean
        public OrderStatusChangedToPaidIntegrationEventHandler orderStatusToAwaitingHandler() {
            return new OrderStatusChangedToPaidIntegrationEventHandler();
        }
    }

    private static class PublisherConfig {
        @Bean
        public CatalogIntegrationEventPublisher publisher() {
            return new CatalogIntegrationEventPublisher();
        }
    }
}
