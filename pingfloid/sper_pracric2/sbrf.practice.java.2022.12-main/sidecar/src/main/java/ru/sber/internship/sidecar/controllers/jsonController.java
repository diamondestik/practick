package ru.sber.internship.sidecar.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.sber.internship.sidecar.models.studentClass;

import java.util.Arrays;

@RestController
public class jsonController {

    @GetMapping("/students")
    public studentClass getStudent()
    {
        studentClass student =  new studentClass();
        student.setName("Sygizmund");
        student.setGroupe("bebra");
        student.setAvarageScore("0.2");

        return student;
    }




}
