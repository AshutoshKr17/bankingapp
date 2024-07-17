//package com.bank.bankingapp.config
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
//class SecurityConfig {
//
//    @Override
//    fun configure(http: HttpSecurity) {
//        http. // Disable CSRF protection for development (use with caution!)
//            authorizeRequests()
//            .anyRequest().permitAll() // Allow all requests for now
//    }
//}
