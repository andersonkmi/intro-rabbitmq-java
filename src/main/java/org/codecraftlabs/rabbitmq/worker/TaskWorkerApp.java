package org.codecraftlabs.rabbitmq.worker;

public class TaskWorkerApp {
    public static void main(String[] args) {
        TaskWorker worker = new TaskWorker();
        worker.processWork("development");
    }
}
