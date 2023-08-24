package com.example.GetCustomers.dao;
import java.util.List;

import lombok.Data;

@Data
public
class EmbeddedCustomers {
    private List<CustomersDAO> customers;
}

