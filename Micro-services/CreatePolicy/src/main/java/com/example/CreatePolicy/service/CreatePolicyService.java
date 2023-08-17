package com.example.CreatePolicy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CreatePolicy.dao.CreatePolicyDAO;

@Service
public class CreatePolicyService {
     @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<String> createPolicy(CreatePolicyDAO policy) {
        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8083/policies", policy, String.class);
            System.out.println("Response Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody());
        return response;
    }   
}
