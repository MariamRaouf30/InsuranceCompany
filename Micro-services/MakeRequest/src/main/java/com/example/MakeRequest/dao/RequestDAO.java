package com.example.MakeRequest.dao;


import lombok.Data;

@Data
public class RequestDAO {
    private String request_id;
    private String type;
    private CustomerDAO customer;
}
