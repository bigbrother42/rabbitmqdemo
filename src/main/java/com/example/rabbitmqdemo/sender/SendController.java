package com.example.rabbitmqdemo.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    //@RequestMapping("/send")
    public void send(int i) {
        String context = "spring boot neo queue ******" + i;
        // System.out.println("Send : " + context);
        this.rabbitTemplate.convertAndSend("helloQueue", context);
    }
}
