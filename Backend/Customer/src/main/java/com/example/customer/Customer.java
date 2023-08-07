package com.example.customer;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



// @Configuration
// @EnableSwagger2
@SpringBootApplication
public class Customer {
	public static void main(String[] args) {
		SpringApplication.run(Customer.class, args);
	}
	// @Bean
	// public Docket customerApiDocket(){
	// 		return new Docket(DocumentationType.SWAGGER_2).select()
	// 		.apis(RequestHandlerSelectors.basePackage("com.example.customer.controller")).paths(PathSelectors.any()).build();
	// }

}
