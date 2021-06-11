package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.BulletinItemRepository;
import com.GrowHub.Server.repositories.KnowhowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KnowhowController {

    @Autowired
    KnowhowRepository knowhowRepository;

    @GetMapping(value = "/knowhows")
    public ResponseEntity getAllKnowhows() {
        return new ResponseEntity(knowhowRepository.findAll(), HttpStatus.OK);
    }
}
