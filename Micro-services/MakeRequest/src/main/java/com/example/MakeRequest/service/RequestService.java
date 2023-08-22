package com.example.MakeRequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.MakeRequest.dao.CustomerDAO;
import com.example.MakeRequest.dao.RequestDAO;

import io.micrometer.core.ipc.http.HttpSender.Request;

@Service
public class RequestService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CustomerService customerService;
        public ResponseEntity<RequestDAO> makeRequest(RequestDAO request, String id){
            CustomerDAO customer = customerService.getCustomerById(id);
            ResponseEntity<RequestDAO> response = restTemplate.postForEntity(
            "http://localhost:8092/requests", request, RequestDAO.class);
            System.out.println(response.getBody());
            System.out.println(request.getCustomer().getName());
            if(request.getCustomer().getName()!=null){
                customer.setName(request.getCustomer().getName());
            }
            if(request.getCustomer().getEmail()!=null){
                customer.setName(request.getCustomer().getEmail());
            }
            if(request.getCustomer().getPhone_number()!=null){
                customer.setName(request.getCustomer().getPhone_number());
            }
            if(response.getStatusCode().is2xxSuccessful()){
              customerService.updateCustomer(customer, id);
               return response;
            }
            else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
}
