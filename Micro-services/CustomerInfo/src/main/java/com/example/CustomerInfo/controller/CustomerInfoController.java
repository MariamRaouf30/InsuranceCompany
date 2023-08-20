package com.example.CustomerInfo.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerInfo.dao.CustomerInfoDAO;
import com.example.CustomerInfo.service.CustomerInfoService;



@RestController
public class CustomerInfoController {
    @Autowired
    private CustomerInfoService customerInfoService;
    
    @GetMapping("/customerinfo/{id}")
        public ResponseEntity<CustomerInfoDAO> customerInfo(@PathVariable("id") String id) {

        ResponseEntity<CustomerInfoDAO> response = customerInfoService.getInfo(id);
        
        return response;
    }
}
