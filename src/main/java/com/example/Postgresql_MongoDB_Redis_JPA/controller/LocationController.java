package com.example.Postgresql_MongoDB_Redis_JPA.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Request.LocationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Postgresql_MongoDB_Redis_JPA.service.LocationService;


/*

Chức năng:
Xử lý các yêu cầu liên quan đến vị trí người dùng như:

Gửi vị trí hiện tại (save vào Redis)

Ghi lịch sử di chuyển (lưu vào MongoDB)

Lấy lịch sử di chuyển theo user

Kiểm tra người dùng có trong vùng an toàn không

* */

@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(@RequestBody LocationRequest request) throws JsonProcessingException {
        locationService.updateLocation(request);
        return ResponseEntity.ok("Location updated");
    }

    @GetMapping("/current/{userId}")
    public ResponseEntity<?> getCurrent(@PathVariable Long userId) {
        return ResponseEntity.ok(locationService.getCurrentLocation(userId));
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<?> getHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(locationService.getLocationHistory(userId));
    }

}
