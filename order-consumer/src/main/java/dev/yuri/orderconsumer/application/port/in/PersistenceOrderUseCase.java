package dev.yuri.orderconsumer.application.port.in;

import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;

public interface PersistenceOrderUseCase {
    boolean persistOrder(OrderDTO orderDTO);
}
