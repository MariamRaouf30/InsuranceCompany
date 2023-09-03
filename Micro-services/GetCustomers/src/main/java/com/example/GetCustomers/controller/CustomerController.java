package com.example.GetCustomers.controller;
import java.util.List;

import com.example.GetCustomers.clientgrpc.ClientService;
//import com.proto.GetCustomers.Customer;
import com.example.customer.Customer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.GetCustomers.dao.CustomersDAO;
import com.example.GetCustomers.service.GetCustomerService;


@RestController
public class CustomerController {
    @Autowired
    private GetCustomerService customerService;

    @Autowired
    private  ClientService clientService;
    @GetMapping("/getallcustomers")
     public  List<CustomersDAO> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping(value = "/getcustomersgrpc")
    public String grpcCustomer() throws Exception {
        return clientService.getCustomersGrpc().toString();
    }
}
