package com.example.Postgresql_MongoDB_Redis_JPA.controller;
/*
Chức năng:
Xử lý yêu cầu HTTP liên quan đến "vùng an toàn (geofence)", ví dụ:

Tạo vùng an toàn

Cập nhật vùng an toàn

Xoá vùng an toàn

Lấy danh sách vùng an toàn của người dùng
 */

import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.GeofenceRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Postgresql_MongoDB_Redis_JPA.service.GeofenceService;

@RestController
@RequestMapping("/api/geofences")
@RequiredArgsConstructor
public class GeofenceController {
    private final GeofenceService geofenceService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody GeofenceRequest request) {
        return ResponseEntity.ok(geofenceService.createGeofence(request));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> listByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(geofenceService.getByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        geofenceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
