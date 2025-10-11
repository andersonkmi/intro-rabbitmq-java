package org.codecraftlabs.rabbitmq.pubsub;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class LogsReceiverApp {
    public static void main(String[] args) {
        LogsReceiver logsReceiver = new LogsReceiver(new RabbitMQConnectionFactory());
        logsReceiver.receiveMessages();
    }
}
