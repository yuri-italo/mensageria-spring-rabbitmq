package dev.yuri.orderproducer.application.port.in;

import dev.yuri.orderproducer.application.port.in.request.OrderRequest;

import java.util.UUID;

public interface RegisterOrderUseCase {
    UUID registerOrder(OrderRequest orderRequest);
}
