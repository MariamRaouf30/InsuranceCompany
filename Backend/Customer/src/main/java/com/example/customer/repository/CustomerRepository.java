package com.example.customer.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.customer.model.Customer;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends MongoRepository<Customer,String>{
    String findIdByName(String name);
    Customer findByName(String name);
    List<Customer> findAll();
}