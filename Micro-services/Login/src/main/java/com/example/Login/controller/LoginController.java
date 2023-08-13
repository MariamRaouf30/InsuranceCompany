package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Login.Model.Login;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginController {
 @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Login login) {
        ResponseEntity<String> response = restTemplate.postForEntity(
            "http://localhost:8090/api/customers/loginCustomer", login, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
    }
}




