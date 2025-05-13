package com.example.Postgresql_MongoDB_Redis_JPA.repository;

import com.example.Postgresql_MongoDB_Redis_JPA.model.Geofence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeofenceRepository extends JpaRepository<Geofence, Long> {
    List<Geofence> findByUserId(Long userId);
}
