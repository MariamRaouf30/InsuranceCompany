package com.example.customer.grpc;

import com.proto.customer.CustomerServiceGrpc.CustomerServiceImplBase;

import ch.qos.logback.classic.Logger;
import io.grpc.stub.StreamObserver;
import lombok.NoArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.sql.Timestamp;
import java.time.LocalDate;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.google.protobuf.util.Timestamps;
import com.proto.customer.CreateCustomerRequest;
import com.proto.customer.CustomerResponse;
import com.proto.customer.CustomerServiceGrpc;
import com.proto.customer.GetAllCustomersRequest;
import com.proto.customer.GetAllCustomersResponse;



public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{
   
    private CustomerRepository customerRepository;
   

@Override
public void getAllCustomers(GetAllCustomersRequest request, StreamObserver<GetAllCustomersResponse> responseObserver) {
    List<Customer> customers = customerRepository.findAll();
    List<com.proto.customer.Customer> customersResponse =
                customers.stream().map(customer -> com.proto.customer.Customer.newBuilder()
                .setId(customer.getId())
                .setName(customer.getName())
                .setEmail(customer.getEmail())
                .setPassword(customer.getPassword())
                .setPhoneNumber(customer.getPhone_number())
                .addAllPolicyName(customer.getPolicy_name())
                .addAllPolicyId(customer.getPolicy_id())
                 .build())
                .collect(Collectors.toList());
    GetAllCustomersResponse response = GetAllCustomersResponse.newBuilder().addAllCustomers(customersResponse).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

@Override
public void createCustomer(CreateCustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
    String name = request.getName();
    String email = request.getEmail();
    String password = request.getPassword();
    String phoneNumber = request.getPhoneNumber();
    Timestamp timestamp = Timestamp.valueOf(LocalDate.parse(request.getDate()).atStartOfDay());

    List<String> policyNames = request.getPolicyNameList();
    List<String> policyIds = request.getPolicyIdList();

    Customer newCustomer = new Customer();
    newCustomer.setName(name);
    newCustomer.setEmail(email);
    newCustomer.setPassword(password);
    newCustomer.setPhone_number(phoneNumber);
    newCustomer.setPolicy_name(policyNames);
    newCustomer.setPolicy_id(policyIds);

    Customer savedCustomer = customerRepository.save(newCustomer);

    CustomerResponse response = CustomerResponse.newBuilder()
            .setId(savedCustomer.getId())
            .setName(savedCustomer.getName())
            .setEmail(savedCustomer.getEmail())
            .setPassword(savedCustomer.getPassword())
            .setPhoneNumber(savedCustomer.getPhone_number())
            .setDate(Timestamps.fromMillis(savedCustomer.getDate().toEpochDay()))
            .addAllPolicyName(savedCustomer.getPolicy_name())
            .addAllPolicyId(savedCustomer.getPolicy_id())
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}
}




