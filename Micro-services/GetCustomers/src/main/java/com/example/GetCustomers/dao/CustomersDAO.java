package com.example.GetCustomers.dao;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CustomersDAO {

    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;

    private List<String> policy_name;
    private List<String> policy_id;

}
