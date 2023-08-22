package com.example.PolicyNames.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.PolicyNames.dao.PolicyNamesDAO;

@Service
public class PolicyNamesServices {
        @Autowired
    private RestTemplate restTemplate;

    
    public ResponseEntity<PolicyNamesDAO> getpolicyNames(String id) {
        String url = "http://localhost:8090/customers/" + id;
        ResponseEntity<PolicyNamesDAO> response = restTemplate.getForEntity(
            url, PolicyNamesDAO.class);
        return response;
    }
}
