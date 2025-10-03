package org.codecraftlabs.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageConsumer {
    private final RabbitMQConnectionFactory rabbitMQConnectionFactory;

    public MessageConsumer(RabbitMQConnectionFactory rabbitMQConnectionFactory) {
        this.rabbitMQConnectionFactory = rabbitMQConnectionFactory;
    }

    public void receiveMessage(String queueName) {
        ConnectionFactory factory = this.rabbitMQConnectionFactory.createConnectionFactory("localhost",
                "development",
                "test",
                "password");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
            };
            channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
            });
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
