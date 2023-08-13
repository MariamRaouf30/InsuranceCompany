package com.example.customer.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;



@RequestMapping("/api/customers")
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @PostMapping("/saveCustomer")
      public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
        System.out.println("Received registration request: " + customer.toString());
        customerRepository.save(customer);
        return ResponseEntity.ok("Registration successful");
    }

}
