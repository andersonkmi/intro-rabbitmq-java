# RabbitMQ intro project
Project to study RabbitMQ features using Java examples

## Rabbit MQ setup

In order to run the examples in this project, RabbitMQ must be locally setup according to the following steps.

### 1. Setup docker container

Run the following command to have RabbitMQ locally running using Docker:

```
docker run -d --hostname dev-rabbit --name dev-rabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -e RABBITMQ_DEFAULT_VHOST=development -p 5672:5672 -p 15672:15672 rabbitmq:4.1.4-management
```

This will start a RabbitMQ using the version 4.1.4 with the following configurations:
- Hostname: dev-rabbit
- username: admin
- password: admiun
- virtual host: development

## Examples 

### Package *org.codecraftlabs.rabbitmq.helloworld*
Simple examples using a classic queue to produce and consume messages.

- `org.codecraftlabs.rabbitmq.helloworld.MessageProducer`: class responsible for creating a test sample message and publish into the message queue
- `org.codecraftlabs.rabbitmq.helloworld.MessageConsumer`: consumes messages from the queue and it remains running until manually interrupted.
- `org.codecraftlabs.rabbitmq.helloworld.NonBlockingConsumer`: consumes a single message and exits. If the queue is empty it also exits.