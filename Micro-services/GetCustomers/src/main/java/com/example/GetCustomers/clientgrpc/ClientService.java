package com.example.GetCustomers.clientgrpc;


import com.example.customer.Customer;
import com.example.customer.CustomerServiceGrpc;
import com.example.customer.GetAllCustomersRequest;
import com.example.customer.GetAllCustomersResponse;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Service
public class ClientService {

    @GrpcClient("myclient")
    private CustomerServiceGrpc.CustomerServiceBlockingStub serviceClient;


    public List<Customer> getCustomersGrpc(){

        final GetAllCustomersResponse response = serviceClient.getAllCustomers(GetAllCustomersRequest.newBuilder().build());
        return response.getCustomersList();
    }

}
