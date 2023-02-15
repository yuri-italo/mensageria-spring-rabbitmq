package dev.yuri.orderconsumer.application.service;

import dev.yuri.orderconsumer.adapter.out.OrderRepository;
import dev.yuri.orderconsumer.application.port.in.PersistenceOrderUseCase;
import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;
import dev.yuri.orderconsumer.application.port.out.entity.OrderEntity;
import dev.yuri.orderconsumer.domain.Order;

public class PersistOrderService implements PersistenceOrderUseCase {
    private final OrderRepository orderRepository;

    public PersistOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean persistOrder(OrderDTO orderDTO) {
        var order = new Order(orderDTO.getId(),orderDTO.getValue(),orderDTO.getPaid());
        var entityOrder = createEntity(order);

        orderRepository.save(entityOrder);
        return true;
    }

    private OrderEntity createEntity(Order order) {
        return new OrderEntity(order.getId(),order.getValue(),order.getPaid());
    }
}
