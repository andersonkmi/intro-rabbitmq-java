package org.codecraftlabs.rabbitmq.helloworld;

import java.time.Instant;

public class MessageProducerApp {
    public static void main(String[] args) {
        MessageProducer messageProducer = new MessageProducer();

        long timestamp = Instant.now().toEpochMilli();
        messageProducer.sendMessage("Test message: '" + timestamp + "'" , "development");
    }
}
