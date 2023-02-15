package dev.yuri.orderproducer.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Order {
    private UUID id;
    private BigDecimal value;
    private Boolean paid;

    public Order(BigDecimal value) {
        this.id = UUID.randomUUID();
        this.value = value;
        this.paid = Boolean.FALSE;
    }
}
