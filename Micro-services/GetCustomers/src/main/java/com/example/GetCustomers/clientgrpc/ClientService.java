package com.example.GetCustomers.clientgrpc;


import com.example.customer.Customer;
import com.example.customer.CustomerServiceGrpc;
import com.example.customer.GetAllCustomersRequest;
import com.example.customer.GetAllCustomersResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @GrpcClient("myclient")
    private CustomerServiceGrpc.CustomerServiceBlockingStub serviceClient;


    public List<Customer> getCustomers(){
        final GetAllCustomersResponse response = this.serviceClient.getAllCustomers(GetAllCustomersRequest.newBuilder().build());
        return response.getCustomersList();
    }

}
