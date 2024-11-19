package tn.esprit.webproject5sae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Webproject5saeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Webproject5saeApplication.class, args);
	}

}
