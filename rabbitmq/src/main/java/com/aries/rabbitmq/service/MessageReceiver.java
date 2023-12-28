package com.aries.rabbitmq.service;

import com.aries.rabbitmq.config.Pkg;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = Pkg.queue, durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = Pkg.exchange, ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC), key = Pkg.routing))
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
