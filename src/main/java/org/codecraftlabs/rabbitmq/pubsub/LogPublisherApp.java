package org.codecraftlabs.rabbitmq.pubsub;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class LogPublisherApp {
    public static void main(String[] args) {
        LogPublisher publisher = new LogPublisher(new RabbitMQConnectionFactory());
        publisher.publishLog(String.join(" ", args));
    }
}
