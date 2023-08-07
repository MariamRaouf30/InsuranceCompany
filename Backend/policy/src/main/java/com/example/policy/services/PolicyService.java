package com.example.policy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.policy.model.Policy;
import com.example.policy.repository.PolicyRepository;

@Service
public class PolicyService {
    @Autowired
    PolicyRepository policyRepository;
    public Policy getPolicyById(int id){
        return null;
    }
    
}
