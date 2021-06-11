package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlotController {

    @Autowired
    PlotRepository plotRepository;

    @GetMapping(value = "/plots")
    public ResponseEntity getAllPlots(){
       return new ResponseEntity(plotRepository.findAll(), HttpStatus.OK);
    }



}
