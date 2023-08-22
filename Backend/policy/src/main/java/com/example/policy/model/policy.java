package com.example.policy.model;

import java.io.Serial;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "policies")
@AllArgsConstructor
@NoArgsConstructor
public class Policy {
    @Id
    private String policy_id;
    private int claim_id;
    private String name;
    private int number;
    private String claim_amount;
    private String type;
    private String customer_name;
    private String customer_number;
    private String customer_email;
}
