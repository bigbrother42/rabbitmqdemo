package com.example.rabbitmqdemo;

import com.example.rabbitmqdemo.sender.SendController;
import com.example.rabbitmqdemo.sender.SendController2;
import com.example.rabbitmqdemo.sender.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private SendController sendController;

    @Autowired
    private SendController2 sendController2;

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sendController.send(0);
    }

    /**
     * 一对多发送
     * @throws Exception
     */
    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sendController.send(i);
        }
    }

    /**
     * 多对多发送
     * @throws Exception
     */
    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 100; i++) {
            sendController.send(i);
            sendController2.send(i);
        }
    }

    @Test
    public void routing() throws Exception {
        //sender.send1();

        //sender.send2();

        sender.send();
    }
}
