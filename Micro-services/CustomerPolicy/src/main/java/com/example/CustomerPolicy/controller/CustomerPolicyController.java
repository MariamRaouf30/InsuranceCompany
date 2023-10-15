package com.example.CustomerPolicy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerPolicy.dao.CustomerPolicy;
import com.example.CustomerPolicy.service.CustomerPolicyService;
import com.example.CustomerPolicy.service.GrpcService;

@RestController
public class CustomerPolicyController {
    
    @Autowired
    private CustomerPolicyService customerPolicyService;
    @Autowired
    private GrpcService grpcService;

    @PostMapping("/customerpolicy")
    public CustomerPolicy createCustomerPolicy(@RequestBody CustomerPolicy customerPolicy){
        return customerPolicyService.createCustomerPolicy(customerPolicy);
    }
    @PostMapping("/customerpolicygrpc")
    public String customerPolicyGrpc(@RequestBody CustomerPolicy customerPolicy){
        return grpcService.createCustomerPolicy(customerPolicy);
    }
}
