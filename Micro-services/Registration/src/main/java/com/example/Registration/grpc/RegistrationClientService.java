package com.example.Registration.grpc;

import java.io.StringBufferInputStream;

import org.springframework.stereotype.Service;

import com.example.Registration.dao.RegistrationDAO;
import com.example.customer.CreateCustomerRequest;
import com.example.customer.CustomerResponse;
import com.example.customer.CustomerServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class RegistrationClientService {
    @GrpcClient("myclient")
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerStub;

    public String createCustomer(RegistrationDAO registrationDAO){
        CreateCustomerRequest request = CreateCustomerRequest.newBuilder()
                .setName(registrationDAO.getName())
                .setEmail(registrationDAO.getEmail())
                .setPassword(registrationDAO.getPassword())
                .setPhoneNumber(registrationDAO.getPhone_number())
                .build();

        CustomerResponse response = customerStub.createCustomer(request);

        return response.getId();
    }



}
