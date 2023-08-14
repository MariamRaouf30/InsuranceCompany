package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class LoginController {
 @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login/{name}")
    public ResponseEntity<String> loginUser(@PathVariable("name") String name) {
        String url = "http://localhost:8090/customers/search/findByName?name=" + name;
        
        ResponseEntity<String> response = restTemplate.getForEntity(
            url, String.class);
        System.out.println(response.getBody());
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed");
        }
        
    }
}
