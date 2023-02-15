package dev.yuri.orderconsumer.config;

import dev.yuri.orderconsumer.adapter.out.OrderRepository;
import dev.yuri.orderconsumer.application.port.in.ListOrdersUseCase;
import dev.yuri.orderconsumer.application.port.in.PersistenceOrderUseCase;
import dev.yuri.orderconsumer.application.service.ListOrdersService;
import dev.yuri.orderconsumer.application.service.PersistOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Autowired
    OrderRepository orderRepository;

    @Bean
    public PersistenceOrderUseCase persistenceOrderUseCase() {
        return new PersistOrderService(orderRepository);
    }

    @Bean
    public ListOrdersUseCase listOrdersUseCase() {
        return new ListOrdersService(orderRepository);
    }

}
