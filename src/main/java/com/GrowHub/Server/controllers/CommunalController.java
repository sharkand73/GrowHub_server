package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.Communal;
import com.GrowHub.Server.repositories.CommunalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommunalController {

    @Autowired
    CommunalRepository communalRepository;

    @GetMapping(value = "/communals")
    public ResponseEntity getAllCommunals() {
        return new ResponseEntity(communalRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/communals/{id}")
    public ResponseEntity<Communal> getCommunal(@PathVariable Long id){
        return new ResponseEntity(communalRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/communals/{id}")
    public ResponseEntity<Communal> putCommunal(@RequestBody Communal communal, @PathVariable Long id){
        Communal communalToUpdate = communalRepository.findById(id).get();
        communalToUpdate.setAreaInfo(communal.getAreaInfo());
        communalToUpdate.setAreaType(communal.getAreaType());
        communalToUpdate.setPlotNumbers(communal.getPlotNumbers());
        communalToUpdate.setAreaName(communal.getAreaName());
        communalToUpdate.setJobs(communal.getJobs());
        return new ResponseEntity<>(communalToUpdate, HttpStatus.OK);
    }


}

