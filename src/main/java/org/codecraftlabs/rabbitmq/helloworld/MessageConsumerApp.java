package org.codecraftlabs.rabbitmq.helloworld;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class MessageConsumerApp {
    public static void main(String[] args) {
        MessageConsumer consumer = new MessageConsumer(new RabbitMQConnectionFactory());
        consumer.receiveMessage("development");
    }
}
