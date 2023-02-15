package dev.yuri.orderproducer.adapter.in.web;

import dev.yuri.orderproducer.application.port.in.RegisterOrderUseCase;
import dev.yuri.orderproducer.application.port.in.request.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final RegisterOrderUseCase registerOrderUseCase;

    public OrderController(RegisterOrderUseCase registerOrderUseCase) {
        this.registerOrderUseCase = registerOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderRequest request) {
        UUID uuid = registerOrderUseCase.registerOrder(request);
        return ResponseEntity.status(201).body("Order was created. id: " + uuid);
    }
}
