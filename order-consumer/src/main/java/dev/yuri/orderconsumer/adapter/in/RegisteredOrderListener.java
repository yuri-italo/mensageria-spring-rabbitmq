package dev.yuri.orderconsumer.adapter.in;

import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;
import dev.yuri.orderconsumer.application.port.in.PersistenceOrderUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RegisteredOrderListener {
    private final PersistenceOrderUseCase persistenceOrderUseCase;

    public RegisteredOrderListener(PersistenceOrderUseCase persistenceOrderUseCase) {
        this.persistenceOrderUseCase = persistenceOrderUseCase;
    }

    @RabbitListener(queues = "orderRegistered")
    public void onOrderRegistered(OrderDTO orderDTO) {
        System.out.println("Order received successfully. id: " + orderDTO.getId());
        persistenceOrderUseCase.persistOrder(orderDTO);
        System.out.println("Saved");
    }
}
