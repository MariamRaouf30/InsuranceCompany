package com.example.customer.grpc;

import com.example.customer.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import net.devh.boot.grpc.server.service.GrpcService;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@GrpcService
public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

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
public void createCustomer(CreateCustomerRequest request, StreamObserver<CustomerResponse> responseObserver)  {
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

    try {
        String customerJson = objectMapper.writeValueAsString(newCustomer);
        rabbitTemplate.convertAndSend("customer.create", "customer.created", customerJson);
        CustomerResponse response = CustomerResponse.newBuilder().setId("customer created").build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        responseObserver.onError(Status.INTERNAL.withDescription("Error creating customer").asRuntimeException());
    }



    
}




    @Override
    public void updateCustomer(UpdateCustomerRequest request,StreamObserver<UpdateCustomerResponse> responseObserver){
    String id = request.getId();
    Optional<Customer> existingCustomer = customerRepository.findById(id);
    if(existingCustomer.isPresent()){
        Customer customerToUpdate = existingCustomer.get();
        if(request.getPolicyId() != null){
            customerToUpdate.getPolicy_id().add(request.getPolicyId());
        }
        if(request.getPolicyName()!=null){
            customerToUpdate.getPolicy_name().add(request.getPolicyName());
        }
        Customer updatedCustomer = customerRepository.save(customerToUpdate);
        UpdateCustomerResponse response = UpdateCustomerResponse.newBuilder()
                .setId(updatedCustomer.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    } else {
        // Handle the case where the customer with the specified ID was not found
        responseObserver.onError(Status.NOT_FOUND.withDescription("Customer not found").asRuntimeException());
    }

    }
    @Override
    public void getById(GetByIdRequest request,StreamObserver<GetByIdResponse> responseObserver){
        String id = request.getId();
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if(existingCustomer.isPresent()) {
            Customer customer = existingCustomer.get();
            com.example.customer.Customer customersResponse =
                     com.example.customer.Customer.newBuilder()
                                    .setId(customer.getId())
                                    .setName(customer.getName())
                                    .setEmail(customer.getEmail())
                                    .setPassword(customer.getPassword())
                                    .setPhoneNumber(customer.getPhone_number())
                                    .build();
            GetByIdResponse response = GetByIdResponse.newBuilder().setCustomer(customersResponse).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void getByName(GetByNameRequest request,StreamObserver<GetByNameResponse> responseObserver){
        String name = request.getName();
        Customer customer = customerRepository.findByName(name);
        if(customer !=null) {
            com.example.customer.Customer customersResponse =
                     com.example.customer.Customer.newBuilder()
                                    .setId(customer.getId())
                                    .setName(customer.getName())
                                    .setEmail(customer.getEmail())
                                    .setPassword(customer.getPassword())
                                    .setPhoneNumber(customer.getPhone_number())
                                    .build();
            GetByNameResponse response = GetByNameResponse.newBuilder().setCustomer(customersResponse).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}




