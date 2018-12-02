package com.llchen.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Walk through the process creating an application and securing it with the Spring Security LDAP module.
 *
 * Build a simple web application that is secured by Spring Security's embedded java based LDAP server.
 *
 * LDAP : lightweight directory access protocol. It's a light weight client server protocol for accessing directory services. It runs over TCP/ IP or other
 * connection oriented transfer services.
 */
@SpringBootApplication
public class AuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationApplication.class, args);
    }
}
