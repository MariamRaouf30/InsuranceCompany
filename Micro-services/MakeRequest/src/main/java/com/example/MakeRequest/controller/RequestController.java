package com.example.MakeRequest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MakeRequest.dao.RequestDAO;
import com.example.MakeRequest.service.RequestService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class RequestController {
 @Autowired
 private RequestService requestService;
 @PostMapping("/makerequest/{id}")
 public ResponseEntity<RequestDAO> makeRequestController(@RequestBody RequestDAO requestDAO, @PathVariable String id){
    ResponseEntity<RequestDAO> response = requestService.makeRequest(requestDAO, id);
    return response;
 }

}
