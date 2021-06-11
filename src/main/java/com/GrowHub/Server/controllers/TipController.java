package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.TipRepository;
import com.GrowHub.Server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TipController {

    @Autowired
    TipRepository tipRepository;

    @GetMapping(value = "/tips")
    public ResponseEntity getAllTips() {
        return new ResponseEntity(tipRepository.findAll(), HttpStatus.OK);
    }

}
