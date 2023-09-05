package com.example.CreatePolicy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.CreatePolicy.dao.PolicyDAO;
import com.example.CreatePolicy.grpc.CreatePolicyClient;
import com.example.CreatePolicy.service.CreatePolicyService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CreatePolicyController {
    @Autowired
    private CreatePolicyService createPolicyService;

    @Autowired
    private CreatePolicyClient policyClient;

    @PostMapping("/createpolicy/{id}")
    public ResponseEntity<PolicyDAO> createPolicyController(@RequestBody PolicyDAO policy,@PathVariable String id) throws Exception {
        ResponseEntity<PolicyDAO> response = createPolicyService.createPolicy(policy,id);
        return response;
    }

    @PostMapping("/createpolicygrpc/{id}")
    public String createPolicyGrpc(@RequestBody PolicyDAO policy, @PathVariable String id){
        String response = policyClient.CreatePolicy(policy, id);
        return response;
    }    
    
}
