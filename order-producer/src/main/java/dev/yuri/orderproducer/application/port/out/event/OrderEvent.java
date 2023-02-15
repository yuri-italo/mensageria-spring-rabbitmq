package dev.yuri.orderproducer.application.port.out.event;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
public class OrderEvent {
    private final UUID id;
    private final BigDecimal value;
    private final Boolean paid;

    public OrderEvent(UUID id, BigDecimal value, Boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
    }
}
