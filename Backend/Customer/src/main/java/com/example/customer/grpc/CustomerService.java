package com.example.customer.grpc;

import com.proto.customer.CustomerServiceGrpc.CustomerServiceImplBase;

import ch.qos.logback.classic.Logger;
import io.grpc.stub.StreamObserver;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.google.protobuf.util.Timestamps;
import com.proto.customer.CustomerResponse;
import com.proto.customer.CustomerServiceGrpc;
import com.proto.customer.GetAllCustomersRequest;
import com.proto.customer.GetAllCustomersResponse;

public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{
    private final CustomerRepository customerRepository = null ;
@Override
public void getAllCustomers(GetAllCustomersRequest request, StreamObserver<GetAllCustomersResponse> responseObserver) {
    List<Customer> customers = customerRepository.findAll();

    // GetAllCustomersResponse.Builder responseBuilder = GetAllCustomersResponse.newBuilder();
    // for (Customer customer : customers) {
    //     CustomerResponse customerResponse = CustomerResponse.newBuilder()
    //             .setId(customer.getId())
    //             .setName(customer.getName())
    //             .setEmail(customer.getEmail())
    //             .setPassword(customer.getPassword())
    //             .setPhoneNumber(customer.getPhone_number())
    //             .setDate(customer.getDate())
    //             .addAllPolicyName(customer.getPolicy_name())
    //             .addAllPolicyId(customer.getPolicy_id())
    //             .build();
    // }
    List<com.proto.customer.Customer> customersResponse =
                customers.stream().map(customer -> com.proto.customer.Customer.newBuilder()
                .setName(customer.getClass().getName())
                .build())
                .collect(Collectors.toList());
    GetAllCustomersResponse response = GetAllCustomersResponse.newBuilder().addAllCustomers(customersResponse).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
}
}
