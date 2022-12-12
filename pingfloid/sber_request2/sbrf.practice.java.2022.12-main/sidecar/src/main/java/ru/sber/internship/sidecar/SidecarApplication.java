package ru.sber.internship.sidecar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class SidecarApplication {

	public static void main(String[] args)
	{
		RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    HttpEntity<String> entity = new HttpEntity<String>(headers);
    String RequestResult = restTemplate.exchange("http://localhost:8080/students", HttpMethod.GET, entity, String.class).getBody();
//	System.out.println(RequestResult);
		SpringApplication.run(SidecarApplication.class, args);
	}

}
