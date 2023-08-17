package com.example.Registration.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Registration.dao.RegistrationDAO;
import com.example.Registration.service.RegistrationService;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationDAO registration) {
        ResponseEntity<String> response = registrationService.registerCustomer(registration);
        return ResponseEntity.ok("Registration successful in Registration Microservice");
    }
}
