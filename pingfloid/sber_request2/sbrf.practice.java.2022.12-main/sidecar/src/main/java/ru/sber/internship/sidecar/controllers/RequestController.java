package ru.sber.internship.sidecar.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

@RestController
public class RequestController {
//    @GetMapping("/read")
//    public String request() throws URISyntaxException, MalformedURLException {
//        URI url = new URI("http://127.0.0.1:8080");
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(url, String.class);
//        System.out.println(result);
//        return result;
//    }
// @RequestMapping(value = "/sentRequest")
//public String getProductList() {
//
//     RestTemplate restTemplate = new RestTemplate();
//    HttpHeaders headers = new HttpHeaders();
//    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//    HttpEntity<String> entity = new HttpEntity<String>(headers);
//    String RequestResult = restTemplate.exchange("http://localhost:8080/students", HttpMethod.GET, entity, String.class).getBody();
//    return RequestResult;
//}
}

