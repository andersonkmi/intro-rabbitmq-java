package org.codecraftlabs.rabbitmq.pubsub;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class LogsPublisherApp {
    public static void main(String[] args) {
        LogsPublisher publisher = new LogsPublisher(new RabbitMQConnectionFactory());
        publisher.publishLogs(String.join(" ", args));
    }
}
