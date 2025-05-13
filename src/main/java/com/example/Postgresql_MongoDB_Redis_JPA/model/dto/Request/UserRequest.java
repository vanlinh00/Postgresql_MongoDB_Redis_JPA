package com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}
