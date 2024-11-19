package com.example.sportyspace;

import com.example.sportyspace.entity.Product;
import com.example.sportyspace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SportySpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportySpaceApplication.class, args);
	}
	/*@Autowired
	private ProductRepository productRepository;

	@Bean
	ApplicationRunner init() {
		return (args) ->{
			productRepository.save(new Product("Whey","wheyyy", 100,"boxeur-serieux"));
			productRepository.findAll().forEach(System.out::println);
		};
	}*/
}
