package com.example.Registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Registration.dao.RegistrationDAO;

@Service
public class RegistrationService {
    @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<String> registerCustomer(RegistrationDAO registration) {
        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8090/customers", registration, String.class);
        return response;
    }
}
