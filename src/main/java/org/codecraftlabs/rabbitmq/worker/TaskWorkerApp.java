package org.codecraftlabs.rabbitmq.worker;

import org.codecraftlabs.rabbitmq.RabbitMQConnectionFactory;

public class TaskWorkerApp {
    public static void main(String[] args) {
        TaskWorker worker = new TaskWorker(new RabbitMQConnectionFactory());
        worker.processWork("development");
    }
}
