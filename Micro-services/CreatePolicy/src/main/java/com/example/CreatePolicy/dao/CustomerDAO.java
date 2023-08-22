package com.example.CreatePolicy.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CustomerDAO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
    private List<String> policy_name = new ArrayList<>();
    private List<PolicyDAO> policy = new ArrayList<>();
    @DBRef
    private List<String> policy_id = new ArrayList<>();
}
