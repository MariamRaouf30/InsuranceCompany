package com.example.Login;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// import lombok.RequiredArgsConstructor;

// @Configuration
// @RequiredArgsConstructor
// @EnableWebSecurity
// public class Security {
//     private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;

//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//         return http 
//              .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
//              .and()
//              .addFilterBefore(new JwtAuthFilter()),BasicAuthenticationFilter.class)
//              .csrf().disable()
//     }
// }
