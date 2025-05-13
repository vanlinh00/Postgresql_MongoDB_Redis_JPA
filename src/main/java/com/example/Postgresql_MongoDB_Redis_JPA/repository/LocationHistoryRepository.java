package com.example.Postgresql_MongoDB_Redis_JPA.repository;


import com.example.Postgresql_MongoDB_Redis_JPA.model.LocationHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationHistoryRepository extends MongoRepository<LocationHistory, String> {
    List<LocationHistory> findByUserId(Long userId);
}
