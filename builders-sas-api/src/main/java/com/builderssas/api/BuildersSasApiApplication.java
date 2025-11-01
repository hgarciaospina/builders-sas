package com.builderssas.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Application entry point for builders-sas-api.
 */
@EnableAsync
@SpringBootApplication
public class BuildersSasApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BuildersSasApiApplication.class, args);
    }
}
