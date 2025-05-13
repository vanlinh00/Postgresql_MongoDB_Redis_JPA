package com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeofenceResponse {
    private Long id;
    private Long userId;
    private Double latitude;
    private Double longitude;
    private Double radius;
}
