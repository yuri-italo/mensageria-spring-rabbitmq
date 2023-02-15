package dev.yuri.orderconsumer.domain;

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

    public Order(UUID id, BigDecimal value, Boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
    }
}
