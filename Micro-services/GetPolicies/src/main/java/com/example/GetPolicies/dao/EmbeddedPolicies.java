package com.example.GetPolicies.dao;

import java.util.List;

import lombok.Data;

@Data
public class EmbeddedPolicies {
    private List<PolicyDAO> policies;
}
