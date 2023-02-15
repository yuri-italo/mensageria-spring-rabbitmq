package dev.yuri.orderconsumer.application.service;

import dev.yuri.orderconsumer.adapter.out.OrderRepository;
import dev.yuri.orderconsumer.application.port.in.ListOrdersUseCase;
import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;
import dev.yuri.orderconsumer.application.port.out.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class ListOrdersService implements ListOrdersUseCase {
    private final OrderRepository orderRepository;

    public ListOrdersService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> listAll() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return createList(orderEntities);
    }

    private List<OrderDTO> createList(List<OrderEntity> orderEntities) {
        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (var order : orderEntities)
            orderDTOS.add(new OrderDTO(order.getId(),order.getValue(),order.getPaid()));

        return orderDTOS;
    }
}
