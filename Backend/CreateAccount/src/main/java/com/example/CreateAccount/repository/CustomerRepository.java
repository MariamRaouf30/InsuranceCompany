package com.example.CreateAccount.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CreateAccount.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

}