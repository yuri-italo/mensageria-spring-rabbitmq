package dev.yuri.orderconsumer.application.port.in;

import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;

import java.util.List;

public interface ListOrdersUseCase {
    List<OrderDTO> listAll();
}
