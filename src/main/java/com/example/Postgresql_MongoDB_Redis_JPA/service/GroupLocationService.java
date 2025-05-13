package com.example.Postgresql_MongoDB_Redis_JPA.service;

import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.GroupLocationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GroupLocationService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String LOCATION_KEY_PREFIX = "user_location:";

    public void saveUserLocation(GroupLocationDTO dto) throws Exception {
        String key = LOCATION_KEY_PREFIX + dto.getUserId();
        String jsonValue = objectMapper.writeValueAsString(dto);
        redisTemplate.opsForValue().set(key, jsonValue);
    }

    public GroupLocationDTO getUserLocation(String userId) throws Exception {
        String key = LOCATION_KEY_PREFIX + userId;
        String jsonValue = redisTemplate.opsForValue().get(key);
        return objectMapper.readValue(jsonValue, GroupLocationDTO.class);
    }

    public Map<String, GroupLocationDTO> getGroupLocations(List<String> userIds) throws Exception {
        Map<String, GroupLocationDTO> result = new HashMap<>();
        for (String id : userIds) {
            GroupLocationDTO dto = getUserLocation(id);
            if (dto != null) result.put(id, dto);
        }
        return result;
    }
}
