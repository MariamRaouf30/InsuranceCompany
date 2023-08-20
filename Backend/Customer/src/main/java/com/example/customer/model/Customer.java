package com.example.customer.model;
// import org.springframework.cglib.core.Local;

// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Inherited;
import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@Document(collection = "customers")
public class Customer {
    @JsonInclude(JsonInclude.Include.ALWAYS)
    @MongoId(FieldType.STRING)
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
    private List<String> policy_name;
    private List<CustomerPolicy> policies;
}
