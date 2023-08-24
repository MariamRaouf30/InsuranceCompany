package com.example.GetPolicies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.GetPolicies.dao.PolicyDAO;
import com.example.GetPolicies.dao.PolicyListResponse;

@Service
public class GetPoliciesService {
    @Autowired
    private RestTemplate restTemplate;

    public List<PolicyDAO> getpolicies() {
        ResponseEntity<PolicyListResponse> policiesResponse = restTemplate.exchange(
            "http://localhost:8083/policies",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<PolicyListResponse>() {}
        );
        return policiesResponse.getBody().get_embedded().getPolicies();
    }
}
