package com.example.testtaskrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TestTaskRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskRestApiApplication.class, args);
    }
}
