package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Login.dao.LoginDAO;
import com.example.Login.grpc.LoginClient;
import com.example.Login.service.LoginService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor
@RestController
public class LoginController {
 @Autowired
    private LoginService loginService;
    @Autowired
    private LoginClient loginClient;

    @GetMapping("/login/{name}")
    public ResponseEntity<String> loginUser(@PathVariable("name") String name) {
        ResponseEntity<String> response = loginService.loginCustomer(name);
        return response;   
    }

    @GetMapping("/logingrpc/{name}")
    public String loginGrpc(@PathVariable("name") String name) {
        return loginClient.getCustomer(name).toString();
    }
    
}
