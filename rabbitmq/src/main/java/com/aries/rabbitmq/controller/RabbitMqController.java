package com.aries.rabbitmq.controller;

import com.aries.rabbitmq.service.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMqController {

    @Autowired
    MessageSender messageSender;

    @GetMapping("/send")
    public void send() {
        messageSender.sendMessage("AAA");
    }
}
