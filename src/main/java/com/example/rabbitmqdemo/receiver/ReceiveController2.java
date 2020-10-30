package com.example.rabbitmqdemo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RabbitListener(queues = "helloQueue")
public class ReceiveController2 {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver 2: " + hello);
    }
}
