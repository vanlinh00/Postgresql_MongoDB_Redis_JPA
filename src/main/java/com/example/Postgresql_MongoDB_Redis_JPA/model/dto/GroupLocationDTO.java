package com.example.Postgresql_MongoDB_Redis_JPA.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GroupLocationDTO {
    private String userId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;

}
