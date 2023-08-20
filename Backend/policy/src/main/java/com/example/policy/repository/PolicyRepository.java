package com.example.policy.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.policy.model.Policy;

public interface PolicyRepository extends MongoRepository<Policy,ObjectId> {
    Policy findByName(String name);
}
