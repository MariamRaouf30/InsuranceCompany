package com.example.CreateAccount.repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.CreateAccount.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,String>{

}