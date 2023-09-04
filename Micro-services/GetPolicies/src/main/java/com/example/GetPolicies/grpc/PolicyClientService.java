package com.example.GetPolicies.grpc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.policy.GetAllPoliciesRequest;
import com.example.policy.GetAllPoliciesResponse;
import com.example.policy.Policy;
import com.example.policy.PolicyServiceGrpc;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class PolicyClientService {
    @GrpcClient("myclient")
    private PolicyServiceGrpc.PolicyServiceBlockingStub policyStub;

    public List<Policy> getPolicies(){
        final GetAllPoliciesResponse response = policyStub.getAllPolicies(GetAllPoliciesRequest.newBuilder().build());
        return response.getPolicyList();
    }
}
