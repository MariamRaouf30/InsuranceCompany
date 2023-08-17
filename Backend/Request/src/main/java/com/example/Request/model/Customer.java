package com.example.Request.model;
// import org.springframework.cglib.core.Local;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
    private String policy_name;
    private List<CustomerPolicy> policies;
}
