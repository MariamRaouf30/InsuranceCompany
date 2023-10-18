package com.example.customer.RabbitMQController;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.core.Binding;

@Configuration
public class RabbitMqConfig {

    private static final String QUEUE_NAME = "customer-queue";
    private static final String EXCHANGE_NAME = "customer-exchange";

    @Bean
    public Queue queueConsumer() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchangeConsumer() {
        return new TopicExchange(EXCHANGE_NAME);
    }


    @Bean
    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("customer created");
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(Listener listener) {
        return new MessageListenerAdapter(listener, "receiveMessage");
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }
}