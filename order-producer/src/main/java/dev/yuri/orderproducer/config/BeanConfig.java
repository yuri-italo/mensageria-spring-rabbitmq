package dev.yuri.orderproducer.config;

import dev.yuri.orderproducer.application.port.in.RegisterOrderUseCase;
import dev.yuri.orderproducer.application.service.RegisterOrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public RegisterOrderUseCase registerOrderUseCase() {
        return new RegisterOrderService(rabbitTemplate);
    }
}
