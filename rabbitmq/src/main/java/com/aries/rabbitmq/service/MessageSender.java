package com.aries.rabbitmq.service;

import com.aries.rabbitmq.config.Pkg;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MessageSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message) {
        System.out.println("publish: " + message);
        amqpTemplate.convertAndSend(Pkg.exchange, Pkg.routing, message);
    }

}
