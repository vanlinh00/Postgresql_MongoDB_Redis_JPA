package com.example.Postgresql_MongoDB_Redis_JPA.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.LocationHistory;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.LocationRequest;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.example.Postgresql_MongoDB_Redis_JPA.repository.LocationHistoryRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final RedisTemplate<String, Object> redisTemplate;
    private final LocationHistoryRepository locationHistoryRepository;

    public void updateLocation(LocationRequest request) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String key = "location:" + request.getUserId();
        String value = objectMapper.writeValueAsString(request);
        redisTemplate.opsForValue().set(key, value);

        // MongoDB
        LocationHistory history = new LocationHistory();
        history.setUserId(request.getUserId());
        history.setLatitude(request.getLatitude());
        history.setLongitude(request.getLongitude());
        history.setTimestamp(LocalDateTime.now());
        history.setNote(request.getNotes());
        locationHistoryRepository.save(history);
    }

    public String getCurrentLocation(Long userId) {
        String key = "location:" + userId;
        return redisTemplate.opsForValue().get(key).toString();
    }

    public List<LocationHistory> getLocationHistory(Long userId) {
        return locationHistoryRepository.findByUserId(userId);
    }
}
