package org.codecraftlabs.rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NewTaskProducer {
    public void sendMessage(String message, String queueName) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setVirtualHost("development");
        factory.setUsername("test");
        factory.setPassword("password");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            channel.basicPublish("", queueName, MessageProperties.PERSISTENT_BASIC, message.getBytes());
            System.out.println("Message submitted: '" + message + "'");
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
