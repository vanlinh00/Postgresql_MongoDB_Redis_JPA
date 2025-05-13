package com.example.Postgresql_MongoDB_Redis_JPA.model.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private Long userId;
    private double latitude;
    private double longitude;
}
