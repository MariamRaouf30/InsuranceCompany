package com.example.customer.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.customer.model.Customer;




public interface CustomerRepository extends MongoRepository<Customer,String>{
    String findIdByName(String name);

}