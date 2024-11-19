package com.example.eureka17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Eureka17Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka17Application.class, args);
    }

}
