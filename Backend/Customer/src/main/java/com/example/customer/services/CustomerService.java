package com.example.customer.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.*;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {
   @Autowired
   CustomerRepository repository;
   public Customer getCustomerById(String id){
    return null;
   }

}

