package com.example.customer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    
    private List<String> policy_name;
    private List<String> policy_id;
}

