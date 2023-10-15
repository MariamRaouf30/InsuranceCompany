package com.example.MailNotification;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.MailNotification.controller.MailController;
@Configuration
public class RabbitMQConfig {
    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);

        container.setQueueNames("user-registration");

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MailController listener) {
        return new MessageListenerAdapter(listener, "onMessageReceived");
    }
}