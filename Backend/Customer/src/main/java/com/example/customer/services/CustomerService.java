package com.example.customer.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;

@RestController
public class CustomerService {
   @Autowired
   RestTemplate restTemplate;
   CustomerRepository repository;
   public Customer getCustomerById(String id){
    return null;
   }
   @RequestMapping(value = "/customerss/{id}", method = RequestMethod.POST)
   public String createCustomer(@RequestBody Customer customer){
      HttpHeaders headers = new HttpHeaders();
      HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);
      
      return restTemplate.exchange(
         "http://localhost:8090/customerss", HttpMethod.POST, entity, String.class).getBody();
  
   }

}

