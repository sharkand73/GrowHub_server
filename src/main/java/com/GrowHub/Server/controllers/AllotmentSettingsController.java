package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.AllotmentSettings;
import com.GrowHub.Server.repositories.AllotmentSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllotmentSettingsController {

    @Autowired
    AllotmentSettingsRepository allotmentSettingsRepository;

    @GetMapping(value = "/allotmentsettings")
    public ResponseEntity getAllAllotmentSettings() {
        return new ResponseEntity(allotmentSettingsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/allotmentsettings/{id}")
    public ResponseEntity getAllotment(@PathVariable Long id){
        return new ResponseEntity(allotmentSettingsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/allotmentsettings")
    public ResponseEntity<AllotmentSettings> postAllotment(@RequestBody AllotmentSettings allotment){
        allotmentSettingsRepository.save(allotment);
        return new ResponseEntity<>(allotment, HttpStatus.OK);
    }

    @PutMapping(value = "/allotmentsettings/{id}")
    public ResponseEntity<AllotmentSettings> putAllotment(@RequestBody AllotmentSettings allotment, @PathVariable Long id){
        AllotmentSettings allotmentSettingsToUpdate = allotmentSettingsRepository.findById(id).get();
        allotmentSettingsToUpdate.setAPIKey(allotment.getAPIKey());
        allotmentSettingsToUpdate.setName(allotment.getName());
        allotmentSettingsToUpdate.setCoordinates(allotment.getCoordinates());
        allotmentSettingsToUpdate.setCountryCode(allotment.getCountryCode());
        allotmentSettingsToUpdate.setMapFilepath(allotment.getMapFilepath());
        allotmentSettingsToUpdate.setLocation(allotment.getLocation());
        allotmentSettingsRepository.save(allotmentSettingsToUpdate);
        return new ResponseEntity<>(allotmentSettingsToUpdate, HttpStatus.OK);
    }

    //didn't put delete in here as updating or adding an allotment to the system is much more likely than one getting demolished
}
