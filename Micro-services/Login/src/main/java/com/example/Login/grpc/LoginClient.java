package com.example.Login.grpc;

import org.springframework.stereotype.Service;

import com.example.customer.Customer;
import com.example.customer.CustomerServiceGrpc;
import com.example.customer.GetByNameRequest;
import com.example.customer.GetByNameResponse;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class LoginClient {
    @GrpcClient("myclient")
    private CustomerServiceGrpc.CustomerServiceBlockingStub loginClient;

     public Customer getCustomer(String name){
        GetByNameRequest request = GetByNameRequest.newBuilder().setName(name).build();
        GetByNameResponse response = loginClient.getByName(request);
        return response.getCustomer();
    }
}
