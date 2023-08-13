package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Login.Model.Login;
import com.example.Login.service.LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginController {
 @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<String> registerUser(@RequestBody Login login) {

        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8090/api/customers/saveCustomer", login, String.class);
        

        return ResponseEntity.ok("Login successful in Login Microservice");
    }   
}




