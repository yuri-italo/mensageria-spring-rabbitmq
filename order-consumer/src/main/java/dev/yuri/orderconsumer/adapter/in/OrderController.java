package dev.yuri.orderconsumer.adapter.in;

import dev.yuri.orderconsumer.application.port.in.ListOrdersUseCase;
import dev.yuri.orderconsumer.application.port.in.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final ListOrdersUseCase listOrdersUseCase;

    public OrderController(ListOrdersUseCase listOrdersUseCase) {
        this.listOrdersUseCase = listOrdersUseCase;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> list() {
        List<OrderDTO> orders = listOrdersUseCase.listAll();
        return ResponseEntity.status(200).body(orders);
    }
}