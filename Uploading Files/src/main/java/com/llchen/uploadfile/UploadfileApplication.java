package com.llchen.uploadfile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * This guide walks through the process of creating a server application that can receive HTTP multi-part file uploads
 *
 * Use case: upload a file in the front end, transfer to backend, and then have some logic to extract data, and deal with it
 * Use Thymeleaf to build front end page
 *
 * To upload files with Servlet containers, we need to register a MultipartConfigElement, which has been auto configured by Spring boot
 *
 */
@SpringBootApplication
//Activate the binded bean and properties
@EnableConfigurationProperties(StorageProperties.class)
public class UploadfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadfileApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
