package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.CommunalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunalController {

    @Autowired
    CommunalRepository communalRepository;

    @GetMapping(value = "/communals")
    public ResponseEntity getAllCommunals() {
        return new ResponseEntity(communalRepository.findAll(), HttpStatus.OK);
    }


}

