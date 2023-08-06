package com.example.CreateAccount.model;
//import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String phone_number;
    private LocalDate date;
}
