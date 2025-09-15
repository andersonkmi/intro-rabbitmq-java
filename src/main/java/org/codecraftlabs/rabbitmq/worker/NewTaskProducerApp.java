package org.codecraftlabs.rabbitmq.worker;

public class NewTaskProducerApp {
    public static void main(String[] args) {
        NewTaskProducer producer = new NewTaskProducer();
        String message = String.join(" ", args);
        producer.sendMessage(message, "development");
    }
}
