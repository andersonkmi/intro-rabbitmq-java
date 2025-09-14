package org.codecraftlabs.rabbitmq.helloworld;

import java.time.Instant;

public class MessageSenderApp {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();

        long timestamp = Instant.now().toEpochMilli();
        messageSender.sendMessage("Test message: '" + timestamp + "'" , "development");
    }
}
