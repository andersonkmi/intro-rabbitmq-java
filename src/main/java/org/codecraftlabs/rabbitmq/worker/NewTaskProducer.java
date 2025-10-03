package org.codecraftlabs.rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NewTaskProducer {
    private final RabbitMQConnectionFactory rabbitMQConnectionFactory;

    public NewTaskProducer(RabbitMQConnectionFactory rabbitMQConnectionFactory) {
        this.rabbitMQConnectionFactory = rabbitMQConnectionFactory;
    }

    public void sendMessage(String message, String queueName) {
        ConnectionFactory factory = this.rabbitMQConnectionFactory.createConnectionFactory("localhost",
                "development",
                "test",
                "password");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_BASIC, message.getBytes());
            System.out.println("Message submitted: '" + message + "'");
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
