package com.example.terrain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TerrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerrainApplication.class, args);
    }
    @Autowired
    private TerrainRepo terrainRepo;

    @Bean
    ApplicationRunner init() {
        return (args) ->{
                terrainRepo.save(new Terrain("Whey","wheyyy", 100,"boxeur-serieux",100));
            terrainRepo.findAll().forEach(System.out::println);
        };
    }
}
