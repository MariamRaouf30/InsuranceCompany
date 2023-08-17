package com.example.policy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    @Id
    private int claim_id;
    private String name;
    private int number;
    private String claim_amount;
    private String type;
}
