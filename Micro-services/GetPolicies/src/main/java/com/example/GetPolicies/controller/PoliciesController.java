package com.example.GetPolicies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GetPolicies.dao.PolicyDAO;
import com.example.GetPolicies.service.GetPoliciesService;

@RestController
public class PoliciesController {
    @Autowired
    private GetPoliciesService policiesService;

     @GetMapping("/getallpolicies")
     public  List<PolicyDAO> getCustomers()
    {
        return policiesService.getpolicies();
    }
}
