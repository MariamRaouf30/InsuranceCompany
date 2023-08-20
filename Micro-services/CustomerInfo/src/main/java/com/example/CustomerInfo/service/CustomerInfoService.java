package com.example.CustomerInfo.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CustomerInfo.dao.CustomerInfoDAO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerInfoService {
    @Autowired
    private RestTemplate restTemplate;

    
    public ResponseEntity<CustomerInfoDAO> getInfo(String id) {
        String url = "http://localhost:8090/customers/" + id;
        ResponseEntity<CustomerInfoDAO> response = restTemplate.getForEntity(
            url, CustomerInfoDAO.class);
        return response;
    }
}
