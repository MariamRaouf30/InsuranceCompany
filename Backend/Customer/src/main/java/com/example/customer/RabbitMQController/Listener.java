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
    
    public Listener(ObjectMapper mapper) {
        this.mapper = mapper;
        
    }

    public void receiveMessage(String message) {
        try{
            String customer = mapper.readValue(message, String.class);
            LOG.info(customer);
            // if("name".equals()){
               
            //     LOG.info("");
            // }else{
            //     LOG.warn("Not Sent");
            // }
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }
    }
    
}
