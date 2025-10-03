package org.codecraftlabs.rabbitmq.worker;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class NewTaskProducerApp {
    public static void main(String[] args) {
        NewTaskProducer producer = new NewTaskProducer(new RabbitMQConnectionFactory());
        String message = String.join(" ", args);
        producer.sendMessage(message, "development");
    }
}
