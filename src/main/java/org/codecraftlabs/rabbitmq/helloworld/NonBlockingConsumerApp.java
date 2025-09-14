package org.codecraftlabs.rabbitmq.helloworld;

public class NonBlockingConsumerApp {
    public static void main(String[] args) {
        NonBlockingConsumer consumer = new NonBlockingConsumer();
        consumer.receiveMessage("development");
    }
}
