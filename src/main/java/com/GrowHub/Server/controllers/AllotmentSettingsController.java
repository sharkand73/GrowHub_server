package com.GrowHub.Server.controllers;

import com.GrowHub.Server.models.AllotmentSettings;
import com.GrowHub.Server.repositories.AllotmentSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllotmentSettingsController {

    @Autowired
    AllotmentSettingsRepository allotmentSettingsRepository;

    @GetMapping(value = "/allotmentsettings")
    public ResponseEntity getAllAllotmentSettings() {
        return new ResponseEntity(allotmentSettingsRepository.findAll(), HttpStatus.OK);
    }
}
