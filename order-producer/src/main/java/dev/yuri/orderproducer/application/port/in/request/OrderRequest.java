package dev.yuri.orderproducer.application.port.in.request;

import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class OrderRequest {
    private BigDecimal value;
    private Boolean paid;
}
