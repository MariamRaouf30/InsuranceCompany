package com.example.MailNotification.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.MailNotification.UserRegisteredPayload;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class MailController {
    public void onMessageReceived(String message) throws JsonMappingException, JsonProcessingException {
         ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<UserRegisteredPayload> mapType = new TypeReference<>() {};
        UserRegisteredPayload payload = objectMapper.readValue(message, mapType);

        System.out.println("Message received");
        System.out.println("User full name:    " + payload.fullName());
        System.out.println("Email Address:     " + payload.emailAddress());
        System.out.println("Confirmation code: " + payload.confirmationCode());
    }
}
