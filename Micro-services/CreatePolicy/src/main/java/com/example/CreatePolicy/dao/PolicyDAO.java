package com.example.CreatePolicy.dao;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class PolicyDAO {
    private String policy_id;
    private int claim_id;
    private String name;
    private int number;
    private String claim_amount;
    private String type;
    private String customer_name;
    private String customer_number;
    private String customer_email;
}
