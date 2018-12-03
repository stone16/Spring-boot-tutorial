package com.llchen.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Walk through creating a RESTful web service with Spring Boot Actuator
 *
 * @SpringBootApplication
 * It provides a load of defaults embedded servlet container depending on the contents of classpath
 *
 * Actuator includes a number of additional features to help you monitor and manage application when it's pushed to production.
 * Auditing, health, and metrics gathering can be automatically applied to application
 *
 * Mainly for debugging, or general microservice insight
 *
 * Most common endpoints Boot provides out of box:
 * 1) /health   show health information
 * 2) /info     displays arbitrary application info
 * 3) /metrics  show metrics information for the current application
 * 4) /trace    display trace information
 *
 * Most time, we also need security module to make sure only qualified user can see all those information
 */
@SpringBootApplication
public class ActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorApplication.class, args);
    }
}
