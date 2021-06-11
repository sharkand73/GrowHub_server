package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.BulletinItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BulletinController {

    @Autowired
    BulletinItemRepository bulletinItemRepository;

    @GetMapping(value = "/bulletins")
    public ResponseEntity getAllBulletins() {
        return new ResponseEntity(bulletinItemRepository.findAll(), HttpStatus.OK);
    }


}
