package com.example.CreateAccount.model;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.time.LocalDate;

@Data
@Document
public class Customer {
    private String id;
    private String name;
    private String password;
    private String phone_number;
    private LocalDate date;
}
