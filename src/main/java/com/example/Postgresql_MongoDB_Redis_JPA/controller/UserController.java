package com.example.Postgresql_MongoDB_Redis_JPA.controller;


import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.LoginRequest;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Postgresql_MongoDB_Redis_JPA.service.UserService;

/*
Chức năng:

+ Xử lý các yêu cầu HTTP liên quan đến người dùng như:

+ Đăng ký tài khoản

+ Đăng nhập / xác thực

+ Lấy thông tin người dùng

+ Cập nhật thông tin người dùng

+ Xoá người dùng

 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("/get")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("hello jenkin ok");
    }
}
