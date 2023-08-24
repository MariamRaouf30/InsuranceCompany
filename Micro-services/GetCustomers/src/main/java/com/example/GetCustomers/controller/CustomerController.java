package com.example.GetCustomers.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GetCustomers.dao.CustomersDAO;
import com.example.GetCustomers.service.GetCustomerService;

@RestController
public class CustomerController {
    @Autowired
    private GetCustomerService customerService;
    
    @GetMapping("/getallcustomers")
     public  List<CustomersDAO> getCustomers()
    {
        return customerService.getCustomers();
    }
}
