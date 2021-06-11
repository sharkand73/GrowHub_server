package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.CommunalRepository;
import com.GrowHub.Server.repositories.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CropController {

    @Autowired
    CropRepository cropRepository;

    @GetMapping(value = "/crops")
    public ResponseEntity getAllCrops() {
        return new ResponseEntity(cropRepository.findAll(), HttpStatus.OK);
    }


}


