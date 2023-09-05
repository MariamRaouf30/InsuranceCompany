package com.example.CreatePolicy.grpc;

import org.springframework.stereotype.Service;

import com.example.CreatePolicy.dao.CustomerDAO;
import com.example.CreatePolicy.dao.PolicyDAO;
import com.example.customer.Customer;
import com.example.customer.CustomerServiceGrpc;
import com.example.customer.GetByIdRequest;
import com.example.customer.GetByIdResponse;
import com.example.customer.UpdateCustomerRequest;
import com.example.customer.UpdateCustomerResponse;
import com.example.policy.CreatePolicyRequest;
import com.example.policy.PolicyResponse;
import com.example.policy.PolicyServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class CreatePolicyClient {
    @GrpcClient("myclient")
    private PolicyServiceGrpc.PolicyServiceBlockingStub policyStub;

    @GrpcClient("customerclient")
    private CustomerServiceGrpc.CustomerServiceBlockingStub customerStub;

    public String CreatePolicy(PolicyDAO policy, String id){
        Customer customer = getCustomer(id);
        System.out.println(customer.getEmail());
        CreatePolicyRequest request = CreatePolicyRequest.newBuilder()
            .setClaimId(policy.getClaim_id())
            .setName(policy.getName())   
            .setNumber(policy.getNumber())
            .setClaimAmount(policy.getClaim_amount())
            .setType(policy.getType())
            .setCustomerName(customer.getName())
            .setCustomerEmail(customer.getEmail())
            .setCustomerNumber(customer.getPhoneNumber())
            .build();
        PolicyResponse response = policyStub.createPolicy(request);
       // System.out.println("policy id"+response.getId().toString());
        updateCustomer(id, policy.getName(), response.getId().toString());
        return response.getId();
    }

    public Customer getCustomer(String id){
        GetByIdRequest request = GetByIdRequest.newBuilder().setId(id).build();
        GetByIdResponse response = customerStub.getById(request);
        return response.getCustomer();
    }
    
    public void updateCustomer(String id,String policy_name,String policy_id)
    {
        UpdateCustomerRequest request = UpdateCustomerRequest.newBuilder()
        .setId(id)
        .setPolicyId(policy_id)
        .setPolicyName(policy_name)
        .build();
        UpdateCustomerResponse response = customerStub.updateCustomer(request);
        // if(response.getId() != null){
        //     System.out.println("Updated Customer");
        // }

    }
}
