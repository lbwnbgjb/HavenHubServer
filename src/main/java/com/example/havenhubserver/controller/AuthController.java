package com.example.havenhubserver.controller;

import com.example.havenhubserver.entity.UserEntity;
import com.example.havenhubserver.model.LoginRequest;
import com.example.havenhubserver.model.LoginResponse;
import com.example.havenhubserver.model.User;
import com.example.havenhubserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        LoginResponse response = new LoginResponse();
        
        // 查找用户
        UserEntity user = userRepository.findByUsername(request.getStudentId());
        
        if (user != null && user.getPassword().equals(request.getPassword())) {
            // 登录成功
            response.setSuccess(true);
            response.setMessage("登录成功");
            response.setStudentId(user.getUsername());
            response.setName(user.getRealname());
            response.setGender(user.getGender());
        } else {
            // 登录失败
            response.setSuccess(false);
            response.setMessage("用户名或密码错误");
        }
        
        return response;
    }

    @PostMapping("/api/register")
    public LoginResponse register(@RequestBody User user) {
        LoginResponse response = new LoginResponse();
        
        // 检查用户是否已存在
        if (userRepository.findByUsername(user.getUsername()) != null) {
            response.setSuccess(false);
            response.setMessage("用户已存在");
            return response;
        }
        
        // 创建新用户
        UserEntity newUser = new UserEntity(user.getUsername(), user.getRealname(), user.getPassword() ,user.getGender());
        System.out.println(user.getGender());
        userRepository.save(newUser);
        
        response.setSuccess(true);
        response.setMessage("注册成功");
        response.setStudentId(user.getUsername());
        response.setName(user.getRealname());
        
        return response;
    }

    @GetMapping("/api/test")
    public String testConnection() {
        return "连接成功";
    }
}