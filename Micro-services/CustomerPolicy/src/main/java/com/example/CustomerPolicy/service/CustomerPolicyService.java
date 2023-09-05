package com.example.CustomerPolicy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerPolicy.dao.CustomerDAO;
import com.example.CustomerPolicy.dao.CustomerPolicy;
import com.example.CustomerPolicy.dao.PolicyDAO;

@Service
public class CustomerPolicyService {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private RestTemplate restTemplate;
    
    public CustomerPolicy createCustomerPolicy(CustomerPolicy customerPolicy){
        CustomerDAO customer = customerPolicy.getCustomer();
        List<PolicyDAO> policies = new ArrayList<>();
        ResponseEntity<CustomerDAO> customerResponse = customerService.postCustomer(customer);
        System.out.println(customerPolicy.getPolicy().get(0).getName());
        String id = customerResponse.getBody().getId();
        System.out.println(customerResponse.getBody().getId());

        if(customerResponse.getStatusCode().is2xxSuccessful()){
        for(int i = 0; i < customerPolicy.getPolicy().size();i++){
             ResponseEntity<PolicyDAO> policyResponse = policyService.createPolicy(customerPolicy.getPolicy().get(i), id);
            policies.add(policyResponse.getBody());
        if(!policyResponse.getStatusCode().is2xxSuccessful()){
           return null;
        }
        }
        }
        customerPolicy.setCustomer(customerService.getCustomerById(id));
        customerPolicy.setPolicy(policies);
        //restTemplate.put("http://localhost:8070/customerpolicy",customerPolicy,CustomerPolicy.class);
        return customerPolicy;
    }
    
}
