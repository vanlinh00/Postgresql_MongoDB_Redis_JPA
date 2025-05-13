package com.example.Postgresql_MongoDB_Redis_JPA.controller;

import com.example.Postgresql_MongoDB_Redis_JPA.model.dto.GroupLocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class GroupLocationWebSocketController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/group/location/update")
    public void updateLocation(GroupLocationDTO dto) {
        messagingTemplate.convertAndSend("/topic/group/location", dto);
    }
}
