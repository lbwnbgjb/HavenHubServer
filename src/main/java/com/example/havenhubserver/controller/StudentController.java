package com.example.havenhubserver.controller;

import com.example.havenhubserver.entity.UserEntity;
import com.example.havenhubserver.model.Student;
import com.example.havenhubserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/student/info")
    public Student getStudentInfo(@RequestBody Student request){

        UserEntity user = userRepository.findByUsername(request.getStudentId());

        Student responseStudent = new Student( user.getRealname(),user.getUsername(), user.getGender());
        System.out.println(responseStudent.getGender());

        return responseStudent;
    }
}
