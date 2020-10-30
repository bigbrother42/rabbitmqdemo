package com.example.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RabbitListener(queues = "helloQueue")
public class ReceiveController {

    @RabbitHandler
    @RequestMapping("/receive")
    public void receive(String hello) {
        System.out.println("Receive : " + hello);
    }
}
