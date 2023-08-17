package com.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Request.model.Request;

public interface RequestRepository extends MongoRepository<Request,ObjectId> {
    
}
