package com.example.Login.service;

import org.springframework.stereotype.Service;

import com.example.Login.Model.Login;

import Repositories.LoginRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    // public Login findByLogin(Login login){
    //     loginRepository.findByLogin(login).orElseThrow(()-> new Exception ("Unknown user", HttpStatus.NOT_FOUND));
    // }
    
}
