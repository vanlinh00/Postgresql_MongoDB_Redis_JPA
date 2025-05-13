package com.example.Postgresql_MongoDB_Redis_JPA.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
// (MongoDB Document)
@Document(collection = "location_history")
@Data
public class LocationHistory {
    @Id
    private String id;

    private Long userId;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
    private String note;

}
