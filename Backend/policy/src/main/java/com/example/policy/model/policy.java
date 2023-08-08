package com.example.policy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Policy {
    @Id
    int claim_id;
    String name;
    int number;
    String claim_amount;
    String type;
}
