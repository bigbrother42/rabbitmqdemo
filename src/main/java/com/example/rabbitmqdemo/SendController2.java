package com.example.rabbitmqdemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController2 {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //@RequestMapping("/send")
    public void send(int i) {
        String context = "spring boot neo queue ******" + i;
        // System.out.println("Send : " + context);
        this.rabbitTemplate.convertAndSend("helloQueue", context);
    }
}
