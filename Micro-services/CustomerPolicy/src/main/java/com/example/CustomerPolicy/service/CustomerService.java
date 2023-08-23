package com.example.CustomerPolicy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerPolicy.dao.CustomerDAO;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<CustomerDAO> postCustomer(CustomerDAO customer){
        ResponseEntity<CustomerDAO> response = restTemplate.postForEntity(
            "http://localhost:8081/register", customer,CustomerDAO.class);
        return response;
    }

    public CustomerDAO getCustomerById(String id) {
        ResponseEntity<CustomerDAO> response = restTemplate.getForEntity(
            "http://localhost:8090/customers/{id}", CustomerDAO.class, id);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch customer data");
        }
    }
    
    
    public void updateCustomer(CustomerDAO customer,String id) {        
        restTemplate.put("http://localhost:8090/customers/{id}",customer,id);
    }
}
