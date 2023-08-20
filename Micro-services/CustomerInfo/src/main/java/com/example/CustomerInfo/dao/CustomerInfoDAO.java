package com.example.CustomerInfo.dao;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoDAO {
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private LocalDate date;
}
