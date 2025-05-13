package com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request;

import lombok.Data;

@Data
public class GeofenceRequest {
    private Long userId;
    private Double latitude;
    private Double longitude;
    private Double radius;
}
