package com.example.Postgresql_MongoDB_Redis_JPA.model.Mapper;

import com.example.Postgresql_MongoDB_Redis_JPA.model.Geofence;
import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.Response.GeofenceResponse;

public class GeofenceMapper {
    public static GeofenceResponse toDto(Geofence geo) {
        return new GeofenceResponse(
                geo.getId(),
                geo.getUserId(),
                geo.getLatitude(),
                geo.getLongitude(),
                geo.getRadius()
        );
    }
}
