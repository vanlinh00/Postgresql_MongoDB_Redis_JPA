package com.example.Postgresql_MongoDB_Redis_JPA.service;

/*
Chức năng:
Chứa logic nghiệp vụ xử lý cho UserController. Ví dụ:

Hash mật khẩu

Xác thực người dùng

Kiểm tra trùng email/username

Giao tiếp với UserRepository

 */

import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.Mapper.UserMapper;
import com.example.Postgresql_MongoDB_Redis_JPA.model.User;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.LoginRequest;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.UserRequest;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Response.UserResponse;
import org.springframework.stereotype.Service;
import com.example.Postgresql_MongoDB_Redis_JPA.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse register(UserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
       // user.setPassword(request.getPassword()); // mã hóa nếu cần
        return UserMapper.toDto(userRepository.save(user));
    }

    public UserResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
//        if (!user.getPassword().equals(request.getPassword())) {
//            throw new RuntimeException("Invalid password");
//        }
        return UserMapper.toDto(user);
    }

    public UserResponse getUserById(Long id) {
        return UserMapper.toDto(
                userRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("User not found"))
        );
    }

}
