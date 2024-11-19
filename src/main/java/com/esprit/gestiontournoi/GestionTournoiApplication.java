package com.esprit.gestiontournoi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class GestionTournoiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionTournoiApplication.class, args);
	}
/*
	@Autowired
	private TournoiRepository tournoiRepository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {
			tournoiRepository.save(new Tournoi("aaaaa", "aaaa", "aaaa", "aaa", 111, LocalDateTime.parse("2024-10-27T18:00:00"), LocalDateTime.parse("2024-10-27T18:00:00")));
			tournoiRepository.save(new Tournoi("bbbbb", "bbbbb", "bbbbb", "bbbbb", 111, LocalDateTime.parse("2024-10-27T18:00:00"), LocalDateTime.parse("2024-10-27T18:00:00")));
			tournoiRepository.save(new Tournoi("ccccc", "ccccc", "ccccc", "ccccc", 111, LocalDateTime.parse("2024-10-27T18:00:00"), LocalDateTime.parse("2024-10-27T18:00:00")));
			tournoiRepository.save(new Tournoi("ddddd", "ddddd", "ddddd", "ddddd", 111, LocalDateTime.parse("2024-10-27T18:00:00"), LocalDateTime.parse("2024-10-27T18:00:00")));

			tournoiRepository.findAll().forEach(System.out::println);
		};
	}*/
}
