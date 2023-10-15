package com.example.MailNotification;

public record UserRegisteredPayload (String fullName, String emailAddress, int confirmationCode) {

}
