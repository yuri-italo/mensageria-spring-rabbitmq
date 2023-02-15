package dev.yuri.orderproducer.application.service;

import dev.yuri.orderproducer.application.port.in.RegisterOrderUseCase;
import dev.yuri.orderproducer.application.port.in.request.OrderRequest;
import dev.yuri.orderproducer.application.port.out.event.OrderEvent;
import dev.yuri.orderproducer.domain.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.UUID;

public class RegisterOrderService implements RegisterOrderUseCase {
    private final RabbitTemplate rabbitTemplate;

    public RegisterOrderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public UUID registerOrder(OrderRequest orderRequest) {
        var order = new Order(orderRequest.getValue());
        var routingKey = "orderRegistered";
        var orderEvent = createEvent(order);

        rabbitTemplate.convertAndSend(routingKey,orderEvent);

        return order.getId();
    }

    private OrderEvent createEvent(Order order) {
        return OrderEvent.builder()
                .id(order.getId())
                .value(order.getValue())
                .paid(order.getPaid())
                .build();
    }
}
