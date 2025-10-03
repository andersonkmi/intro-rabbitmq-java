package org.codecraftlabs.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageProducer {
    private final RabbitMQConnectionFactory rabbitMQConnectionFactory;

    public MessageProducer(RabbitMQConnectionFactory rabbitMQConnectionFactory) {
        this.rabbitMQConnectionFactory = rabbitMQConnectionFactory;
    }

    public void sendMessage(String message, String queueName) {
        ConnectionFactory factory = this.rabbitMQConnectionFactory.createConnectionFactory("localhost",
                "development",
                "test",
                "password");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println("Message submitted");
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
