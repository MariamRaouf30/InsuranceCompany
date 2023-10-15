package com.example.Registration.controller;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Registration.dao.RegistrationDAO;
import com.example.Registration.dao.UserRegisteredPayload;
import com.example.Registration.grpc.RegistrationClientService;
import com.example.Registration.service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RegistrationController {
    static String QUEUE_NAME = "user-registration";

    private final RabbitTemplate rabbitTemplate;

    public RegistrationController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationClientService clientService;
    
    @PostMapping("/register")
    public ResponseEntity<RegistrationDAO> registerUser(@RequestBody RegistrationDAO registration) {
        ResponseEntity<RegistrationDAO> response = registrationService.registerCustomer(registration);
        return response;
    }

    @PostMapping("/grpcregister")
    public String registerGrpc(@RequestBody RegistrationDAO registration){
        return clientService.createCustomer(registration);
    }
    @PostMapping("/registerRabbit")
    public ResponseEntity<Map<String, String>> rabbitRegister(@RequestBody RegistrationDAO registerDao) throws JsonProcessingException {
        
        Random random = new Random();
        int confirmationCode = random.nextInt(900000) + 100000;

        UserRegisteredPayload queuePayload = new UserRegisteredPayload(
                registerDao.getName(),
                registerDao.getEmail(),
                confirmationCode
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String queuePayloadString = objectMapper.writeValueAsString(queuePayload);

        rabbitTemplate.convertAndSend(QUEUE_NAME, queuePayloadString);

        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");

        return ResponseEntity.ok(response);
    }
}
