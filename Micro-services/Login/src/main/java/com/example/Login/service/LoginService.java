package com.example.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoginService {
        @Autowired
    private RestTemplate restTemplate;


    public ResponseEntity<String> loginCustomer(String name) {
        String url = "http://localhost:8090/customers/search/findByName?name=" + name;
        ResponseEntity<String> response = restTemplate.getForEntity(
            url, String.class);
        return response;
    }
    
}
