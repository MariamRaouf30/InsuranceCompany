package com.example.CustomerPolicy.dao;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CustomerPolicy {
    CustomerDAO customer;
    List <PolicyDAO> policy = new ArrayList<>();
}
