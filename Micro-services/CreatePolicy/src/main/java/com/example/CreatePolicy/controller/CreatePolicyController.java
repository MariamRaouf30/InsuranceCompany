package com.example.CreatePolicy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreatePolicy.dao.CreatePolicyDAO;
import com.example.CreatePolicy.service.CreatePolicyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CreatePolicyController {
    @Autowired
    private CreatePolicyService createPolicyService;

    @PostMapping("/createpolicy")
    public ResponseEntity<String> createPolicyController(@RequestBody CreatePolicyDAO policy) {
        ResponseEntity<String> response = createPolicyService.createPolicy(policy);
        return ResponseEntity.ok("Policy created successfully");
    }
    

}
