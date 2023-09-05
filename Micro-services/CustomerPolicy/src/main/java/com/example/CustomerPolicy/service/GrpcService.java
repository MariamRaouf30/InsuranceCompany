package com.example.CustomerPolicy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerPolicy.dao.CustomerDAO;

@Service
public class GrpcService {
    @Autowired
    private RestTemplate restTemplate;
    
    public CustomerDAO createCustomer(CustomerDAO customer){
        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8081/grpcregister", customer,String.class);
            if(response.getBody()!=null){
                customer.setId(response.getBody());
                return customer;
            }
            else {
                throw new RuntimeException("Failed to register customer ");
            }
    }
    
}
