package com.llchen.msgwithredis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.util.concurrent.CountDownLatch;

/**
 * Walk through the process of using Spring Data Redis to publish and subscribe to messages sent via Redis.
 *
 * Redis is an key value store that comes with a messaging system
 */
@SpringBootApplication
public class MsgwithredisApplication {

    private static final Logger log = LoggerFactory.getLogger(MsgwithredisApplication.class);

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // listen msg on "chat" to[ic
        container.addMessageListener(listenerAdapter, new PatternTopic("chat"));

        return container;
    }

    // because the Receiver class is a POJO, it needs to be wrapped in a msg listener adapter that implements the MessageListener interface
    // required by addMessageListener
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    public static void main(String[] args) throws InterruptedException {

        ApplicationContext ctx = SpringApplication.run(MsgwithredisApplication.class, args);

        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);

        CountDownLatch latch = ctx.getBean(CountDownLatch.class);

        log.info("Sending msg......");
        template.convertAndSend("chat", "hello, let's chat!");

        latch.await();

        System.exit(0);
    }
}
