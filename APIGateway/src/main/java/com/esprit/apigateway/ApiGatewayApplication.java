package com.esprit.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
                .route("GestionTournoi", r -> r.path("/tournois/**")
                        .uri("http://localhost:8080"))
                .route("SportySpace", r -> r.path("/products/**")
                        .uri("http://localhost:8082"))
                .route("Terrain", r -> r.path("/terrains/**")
                        .uri("http://localhost:8089"))
                .route("Reservation", r -> r.path("/reservation/**")
                        .uri("http://localhost:8085"))
                .route("webproject5sae", r -> r.path("/Recrutement/**")
                        .uri("http://localhost:8086"))
                .route("NODE-USER-SERVICE", r -> r.path("/users/**")
                        .uri("http://localhost:4000"))
                .build();
    }
}
