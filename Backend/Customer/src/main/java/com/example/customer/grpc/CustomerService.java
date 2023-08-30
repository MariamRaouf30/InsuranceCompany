package com.example.customer.grpc;

import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.stream.Collectors;

import net.devh.boot.grpc.server.service.GrpcService;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.CreateCustomerRequest;
import com.example.customer.CustomerResponse;
import com.example.customer.CustomerServiceGrpc;
import com.example.customer.GetAllCustomersRequest;
import com.example.customer.GetAllCustomersResponse;


@GrpcService
public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void getAllCustomers(GetAllCustomersRequest request, StreamObserver<GetAllCustomersResponse> responseObserver) {
//        List<Customer> customers = customerRepository.findAll();
//        System.out.println(customerRepository.findAll());
//        System.out.println(customers.get(0).getName());
//        System.out.println(customers);
        List<com.example.customer.Customer> customersResponse =
                customerRepository.findAll().stream().map(customer -> com.example.customer.Customer.newBuilder()
                .setId(customer.getId())
                .setName(customer.getName())
                .setEmail(customer.getEmail())
                .setPassword(customer.getPassword())
                .setPhoneNumber(customer.getPhone_number())

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
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}
}




