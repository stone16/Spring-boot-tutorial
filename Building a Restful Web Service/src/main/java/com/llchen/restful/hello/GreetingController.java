package com.llchen.restful.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // ensures HTTP requests to /greeting are mapped to the greeting() method
    @RequestMapping("/greeting")
    // RequestParam binds the value of the query string parameter name into the name parameter
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
        // The RESTful web controller populates and return json object
        // Spring's MappingJackson2HttpMessageConverter is automatially chosen to convert the Greeting instance to JSON
        return Greeting.builder()
                .id(counter.incrementAndGet())
                .content(String.format(template, name))
                .build();
    }
}
