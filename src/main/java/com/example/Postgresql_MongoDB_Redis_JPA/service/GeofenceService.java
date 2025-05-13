package com.example.Postgresql_MongoDB_Redis_JPA.service;

/*
Chức năng:
Xử lý các logic liên quan đến vùng an toàn:

Tạo vùng an toàn, kiểm tra giới hạn

Kiểm tra vị trí người dùng có nằm trong vùng an toàn không

Giao tiếp với GeofenceRepository
 */

import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.Geofence;
import com.example.Postgresql_MongoDB_Redis_JPA.model.Mapper.GeofenceMapper;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.GeofenceRequest;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Response.GeofenceResponse;
import org.springframework.stereotype.Service;
import com.example.Postgresql_MongoDB_Redis_JPA.repository.GeofenceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeofenceService {
    private final GeofenceRepository geofenceRepository;

    public GeofenceResponse createGeofence(GeofenceRequest request) {
        Geofence geo = new Geofence();
        geo.setUserId(request.getUserId());
        geo.setLatitude(request.getLatitude());
        geo.setLongitude(request.getLongitude());
        geo.setRadius(request.getRadius());
        return GeofenceMapper.toDto(geofenceRepository.save(geo));
    }

    public List<GeofenceResponse> getByUserId(Long userId) {
        return geofenceRepository.findByUserId(userId)
                .stream().map(GeofenceMapper::toDto)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        geofenceRepository.deleteById(id);
    }
}
