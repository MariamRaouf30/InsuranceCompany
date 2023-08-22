package com.example.Registration.dao;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class RegistrationDAO {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
    private List<String> policy_name;
    private List<String> policy_id;
    
}