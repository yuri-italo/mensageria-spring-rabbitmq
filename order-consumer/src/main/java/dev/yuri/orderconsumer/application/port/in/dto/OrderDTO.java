package dev.yuri.orderconsumer.application.port.in.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class OrderDTO {
    private UUID id;
    private BigDecimal value;
    private Boolean paid;

    public OrderDTO() {
    }

    public OrderDTO(UUID id, BigDecimal value, Boolean paid) {
        this.id = id;
        this.value = value;
        this.paid = paid;
    }
}
