package ru.sber.internship.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;

@SpringBootApplication
public class SidecarApplication {

	public static void main(String[] args) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.getForObject("http://localhost:8080/file?filepath=/var/tmp/fruit.json", String.class);
		SpringApplication.run(SidecarApplication.class, args);
	}

}
