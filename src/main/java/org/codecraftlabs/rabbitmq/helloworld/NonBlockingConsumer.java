package org.codecraftlabs.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NonBlockingConsumer {
    private final RabbitMQConnectionFactory rabbitMQConnectionFactory;

    public NonBlockingConsumer(RabbitMQConnectionFactory rabbitMQConnectionFactory) {
        this.rabbitMQConnectionFactory = rabbitMQConnectionFactory;
    }

    public void receiveMessage(String queueName) {
        ConnectionFactory factory = this.rabbitMQConnectionFactory.createConnectionFactory("localhost",
                "development",
                "test",
                "password");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            var response = channel.basicGet(queueName, true);

            if (response != null) {
                String message = new String(response.getBody(), "UTF-8");
                System.out.println("Received: " + message);
            } else {
                System.out.println("No message available");
            }
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
