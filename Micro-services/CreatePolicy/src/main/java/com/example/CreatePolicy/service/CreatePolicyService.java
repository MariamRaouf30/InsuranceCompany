package com.example.CreatePolicy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CreatePolicy.dao.CustomerDAO;
import com.example.CreatePolicy.dao.PolicyDAO;

@Service
public class CreatePolicyService {
     @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerService customerService;

    public ResponseEntity<PolicyDAO> createPolicy(PolicyDAO policy, String id) throws Exception {
        CustomerDAO customer = customerService.getCustomerById(id);
        policy.setCustomer_name(customer.getName());
        policy.setCustomer_email(customer.getEmail());
        policy.setCustomer_number(customer.getPhone_number());
        ResponseEntity<PolicyDAO> response = restTemplate.postForEntity(
            "http://localhost:8083/policies", policy, PolicyDAO.class);
        System.out.println(response.getBody().getPolicy_id());
        System.out.println(response.getBody());
        System.out.println(policy.getName());
        if(response.getStatusCode().is2xxSuccessful()){
           List<String> policyNames = new ArrayList<>();
           List<PolicyDAO> policies = new ArrayList<>();
           List<String> policy_id = new ArrayList<>();
           if(customer.getPolicy_name()!=null){
            policyNames = customer.getPolicy_name();
           }
           if(customer.getPolicy()!=null){
                policies = customer.getPolicy();
           }
           if(customer.getPolicy_id()!=null){
                policy_id = customer.getPolicy_id();
           }
           policyNames.add(policy.getName());
           policies.add(response.getBody());
           policy_id.add(response.getBody().getPolicy_id());
             customer.setPolicy_name(policyNames);
             customer.setPolicy_id(policy_id);
             //customer.setPolicy(policies);
            customerService.updateCustomer(customer, id);
            return response;
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
            
        
    }   
}
