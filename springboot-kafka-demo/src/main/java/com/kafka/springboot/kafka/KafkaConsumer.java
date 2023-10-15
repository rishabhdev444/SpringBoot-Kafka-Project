package com.kafka.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "topic-example-2",groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s",message));
        System.out.println(message);
    }
}
