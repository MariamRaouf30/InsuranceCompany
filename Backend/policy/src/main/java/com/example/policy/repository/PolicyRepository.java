package com.example.policy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.policy.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy,String> {
    Policy findByName(String name);
}
