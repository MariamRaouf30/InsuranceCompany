package com.example.CreateAccount.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CreateAccount.model.Customer;
import com.example.CreateAccount.repository.CustomerRepository;

@Service
public class CustomerService {
   @Autowired
   CustomerRepository repository;
   public Customer getCustomerById(String id){
    return null;
   }

}

