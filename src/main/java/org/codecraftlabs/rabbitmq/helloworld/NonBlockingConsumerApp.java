package org.codecraftlabs.rabbitmq.helloworld;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class NonBlockingConsumerApp {
    public static void main(String[] args) {
        NonBlockingConsumer consumer = new NonBlockingConsumer(new RabbitMQConnectionFactory());
        consumer.receiveMessage("development");
    }
}
