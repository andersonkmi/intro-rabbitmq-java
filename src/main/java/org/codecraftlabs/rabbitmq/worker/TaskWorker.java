package org.codecraftlabs.rabbitmq.worker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TaskWorker {
    private final RabbitMQConnectionFactory rabbitMQConnectionFactory;

    public TaskWorker(RabbitMQConnectionFactory rabbitMQConnectionFactory) {
        this.rabbitMQConnectionFactory = rabbitMQConnectionFactory;
    }

    public void processWork(String queueName) {
        ConnectionFactory factory = this.rabbitMQConnectionFactory.createConnectionFactory("localhost",
                "development",
                "test",
                "password");

        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
            channel.queueDeclare(queueName, false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            channel.basicQos(1);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                try {
                    String message = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                    doWork(message);
                } finally {
                    System.out.println(" [x] Done");
                    channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                }
            };
            channel.basicConsume(queueName, false, deliverCallback, consumerTag -> {});
        } catch (TimeoutException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void doWork(String task) {
        for (char ch : task.toCharArray()) {
            if (ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
