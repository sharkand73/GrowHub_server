package com.GrowHub.Server.controllers;

import com.GrowHub.Server.repositories.CommunalRepository;
import com.GrowHub.Server.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping(value = "/jobs")
    public ResponseEntity getAllJobs() {
        return new ResponseEntity(jobRepository.findAll(), HttpStatus.OK);
    }


}

