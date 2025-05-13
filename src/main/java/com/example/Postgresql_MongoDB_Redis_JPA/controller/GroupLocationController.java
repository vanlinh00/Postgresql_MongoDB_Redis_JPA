package com.example.Postgresql_MongoDB_Redis_JPA.controller;

import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.GroupLocationDTO;
import com.example.Postgresql_MongoDB_Redis_JPA.service.GroupLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/group/location")
public class GroupLocationController {

    @Autowired
    private GroupLocationService groupLocationService;

    @PostMapping("/save")
    public ResponseEntity<String> saveLocation(@RequestBody GroupLocationDTO dto) throws Exception {
        groupLocationService.saveUserLocation(dto);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/all")
    public ResponseEntity<Map<String, GroupLocationDTO>> getGroupLocations(
            @RequestParam List<String> userIds) throws Exception {
        return ResponseEntity.ok(groupLocationService.getGroupLocations(userIds));
    }
}
