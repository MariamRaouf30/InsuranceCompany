package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.model.Customer;
import java.util.List;



public interface CustomerRepository extends JpaRepository<Customer,Integer>{

    Customer findByName(String name);
    Customer findByNameAndPassword(String name, String password);
}