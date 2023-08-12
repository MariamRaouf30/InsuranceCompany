package com.example.customer.model;
//import org.springframework.cglib.core.Local;
//import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    
    private @GeneratedValue @Id int id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
}
