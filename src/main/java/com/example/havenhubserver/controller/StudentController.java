package com.example.havenhubserver.controller;

import com.example.havenhubserver.entity.UserEntity;
import com.example.havenhubserver.model.Student;
import com.example.havenhubserver.model.StudentUpdateRequest;
import com.example.havenhubserver.model.StudentUpdateResponse;
import com.example.havenhubserver.model.User;
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
        System.out.println(responseStudent.getName());

        return responseStudent;
    }

    @PostMapping("api/student/update")
    public StudentUpdateResponse updateStudentPassword(@RequestBody StudentUpdateRequest request) {

        StudentUpdateResponse studentUpdateResponse = new StudentUpdateResponse();
        System.out.println(request.getNewName());

        if (userRepository.findByUsername(request.getStudentId()) != null) {
            UserEntity userUpdate=userRepository.findByUsername(request.getStudentId());

            if(userUpdate.getPassword().equals(request.getOldPassword())){

                userUpdate.setPassword(request.getNewPassword());
                userUpdate.setRealname(request.getNewName());
                userRepository.save(userUpdate);

                studentUpdateResponse.setSuccess(true);
                studentUpdateResponse.setMessage("密码已更新，请重新登录");
            }else {
                studentUpdateResponse.setSuccess(false);
                studentUpdateResponse.setMessage("密码错误，请重新输入");
            }


            return studentUpdateResponse;
        } else {

            studentUpdateResponse.setSuccess(false);
            studentUpdateResponse.setMessage("用户不存在");
            return studentUpdateResponse;

        }

    }
}
