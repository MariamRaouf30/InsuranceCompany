package com.example.CustomerPolicy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerPolicy.dao.CustomerDAO;
import com.example.CustomerPolicy.dao.CustomerPolicy;
import com.example.CustomerPolicy.dao.PolicyDAO;

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

    public void createPolicy(PolicyDAO policy, String id){
            ResponseEntity<PolicyDAO> response = restTemplate.postForEntity(
            "http://localhost:8087/createpolicygrpc/{id}", policy,PolicyDAO.class,id);
            System.out.println(response.getStatusCode().is2xxSuccessful());
       
    }

    public String createCustomerPolicy(CustomerPolicy customerPolicy){
        CustomerDAO customer = createCustomer(customerPolicy.getCustomer());
        for(int i = 0; i<customerPolicy.getPolicy().size();i++){
            createPolicy(customerPolicy.getPolicy().get(i),customer.getId());
        }
        return "Done";
    }

}
