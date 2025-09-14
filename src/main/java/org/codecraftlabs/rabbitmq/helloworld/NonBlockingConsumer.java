package org.codecraftlabs.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NonBlockingConsumer {
    public void receiveMessage(String queueName) {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            factory.setVirtualHost("development");
            factory.setUsername("test");
            factory.setPassword("password");

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
