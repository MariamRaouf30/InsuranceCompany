package com.example.Registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Registration.model.Registration;



@RestController
public class RegistrationController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Registration registration) {

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8090/api/customers/saveCustomer", registration, String.class);
        
        
        return ResponseEntity.ok("Registration successful in Registration Microservice");
    }
}
