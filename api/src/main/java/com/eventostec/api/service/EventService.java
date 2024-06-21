package com.eventostec.api.service;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class EventService {

    public Event createEvent(EventRequestDTO dto){
        String imgUrl = null;

        if(dto.image() != null){
            imgUrl = this.uploadImg(dto.image());
        }

        Event newEvent = new Event();
        newEvent.setTitle(dto.title());
        newEvent.setEventUrl(dto.eventUrl());
        newEvent.setDate(new Date(dto.date()));
        newEvent.setDescription(dto.description());
        newEvent.setImgUrl(imgUrl);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile) {
        return "";
    }
}
