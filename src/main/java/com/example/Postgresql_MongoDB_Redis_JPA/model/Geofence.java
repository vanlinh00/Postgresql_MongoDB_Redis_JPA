package com.example.Postgresql_MongoDB_Redis_JPA.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// (PostgreSQL Entity)
@Entity
@Table(name = "geofences")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geofence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latitude;
    private Double longitude;
    private Double radius;

    // Không dùng quan hệ với entity User nữa
    @Column(name = "user_id")
    private Long userId;
}
