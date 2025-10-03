package org.codecraftlabs.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQConnectionFactory {
    public ConnectionFactory createConnectionFactory(String host, String virtualHost, String userName, String password) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setVirtualHost(virtualHost);
        factory.setUsername(userName);
        factory.setPassword(password);
        return factory;
    }
}
