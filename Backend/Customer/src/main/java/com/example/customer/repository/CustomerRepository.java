package com.example.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.customer.model.Customer;



public interface CustomerRepository extends MongoRepository<Customer,String>{

    Customer findByName(String name);
    Customer findByNameAndPassword(String name, String password);
}