package com.example.GetCustomers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.GetCustomers.dao.CustomersDAO;
import com.example.GetCustomers.dao.CustomersListResponse;
import com.example.GetCustomers.dao.EmbeddedCustomers;

@Service
public class GetCustomerService {
    @Autowired
    private RestTemplate restTemplate;

    public List<CustomersDAO> getCustomers() {
        ResponseEntity<CustomersListResponse> customersResponse = restTemplate.exchange(
            "http://localhost:8090/customers",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<CustomersListResponse>() {}
        );
        return customersResponse.getBody().get_embedded().getCustomers();
    }
}
