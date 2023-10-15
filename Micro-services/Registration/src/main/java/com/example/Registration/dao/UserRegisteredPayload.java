package com.example.Registration.dao;

public record UserRegisteredPayload (String fullName, String emailAddress, int confirmationCode) {

}