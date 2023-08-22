package com.example.PolicyNames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.PolicyNames.dao.PolicyNamesDAO;
import com.example.PolicyNames.service.PolicyNamesServices;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class PolicyNamesController {
    @Autowired
    private PolicyNamesServices namesServices;
    @GetMapping("/policynames/{id}")
    public ResponseEntity<PolicyNamesDAO> policyNames(@PathVariable String id){
        ResponseEntity<PolicyNamesDAO>response = namesServices.getpolicyNames(id);
        return response;
    }
} 
