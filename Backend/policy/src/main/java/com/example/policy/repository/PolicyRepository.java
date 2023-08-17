package com.example.policy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.policy.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy,Integer> {
    Policy findByName(String name);
}
