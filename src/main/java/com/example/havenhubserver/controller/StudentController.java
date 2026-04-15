package com.example.havenhubserver.controller;

import com.example.havenhubserver.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {

    @GetMapping("/api/student/info")
    public Student getStudentInfo(){
        return new Student("汪力","2022036360");

    }
}
