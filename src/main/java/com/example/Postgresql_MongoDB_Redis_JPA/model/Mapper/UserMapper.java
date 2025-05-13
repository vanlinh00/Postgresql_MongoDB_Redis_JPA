package com.example.Postgresql_MongoDB_Redis_JPA.model.Mapper;

import com.example.Postgresql_MongoDB_Redis_JPA.model.User;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Response.UserResponse;

public class UserMapper {
    public static UserResponse toDto(User user) {
        return new UserResponse(user.getId(), user.getUsername());
    }
}
