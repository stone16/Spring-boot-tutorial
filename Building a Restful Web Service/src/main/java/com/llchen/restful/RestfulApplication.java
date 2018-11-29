package com.llchen.restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Maven searches for the public static void main() method to flag as a runnable class

/**
 * SpringBootApplication is a convenience annotation adds
 * 1）@Configuration tags the class as a source of bean definitions for the application context
 * 2) @EnableAutoConfiguration tells Spring boot to start adding beans based on classpath settings, other beans, and various property settings
 * 3) @EnableWebWvc flags the application as a web application, and sets up DispatcherServlet
 * 4) @ComponentScan tells Spring to look for other components, configurations, and services in this package
 */
@SpringBootApplication
public class RestfulApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApplication.class, args);
    }
}
