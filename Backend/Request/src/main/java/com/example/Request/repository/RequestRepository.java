package com.example.Request.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Request.model.Request;

public interface RequestRepository extends MongoRepository<Request,String> {
    
}
