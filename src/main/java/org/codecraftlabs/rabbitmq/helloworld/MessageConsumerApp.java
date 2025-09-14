package org.codecraftlabs.rabbitmq.helloworld;

public class MessageConsumerApp {
    public static void main(String[] args) {
        MessageConsumer consumer = new MessageConsumer();
        consumer.receiveMessage("development");
    }
}
