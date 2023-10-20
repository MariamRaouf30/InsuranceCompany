package com.example.customer.RabbitMQController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Listener {
    public static final Logger LOG = LoggerFactory.getLogger(Listener.class);
    private final ObjectMapper mapper;
    private final CustomerRepository customerRepository;
    public Listener(ObjectMapper mapper, CustomerRepository customerRepository) {
        this.mapper = mapper;
        this.customerRepository = customerRepository;
    }

    public void receiveMessage(String message) {
        
            try {
                
                Customer customer = mapper.readValue(message, Customer.class);
    
                
                customerRepository.save(customer);
    
                LOG.info(customer.getName() + " : Customer is created");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
    }
    
}
