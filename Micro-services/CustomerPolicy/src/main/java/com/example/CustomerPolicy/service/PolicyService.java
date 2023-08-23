package com.example.CustomerPolicy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerPolicy.dao.CustomerDAO;
import com.example.CustomerPolicy.dao.PolicyDAO;

@Service
public class PolicyService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<PolicyDAO> createPolicy(PolicyDAO policy,String id){
         ResponseEntity<PolicyDAO> response = restTemplate.postForEntity(
            "http://localhost:8087/createpolicy/{id}",policy ,PolicyDAO.class,id);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response;
            } else {
                throw new RuntimeException("Failed to fetch customer data");
            }
    }
}
