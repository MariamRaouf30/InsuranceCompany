package com.example.policy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.policy.model.Policy;
import com.example.policy.repository.PolicyRepository;

@RestController
public class PolicyController {
    @Autowired
    private PolicyRepository policyRepository;

    @GetMapping
    public List<Policy> getAll() {
        return (List<Policy>) policyRepository.findAll();
    }

    @PostMapping("/saveCustomer")
    public Policy createPerson(@RequestBody Policy policy) {
        return policyRepository.save(policy);
    }

}