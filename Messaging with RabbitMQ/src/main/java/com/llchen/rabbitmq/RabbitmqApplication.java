package com.llchen.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * Build an application that publishes a msg using Spring AMQP's Rabbit Template,
 * and subscribe to the msg on a POJO using MessageListenerAdapter
 *
 * Use RabbitTemplate, providing everything needed to send and receive msgs with RabbitMQ. Need to configure:
 * 1) A message listener container
 * 2) Declare the queue, the exchange, and the binding between them
 * 3) A component to send more messages to test the listener
 */
@SpringBootApplication
public class RabbitmqApplication {

    static final String topicExchangeName = "spring-rabbit-msg-example";

    static final String queueName = "spring-boot";

    // Create an AMQP queue
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    // Creates a topic exchange
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    // binds queue and topic together, define the behavior that occurs when RabbitTemplate publishes to an exchange
    // routing key means any msg sent with this routing key will be routed to the queue.
    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    // Registered as a message listener in the container, it will listener for the msg in "spring-boot"
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }
}
