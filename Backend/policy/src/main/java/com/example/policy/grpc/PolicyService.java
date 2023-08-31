package com.example.policy.grpc;

import com.example.policy.*;
import com.example.policy.repository.PolicyRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;
import java.util.stream.Collectors;


@GrpcService
public class PolicyService extends PolicyServiceGrpc.PolicyServiceImplBase {
    private PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public void getAllPolicies(GetAllPoliciesRequest request, StreamObserver<GetAllPoliciesResponse> responseObserver){
        List<com.example.policy.Policy> policiesResponse =
                policyRepository.findAll().stream().map(policy -> com.example.policy.Policy.newBuilder()
                        .setPolicyId(policy.getPolicy_id())
                        .setClaimId(policy.getClaim_id())
                        .setName(policy.getName())
                        .setNumber(policy.getNumber())
                        .setClaimAmount(policy.getClaim_amount())
                        .setType(policy.getType())
                        .build())
                        .collect(Collectors.toList());
        GetAllPoliciesResponse response = GetAllPoliciesResponse.newBuilder().addAllPolicy(policiesResponse).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    @Override
    public void createPolicy(CreatePolicyRequest request, StreamObserver<PolicyResponse>responseObserver){
        String policyId = request.getPolicyId();
        int claimId = request.getClaimId();
        String name = request.getName();
        int number = request.getNumber();
        String claimAmount = request.getClaimAmount();
        String type = request.getType();
        String customerName = request.getCustomerName();
        String customerEmail = request.getCustomerEmail();
        String customerNumber = request.getCustomerNumber();

        com.example.policy.model.Policy newPolicy = new com.example.policy.model.Policy();
        newPolicy.setPolicy_id(policyId);
        newPolicy.setClaim_id(claimId);
        newPolicy.setName(name);
        newPolicy.setNumber(number);
        newPolicy.setClaim_amount(claimAmount);
        newPolicy.setType(type);
        newPolicy.setCustomer_name(customerName);
        newPolicy.setCustomer_email(customerEmail);
        newPolicy.setCustomer_number(customerNumber);

        com.example.policy.model.Policy savedPolicy = policyRepository.save(newPolicy);
        PolicyResponse response = PolicyResponse.newBuilder()
                .setId(savedPolicy.getPolicy_id())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
