package com.example.CreatePolicy.grpc;

import org.springframework.stereotype.Service;

import com.example.CreatePolicy.dao.PolicyDAO;
import com.example.policy.CreatePolicyRequest;
import com.example.policy.PolicyResponse;
import com.example.policy.PolicyServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class CreatePolicyClient {
    @GrpcClient("myclient")
    private PolicyServiceGrpc.PolicyServiceBlockingStub policyStub;

    public String CreatePolicy(PolicyDAO policy){
        CreatePolicyRequest request = CreatePolicyRequest.newBuilder()
            .setClaimId(policy.getClaim_id())
            .setName(policy.getName())   
            .setNumber(policy.getNumber())
            .setClaimAmount(policy.getClaim_amount())
            .setType(policy.getType())
            .build();

        PolicyResponse response = policyStub.createPolicy(request);
        return response.getId();
    }
    
}
