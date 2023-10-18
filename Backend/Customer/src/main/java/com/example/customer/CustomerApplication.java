package com.example.customer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.example.customer.model.Customer;




@SpringBootApplication
public class CustomerApplication  implements RepositoryRestConfigurer {

    public static void main(String[] args) {
        
        SpringApplication.run(CustomerApplication.class, args);
    }
    //     private static final String QUEUE_NAME = "customer-queue";
    // private static final String EXCHANGE_NAME = "customer.create";

    // @Bean
    // public Queue queueProducer(){
    //     return new Queue(QUEUE_NAME, false);
    // }

    // @Bean
    // public TopicExchange exchangeProducer(){
    //     return new TopicExchange(EXCHANGE_NAME);
    // }

    // @Bean
    // public Binding bindingProducer(Queue queue, TopicExchange exchange){
    //     return BindingBuilder.bind(queue).to(exchange).with("customer.queue");
    // }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:3000"); // Allow your React frontend's domain
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }


     @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Customer.class);
    }
    
}
