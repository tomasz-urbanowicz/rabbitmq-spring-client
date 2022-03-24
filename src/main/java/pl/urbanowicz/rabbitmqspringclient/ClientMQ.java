package pl.urbanowicz.rabbitmqspringclient;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientMQ {

    @Autowired
    private RabbitTemplate _rabbitTemplate;

    @GetMapping("/receiveMessage")
    public Object sendMessage() {
        return _rabbitTemplate.receiveAndConvert("testowa").toString();
    }

    @RabbitListener(queues = "testowa")
    public void rabbitListener(String s) {
        System.out.println(s);
    }
}
