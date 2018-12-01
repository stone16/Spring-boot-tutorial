package com.llchen.consumingrestful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Walks you through the process of creating an application that consumes a RESTFUL web service
 *
 * @SpringBootApplication adds all of the following
 * 1) @Configuration tags the class as a source of bean definitions for the application context
 * Attention! @Configuration will make sure all beans inside this class is singleton
 * 2) @EnableAutoConfiguration tells Springboot to start adding beans based on classpath settings, other beans, and various property settings
 * 3) @EnableWebMvc  setting up a dispatcherServelet
 * 4) @ComponentScan tells Spring to look for other components, configurations, and services in the package, allowing it to find controller
 */
@SpringBootApplication
public class ConsumingrestfulApplication {

    private static final Logger log = LoggerFactory.getLogger(ConsumingrestfulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingrestfulApplication.class, args);
    }

    // The RestTemplateBuilder is injected by Spring
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);

            log.info(quote.toString());
        };
    }
}
